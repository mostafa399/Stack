package com.mostafahelal.stack.questionlist;

import android.content.Context;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.StringRes;

public abstract class BaseViewMvc<ListenerType>extends BaseObservable<ListenerType>
        implements ObservableViewMvc<ListenerType> {

    private View mRootView;

    public View getRootView() {
        return mRootView;
    }

    protected void setRootView(View mRootView) {
        this.mRootView = mRootView;
    }
    @SuppressWarnings("unchecked")
    protected <T extends View> T findViewById(@IdRes int id){
        return (T) mRootView.findViewById(id);
    }


    protected Context getContext(){
        return getRootView().getContext();
    }

    protected String getString(@StringRes int id){return getContext().getString(id);}
    protected String getString(@StringRes int id, Object... formatArgs){
        return getContext().getString(id, formatArgs);
    }

}
