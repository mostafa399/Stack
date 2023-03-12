package com.mostafahelal.stack.common;

import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;

import com.mostafahelal.stack.MyApplication;
import com.mostafahelal.stack.dependency.CompositionRoot;
import com.mostafahelal.stack.dependency.PresentationCompositionRoot;

public class BaseActivity extends AppCompatActivity {
PresentationCompositionRoot presentationCompositionRoot;

    public PresentationCompositionRoot getPresentationCompositionRoot() {
        if (presentationCompositionRoot==null){
            presentationCompositionRoot=new PresentationCompositionRoot(getCompositionRoot(),
                    getSupportFragmentManager(), LayoutInflater.from(this));
        }
        return presentationCompositionRoot;
    }

    protected CompositionRoot getCompositionRoot() {
        return ((MyApplication)getApplication()).getCompositionRoot();

    }
}
