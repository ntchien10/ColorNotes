package com.example.randombackground;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    ArrayList<Integer> arrayImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout =(LinearLayout) findViewById(R.id.myLinearLayout);
        arrayImage=new ArrayList<>();
        arrayImage.add(R.drawable.nen1);
        arrayImage.add(R.drawable.nen2);
        arrayImage.add(R.drawable.nen3);
        arrayImage.add(R.drawable.nen4);
        Random random=new Random();
        int vitri= random.nextInt(arrayImage.size());
        linearLayout.setBackgroundResource(arrayImage.get(vitri));
    }
}