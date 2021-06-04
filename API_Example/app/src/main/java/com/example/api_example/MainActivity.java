package com.example.api_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String jsonData = "  [\n" +
                "        {\n" +
                "            \"albumId\": 1,\n" +
                "                \"id\": 1,\n" +
                "                \"title\": \"accusamus beatae ad facilis cum similique qui sunt\",\n" +
                "                \"url\": \"https://via.placeholder.com/600/92c952\",\n" +
                "                \"thumbnailUrl\": \"https://via.placeholder.com/150/92c952\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"albumId\": 1,\n" +
                "                \"id\": 2,\n" +
                "                \"title\": \"reprehenderit est deserunt velit ipsam\",\n" +
                "                \"url\": \"https://via.placeholder.com/600/771796\",\n" +
                "                \"thumbnailUrl\": \"https://via.placeholder.com/150/771796\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"albumId\": 1,\n" +
                "                \"id\": 3,\n" +
                "                \"title\": \"officia porro iure quia iusto qui ipsa ut modi\",\n" +
                "                \"url\": \"https://via.placeholder.com/600/24f355\",\n" +
                "                \"thumbnailUrl\": \"https://via.placeholder.com/150/24f355\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"albumId\": 1,\n" +
                "                \"id\": 4,\n" +
                "                \"title\": \"culpa odio esse rerum omnis laboriosam voluptate repudiandae\",\n" +
                "                \"url\": \"https://via.placeholder.com/600/d32776\",\n" +
                "                \"thumbnailUrl\": \"https://via.placeholder.com/150/d32776\"\n" +
                "        }\n" +
                "    ]";



        try {

            JSONObject json=new JSONObject();
            int albumId=json.getInt("albumID");
            String title=json.getString("title");
            String url=json.getString("url");
            String thumbnailUrl=json.getString("thumbnailUrl");

            POST post=new POST(albumId,title,url,thumbnailUrl);


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}