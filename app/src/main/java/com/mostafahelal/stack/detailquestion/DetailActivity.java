package com.mostafahelal.stack.detailquestion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.mostafahelal.stack.common.BaseActivity;
import com.mostafahelal.stack.common.DialogManeger;
import com.mostafahelal.stack.common.ServerErrorDialogFragment;
import com.mostafahelal.stack.pojo.FetchQuestionDetails;
import com.mostafahelal.stack.pojo.QuestionWithBody;

public class DetailActivity extends BaseActivity
        implements QuestionDetailsViewMVC.Listener, FetchQuestionDetails.Listener {

    public static final String EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID";
    private String questionId;
    private FetchQuestionDetails fetchQuestionDetails;
    private QuestionDetailsViewMVC viewMvc;
    public static void start(Context context, String questionId) {
        Intent i = new Intent(context, DetailActivity.class);
        i.putExtra(EXTRA_QUESTION_ID, questionId);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewMvc=getPresentationCompositionRoot().getViewMvcFactory().newInstance(QuestionDetailsViewMVC.class,null);
        setContentView(viewMvc.getRootView());
         fetchQuestionDetails=getCompositionRoot().getfetchQuestionDetailsUseCase();
        questionId=getIntent().getExtras().getString(EXTRA_QUESTION_ID);

    }

    @Override
    protected void onStart() {
        super.onStart();
        viewMvc.registerListener(this);
        fetchQuestionDetails.registerListener(this);
        fetchQuestionDetails.fetchQuestionDetailsAndNotify(questionId);
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewMvc.unregisterListener( this);
        fetchQuestionDetails.unregisterListener(this);
    }

    @Override
    public void onFetchOfQuestionDetailsSucceeded(QuestionWithBody question) {
        viewMvc.bindQuestion(question);
    }

    @Override
    public void onFetchOfQuestionDetailsFailed() {
        DialogManeger dialogManeger=getCompositionRoot().getDialogsManagerFactory().newDialogManager(getSupportFragmentManager());
        dialogManeger.showRetainedDialogWithId(ServerErrorDialogFragment.newInstance(),"");
    }
}