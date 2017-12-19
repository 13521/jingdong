package com.bawei.guolei.jingdong.model;

import okhttp3.Callback;

/**
 * Created by Lenovo on 2017/12/10.
 */
public interface SsuoIsModel {
    public void GetNetData(String keywords, String page, Callback callback);
}
