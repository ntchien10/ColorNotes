package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonHoc;
    ArrayList<String> arrayCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMonHoc =(ListView) findViewById(R.id.listviewMonHoc);
        arrayCourse=new ArrayList<>();

        arrayCourse.add("PHP");
        arrayCourse.add("Unity");
        arrayCourse.add("Android");
        arrayCourse.add("HTML");
        arrayCourse.add("IOS");

        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arrayCourse);

        lvMonHoc.setAdapter(adapter);
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrayCourse.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Long click: "+position, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}