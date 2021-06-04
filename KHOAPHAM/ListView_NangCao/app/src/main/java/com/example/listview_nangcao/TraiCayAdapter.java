package com.example.listview_nangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Base64;
import java.util.List;

public class TraiCayAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TraiCay> traiCayList;

    public TraiCayAdapter(Context context, int layout, List<TraiCay> traiCayList) {
        this.context = context;
        this.layout = layout;
        this.traiCayList = traiCayList;
    }

    //tra ve so dong
    @Override
    public int getCount() {
        return traiCayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        convertView=inflater.inflate(layout,null );

        //ánh xạ
        TextView txtTen=(TextView) convertView.findViewById(R.id.textviewTen);
        TextView txtMoTa=(TextView) convertView.findViewById(R.id.textviewMoTa);
        ImageView imgHinh = (ImageView) convertView.findViewById(R.id.imageviewHinh);

        //gans gtri
        TraiCay traiCay= traiCayList.get(position);

        txtTen.setText(traiCay.getTen());
        txtMoTa.setText(traiCay.getMoTa());
        imgHinh.setImageResource(traiCay.getHinh());

        return null;
    }
}
