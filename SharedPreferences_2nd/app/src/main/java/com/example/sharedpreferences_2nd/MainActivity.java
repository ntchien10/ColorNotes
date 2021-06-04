package com.example.sharedpreferences_2nd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String SHARED_PREFERENCES_NAME="chiencoder.com";

    private final String NAME="name";
    private final String AGE="age";
    private final String IS_SINGLE="is_single";
    private final String ADDRESS="address";
    
    private final String TAG=getClass().getSimpleName();

    private Button btnSaveData,btnReadData,btnRemoveByKey,btnRemoveAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSaveData=(Button) findViewById(R.id.btnSaveData);
        btnReadData=(Button)findViewById(R.id.btnReadData);
        btnRemoveByKey=(Button)findViewById(R.id.btnRemoveByKey);
        btnRemoveAll=(Button)findViewById(R.id.btnRemoveAll);

        btnSaveData.setOnClickListener(v -> {addData();});
        btnReadData.setOnClickListener(v -> {readData();});
        btnRemoveByKey.setOnClickListener(v -> {
            removeByKey(NAME);
            readData();
        });
        btnRemoveAll.setOnClickListener(v -> {removeAll();readData();});
    }
    private void addData(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences pr= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.putString(NAME,"Nguyễn Thế Chiến");
        editor.putInt(AGE,20);
        editor.putBoolean(IS_SINGLE,false);
        editor.putString(ADDRESS,"Hà Nội");
        editor.apply();
        Toast.makeText(this, "save data successfully", Toast.LENGTH_SHORT).show();
    }
    private void readData() {
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE);

        String name=sharedPreferences.getString(NAME,"No name");
        int age=sharedPreferences.getInt(AGE,0);
        boolean is_single=sharedPreferences.getBoolean(IS_SINGLE,false);
        String address=sharedPreferences.getString(ADDRESS,"NULL");

        Log.d(TAG, "chiencoder: "
                +"\nname: "+name
                        +"\nage: "+age
                +"\nIs single: "+is_single
                +"\n address: "+address
        );
        Toast.makeText(this, "Read data successfully", Toast.LENGTH_SHORT).show();
    }

    private void removeByKey(String key){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.remove(key);
        editor.apply();
    }
    private void removeAll() {
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}