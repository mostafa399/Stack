package com.mostafahelal.stack.detailquestion;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mostafahelal.stack.R;
import com.mostafahelal.stack.pojo.QuestionWithBody;
import com.mostafahelal.stack.questionlist.BaseViewMvc;

public class QuestionDetailsViewMvcImpl extends BaseViewMvc<QuestionDetailsViewMVC.Listener>
        implements QuestionDetailsViewMVC {
    private final TextView mTxtQuestionBody;
    public QuestionDetailsViewMvcImpl(LayoutInflater inflater, ViewGroup container) {
        setRootView(inflater.inflate(R.layout.activity_detail, container, false));
        mTxtQuestionBody = findViewById(R.id.txt_question_body);
    }


    @Override
    public void bindQuestion(QuestionWithBody question) {
        String questionBody = question.getmBody();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            mTxtQuestionBody.setText(Html.fromHtml(questionBody, Html.FROM_HTML_MODE_LEGACY));
        } else {
            mTxtQuestionBody.setText(Html.fromHtml(questionBody));
        }
    }
}
