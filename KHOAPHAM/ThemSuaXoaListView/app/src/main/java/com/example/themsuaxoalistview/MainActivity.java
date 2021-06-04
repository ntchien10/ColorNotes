package com.example.themsuaxoalistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonHoc;
    Button btnThem;
    EditText edtMonHoc;
    ArrayList<String> arrayCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMonHoc=(ListView) findViewById(R.id.lstmonhoc);
        btnThem=(Button) findViewById(R.id.button);
        edtMonHoc=(EditText)findViewById(R.id.editTextTextPersonName);
        arrayCourse=new ArrayList<>();

        arrayCourse.add("PHP");
        arrayCourse.add("Unity");
        arrayCourse.add("Android");
        arrayCourse.add("HTML");
        arrayCourse.add("IOS");

        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arrayCourse);

        lvMonHoc.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monhoc= edtMonHoc.getText().toString();
                arrayCourse.add(monhoc);
                adapter.notifyDataSetChanged();
            }
        });

    }
}