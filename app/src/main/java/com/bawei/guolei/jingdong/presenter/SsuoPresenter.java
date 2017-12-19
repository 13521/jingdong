package com.bawei.guolei.jingdong.presenter;

import android.content.Context;
import android.util.Log;

import com.bawei.guolei.jingdong.bean.SsuoBean;
import com.bawei.guolei.jingdong.model.SsuoModel;
import com.bawei.guolei.jingdong.utils.OnUiCallback;
import com.bawei.guolei.jingdong.view.SsuoView;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by Lenovo on 2017/12/10.
 */
public class SsuoPresenter {

    Context context;
    SsuoView ssuoView;
    SsuoModel ssuoModel;
    public SsuoPresenter(Context context, SsuoView ssuoView){
        this.context=context;
        this.ssuoView=ssuoView;
        this.ssuoModel=new SsuoModel();


    }
    public void getdata(String keyword,String page){
        ssuoModel.GetNetData(keyword, page, new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {

            }

            @Override
            public void onSuccess(String result) {
                //获取数据成功时将放回的json 变成bean
                Log.i("3333333", "onSuccess: "+result.toString());
                Gson gson=new Gson();
                SsuoBean ssuoBean= gson.fromJson(result,SsuoBean.class);
                ssuoView.ShowView(ssuoBean);

            }
        });

    }
    //用来防止内存溢出
    public void destory(){
        this.ssuoView=null;
    }
}
