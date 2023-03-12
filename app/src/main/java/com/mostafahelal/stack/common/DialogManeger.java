package com.mostafahelal.stack.common;

import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
@UiThread
public class DialogManeger {
    public static final String ARGUMENT_DIALOG_ID = "ARGUMENT_DIALOG_ID";
    private static final String DIALOG_FRAGMENT_TAG = "DIALOG_FRAGMENT_TAG";
    private  FragmentManager fragmentManager;
    private DialogFragment dialogFragment;

    public DialogManeger(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        Fragment fragment = fragmentManager.findFragmentByTag(DIALOG_FRAGMENT_TAG);

        if (fragment != null && DialogFragment.class.isAssignableFrom(
                fragment.getClass())){
            dialogFragment = (DialogFragment) fragment;

        }

    }


    public DialogFragment getmCurrentlyShownDialog() {
        return dialogFragment;
    }
    public String getCurrentlyShownDialogId() {
        if (dialogFragment == null || dialogFragment.getArguments() == null ||
                !dialogFragment.getArguments().containsKey(ARGUMENT_DIALOG_ID)) {
            return "";
        } else {
            return dialogFragment.getArguments().getString(ARGUMENT_DIALOG_ID);
        }
    }
    public boolean isDialogCurrentlyShown(String id) {
        String shownDialogId = getCurrentlyShownDialogId();
        return !TextUtils.isEmpty(shownDialogId) && shownDialogId.equals(id);
    }
    public void dismissCurrentlyShownDialog() {
        if (dialogFragment != null) {
            dialogFragment.dismissAllowingStateLoss();
            dialogFragment = null;
        }
    }


    public void showRetainedDialogWithId(DialogFragment dialog, @Nullable String id) {
        dismissCurrentlyShownDialog();
        dialog.setRetainInstance(true);
        setId(dialog, id);
        showDialog(dialog);
    }
    private void setId(DialogFragment dialog, String id) {
        Bundle args = dialog.getArguments() != null ? dialog.getArguments() : new Bundle(1);
        args.putString(ARGUMENT_DIALOG_ID, id);
        dialog.setArguments(args);
    }

    private void showDialog(DialogFragment dialog) {
        fragmentManager.beginTransaction()
                .add(dialog, DIALOG_FRAGMENT_TAG)
                .commitAllowingStateLoss();
        dialogFragment = dialog;
    }

}
