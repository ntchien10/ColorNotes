package com.example.sqlite_1st.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sqlite_1st.Model.Person;
import com.example.sqlite_1st.R;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Person> {

    private Context context;
    private int resoure;
    private List<Person> listStudent;

    public CustomAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Person> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resoure = resource;
        this.listStudent = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_person, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvId = (TextView) convertView.findViewById(R.id.tv_id);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tvPhoneNumber = (TextView) convertView.findViewById(R.id.tv_phone);
            viewHolder.tvAge = (TextView) convertView.findViewById(R.id.tv_age);
            viewHolder.tvAddress = (TextView) convertView.findViewById(R.id.tv_address);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Person person = listStudent.get(position);
        viewHolder.tvId.setText(String.valueOf(person.getmID()));
        viewHolder.tvName.setText(person.getmName());
        viewHolder.tvAddress.setText(person.getmAddress());
        viewHolder.tvAge.setText(person.getmAge());
        viewHolder.tvPhoneNumber.setText(person.getmPhone());

        return convertView;
    }

    public class ViewHolder {

        private TextView tvId;
        private TextView tvName;
        private TextView tvAddress;
        private TextView tvAge;
        private TextView tvPhoneNumber;
    }
}