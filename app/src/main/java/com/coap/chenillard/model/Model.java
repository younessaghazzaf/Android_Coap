package com.coap.chenillard.model;
import com.coap.chenillard.*;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

/**
 * Created by controlberkani on 10/07/2015.
 */
public class Model {
    Context c;
    private ArrayList<String> li=new ArrayList<String>();
    private String[] node_id={"0","2","1"};

    public Model(Context con){
        this.c=con;


    }
    public ArrayList<String> get_Ids(){
        return (ArrayList<String>)li.clone();
    }
    public void add_id(String id){
       /* int i=Integer.getInteger(id);
        if(i==0){
            node_id[i]=id;
        }else{
            for(int j=0;j<node_id.length;j++){
                if(j==i){

                }
            }
        }*/
        li.add(id);
    }
}
