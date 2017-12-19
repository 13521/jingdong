package com.bawei.guolei.jingdong.jingdong;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.bawei.guolei.jingdong.R;
import com.bawei.guolei.jingdong.fragment.Fragment_Card;
import com.bawei.guolei.jingdong.fragment.Fragment_Class;
import com.bawei.guolei.jingdong.fragment.Fragment_FaXian;
import com.bawei.guolei.jingdong.fragment.Fragment_ShouYe;
import com.bawei.guolei.jingdong.fragment.Fragment_wode;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frameLayout,new Fragment_ShouYe()).commit();


        initView();




    }

    private void initView() {
         radioGroup= (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.home:
                        getFragment(new Fragment_ShouYe());
                        break;
                    case R.id.fclass:
                        getFragment(new Fragment_Class());
                        break;
                    case R.id.faxian:
                        getFragment(new Fragment_FaXian());
                        break;
                    case R.id.card:
                        getFragment(new Fragment_Card());
                        break;
                    case R.id.my:
                        getFragment(new Fragment_wode());
                        break;



                }
            }
        });
    }
    private void getFragment(Fragment fragment){
        manager.beginTransaction().replace(R.id.frameLayout,fragment).commit();

    }
}
