package com.example.externalstorage1st;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnSave, btnRead;

    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkAndRequestPermission();
        btnSave=(Button)findViewById(R.id.btnSave);
        btnRead=(Button)findViewById(R.id.btnRead);
        btnSave.setOnClickListener(v -> {
            savaData();
            Log.d("isExternalStorageAvailable","onclick: "+isExternalStorageAvailable());
            Log.d("isExternalStorageReadable","onclick: "+isExternalStorageReadable());
        });
        btnRead.setOnClickListener(v -> {readData();});
    }

    private void checkAndRequestPermission() {
        String[] permissions = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA
        };
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(permission);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 1);
        }
    }

    private void savaData() {
        String content="Chia sẻ kiến thức lập trình";
        File file;
        FileOutputStream fileOutputStream;
        try {
            file=new File(Environment.getExternalStorageDirectory(),"thangcoder.com");
            Log.d("MainActivity",Environment.getExternalStorageDirectory().getAbsolutePath());
            Log.d("MainActivity",getExternalFilesDir("Cheng").getAbsolutePath());
            Log.d("MainActivity",Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());

            Environment.getExternalStorageDirectory();

            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);

            fileOutputStream=new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void saveSDCard(){
        try {

            File myFile = new File("/sdcard/thangcoder.txt");
            myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter =
                    new OutputStreamWriter(fOut);
            myOutWriter.append("Cheng");
            myOutWriter.close();
            fOut.close();
            Toast.makeText(getBaseContext(),
                    "Done writing SD ",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }

    }
    private void writeToSDFile(){

        String root = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
        Log.d("Cheng", "writeToSDFile: "+root);



        File dir = new File ("/sdcard1" + "/download1");
        dir.mkdirs();
        File file = new File(dir, "myData.txt");

        try {
            FileOutputStream f = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(f);
            pw.println("Hi , How are you");
            pw.println("Hello");
            pw.flush();
            pw.close();
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.i("MainActivity", "******* File not found. Did you" +
                    " add a WRITE_EXTERNAL_STORAGE permission to the   manifest?");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readData(){
        BufferedReader input = null;
        File file = null;
        try {
            file = new File(Environment.getExternalStorageDirectory(), "thangcoder.com");

            input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = input.readLine()) != null) {
                buffer.append(line);
            }

            Log.d("MainActivity", buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        Log.d("cHENG", "isExternalStorageAvailable: "+extStorageState);
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }
    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
}