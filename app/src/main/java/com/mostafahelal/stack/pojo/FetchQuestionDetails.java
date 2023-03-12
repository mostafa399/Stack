package com.mostafahelal.stack.pojo;

import androidx.annotation.NonNull;

import com.mostafahelal.stack.network.SingleQuestionResponseSchema;
import com.mostafahelal.stack.network.StackApi;
import com.mostafahelal.stack.questionlist.BaseObservable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchQuestionDetails extends BaseObservable<FetchQuestionDetails.Listener> {
    private StackApi stackApi;
    @NonNull
    private Call<SingleQuestionResponseSchema>call;
    public interface Listener {
        void onFetchOfQuestionDetailsSucceeded(QuestionWithBody question);
        void onFetchOfQuestionDetailsFailed();
    }
    public void fetchQuestionDetailsAndNotify(String questionId){
        cancelCurrentFetchIfActive();
        call=stackApi.getQuestionDetails(questionId);
        call.enqueue(new Callback<SingleQuestionResponseSchema>() {
            @Override
            public void onResponse(Call<SingleQuestionResponseSchema> call, Response<SingleQuestionResponseSchema> response) {
                if (response.isSuccessful()){
                    notifySucceeded(response.body().getQuestions());
                }
                else {
                    notifyFailed();
                }
            }

            @Override
            public void onFailure(Call<SingleQuestionResponseSchema> call, Throwable t) {
                if (call != null && !call.isCanceled() && !call.isExecuted()){
                    call.cancel();
                }
            }
        });
    }

    public FetchQuestionDetails(StackApi stackApi) {
        this.stackApi = stackApi;
    }

    private void cancelCurrentFetchIfActive(){
        if(call != null && !call.isCanceled() && !call.isExecuted()){
            call.cancel();
        }
    }

    private void notifySucceeded(QuestionWithBody question){
        for (Listener listener : getListeners()){
            listener.onFetchOfQuestionDetailsSucceeded(question);
        }
    }

    private void notifyFailed(){
        for (Listener listener : getListeners()){
            listener.onFetchOfQuestionDetailsFailed();
        }
    }
}
