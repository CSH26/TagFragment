package com.example.tj.tagfragment;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by 301 on 2016-06-10.
 */
public class Floater {

    private static final String TAG = "Floater";
    private Context context;
    private int size;
    private LinearLayout horizontalLayout1;
    private LinearLayout horizontalLayout2;

    public Floater(Context context) {
        this.context = context;
        this.size = 0;
    }

    public void tagDraw(LinearLayout layout, Tag tag){
        layout.addView(tag);
    }

    public void changeDraw(LinearLayout layout, Tag tag){
        if(size==0) {
            layoutDynamicAddView(layout);           //레이아웃을 셋팅하고 필드에 반환된 레이아웃을 메인레이아웃에 추가
            layout.addView(horizontalLayout1);
            layout.addView(horizontalLayout2);
        }
        if(size < 4){
            horizontalLayout1.addView(tag);
        }else {
            horizontalLayout2.addView(tag);
        }
        size++;

    }

    // 태그 메시지가 특정개수 이상되면 해당페이지에 동적으로 레이아웃 추가
    public void layoutDynamicAddView(LinearLayout layout){
        LinearLayout horizontalLayout1 = new LinearLayout(context);
        LinearLayout horizontalLayout2 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layout.setOrientation(LinearLayout.VERTICAL);

        horizontalLayout1.setOrientation(LinearLayout.HORIZONTAL);
        horizontalLayout1.setLayoutParams(layoutParams1);
        horizontalLayout1.setGravity(Gravity.CENTER);
        horizontalLayout2.setOrientation(LinearLayout.HORIZONTAL);
        horizontalLayout2.setLayoutParams(layoutParams2);
        horizontalLayout2.setGravity(Gravity.CENTER);

        //필드 레이아웃에 추가.
        this.horizontalLayout1 = horizontalLayout1;
        this.horizontalLayout2 = horizontalLayout2;

    }

    public void resetSize(){
        size = 0;
    }
}
