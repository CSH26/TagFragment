package com.example.tj.tagfragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created by TJ on 2016-06-10.
 */
public class Tag extends TextView {

    private static final String TAG = "TagActivity";
    private Resources resources;
    private Context context;

    // 텍스트 뷰를 상속받아 백그라운드와 텍스트 컬러, 정렬등을 자동으로 생성
    public Tag(Context context, String text) {
        super(context);
        this.context = context;
        resources = getResources();
        this.setBackground(resources.getDrawable(R.drawable.cloud_size));
        this.setTextColor(Color.WHITE);
        this.setPadding(0, 0, 0, 20);
        this.setText(text);
        this.setTag(text);
        this.setGravity(Gravity.CENTER);
    }

}
