package com.example.xeviet.ui.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.xeviet.R;
import com.example.xeviet.databinding.FragmentHomeBinding;
import com.example.xeviet.ui.add.AddViewModel;

public class AddFragment extends Fragment {
    private AddViewModel addViewModel;
    ImageView btnAddAvatar,btnAddAnh1,btnAddAnh2,btnAddAnh3,btnAddAnh4,
            btnAddAnh5,btnAddAnh6,btnAddAnh7,btnAddAnh8;
    View view;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addViewModel =
                new ViewModelProvider(this).get(AddViewModel.class);

        view= inflater.inflate(R.layout.fragment_add,container,false);

        AnhXa();

        btnAddAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
    private void AnhXa(){
        btnAddAvatar=(ImageView)view.findViewById(R.id.btnAddAvatar);
        btnAddAnh1=(ImageView)view.findViewById(R.id.btnAddAnh1);
        btnAddAnh2=(ImageView)view.findViewById(R.id.btnAddAnh2);
        btnAddAnh3=(ImageView)view.findViewById(R.id.btnAddAnh3);
        btnAddAnh4=(ImageView)view.findViewById(R.id.btnAddAnh4);
        btnAddAnh5=(ImageView)view.findViewById(R.id.btnAddAnh5);
        btnAddAnh6=(ImageView)view.findViewById(R.id.btnAddAnh6);
        btnAddAnh7=(ImageView)view.findViewById(R.id.btnAddAnh7);
        btnAddAnh8=(ImageView)view.findViewById(R.id.btnAddAnh8);
    }
}
