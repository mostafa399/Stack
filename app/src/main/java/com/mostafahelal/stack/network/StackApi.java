package com.mostafahelal.stack.network;

import com.mostafahelal.stack.network.QuestionListResponseScheme;
import com.mostafahelal.stack.network.SingleQuestionResponseSchema;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StackApi {
    @GET("questions?order=desc&sort=activity&site=stackoverflow")
    Call<QuestionListResponseScheme>getQuestions(@Query("pagesize")Integer pageSize);

    @GET("questions/{questionId}?site=stackoverflow&filter=withbody")
    Call<SingleQuestionResponseSchema> getQuestionDetails(@Path("questionId") String questionId);

}
