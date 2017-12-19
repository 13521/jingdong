package com.bawei.guolei.jingdong.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bawei.guolei.jingdong.R;

public class EWMActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView mImage;
    private Button mSc;
    private Button mEr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ewm);
        initView();
    }

    private void initView() {
        mEr = (Button) findViewById(R.id.er);
        mEr.setOnClickListener(this);
        mSc = (Button) findViewById(R.id.sc);
        mSc.setOnClickListener(this);
        mImage = (ImageView) findViewById(R.id.image);
    }

    @Override
    public void onClick(View view) {

    }
}
