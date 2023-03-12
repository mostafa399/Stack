package com.mostafahelal.stack.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.mostafahelal.stack.detailquestion.QuestionDetailsViewMVC;
import com.mostafahelal.stack.detailquestion.QuestionDetailsViewMvcImpl;
import com.mostafahelal.stack.questionlist.QuestionsListViewMVCImpl;
import com.mostafahelal.stack.questionlist.QuestionsListViewMvc;
import com.mostafahelal.stack.questionlist.ViewMvc;

public class ViewMvcFactory {
    private final LayoutInflater layoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }
public <T extends ViewMvc>T newInstance(Class<T>MvcViewClass, @NonNull ViewGroup container){
        ViewMvc viewMvc;
        if (MvcViewClass== QuestionsListViewMvc.class){
            viewMvc=new QuestionsListViewMVCImpl(layoutInflater,container);
        } else if (MvcViewClass== QuestionDetailsViewMVC.class) {
            viewMvc=new QuestionDetailsViewMvcImpl(layoutInflater,container);
            
        }else {
            throw new IllegalArgumentException("Unsupported Mvc View Class"+layoutInflater);
        }
        return (T)viewMvc;
}
}
