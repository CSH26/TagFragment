package com.example.tj.tagfragment;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class TagFragment extends Fragment {
    LinearLayout cloudLayout;
    LinearLayout basketLayout;
    private static final int CLOUD_SIZE = 8;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TagFragment() {
        // Required empty public constructor
    }

    public static TagFragment newInstance(String param1, String param2) {
        TagFragment fragment = new TagFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Drawable normalShape = getResources().getDrawable(
                R.drawable.normal_shape);
        Drawable targetShape = getResources().getDrawable(
                R.drawable.target_shape);

        View view = inflater.inflate(R.layout.fragment_tag, container, false);
        Resources resources = getResources();
        cloudLayout  = (LinearLayout)view.findViewById(R.id.cloudLayout);
        cloudLayout.setOnDragListener(new DragListener(view.getContext(),normalShape, targetShape));
        basketLayout = (LinearLayout)view.findViewById(R.id.basketLayout);
        basketLayout.setOnDragListener(new DragListener(view.getContext(),normalShape, targetShape));

        String[] text = new String[CLOUD_SIZE];
        Tag[] tag = new Tag[CLOUD_SIZE];
        Floater floater = new Floater(view.getContext());

        for(int i = 0;i<CLOUD_SIZE;i++){
            text[i]="TAG"+i;
            tag[i] = new Tag(view.getContext(),text[i]);
            tag[i].setOnTouchListener(new TouchListener());
            if(CLOUD_SIZE < 4)
                floater.tagDraw(cloudLayout, tag[i]);
            else
                floater.changeDraw(cloudLayout,tag[i]);
        }

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
