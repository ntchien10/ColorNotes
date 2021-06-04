package com.example.cuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtDiem;
    CheckBox cb1,cb2,cb3;
    SeekBar sk1,sk2,sk3;
    ImageButton ibtnPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        CountDownTimer countDownTimer=new CountDownTimer(60000,300) {
            @Override
            public void onTick(long millisUntilFinished) {
                int number=5;
                Random random=new Random(number);
                int one=random.nextInt(number); 
                int two=random.nextInt(number);
                int three=random.nextInt(number);
                sk1.setProgress(sk1.getProgress()+one);
                sk2.setProgress(sk2.getProgress()+two);
                sk3.setProgress(sk3.getProgress()+three);
            }

            @Override
            public void onFinish() {

            }
        };
        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.start();
            }
        });
    }
    private void AnhXa() {
        txtDiem = (TextView) findViewById(R.id.diem);
        ibtnPlay = (ImageButton) findViewById(R.id.buttonPlay);
        cb1 = (CheckBox) findViewById(R.id.checkboxOne);
        cb2 = (CheckBox) findViewById(R.id.checkboxTwo);
        cb3 = (CheckBox) findViewById(R.id.checkboxThree);
        sk1 = (SeekBar) findViewById(R.id.seebarOne);
        sk2 = (SeekBar) findViewById(R.id.seebarTwo);
        sk3 = (SeekBar) findViewById(R.id.seebarThree);
    }
}