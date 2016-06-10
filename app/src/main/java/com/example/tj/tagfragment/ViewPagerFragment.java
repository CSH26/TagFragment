package com.example.tj.tagfragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewPagerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final SeekBarFragment seekBarFragment = new SeekBarFragment();
        final TagFragment tagFragment = new TagFragment();

        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);

        FragmentManager childFragmentManager = getChildFragmentManager();
        //마술이 작용하는 부분 조금더 뜯어봐야 하지만 child fragment manager도 넣어주고.. ;;
        //fragment가 생성되면
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(childFragmentManager) {

            @Override
            public Fragment getItem(int position) {
                //탭이 두개이기 때문에 쓸 수 있는 특수한 경우이다. 3개 이상인 경우 스위치가 적당하다.
                return position == 0 ? seekBarFragment : tagFragment ;
            }



            @Override
            public CharSequence getPageTitle(int position) {
                return position == 0 ? "Seek Bar" : "Tag" ;
            }





            @Override
            public int getCount() {
                return 2;
            }
        };

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setAdapter(fragmentPagerAdapter);


        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }

}
