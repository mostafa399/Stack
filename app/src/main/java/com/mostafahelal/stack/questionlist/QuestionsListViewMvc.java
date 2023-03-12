package com.mostafahelal.stack.questionlist;

import com.mostafahelal.stack.pojo.Item;

import java.util.List;

public interface QuestionsListViewMvc extends ObservableViewMvc<QuestionsListViewMvc.Listener>{
     interface Listener {
        void onQuestionClicked(Item item);
    }
    void bindQuestions(List<Item >items);
}
