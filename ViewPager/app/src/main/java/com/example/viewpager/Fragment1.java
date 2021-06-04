package com.example.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    public Fragment1(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1, container, false);

        TextView tv = (TextView) v.findViewById(R.id.title);
        tv.setText(getArguments().getString("text"));

        ImageView imageView = (ImageView) v.findViewById(R.id.image);
        imageView.setBackgroundResource(getArguments().getInt("img"));

        return v;
    }
    public static Fragment1 newInstance(String text, int image) {

        Fragment1 f = new Fragment1();
        Bundle b = new Bundle();
        b.putString("text", text);
        b.putInt("img", image);

        f.setArguments(b);

        return f;
    }
}
