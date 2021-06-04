package com.example.viewpagerexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FragmentViewPager extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup contrainer, Bundle savedInstanceState){
        super.onCreateView(inflater,contrainer,savedInstanceState);
        View v= inflater.inflate(R.layout.fragment_main,contrainer,false);

        TextView textView=(TextView)v.findViewById(R.id.tv_text);
        textView.setText(getArguments().getString("text"));

        ImageView imageView=(ImageView)v.findViewById(R.id.image);
        imageView.setBackgroundResource(getArguments().getInt("image"));

        return v;
    }
    public static FragmentViewPager newInstance(String text,int image){
        FragmentViewPager f=new FragmentViewPager();
        Bundle b=new Bundle();
        b.putString("text",text);
        b.putInt("image",image);
        f.setArguments(b);
        return f;
    }
}

