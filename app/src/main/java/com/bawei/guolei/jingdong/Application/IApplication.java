package com.bawei.guolei.jingdong.Application;

import android.app.Application;

import com.bawei.guolei.jingdong.IGetDataBase;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lenovo on 2017/12/6.
 */
public class IApplication extends Application {

    public static IGetDataBase iGetDataBase;
    public static IGetDataBase V_iGetDataBase;
    public static IGetDataBase C_iGetDataBase;
    public static IGetDataBase ad_iGetDataBase;
    public static IGetDataBase sh_iGetDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(configuration);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        iGetDataBase = retrofit.create(IGetDataBase.class);

        Retrofit retrofit2=new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
       V_iGetDataBase = retrofit.create(IGetDataBase.class);

        Retrofit retrofit3=new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        C_iGetDataBase = retrofit.create(IGetDataBase.class);

        Retrofit retrofit4=new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ad_iGetDataBase = retrofit.create(IGetDataBase.class);

//        Retrofit retrofit5=new Retrofit.Builder()
//                .baseUrl("https://www.zhaoapi.cn")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        sh_iGetDataBase = retrofit.create(IGetDataBase.class);

    }
}
