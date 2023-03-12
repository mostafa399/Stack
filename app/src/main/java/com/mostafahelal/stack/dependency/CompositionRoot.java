package com.mostafahelal.stack.dependency;

import androidx.annotation.UiThread;

import com.mostafahelal.stack.common.Constants;
import com.mostafahelal.stack.common.DialogsManagerFactory;
import com.mostafahelal.stack.network.StackApi;
import com.mostafahelal.stack.pojo.FetchQuestionDetails;
import com.mostafahelal.stack.pojo.FetchQuestionsList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@UiThread
public class CompositionRoot {
    private Retrofit retrofit;
    private StackApi stackApi;

    @UiThread
    public Retrofit getRetrofit() {
        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

    public StackApi getStackApi() {
        if (stackApi==null){
            stackApi=getRetrofit().create(StackApi.class);
        }
        return stackApi;
    }
    @UiThread
    public FetchQuestionDetails getfetchQuestionDetailsUseCase(){
        return new FetchQuestionDetails(getStackApi());
    }

    @UiThread
    public FetchQuestionsList getfetchQuestionsListUseCase(){
        return new FetchQuestionsList(getStackApi());
    }
    public DialogsManagerFactory getDialogsManagerFactory(){
        return new DialogsManagerFactory();
    }


}
