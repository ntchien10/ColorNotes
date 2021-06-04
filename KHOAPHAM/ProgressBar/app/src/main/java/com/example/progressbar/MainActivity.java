package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btnDownload);
        progressBar =(ProgressBar) findViewById(R.id.progressBar);

        progressBar.setMax(100);
        progressBar.setProgress(0);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countDownTimer=new CountDownTimer(10000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        progressBar.setProgress(progressBar.getProgress()+10);
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(MainActivity.this, "Time up!", Toast.LENGTH_SHORT).show();
                    }
                };
                countDownTimer.start();
            }
        });
    }
}