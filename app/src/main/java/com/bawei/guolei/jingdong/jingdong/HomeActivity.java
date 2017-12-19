package com.bawei.guolei.jingdong.jingdong;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawei.guolei.jingdong.R;

public class HomeActivity extends AppCompatActivity {

    private Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        //getSupportActionBar().hide();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it=new Intent(HomeActivity.this,MainActivity.class);
                startActivity(it);
                finish();

            }
        },3000);
    }
}
