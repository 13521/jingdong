package com.bawei.guolei.jingdong.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.guolei.jingdong.R;
import com.bawei.guolei.jingdong.bean.ZcBean;
import com.bawei.guolei.jingdong.presenter.MyZcPresenter;
import com.bawei.guolei.jingdong.view.ShowZCview;

public class RegisterActivity extends AppCompatActivity implements ShowZCview, View.OnClickListener {

    private Button bt_zhuce;
    private EditText user_name;
    private EditText user_pwd;
    MyZcPresenter presenter=new MyZcPresenter(this,this);
    private ImageView zcfh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        zcfh = (ImageView) findViewById(R.id.zcfh);
        user_name = (EditText) findViewById(R.id.user_name);
        user_pwd = (EditText) findViewById(R.id.user_pwd);
        bt_zhuce = (Button) findViewById(R.id.register_btn);
        bt_zhuce.setOnClickListener(this);
        zcfh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_btn:
                presenter.clickzc(user_name.getText().toString(),user_pwd.getText().toString());
                break;
            default:
                break;
        }
    }


    public void ShowZcView(ZcBean bean) {
        Toast.makeText(this, bean.getMsg(), Toast.LENGTH_SHORT).show();
    }
}
