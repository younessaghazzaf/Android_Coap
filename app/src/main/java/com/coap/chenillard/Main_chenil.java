package com.coap.chenillard;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Main_chenil extends ActionBarActivity {
    View Buton;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chenil);
        //Buton=(Button)findViewById(R.id.b1);
       // Toast t=Toast.makeText(this,"yes",Toast.LENGTH_LONG);
        //t.show();
    }

    @Override
    protected void onStop(){
        //Buton.setVisibility(View.INVISIBLE);
        Toast.makeText(this,"off",Toast.LENGTH_LONG).show();
        super.onStop();
    }

    @Override
    protected void onPause(){
       super.onPause();
        Toast.makeText(this,"1000",Toast.LENGTH_LONG).show();
        i=100;
    }
    @Override
    protected void onResume(){
        super.onResume();
        if(i==100){
            Toast.makeText(this,"1000",Toast.LENGTH_LONG).show();
        }
        i=0;
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"offdes",Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_chenil, menu);
        return true;
    }

    @Override
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
    }

}
