package com.coap.chenillard;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Main_chenil extends Activity {
    Button service;
    Boolean on=false;
    ImageView img1;
    Drawable d1,d2;

    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chenil);
        //l1 = (LinearLayout)getLayoutInflater().inflate(R.layout.z1_controller,null); // We can't add a layout that is the context of current activity
        service = (Button)findViewById(R.id.service);
        img1=(ImageView)findViewById(R.id.stateled);

        Toast.makeText(this,service.getText(),Toast.LENGTH_SHORT).show();
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

}
