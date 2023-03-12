package com.mostafahelal.stack.questionlist;

public interface ObservableViewMvc <ListenerType> extends ViewMvc{
    void registerListener(ListenerType listenerType);
    void unregisterListener(ListenerType listenerType);
}
