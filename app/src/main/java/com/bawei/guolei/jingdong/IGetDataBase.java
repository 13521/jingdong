package com.bawei.guolei.jingdong;

import com.bawei.guolei.jingdong.bean.AddBean;
import com.bawei.guolei.jingdong.bean.ClassBean;
import com.bawei.guolei.jingdong.bean.PicBean;
import com.bawei.guolei.jingdong.bean.ShowBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Lenovo on 2017/12/6.
 */
public interface IGetDataBase {

    @GET("/product/getCatagory")
    Call<PicBean> get();

    @GET("ad/getAd")
    Call<ShowBean> get1();

    @GET("/product/getProductCatagory")
    Call<ClassBean> get2(@Query("cid") int cid);

    @GET("/product/addCart")
    Call<AddBean> get3(@Query("uid") String uid,@Query("source") String source,@Query("pid") int pid);

//    @GET("/product/getCarts")
//    Call<ShopBean> get4(@Query("uid") String uid,@Query("source") String android);
}
