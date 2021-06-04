package com.example.call_api_example;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DemoRetrofit {
    public static Retrofit retrofit;
    public static Retrofit getInstance(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl("https://6076b4b81ed0ae0017d699a3.mockapi.io/users")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
