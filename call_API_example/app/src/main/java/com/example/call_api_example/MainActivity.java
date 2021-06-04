package com.example.call_api_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DemoService demoService= DemoRetrofit.getInstance().create(DemoService.class);
        demoService.getPost().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String data=response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public interface DemoService{
        @GET("posts")
            Call<ResponseBody> getPost();
        @GET("todos/{id}")
        Call<ResponseBody> getUserInfo(@Part("id") String id);

        @FormUrlEncoded
        @POST("posts/")
        Call<ResponseBody> createUser(@Field("id") String id, @Field("name") String name, @Field("avatar") String avartar);

    }
}