package com.example.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_EXAMPLE=0x9345;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnActivity=(Button)findViewById(R.id.btnActivity);
        View fragment = findViewById(R.id.id_fragment);
        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Activity", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity.this,SubActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Activity 2", Toast.LENGTH_SHORT).show();

                // Start DetailActivity với request code vừa được khai báo trước đó
                startActivityForResult(intent, REQUEST_CODE_EXAMPLE);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Kiểm tra requestCode có trùng với REQUEST_CODE vừa dùng
        if(requestCode == REQUEST_CODE_EXAMPLE) {

            // resultCode được set bởi DetailActivity
            // RESULT_OK chỉ ra rằng kết quả này đã thành công
            if(resultCode == SubActivity.RESULT_OK) {
                // Nhận dữ liệu từ Intent trả về
                final String result = data.getStringExtra(SubActivity.EXTRA_DATA);

                // Sử dụng kết quả result bằng cách hiện Toast
                Toast.makeText(this, "Result: " + result, Toast.LENGTH_LONG).show();
            } else {
                // DetailActivity không thành công, không có data trả về.
            }
        }
    }
}