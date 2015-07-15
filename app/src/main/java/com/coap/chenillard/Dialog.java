package com.coap.chenillard;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

/**
 * Created by controlberkani on 10/07/2015.
 */
public class Dialog extends DialogFragment{
    @Override
    public android.app.Dialog onCreateDialog(Bundle saveInstance){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.dialog, null))
                // Add action buttons
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Dialog.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
    @Override
    public void onDetach(){
        super.onDetach();
        Toast.makeText(this.getActivity(),"Dialog dismiss",Toast.LENGTH_SHORT).show();
    }

}
