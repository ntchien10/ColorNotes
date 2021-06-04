package com.example.example_buoi8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.text);
        Handler h = new Handler();
//handler:
        Random random=new Random();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setText("chạy");

            }
        }, 5000);
//timer:
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(random.nextInt(100)+"");
                    }
                });

            }
        };
        long delay = 3000L;
        Timer timer = new Timer();
        timer.schedule(timerTask, 10,delay);
    }
}