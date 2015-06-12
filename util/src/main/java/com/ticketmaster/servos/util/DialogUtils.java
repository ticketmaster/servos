package com.ticketmaster.servos.util;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnShowListener;
import android.support.annotation.StringRes;
import android.text.Editable;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public final class DialogUtils {

    private DialogUtils() { }

    /**
     * Get a dialog that shows the provided title and an indeterminate spinner. You are responsible for showing and canceling it.
     */
    public static ProgressDialog getProgressDialog(Context context, String title) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(title);
        progressDialog.setIndeterminate(true);
        return progressDialog;
    }

    /**
     * Get a dialog that shows the provided title and an indeterminate spinner. You are responsible for showing and canceling it.
     */
    public static ProgressDialog getProgressDialog(Context context, @StringRes int titleResId) {
        return getProgressDialog(context, context.getResources().getString(titleResId));
    }

    /**
     * Get a dialog that shows the provided message and an "OK" button to dismiss.
     */
    public static AlertDialog getMessageDialog(Context context, String message) {
        return new Builder(context)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }

    /**
     * Get a dialog that shows the provided message and an "OK" button to dismiss.
     */
    public static AlertDialog getMessageDialog(Context context, @StringRes int messageId) {
        return getMessageDialog(context, context.getResources().getString(messageId));
    }

    /**
     * Get a dialog that shows the provided message and has two buttons: OK and Cancel. The dialog will be dismissed if either button is pressed.
     * @param onClickListener The listener to be called if OK is clicked.
     */
    public static AlertDialog getOkCancelDialog(final Context context,
                                               String message,
                                               OnClickListener onClickListener) {
        return new Builder(context)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, onClickListener)
                .setNegativeButton(android.R.string.cancel, null)
                .create();
    }

    /**
     * Get a dialog that shows the provided message and has two buttons: OK and Cancel. The dialog will be dismissed if either button is pressed.
     * @param onClickListener The listener to be called if OK is clicked.
     */
    public static AlertDialog getOkCancelDialog(final Context context,
                                                @StringRes int messageId,
                                                OnClickListener onClickListener) {
        return getOkCancelDialog(context, context.getResources().getString(messageId), onClickListener);
    }

    /**
     * Get a dialog with a title and an EditText for the user to type in. Automatically opens the keyboard when shown.
     * @param title The title of the window
     * @param hint  The hint of the EditText if initialInputText is empty.
     * @param initialInputText The text that will be set on the EditText initially.
     * @param listener The listener that will be called when the user clicks "OK" and be given the text that they entered.
     */
    public static AlertDialog getInputDialog(final Context context,
                                             String title,
                                             final String hint,
                                             final String initialInputText,
                                             final OnTextEnteredListener listener) {
        final EditText inputField = new EditText(context);
        inputField.setHint(hint);
        inputField.setText(initialInputText);
        AlertDialog dialog = new Builder(context)
                .setTitle(title)
                .setPositiveButton(android.R.string.ok, new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (listener != null) {
                            listener.onTextEntered(inputField.getText());
                        }
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .create();
        int padding = (int) DensityUtils.dpToPx(16);
        dialog.setView(inputField, padding, padding, padding, 0);
        dialog.setOnShowListener(new OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                InputMethodManager inputManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(inputField, InputMethodManager.SHOW_IMPLICIT);
            }
        });
        return dialog;
    }

    /**
     * Get a dialog with a title and an EditText for the user to type in. Automatically opens the keyboard when shown.
     * @param titleId The title of the window
     * @param hintId  The hint of the EditText if initialInputText is empty.
     * @param initialInputText The text that will be set on the EditText initially.
     * @param listener The listener that will be called when the user clicks "OK" and be given the text that they entered.
     */
    public static AlertDialog getInputDialog(final Context context,
                                             @StringRes int titleId,
                                             @StringRes int hintId,
                                             final String initialInputText,
                                             final OnTextEnteredListener listener) {
        return getInputDialog(context, context.getResources().getString(titleId),
                context.getResources().getString(hintId), initialInputText, listener);
    }

    /**
     * Listener to be called when a user finishes editing text in an input dialog.
     */
    public interface OnTextEnteredListener {
        /**
         * Listener to be called when a user finishes editing text in an input dialog.
         * @param text The text of the EditText in the input dialog when the user clicked "Ok".
         */
        void onTextEntered(Editable text);
    }
}
