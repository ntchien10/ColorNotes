package com.example.recycleviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcView;
    List<FootballTeam> teamList=new ArrayList<>();
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcView=(RecyclerView)findViewById(R.id.rc_view);
        setTeamdata();
        adapter=new MyAdapter(teamList, getApplicationContext());
        LinearLayoutManager manager=new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);

        rcView.setLayoutManager(manager);
        rcView.setAdapter(adapter);
    }

    private void setTeamdata() {
        FootballTeam team ;

        team =new FootballTeam("Nguyen the chien", "ha noi", 2000);
        teamList.add(team);

        team =new FootballTeam("Nguyen the chien 2", "ha noi", 2000);
        teamList.add(team);

        team =new FootballTeam("Nguyen the chien 3", "ha noi", 2000);
        teamList.add(team);

        team =new FootballTeam("Nguyen the chien 4", "ha noi", 2000);
        teamList.add(team);
    }
}