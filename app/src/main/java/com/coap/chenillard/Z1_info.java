package com.coap.chenillard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by controlberkani on 08/07/2015.
 */
public class Z1_info extends RelativeLayout{
    public Z1_info(Context context, AttributeSet attrs) {
        super(context, attrs);
        RelativeLayout r1=(RelativeLayout)inflate(context,R.layout.z1_info,null);
        this.addView(r1);

    }
}
