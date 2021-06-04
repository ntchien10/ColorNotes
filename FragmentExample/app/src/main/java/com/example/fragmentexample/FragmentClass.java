package com.example.fragmentexample;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class FragmentClass extends Fragment {
    Button btnFragment;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater,container,savedInstanceState);
        View view= inflater.inflate(R.layout.fragment,container,false);

        Button btnFragment=(Button)view.findViewById(R.id.btnFragment);
        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Button Fragment", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
