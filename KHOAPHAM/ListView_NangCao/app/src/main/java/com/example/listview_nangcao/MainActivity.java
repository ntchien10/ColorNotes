package com.example.listview_nangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvTraiCay;
    ArrayList<TraiCay> arrayTraiCay;
    TraiCayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        adapter=new TraiCayAdapter(this, R.layout.dong_trai_cay, arrayTraiCay);
        lvTraiCay.setAdapter(adapter);
    }
    private void AnhXa(){
        lvTraiCay=(ListView) findViewById(R.id.listviewTraiCay);
        arrayTraiCay=new ArrayList<>();

        arrayTraiCay.add(new TraiCay("Táo" , "Táo tàu", R.drawable.tao));
        arrayTraiCay.add(new TraiCay("Thanh long","Thanh long ruột trắng", R.drawable.thanhlong));
        arrayTraiCay.add(new TraiCay("bưởi","Bưởi diễn trồng ở Mỹ Đình",R.drawable.buoi));
    }
}