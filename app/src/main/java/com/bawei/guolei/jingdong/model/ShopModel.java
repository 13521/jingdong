package com.bawei.guolei.jingdong.model;

import com.bawei.guolei.jingdong.bean.ShopBean;
import com.bawei.guolei.jingdong.utils.AbstractUiCallBack;
import com.bawei.guolei.jingdong.utils.OkhttpUtils;

/**
 * Created by Lenovo on 2017/12/15.
 */

public class ShopModel {
    public void getData(final ShopCallBack callBack){
        OkhttpUtils.getInstance().asy(null, "https://www.zhaoapi.cn/product/getCarts?token=78C176A56968B3FA29CBA470E2A3D0A5&&uid=3804", new AbstractUiCallBack<ShopBean>() {
            @Override
            public void success(ShopBean shopBean) {
                 callBack.success(shopBean);
            }

            @Override
            public void failure(Exception e) {

            }
        });


    }

}
