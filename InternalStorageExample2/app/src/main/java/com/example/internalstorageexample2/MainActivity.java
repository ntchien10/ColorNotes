package com.example.internalstorageexample2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSave,btnRead;
    private TextView txtData;
    private final String fileName="tenfile";
    private final String NDfile="Nguyen The Chien";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave=(Button)findViewById(R.id.btnSave);
        btnRead=(Button)findViewById(R.id.btnRead);
        txtData=(TextView)findViewById(R.id.txtData);

        btnSave.setOnClickListener(this);
        btnRead.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSave:
                saveData();
                break;
            case R.id.btnRead:
                readData();
                break;
            default:
                break;
        }
    }

    public void saveData(){
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=openFileOutput(fileName, Context.MODE_PRIVATE);
            fileOutputStream.write(NDfile.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readData() {
        try {
            File file=new File(getFilesDir(),fileName);
            FileInputStream in=openFileInput(fileName);
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            StringBuffer buffer=new StringBuffer();
            String line=null;

            while ((line=br.readLine())!=null){
                buffer.append(line);
            }
            Log.d("MainActivity",buffer.toString());
            txtData.setText(buffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}