package com.coap.chenillard;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by controlberkani on 08/07/2015.
 */
public class Z1_info extends RelativeLayout{
        Dialog d;
        Context c;
        Activity a;
    public Z1_info(Context context, AttributeSet attrs) {
        super(context, attrs);

        c=context;
        RelativeLayout r1=(RelativeLayout)inflate(context,R.layout.z1_info,null);
        this.addView(r1);


    }


}
