package com.example.serviceandbroadcastexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


import static com.example.serviceandbroadcastexample.MainActivity.DOWNLOAD_COMPLETE_ACTION;
import static com.example.serviceandbroadcastexample.DownloadService.URL_ARG;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_WRITE_STORAGE = 1;
    private BroadcastReceiver receiver = new DownloadCompleteReceiver();

    static final String DOWNLOAD_COMPLETE_ACTION = "com.vinid.myfirstproject.download_complete";
    private static final String IMAGE_URL = "https://images.pexels.com/photos/462118/pexels-photo-462118.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
        registerBroadCastReceiver();
    }

    private void setupView(){
        findViewById(R.id.btnStartDownload).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForStartDownloadService();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    private boolean hasStoragePermission() {
        return (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }

    private void checkForStartDownloadService() {
        boolean hasPermission = hasStoragePermission();
        if (hasPermission) {
            startDownloadService();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_WRITE_STORAGE);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_WRITE_STORAGE && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startDownloadService();
        }
    }

    private void registerBroadCastReceiver() {
        IntentFilter filter = new IntentFilter(DOWNLOAD_COMPLETE_ACTION);
        registerReceiver(receiver, filter);
    }

    private void startDownloadService() {
        Toast.makeText(this, "Download started!!!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, DownloadService.class);
        intent.putExtra(URL_ARG, IMAGE_URL);
        startService(intent);
    }

    class DownloadCompleteReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String filePath = intent.getStringExtra(DownloadService.FILE_PATH_KEY);
            ImageView imageView = findViewById(R.id.ivImage);
            Glide.with(MainActivity.this)
                    .load(filePath)
                    .into(imageView);
        }
    }
}
