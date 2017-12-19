package com.bawei.guolei.jingdong.model;

import com.bawei.guolei.jingdong.Application.IApplication;
import com.bawei.guolei.jingdong.bean.ShowBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Lenovo on 2017/12/9.
 */
public class FraglsModel {
    public void getData(final FraglsCallBack callBack){
        Call<ShowBean> call= IApplication.V_iGetDataBase.get1();

        call.enqueue(new Callback<ShowBean>() {
            @Override
            public void onResponse(Call<ShowBean> call, Response<ShowBean> response) {
                ShowBean shBean=response.body();
                callBack.successes(shBean);
            }

            @Override
            public void onFailure(Call<ShowBean> call, Throwable t) {

            }
        });

    }
}
