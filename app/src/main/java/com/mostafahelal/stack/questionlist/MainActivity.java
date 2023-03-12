package com.mostafahelal.stack.questionlist;

import android.os.Bundle;

import com.mostafahelal.stack.common.BaseActivity;
import com.mostafahelal.stack.common.DialogManeger;
import com.mostafahelal.stack.common.ServerErrorDialogFragment;
import com.mostafahelal.stack.detailquestion.DetailActivity;
import com.mostafahelal.stack.pojo.FetchQuestionsList;
import com.mostafahelal.stack.pojo.Item;

import java.util.List;

public class MainActivity extends BaseActivity
        implements  QuestionsListViewMvc.Listener,
        FetchQuestionsList.Listener {


    private static final int NUM_OF_QUESTIONS_TO_FETCH  = 50;
    private QuestionsListViewMvc viewMvc;
    private FetchQuestionsList fetchQuestions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // viewMvc=new QuestionsListViewMVCImpl(LayoutInflater.from(this) ,null);
        viewMvc=getPresentationCompositionRoot().getViewMvcFactory().newInstance(QuestionsListViewMvc.class,null);
        setContentView(viewMvc.getRootView());
        fetchQuestions=getCompositionRoot().getfetchQuestionsListUseCase();


    }

    @Override
    protected void onStart() {
        super.onStart();
        viewMvc.registerListener(this);
        fetchQuestions.registerListener(this);
        fetchQuestions.fetchLastActiveQuestionsAndNotify(NUM_OF_QUESTIONS_TO_FETCH);
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewMvc.unregisterListener(this);
        fetchQuestions.unregisterListener(this);

    }

    @Override
    public void onQuestionClicked(Item item) {
        DetailActivity.start(MainActivity.this,item.getQuestionId());

    }

    @Override
    public void onFetchOfQuestionsSucceeded(List<Item> questions) {
        viewMvc.bindQuestions(questions);
    }

    @Override
    public void onFetchOfQuestionsFailed() {
        DialogManeger dialogManeger=getCompositionRoot().getDialogsManagerFactory().newDialogManager(getSupportFragmentManager());
        dialogManeger.showRetainedDialogWithId(ServerErrorDialogFragment.newInstance(),"");
    }
}