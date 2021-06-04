package com.example.savefilefirebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnSave;
    ImageView imgImage;
    EditText edtName;

    DatabaseReference mData;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    int REQUEST_CODE_IMAGE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mData= FirebaseDatabase.getInstance().getReference();
        final StorageReference storageRef=storage.getReferenceFromUrl("gs://savefile-1e505.appspot.com");

        AnhXa();
        imgImage.setOnClickListener(v -> {
            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,REQUEST_CODE_IMAGE);
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                StorageReference mountainsRef=storageRef.child("image"+calendar.getTimeInMillis()+".png");

                imgImage.setDrawingCacheEnabled(true);
                imgImage.buildDrawingCache();
                Bitmap bitmap = ((BitmapDrawable) imgImage.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] data = baos.toByteArray();

                UploadTask uploadTask = mountainsRef.putBytes(data);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Toast.makeText(MainActivity.this, "loi", Toast.LENGTH_SHORT).show();
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                        // ...
                        Task<Uri> downloadUrl= taskSnapshot.getStorage().getDownloadUrl();
                        Toast.makeText(MainActivity.this, "thanh cong", Toast.LENGTH_SHORT).show();
                        Log.d("AAAA",downloadUrl+"");

                        //Tạo node
                        HinhAnh hinhanh=new HinhAnh(edtName.getText().toString(), downloadUrl.toString());
                        mData.child("HinhAnh").push().setValue(hinhanh, new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                if (error.equals("")){
                                    Toast.makeText(MainActivity.this, "Luu thanh cong", Toast.LENGTH_SHORT).show();
                                }
                                else
                                    Toast.makeText(MainActivity.this, "Luu loi", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==REQUEST_CODE_IMAGE&&resultCode==RESULT_OK&&data!=null){
            Bitmap bitmap=(Bitmap)data.getExtras().get("data");
            imgImage.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void AnhXa(){
        btnSave=(Button)findViewById(R.id.btnSave);
        imgImage=(ImageView)findViewById(R.id.imgImage);
        edtName=(EditText)findViewById(R.id.edtName);
    }
}