package com.example.tj.tagfragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

/**
 * Created by TJ on 2016-06-10.
 */
public class Tag extends TextView {

    private Resources resources;

    public Tag(Context context) {
        super(context);
        resources.getDrawable(R.drawable.cloud_size);

    }



}
