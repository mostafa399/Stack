package com.mostafahelal.stack.pojo;

import androidx.annotation.Nullable;

import com.mostafahelal.stack.network.QuestionListResponseScheme;
import com.mostafahelal.stack.network.StackApi;
import com.mostafahelal.stack.questionlist.BaseObservable;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchQuestionsList extends BaseObservable<FetchQuestionsList.Listener> {
    @Nullable
    Call<QuestionListResponseScheme> call;
    private final StackApi stackApi;

    public interface Listener {
        void onFetchOfQuestionsSucceeded(List<Item> questions);
        void onFetchOfQuestionsFailed();
    }


    public FetchQuestionsList(StackApi stackApi) {
        this.stackApi = stackApi;
    }

    public void fetchLastActiveQuestionsAndNotify(int numOfQuestion ){
        cancelCurrentFetchIfActive();
        call=stackApi.getQuestions(numOfQuestion);
        call.enqueue(new Callback<QuestionListResponseScheme>() {
            @Override
            public void onResponse(Call<QuestionListResponseScheme> call, Response<QuestionListResponseScheme> response) {
                if(response.isSuccessful()){
                    notifySucceeded(response.body().getItems());

                }else {
                    notifyFailed();
                }
            }

            @Override
            public void onFailure(Call<QuestionListResponseScheme> call, Throwable t) {

            }
        });


    }
    private void cancelCurrentFetchIfActive(){
        if (call != null && !call.isCanceled() && !call.isExecuted()){
            call.cancel();
        }
    }

    private void notifySucceeded(List<Item> questions){
        List<Item> unmodifiableQuestions = Collections.unmodifiableList(questions);
        for (Listener listener : getListeners()){
            listener.onFetchOfQuestionsSucceeded(unmodifiableQuestions);
        }
    }

    private void notifyFailed(){
        for (Listener listener : getListeners()){
            listener.onFetchOfQuestionsFailed();
        }
    }
}
