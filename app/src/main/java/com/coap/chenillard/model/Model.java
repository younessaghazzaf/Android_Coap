package com.coap.chenillard.model;
import com.coap.chenillard.*;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by controlberkani on 10/07/2015.
 */
public class Model implements Serializable{
    String id,ip,t,n;

    public Model(String id,String ip,String t,String n){
        this.id=id;
        this.ip=ip;
        this.t=t;
        this.n=n;
    }
    //------Getter--------
    public String get_id(){
        return id;
    }
    public String get_ip(){
        return ip;
    }
    public String get_t(){
        return t;
    }
    public String get_n(){
        return n;
    }
    //------setter--------
    public void set_id(String id){
        this.id=id;
    }
    public void set_ip(String ip){
        this.ip=ip;
    }
    public void set_t(String t){
        this.t=t;
    }
    public void set_n(String n){
        this.n=n;
    }


    public String toString(){
        StringBuffer b=new StringBuffer();
        b.append("id = "+id + "\n");
        b.append("ip = "+ip + "\n");
        b.append("t = "+t + "\n");
        b.append("n = "+n + "\n");
        return b.toString();
    }
}
