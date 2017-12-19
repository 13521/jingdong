package com.bawei.guolei.jingdong.presenter;

import com.bawei.guolei.jingdong.bean.ShopBean;
import com.bawei.guolei.jingdong.model.ShopCallBack;
import com.bawei.guolei.jingdong.model.ShopModel;
import com.bawei.guolei.jingdong.view.ShopView;

/**
 * Created by Lenovo on 2017/12/15.
 */

public class ShopPresenter {
    private ShopView shopView;
    private ShopModel shopModel;
    public ShopPresenter(ShopView shopView) {
        this.shopView=shopView;
        this.shopModel=new ShopModel();

    }

    public void getData() {
        shopModel.getData(new ShopCallBack() {
            @Override
            public void success(ShopBean shopBean) {
                if (shopView!=null){
                    shopView.success(shopBean);
                }
            }
        });

    }
    public void detach(){
        shopView= null;
    }

}
