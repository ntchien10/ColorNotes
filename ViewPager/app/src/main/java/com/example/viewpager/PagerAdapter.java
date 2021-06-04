package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int pos) {
        switch (pos) {
            case 0:
                return Fragment1.newInstance("Bưởi", R.drawable.buoi);
            case 1:
                return Fragment1.newInstance("Táo", R.drawable.tao);
            case 2:
                return Fragment1.newInstance("Thanh long", R.drawable.thanhlong);
            default:
                return Fragment1.newInstance("buoi", R.drawable.buoi);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

}
