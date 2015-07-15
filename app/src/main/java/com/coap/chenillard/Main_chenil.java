package com.coap.chenillard;


import android.content.Context;
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

import java.util.ArrayList;

public class Main_chenil extends Activity {
    //--Initialisation of Views and model
    Button service;
    Boolean on=false;
    ListView list;
    ImageView img1;
    Drawable d1,d2;
    Dialog dialog;
    Model model;
    int i=0;
    adapt adapter;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chenil);
        //----State model

        array=new ArrayList<Model>();
        //l1 = (LinearLayout)getLayoutInflater().inflate(R.layout.z1_controller,null); // We can't add a layout that is the context of current activity
        service = (Button)findViewById(R.id.service);
        img1=(ImageView)findViewById(R.id.stateled);
        //-----------List Adapter---------
        adapter=new adapt(this);
        list=(ListView)findViewById(R.id.yes);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Main_chenil.this,array.get(position).get_id(),Toast.LENGTH_SHORT).show();

            }
        });
        adapter.setNotifyOnChange(true);
        list.setAdapter(adapter);
        //---example Add to list ------
        adapter.add(new Model("123","123.AZE123.","123","11"));
        adapter.add(new Model("124","123.AZE123.","123","11"));
        adapter.add(new Model("125","123.AZE123.","123","11"));
        //--------Dialog show----------
        dialog = new Dialog();
        dialog.SetAddapter(adapter);
        //------------Add/remove Button---------
        ImageButton b1=(ImageButton)findViewById(R.id.imageb1);
        ImageButton b2=(ImageButton)findViewById(R.id.imageb2);
        b1.setOnClickListener(new Image_Listenner());
        //----------------------
        //Toast.makeText(this,"rr",Toast.LENGTH_SHORT).show();
        d1=getResources().getDrawable(R.drawable.vert);
        d2=getResources().getDrawable(R.drawable.rouge);

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
    protected void onStop(){
        //Buton.setVisibility(View.INVISIBLE);
        //Toast.makeText(this,"off",Toast.LENGTH_LONG).show();
        super.onStop();
    }

    @Override
    protected void onPause(){
       super.onPause();

        i=100;
    }
    @Override
    protected void onResume(){
        super.onResume();

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

   }
    class Image_Listenner implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            dialog.show(getFragmentManager(),"Add_Led");
        }
    }
}
