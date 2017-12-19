package com.bawei.guolei.jingdong.model;

import com.bawei.guolei.jingdong.Application.IApplication;
import com.bawei.guolei.jingdong.bean.ShowBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Lenovo on 2017/12/7.
 */
public class ViewModel {
    public void getData(final ViewCallBack callBack){
        Call<ShowBean> call= IApplication.V_iGetDataBase.get1();

        call.enqueue(new Callback<ShowBean>() {
            @Override
            public void onResponse(Call<ShowBean> call, Response<ShowBean> response) {
               ShowBean sbean=response.body();
                callBack.success(sbean);
            }

            @Override
            public void onFailure(Call<ShowBean> call, Throwable t) {

            }
        });

    }

}
