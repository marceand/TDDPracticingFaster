package com.marceme.tddfasterpracting.util;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.marceme.tddfasterpracting.R;
import com.marceme.tddfasterpracting.imageui.ImageActivity;

/**
 * @author Marcelino Yax-marce7j@gmail.com-Android Developer
 *         Created on 2/25/2017.
 */

public class DialogFactory {
    public static Dialog createErrorDialog(Context context, String message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context)
                .setTitle(context.getString(R.string.dialog_error_title))
                .setMessage(message)
                .setNeutralButton(R.string.dialog_action_ok, null);
        return alertDialog.create();
    }
}
