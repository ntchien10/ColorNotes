package com.example.sqlite_2nd.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite_2nd.Model.Student;
import com.example.sqlite_2nd.R;

import java.util.List;

public class CustomAdapter extends ArrayAdapter {
    private Context context;
    private int resoure;
    private List<Student> listStudent;

    public CustomAdapter(@NonNull Context context, int resoure, @NonNull List objects) {
        super(context, resoure, objects);
        this.context= context;
        this.resoure=resoure;
        this.listStudent=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.list_item_student,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvID = (TextView)convertView.findViewById(R.id.tv_id);
            viewHolder.tvName = (TextView)convertView.findViewById(R.id.tv_name);
            viewHolder.tvPhoneNumber = (TextView)convertView.findViewById(R.id.tv_phone_number);
            viewHolder.tvEmail  = (TextView)convertView.findViewById(R.id.tv_email);
            viewHolder.tvAddress = (TextView)convertView.findViewById(R.id.tv_address);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Student student = listStudent.get(position);
        viewHolder.tvID.setText(String.valueOf(student.getmID()));
        viewHolder.tvName.setText(student.getmName());
        viewHolder.tvAddress.setText(student.getmAddress());
        viewHolder.tvEmail.setText(student.getmEmail());
        viewHolder.tvPhoneNumber.setText(student.getmPhoneNumber());

        return convertView;


    }
    public class ViewHolder {
        private TextView tvID;
        private TextView tvName;
        private TextView tvAddress;
        private TextView tvPhoneNumber;
        private TextView tvEmail;
    }
}
