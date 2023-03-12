package com.mostafahelal.stack.dependency;

import android.view.LayoutInflater;

import androidx.annotation.UiThread;
import androidx.fragment.app.FragmentManager;

import com.mostafahelal.stack.common.DialogManeger;
import com.mostafahelal.stack.common.ViewMvcFactory;
import com.mostafahelal.stack.pojo.FetchQuestionDetails;
import com.mostafahelal.stack.pojo.FetchQuestionsList;

public class PresentationCompositionRoot {
    private final CompositionRoot compositionRoot;
    private final FragmentManager fragmentManager;
    private LayoutInflater layoutInflater;

    public PresentationCompositionRoot(CompositionRoot compositionRoot
            , FragmentManager fragmentManager
            , LayoutInflater layoutInflater) {
        this.compositionRoot = compositionRoot;
        this.fragmentManager = fragmentManager;
        this.layoutInflater = layoutInflater;
    }

    public DialogManeger getDialogManeger(){
        return new DialogManeger(fragmentManager);
    }
    public FetchQuestionDetails getfetchQuestionDetailsUseCase(){
        return compositionRoot.getfetchQuestionDetailsUseCase();
    }

    @UiThread
    public FetchQuestionsList getfetchQuestionsListUseCase(){
        return compositionRoot.getfetchQuestionsListUseCase();
    }
    public ViewMvcFactory getViewMvcFactory(){
        return new ViewMvcFactory(layoutInflater);
    }
}
