package com.example.tj.tagfragment;

import android.content.ClipData;
import android.content.ClipDescription;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 301 on 2016-06-10.
 */
public class TouchListener implements View.OnTouchListener {
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        // 태그 생성
        ClipData.Item item = new ClipData.Item(
                (CharSequence) view.getTag());

        String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
        ClipData data = new ClipData(view.getTag().toString(),
                mimeTypes, item);
        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                view);

        view.startDrag(data, // data to be dragged
                shadowBuilder, // drag shadow
                view, // 드래그 드랍할  Vew
                0 // 필요없은 플래그
        );

        view.setVisibility(View.INVISIBLE);
        return false;
    }
}
