package com.coap.chenillard;


import android.content.Context;
import android.graphics.AvoidXfermode;
import android.graphics.drawable.Drawable;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.coap.chenillard.model.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Main_chenil extends Activity {
    //--Initialisation of Views and model

    Button service;
    Boolean on=false;
    ListView list;
    ImageView img1;
    Drawable d1,d2;
    Dialog dialog;
    Dialog2 dialog2;
    Model Current;
    TextView id,ip,t,n;
    int i=0;
    adapt adapter;
    Array_holder holder;
    ArrayList<Model> array;
    /*
    *
    * Android build life Cycle
    * -----------------------
    * onCreate()
    * onStop()
    * onPause()
    * onDestroy()
    *
    * */
    @Override
    protected void onSaveInstanceState(Bundle outstate){
        super.onSaveInstanceState(outstate);

        outstate.putSerializable("Current",Current);

        Array_holder hold=new Array_holder((ArrayList<Model>)array.clone());
        array.clear();
        Toast.makeText(this,"saveInstance",Toast.LENGTH_LONG).show();
        outstate.putSerializable("array", hold);
        outstate.putBoolean("service",on);
    }
    @Override
    protected void onRestoreInstanceState(Bundle outstate){
        super.onRestoreInstanceState(outstate);
    }
     @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chenil);
         Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show();

         //---------model--------
        array=new ArrayList<Model>();

         //----------old instance Restore------
         if(savedInstanceState!=null){
             holder = (Array_holder) savedInstanceState.getSerializable("array");
             on=savedInstanceState.getBoolean("service");
                            }
        if(holder!=null)
            array=new ArrayList<Model>((ArrayList<Model>)holder.ar.clone());

        //l1 = (LinearLayout)getLayoutInflater().inflate(R.layout.z1_controller,null); // We can't add a layout that is the context of current activity
        service = (Button)findViewById(R.id.service);
        img1=(ImageView)findViewById(R.id.stateled);
        //-------------------------------
        id=(TextView)findViewById(R.id.t1);
        ip=(TextView)findViewById(R.id.t2);
        t=(TextView)findViewById(R.id.t3);
        n=(TextView)findViewById(R.id.t4);
        if(savedInstanceState!=null)
            Current=(Model)savedInstanceState.getSerializable("Current");
        if(Current!=null ){
            this.id.setText("Id : "+Current.get_id());
            this.ip.setText("Ip : "+Current.get_ip());
            this.t.setText("t : "+Current.get_t());
            this.n.setText("n : "+Current.get_n());
        }
        //-----------List Adapter---------
        adapter=new adapt(this);
        list=(ListView)findViewById(R.id.yes);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Current=array.get(position);
                Main_chenil.this.id.setText("Id : "+Current.get_id());
                Main_chenil.this.ip.setText("Ip : "+Current.get_ip());
                Main_chenil.this.t.setText("t : " + Current.get_t());
                Main_chenil.this.n.setText("n : " + Current.get_n());
            }
        });

        adapter.setNotifyOnChange(true);
        list.setAdapter(adapter);
        //---example Add to list ------
       // adapter.add(new Model("123","123.AZE123.","123","11"));
        //adapter.add(new Model("124","123.AZE123.","123","11"));
        //adapter.add(new Model("125","123.AZE123.","123","11"));
        //--------Dialog show----------
        dialog = new Dialog();
        dialog.SetAddapter(adapter);
        dialog2=new Dialog2();
        dialog2.SetAddapter(adapter,this,array);
        //------------Add/remove Button---------
        ImageButton b1=(ImageButton)findViewById(R.id.imageb1);
        ImageButton b2=(ImageButton)findViewById(R.id.imageb2);
        b1.setOnClickListener(new Image_Listenner());
        b2.setOnClickListener(new Image_Listenner2());
        //----------------------
        //Toast.makeText(this,"rr",Toast.LENGTH_SHORT).show();
        d1=getResources().getDrawable(R.drawable.vert);
        d2=getResources().getDrawable(R.drawable.rouge);
        if(on){
            service.setText(R.string.off);
            img1.setImageDrawable(d1);
        }else{
            service.setText(R.string.on);
            img1.setImageDrawable(d2);
        }
        //--------service On/off Listener button
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(on){
                    service.setText(R.string.on);
                    img1.setImageDrawable(d2);
                }else{
                    service.setText(R.string.off);
                    img1.setImageDrawable(d1);
                }
                on=!on;

            }
        });
        //Toast.makeText(this,n.getContext().toString(),Toast.LENGTH_LONG).show();
        //----------------------------------

    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(this,"Restart",Toast.LENGTH_LONG).show();

    }
    @Override
    protected void onStop(){
        //Buton.setVisibility(View.INVISIBLE);
        //Toast.makeText(this,"off",Toast.LENGTH_LONG).show();
        super.onStop();
    }

    @Override
    protected void onPause(){
       super.onPause();
    }
    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this,"Resume",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"Activity destroyed",Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_chenil, menu);
        return true;
    }

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this,"menu",Toast.LENGTH_LONG);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
    class adapt extends ArrayAdapter<Model>{

       Context c;
        adapt(Context c){
            super(c,R.layout.liste_container,R.id.node_id,array);
            this.c=c;
        }
       @Override
       public View getView(int pos, View v,ViewGroup Root){
            View view=v;
            if(v==null){
                LayoutInflater inflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view=(RelativeLayout)inflater.inflate(R.layout.liste_container,Root,false);}
                TextView t=(TextView)view.findViewById(R.id.node_id);
                //Toast.makeText(c,"pos : "+pos,Toast.LENGTH_SHORT).show();
                t.setText(array.get(pos).get_id());

           //Toast.makeText(c,"pos : "+pos,Toast.LENGTH_SHORT).show();
           return view;

       }
       @Override
       public void notifyDataSetChanged(){
           super.notifyDataSetChanged();
           Toast.makeText(c,"Item Added",Toast.LENGTH_SHORT).show();
           //Toast.makeText(c,model.toString(),Toast.LENGTH_SHORT).show();

       }
       @Override
       public void add(Model t){
          super.add(t);
       }
       @Override
       public void remove(Model t){
           super.remove(t);
       }
       @Override
       public Model getItem(int t){
           return super.getItem(t);
       }

   }
    class Image_Listenner implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            dialog.show(getFragmentManager(),"Add_Led");
        }
    }
    class Image_Listenner2 implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            dialog2.show(getFragmentManager(),"Add_Led2");
        }
    }
    public static class Array_holder implements Serializable{
        private static final long serialVersionUID = 1L;
        private ArrayList<Model> ar;
        public Array_holder(ArrayList<Model> a){
            ar=a;
        }
    }
}
