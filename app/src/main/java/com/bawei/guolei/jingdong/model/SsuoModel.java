package com.bawei.guolei.jingdong.model;

import com.bwie.mylibrary.OkHttp3Utils;

import okhttp3.Callback;

/**
 * Created by Lenovo on 2017/12/10.
 */
public class SsuoModel implements SsuoIsModel{

    @Override
    public void GetNetData(String keywords, String page, Callback callback) {
        OkHttp3Utils.doGet("https://www.zhaoapi.cn/product/searchProducts?keywords="+keywords+"&page="+page+"&source=android",callback);

    }
}
