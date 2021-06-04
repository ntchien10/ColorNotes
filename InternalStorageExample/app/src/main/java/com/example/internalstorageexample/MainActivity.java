package com.example.internalstorageexample;

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
    private TextView textView;
    private final String filename="codedao.com";
    private final String content="chia sẻ kiến thức lập trình";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textView);
        btnSave=(Button) findViewById(R.id.buttonSave);
        btnRead=(Button) findViewById(R.id.buttonRead);

        btnSave.setOnClickListener(this);
        btnRead.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonSave:
                saveDatat();
                break;
            case R.id.buttonRead:
                readData();
                break;
            default:
                break;
        }
    }

    public void saveDatat(){
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=openFileOutput(filename, Context.MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readData(){
        try {
            File file=new File(getFilesDir(),filename);
            FileInputStream in= openFileInput(filename);
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            StringBuffer buffer=new StringBuffer();
            String line=null;
            while ((line=br.readLine())!=null){
                buffer.append(line).append("\n");
            }
            Log.d("MainACtivity",buffer.toString());
            textView.setText(buffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}