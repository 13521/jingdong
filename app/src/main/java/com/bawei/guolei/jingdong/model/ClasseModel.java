package com.bawei.guolei.jingdong.model;

import com.bawei.guolei.jingdong.Application.IApplication;
import com.bawei.guolei.jingdong.bean.ClassBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Lenovo on 2017/12/8.
 */
public class ClasseModel {
    public void getDataA(final ClasseCallBack callBack,int cid){
        Call<ClassBean> call= IApplication.C_iGetDataBase.get2(cid);

        call.enqueue(new Callback<ClassBean>() {
            @Override
            public void onResponse(Call<ClassBean> call, Response<ClassBean> response) {
                ClassBean classBean=response.body();
                callBack.successed(classBean);
            }

            @Override
            public void onFailure(Call<ClassBean> call, Throwable t) {

            }
        });

    }
}
