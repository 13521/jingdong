package com.bawei.guolei.jingdong.presenter;

import android.content.Context;

import com.bawei.guolei.jingdong.bean.ZcBean;
import com.bawei.guolei.jingdong.model.MyZcModel;
import com.bawei.guolei.jingdong.utils.OnUiCallback;
import com.bawei.guolei.jingdong.view.ShowZCview;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by asus on 2017/11/7.
 */

public class MyZcPresenter {
    Context context;
    MyZcModel model;
    ShowZCview view;

    public MyZcPresenter(Context context, ShowZCview view) {
        this.context = context;
        this.view = view;
        model=new MyZcModel();
    }



    public void clickzc(String phone,String pwd ){
        model.getnetZCdata(phone, pwd, new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                ZcBean bean = gson.fromJson(result, ZcBean.class);
                view.ShowZcView(bean);
            }
        });
    }

}
