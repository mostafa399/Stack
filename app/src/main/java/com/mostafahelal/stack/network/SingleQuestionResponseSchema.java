package com.mostafahelal.stack.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mostafahelal.stack.pojo.QuestionWithBody;

import java.util.Collections;
import java.util.List;

public class SingleQuestionResponseSchema {
    @SerializedName("items")
    @Expose
    private final List<QuestionWithBody> mQuestions;

    public SingleQuestionResponseSchema(QuestionWithBody questions) {
        mQuestions = Collections.singletonList(questions);
    }

    public QuestionWithBody getQuestions() {
        return mQuestions.get(0);
    }
}
