package com.mostafahelal.stack;

import android.app.Application;

import com.mostafahelal.stack.dependency.CompositionRoot;
import com.mostafahelal.stack.dependency.PresentationCompositionRoot;


public class MyApplication extends Application {
private CompositionRoot compositionRoot;
private PresentationCompositionRoot presentationCompositionRoot;

    @Override
    public void onCreate() {
        super.onCreate();
        compositionRoot=new CompositionRoot();

    }

    public CompositionRoot getCompositionRoot() {
        return compositionRoot;
    }
    public PresentationCompositionRoot getPresentationCompositionRoot(){
        return presentationCompositionRoot;
    }
}
