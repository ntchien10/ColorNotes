package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioButtonTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButtonTime=(RadioGroup) findViewById(R.id.radioThoiGian);
        radioButtonTime.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButtonSang:
                        Toast.makeText(MainActivity.this, "Chào buổi sáng", Toast.LENGTH_SHORT).show();
                    break;
                    case R.id.radioButtonTrua:
                        Toast.makeText(MainActivity.this, "Chào buổi trưa", Toast.LENGTH_SHORT).show();
                    break;
                    case R.id.radioButtonChieu:
                        Toast.makeText(MainActivity.this, "Chào buổi chiều", Toast.LENGTH_SHORT).show();
                    break;
                }

            }
        });
    }

}