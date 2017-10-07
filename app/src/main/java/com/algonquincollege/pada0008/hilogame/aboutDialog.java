package com.algonquincollege.pada0008.hilogame;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 *  Purpose HiLo Game for assignment.
 *  @author Janki Padaliya (pada0008)
 *  date : 2017-10-06
 */


public class aboutDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String DialogMsg = getString(R.string.author);

        // Decorate our About dialog
        builder.setTitle(R.string.alertDialog)
                .setMessage(DialogMsg)
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();

    }


}
