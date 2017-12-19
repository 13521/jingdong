package com.bawei.guolei.jingdong.view;

import com.bawei.guolei.jingdong.bean.PicBean;

/**
 * Created by Lenovo on 2017/12/6.
 */
public interface FragView {
    public void success(PicBean picBean);
    public void failure(Exception e);
}
