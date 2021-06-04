package com.example.externalstorage2nd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnSave,btnRead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave=(Button)findViewById(R.id.btnSave);
        btnRead=(Button)findViewById(R.id.btnRead);

        checkAndRequesPermission();
        btnSave.setOnClickListener(v -> {
            saveData();
            Log.d("ExtStorageAvailable","onclick: "+IsExternalStorageAvailable());
            Log.d("ExtStorageReadable","onclick: "+IsExternalStorageReadable());
        });
        btnRead.setOnClickListener(v -> {
            readData();
        });
    }

    private void readData() {
        BufferedReader input=null;
        File file=null;
        try{
            file=new File(Environment.getExternalStorageDirectory(),"chiencoder.com");
            input= new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            StringBuffer buffer=new StringBuffer();
            while ((line=input.readLine())!=null){
                buffer.append(line);
            }
            Log.d("MainActivity",buffer.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Boolean IsExternalStorageReadable() {
        String state=Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)||Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            return true;
        }
        return false;
    }

    private Boolean IsExternalStorageAvailable() {
        String extStorageState =Environment.getExternalStorageState();
        Log.d("chien","is External Storage State: "+extStorageState);
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)){
            return true;
        }
        return false;
    }

    private void checkAndRequesPermission() {
        String[] permissions=new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA
        };
        List<String> listPermissionNeeded=new ArrayList<>();
            for (String permission : permissions){
                if(ContextCompat.checkSelfPermission(this,permission)!= PackageManager.PERMISSION_GRANTED){
                    listPermissionNeeded.add(permission);
                }
            }
            if (listPermissionNeeded.isEmpty()){
                ActivityCompat.requestPermissions(this,listPermissionNeeded.toArray(new String[listPermissionNeeded.size()]),1);
            }
    }

    private void saveData() {
        String content="Blog chia sẻ kiến thức lập trình";
        File file;
        FileOutputStream fileOut;
        try {
            file=new File(Environment.getExternalStorageDirectory(),"chiencoder.com");
            Log.d("MainActivity",Environment.getExternalStorageDirectory().getAbsolutePath());
            Log.d("MainActivity",getExternalFilesDir("chien").getAbsolutePath());
            Log.d("MainActivity",Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());

            Environment.getExternalStorageDirectory();
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);

            fileOut=new FileOutputStream(file);
            fileOut.write(content.getBytes());
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
