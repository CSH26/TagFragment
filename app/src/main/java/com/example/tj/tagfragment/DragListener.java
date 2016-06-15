package com.example.tj.tagfragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by csh on 2016-06-12.
 */
public class DragListener implements View.OnDragListener {

    private Context context;
    Drawable normalShape;
    Drawable targetShape;

    public DragListener(Context context, Drawable normalShape, Drawable targetShape) {
        this.context = context;
        this.normalShape = normalShape;
        this.targetShape = targetShape;
    }

    public boolean onDrag(View v, DragEvent event) {

        // 이벤트 시작
        switch (event.getAction()) {

            // 이미지를 드래그 시작될때
            case DragEvent.ACTION_DRAG_STARTED:
                Log.d("DragClickListener", "ACTION_DRAG_STARTED");
                break;

            // 드래그한 이미지를 옮길려는 지역으로 들어왔을때
            case DragEvent.ACTION_DRAG_ENTERED:
                Log.d("DragClickListener", "ACTION_DRAG_ENTERED");
                // 이미지가 들어왔다는 것을 알려주기 위해 배경이미지 변경
                v.setBackground(targetShape);
                break;

            // 드래그한 이미지가 영역을 빠져 나갈때
            case DragEvent.ACTION_DRAG_EXITED:
                Log.d("DragClickListener", "ACTION_DRAG_EXITED");
                v.setBackground(normalShape);
                break;

            // 이미지를 드래그해서 드랍시켰을때
            case DragEvent.ACTION_DROP:
                Log.d("DragClickListener", "ACTION_DROP");

                if (v == v.findViewById(R.id.basketLayout)) {  // 장바구니 레이아웃에 아이템이 드랍되면
                    View view = (View) event.getLocalState();
                    ViewGroup viewgroup = (ViewGroup) view
                            .getParent();
                    viewgroup.removeView(view);
                    // cloud 레이아웃에서 기존 뷰 제거
                    Toast.makeText(context, "추가 되었습니다.",Toast.LENGTH_SHORT).show();

                    // basket 레이아웃에 뷰 추가
                    LinearLayout containView = (LinearLayout) v;
                    containView.addView(view);
                    view.setVisibility(View.VISIBLE);

                }else if (v == v.findViewById(R.id.cloudLayout)) { // 기존 레이아웃에 드랍되면
                    View view = (View) event.getLocalState();
                    ViewGroup viewgroup = (ViewGroup) view
                            .getParent();
                    viewgroup.removeView(view);  // basket레이아웃에서 뷰를 제거하고

                    // cloud레이아웃에 뷰 추가
                    LinearLayout containView = (LinearLayout) v;
                    containView.addView(view);
                    view.setVisibility(View.VISIBLE);

                }else {
                    View view = (View) event.getLocalState();
                    view.setVisibility(View.VISIBLE);
                    Toast.makeText(context,
                            "이미지를 다른 지역에 드랍할수 없습니다.",
                            Toast.LENGTH_LONG).show();
                    break;
                }
                break;

            case DragEvent.ACTION_DRAG_ENDED:
                Log.d("DragClickListener", "ACTION_DRAG_ENDED");
                v.setBackground(normalShape); // go back to normal shape

            default:
                break;
        }
        return true;
    }
}
