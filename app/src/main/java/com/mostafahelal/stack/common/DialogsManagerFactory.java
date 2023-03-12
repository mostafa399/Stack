package com.mostafahelal.stack.common;

import androidx.fragment.app.FragmentManager;

public class DialogsManagerFactory {
    public DialogManeger newDialogManager(FragmentManager fragmentManager){
        return new DialogManeger(fragmentManager);
    }
}
