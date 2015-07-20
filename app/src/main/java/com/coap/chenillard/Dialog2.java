package com.coap.chenillard;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.coap.chenillard.model.Model;

/**
 * Created by controlberkani on 10/07/2015.
 */
public class Dialog2 extends DialogFragment{
    ArrayAdapter<Model> array;
    RelativeLayout linear;
    EditText ed1;
    Model mod;
    Context c;
    public  void SetAddapter( ArrayAdapter<Model> a,Context con){
        array=a;
        c=con;
    }
    @Override
    public android.app.Dialog onCreateDialog(Bundle saveInstance){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        linear=(RelativeLayout)inflater.inflate(R.layout.dialog2, null);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(linear)
                // Add action buttons
                .setPositiveButton("Remove", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        ed1 = (EditText) linear.findViewById(R.id.dia2);
                        mod = getModel(ed1.getText().toString());
                        if (mod != null) {
                            array.remove(mod);
                        }
                        // array.remove();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Dialog2.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
    @Override
    public void onDetach(){
        super.onDetach();
    }
    public Model getModel(String id){
        Model in=null;
        int i=0;
        // to remove bugs!!!
        while(array.getItem(i)!=null){
            if(array.getItem(i).get_id().compareTo(id)==0){
                in=array.getItem(i);
            }
            i++;
        }
        //----------------
        return in;
    }

}
