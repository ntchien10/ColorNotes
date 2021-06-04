package com.example.viewpagerexample;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return FragmentViewPager.newInstance("Buoi",R.drawable.buoi);

            case 1:
                return FragmentViewPager.newInstance("Tao",R.drawable.tao);

            case 2:
                return FragmentViewPager.newInstance("Thanh long",R.drawable.thanhlong);

            default:
                return FragmentViewPager.newInstance("Buoi",R.drawable.buoi);
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
