package com.coap.chenillard;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.coap.chenillard.model.Model;

/**
 * Created by controlberkani on 10/07/2015.
 */
public class Dialog extends DialogFragment{
    ArrayAdapter<Model> array;
    LinearLayout linear;
    EditText ed1,ed2,ed3,ed4;
    public  void SetAddapter( ArrayAdapter<Model> a){
        array=a;
    }
    @Override
    public android.app.Dialog onCreateDialog(Bundle saveInstance){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        linear=(LinearLayout)inflater.inflate(R.layout.dialog, null);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(linear)
                // Add action buttons
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        ed1=(EditText)linear.findViewById(R.id.edit_id);
                        array.add(new Model(ed1.getText().toString(),"","",""));
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
    }

}
