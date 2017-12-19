package com.bawei.guolei.jingdong.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.guolei.jingdong.R;
import com.bawei.guolei.jingdong.bean.LoginBean;
import com.bawei.guolei.jingdong.jingdong.MainActivity;
import com.bawei.guolei.jingdong.presenter.MyLogingPresenter;
import com.bawei.guolei.jingdong.view.ShowLoginView;

public class LoginActivity extends AppCompatActivity implements ShowLoginView {

    //输入账号
    private EditText mUserName;
    //输入密码
    private EditText mUserPwd;
    //登录
    private Button mLoginBtn;
    //注册登录
    private TextView mRegister;
    //找回密码
    private TextView mZhaohui;
    private ImageView denglufanhui;
    MyLogingPresenter presenter = new MyLogingPresenter(this, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUserName = (EditText) findViewById(R.id.user_name);
        mUserPwd = (EditText) findViewById(R.id.user_pwd);
        mLoginBtn = (Button) findViewById(R.id.login_btn);
        mRegister = (TextView) findViewById(R.id.register);
        mZhaohui = (TextView) findViewById(R.id.zhaohui);
        denglufanhui = (ImageView) findViewById(R.id.denglufanhui);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.login(mUserName.getText().toString(), mUserPwd.getText().toString());

            }
        });
        denglufanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    public void showLogin(LoginBean bean) {
        Toast.makeText(LoginActivity.this, bean.getMsg(), Toast.LENGTH_SHORT).show();
        if (bean.getMsg().equals("登录成功")) {
            SharedPreferences sharedPreferences = this.getSharedPreferences("config", MODE_PRIVATE);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("islogin", true).commit();
            edit.putString("sjh", bean.getData().getMobile()).commit();
            finish();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

        }

    }
}
