package com.example.oops;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView) findViewById(R.id.chu);

        SinhVien sinhVien =new SinhVien();
        sinhVien.HoTen="nguyen the chien";
        sinhVien.DiaChi="ha noi";
        sinhVien.NamSinh=2000;

        textView.setText(sinhVien.HoTen);
    }
}