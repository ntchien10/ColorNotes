package com.example.xeviet.ui.person;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xeviet.R;
import com.example.xeviet.ui.login.Login;
import com.example.xeviet.ui.login.Register;

import java.util.ArrayList;
import java.util.List;

public class PersonFragment extends Fragment {
    RecyclerView recyclerViewPerson;
    List<PersonFormOption> personFormOptionList=new ArrayList<>();
    PersonAdapter adapter;
    ImageView img_avatar_person;
    TextView txt_ten_person;
    ImageView img_Setting;

    View view;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_person,container,false);

        recyclerViewPerson=(RecyclerView) view.findViewById(R.id.recycleview_person_option);
        setPersonOption();

        adapter=new PersonAdapter(personFormOptionList, view.getContext());
        LinearLayoutManager manager=new LinearLayoutManager(view.getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewPerson.setLayoutManager(manager);
        recyclerViewPerson.setAdapter(adapter);

//        setting
//        img_avatar_person.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (txt_ten_person.equals("ĐĂNG NHẬP")){
//                    Intent intent=new Intent(getContext(), Login.class);
//                    startActivity(intent);
//                }
//            }
//        });
//        txt_ten_person.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (txt_ten_person.equals("ĐĂNG NHẬP")){
//                    Intent intent=new Intent(getContext(), Login.class);
//                    startActivity(intent);
//                }
//            }
//        });
//        img_Setting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(getContext(), Info.class);
//                startActivity(intent);
//            }
//        });

        return view;
    }

    private void setPersonOption() {
        PersonFormOption option;

        option =new PersonFormOption(R.drawable.icon_favorite_black, "Sản phẩm yêu thích");
        personFormOptionList.add(option);

        option =new PersonFormOption(R.drawable.xe_ga, "Xe đang bán");
        personFormOptionList.add(option);

        option =new PersonFormOption(R.drawable.xe_so,"Xe đã mua");
        personFormOptionList.add(option);

        option =new PersonFormOption(R.drawable.xe_pkl,"Trung tâm trợ giúp");
        personFormOptionList.add(option);

        option =new PersonFormOption(R.drawable.xe_dien, "Phiên bản");
        personFormOptionList.add(option);

        option =new PersonFormOption(R.drawable.xe_dien, "Điều khoản");
        personFormOptionList.add(option);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
    private void AnhXa(){
        img_Setting=(ImageView) view.findViewById(R.id.img_setting);
        img_avatar_person=(ImageView)view.findViewById(R.id.img_avatar_person);
        txt_ten_person=(TextView)view.findViewById(R.id.txt_ten_person);
    }
}
