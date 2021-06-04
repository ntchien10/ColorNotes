package com.example.themsuaxoalistview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btnMonHoc,btnCapNhat;
    ListView listView;
    ArrayList<String> lstMonHoc;
    int vitri=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.edittextmonhoc);
        btnMonHoc=(Button)findViewById(R.id.button);
        btnCapNhat=(Button)findViewById(R.id.button2);
        listView=(ListView)findViewById(R.id.lstmonhoc);
        ArrayList<String> arrayCourse=new ArrayList<>();

        arrayCourse.add("Android");
        arrayCourse.add("IOS");
        arrayCourse.add("Flutter");
        arrayCourse.add("React Native");
        arrayCourse.add("PHP");
        arrayCourse.add("Java");

        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arrayCourse);
        listView.setAdapter(adapter);

        btnMonHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monhoc=editText.getText().toString();
                arrayCourse.add(monhoc);
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editText.setText(arrayCourse.get(position));
                vitri=position;
            }
        });
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCourse.set(vitri, editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }
}