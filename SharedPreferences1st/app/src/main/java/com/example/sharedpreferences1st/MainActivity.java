package com.example.sharedpreferences1st;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String SHARED_PREFERECES_NAME= "thangcoder.com";
    private final String MY_NAME ="my_name";
    private final String AGE ="age";
    private final String IS_SINGLE ="is_single";
    private final String WEIGHT = "weight";
    private final String ADDRESS = "address";
    private Button btnSaveData, btnReadData, btnRemoveKey,btnRemoveAll;
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSaveData=(Button) findViewById(R.id.btnSaveData);
        btnReadData=(Button) findViewById(R.id.btnReadData);
        btnRemoveKey=(Button)findViewById(R.id.btnRemoveKey);
        btnRemoveAll=(Button)findViewById(R.id.btnRemoveAll);

        btnSaveData.setOnClickListener(v -> {addData();});
        btnReadData.setOnClickListener(v -> {readData();});
        btnRemoveKey.setOnClickListener(v -> {
            removeByKey(MY_NAME);
            readData();
        });
        btnRemoveAll.setOnClickListener(v -> {removeAll();});
    }

    private void removeAll() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERECES_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    private void removeByKey(String key) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERECES_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.remove(key);
        editor.apply();
    }

    private void readData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERECES_NAME,Context.MODE_PRIVATE);
        String name = sharedPreferences.getString(MY_NAME,"Noname");
        int age = sharedPreferences.getInt(AGE,0);
        boolean isSingle = sharedPreferences.getBoolean(IS_SINGLE,false);
        long weight = sharedPreferences.getLong(WEIGHT,0);
        String address = sharedPreferences.getString(ADDRESS,"null");

        Log.d(TAG, "Thangcoder: "
                +"Name: "+name +"\n"
                +"Age:" +age +"\n"
                +"Single: "+isSingle +"\n"
                + "Weight: "+weight +"\n"
                +"Address: "+address);
    }

    private void addData() {
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFERECES_NAME, Context.MODE_PRIVATE);
        SharedPreferences pf= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(MY_NAME,"Nguyen The Chien");
        editor.putInt(AGE,20);
        editor.putBoolean(IS_SINGLE,false);
        editor.putLong(WEIGHT,68);
        editor.putString(ADDRESS,"Hà Nội");
        editor.apply();
        Toast.makeText(this, "save successfully", Toast.LENGTH_SHORT).show();
    }
}