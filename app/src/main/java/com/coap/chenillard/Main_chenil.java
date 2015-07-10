package com.coap.chenillard;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
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

public class Main_chenil extends Activity {
    Button service;
    Boolean on=false;
    ListView list;
    ImageView img1;
    Drawable d1,d2;
    Dialog dialog;
    Model model;
    int i=0;
    adapt adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chenil);
        model=new Model(this);

        dialog = new Dialog();

        //l1 = (LinearLayout)getLayoutInflater().inflate(R.layout.z1_controller,null); // We can't add a layout that is the context of current activity
        service = (Button)findViewById(R.id.service);
        img1=(ImageView)findViewById(R.id.stateled);

        adapter=new adapt(model,this);
        list=(ListView)findViewById(R.id.yes);
        adapter.setNotifyOnChange(true);

        list.setAdapter(adapter);
        adapter.add("aze");
        adapter.add("yes");
        //---------------------
        ImageButton b1=(ImageButton)findViewById(R.id.imageb1);
        ImageButton b2=(ImageButton)findViewById(R.id.imageb2);
        b1.setOnClickListener(new Image_Listenner());
        //----------------------
        Toast.makeText(this,"rr",Toast.LENGTH_SHORT).show();
        d1=getResources().getDrawable(R.drawable.vert);
        d2=getResources().getDrawable(R.drawable.rouge);

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
    class adapt extends ArrayAdapter<String>{
       Model model1;
       Context c;
        adapt(Model m,Context c){
            super(c,R.layout.liste_container,R.id.node_id,model.get_Ids());
            this.c=c;
            model1=m;
        }
       @Override
       public View getView(int pos, View v,ViewGroup Root){
            View view=v;
            if(v==null){
                LayoutInflater inflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view=(RelativeLayout)inflater.inflate(R.layout.liste_container,Root,false);
                TextView t=(TextView)view.findViewById(R.id.node_id);
                Toast.makeText(c,t.getText(),Toast.LENGTH_SHORT).show();}

           return view;

       }
       @Override
       public void notifyDataSetChanged(){
           super.notifyDataSetChanged();
           Toast.makeText(c,"zezeze",Toast.LENGTH_SHORT).show();
       }
       @Override
       public void add(String t){
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
