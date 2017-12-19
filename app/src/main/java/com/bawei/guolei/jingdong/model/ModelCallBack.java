package com.bawei.guolei.jingdong.model;

import com.bawei.guolei.jingdong.bean.PicBean;

/**
 * Created by Lenovo on 2017/12/6.
 */
public interface ModelCallBack {
    public void success(PicBean picBean);
    public void failure(Exception e);
}
