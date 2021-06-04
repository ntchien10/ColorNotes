package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    RelativeLayout manhinh;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manhinh=(RelativeLayout) findViewById(R.id.manhinh);
        manhinh.setBackgroundResource(R.drawable.android);

    }
}