package com.mostafahelal.stack.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.mostafahelal.stack.R;

public class ServerErrorDialogFragment extends DialogFragment {
    public static ServerErrorDialogFragment newInstance() {
        return new ServerErrorDialogFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

        alertDialogBuilder.setTitle(R.string.server_error_dialog_title);

        alertDialogBuilder.setMessage(R.string.server_error_dialog_message);

        alertDialogBuilder.setPositiveButton(
                R.string.server_error_dialog_button_caption,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                }
        );
        return alertDialogBuilder.create();
    }
}