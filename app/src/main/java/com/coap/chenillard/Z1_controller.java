package com.coap.chenillard;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by controlberkani on 09/07/2015.
 */
public class Z1_controller extends LinearLayout {
    public Z1_controller(Context context, AttributeSet attrs) {
        super(context, attrs);
        LinearLayout r1=(LinearLayout)inflate(context,R.layout.z1_controller,null);
        this.addView(r1);

    }
}
