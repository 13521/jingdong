package com.bawei.guolei.jingdong.model;

import com.bawei.guolei.jingdong.Application.IApplication;
import com.bawei.guolei.jingdong.bean.PicBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Lenovo on 2017/12/8.
 */
public class ClassModel {
    public void getData(final ClassCallBack callBack){
        Call<PicBean> call= IApplication.iGetDataBase.get();

        call.enqueue(new Callback<PicBean>() {
            @Override
            public void onResponse(Call<PicBean> call, Response<PicBean> response) {
                PicBean pibean=response.body();
                callBack.success(pibean);
            }

            @Override
            public void onFailure(Call<PicBean> call, Throwable t) {

            }
        });

    }

}
