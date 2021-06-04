package com.example.recycleviewexample;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    public List<FootballTeam> teamList;
    Context ctx;

    public MyAdapter(List<FootballTeam> teamList, Context ctx) {
        super();
        this.teamList = teamList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(teamList.get(position).getName());
        holder.leage.setText(teamList.get(position).getLeage());
        holder.year.setText(String.valueOf(teamList.get(position).getYear()));
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name, leage,year;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.tv_name);
            leage=(TextView)itemView.findViewById(R.id.tv_leage);
            year=(TextView)itemView.findViewById(R.id.tv_year);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position= getLayoutPosition();
            FootballTeam fbteam=teamList.get(position);

            Toast.makeText(ctx, fbteam.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
