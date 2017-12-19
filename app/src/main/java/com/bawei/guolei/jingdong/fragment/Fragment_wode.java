package com.bawei.guolei.jingdong.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.guolei.jingdong.R;
import com.bawei.guolei.jingdong.activity.LoginActivity;

/**
 * Created by Lenovo on 2017/12/6.
 */
public class Fragment_wode extends Fragment{

    private ImageView image;
    private TextView telogin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment5,container,false);
       initView(view);

        return view;


    }

    private void initView(View view) {
        image = view.findViewById(R.id.head_iv);
        telogin = view.findViewById(R.id.login);

        final SharedPreferences sharedPreferences=getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);
        final boolean islogin = sharedPreferences.getBoolean("islogin", false);
        if (islogin){
            String sjh = sharedPreferences.getString("sjh", null);
            telogin.setText(sjh);


        }else{

            telogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(getActivity(),LoginActivity.class);
                    getActivity().startActivity(intent1);
                    getActivity().finish();
                }
            });


        }
        telogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getActivity(),LoginActivity.class);
                getActivity().startActivity(intent1);

            }
        });

    }






}
