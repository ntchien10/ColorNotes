package com.example.fragmentexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    public static final String EXTRA_DATA = "EXTRA_DATA";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
        Button btnClickMe =findViewById(R.id.btnClickMe);
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SubActivity.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(SubActivity.this, "Main activity", Toast.LENGTH_SHORT).show();


//                // Tạo một Intent mới để chứa dữ liệu trả về
//                final Intent data = new Intent();
//                // Truyền data vào intent
//                data.putExtra(EXTRA_DATA, "Some interesting data!");
//
//                // Đặt resultCode là Activity.RESULT_OK to
//                // thể hiện đã thành công và có chứa kết quả trả về
//                setResult(SubActivity.RESULT_OK, data);
//
//                // gọi hàm finish() để đóng Activity hiện tại và trở về MainActivity.
//                finish();
            }
        });
    }

//    @Override
//    public void onBackPressed() {
//
//        // đặt resultCode là Activity.RESULT_CANCELED thể hiện
//        // đã thất bại khi người dùng click vào nút Back.
//        // Khi này sẽ không trả về data.
//        setResult(SubActivity.RESULT_CANCELED);
//        super.onBackPressed();
//    }
}
