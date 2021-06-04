package com.example.maytinh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_tinh;
    private EditText et_so1;
    private EditText et_so2;
    private TextView tv_kq;

    private int so1;
    private int so2;
    private String KetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_tinh=(Button) findViewById(R.id.btn_tinh);
        et_so1=(EditText)findViewById(R.id.et_so1);
        et_so2=(EditText) findViewById(R.id.et_so2);
        tv_kq=(TextView) findViewById(R.id.tv_kq);


        btn_tinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view==btn_tinh){
                    if(et_so1.getText().toString().isEmpty()||et_so2.getText().toString().isEmpty()){
                        Toast.makeText(MainActivity.this,"vui long nhap day du so! ", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        so1=Integer.parseInt(et_so1.getText().toString());
                        so2=Integer.parseInt(et_so2.getText().toString());
                        KetQua=String.valueOf(so1+so2);
                        tv_kq.setText("Kết quả là: "+KetQua);
                    }
                }
            }
        });
    }
}