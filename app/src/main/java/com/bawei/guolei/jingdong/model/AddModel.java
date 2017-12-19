package com.bawei.guolei.jingdong.model;


import com.bawei.guolei.jingdong.Application.IApplication;
import com.bawei.guolei.jingdong.bean.AddBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Lenovo on 2017/12/15.
 */

public class AddModel {
    public void getData(final AddCallBack callBack, int pid){
        Call<AddBean> call= IApplication.ad_iGetDataBase.get3("3804","android",pid);
        call.enqueue(new Callback<AddBean>() {
            @Override
            public void onResponse(Call<AddBean> call, Response<AddBean> response) {
                AddBean addBean=response.body();
                callBack.success(addBean);
            }

            @Override
            public void onFailure(Call<AddBean> call, Throwable t) {

            }
        });


    }


}
