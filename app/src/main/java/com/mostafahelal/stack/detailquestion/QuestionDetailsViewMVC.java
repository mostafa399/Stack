package com.mostafahelal.stack.detailquestion;

import com.mostafahelal.stack.pojo.QuestionWithBody;
import com.mostafahelal.stack.questionlist.ObservableViewMvc;

public interface QuestionDetailsViewMVC extends ObservableViewMvc<QuestionDetailsViewMVC.Listener> {
     interface Listener {
    }
    void bindQuestion(QuestionWithBody question);

}
