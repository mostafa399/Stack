package com.mostafahelal.stack.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionWithBody {
    @SerializedName("title")
    @Expose
    private final String mTitle;

    @SerializedName("question_id")
    @Expose
    private final String mId;

    @SerializedName("body")
    @Expose
    private final String mBody;

    public QuestionWithBody(String mTitle, String mId, String mBody) {
        this.mTitle = mTitle;
        this.mId = mId;
        this.mBody = mBody;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmId() {
        return mId;
    }

    public String getmBody() {
        return mBody;
    }
}

