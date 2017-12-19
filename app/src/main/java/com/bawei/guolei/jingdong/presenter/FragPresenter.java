package com.bawei.guolei.jingdong.presenter;

import com.bawei.guolei.jingdong.bean.PicBean;
import com.bawei.guolei.jingdong.model.FragModel;
import com.bawei.guolei.jingdong.model.ModelCallBack;
import com.bawei.guolei.jingdong.view.FragView;

/**
 * Created by Lenovo on 2017/12/6.
 */
public class FragPresenter {

    private FragView fragView;
    private FragModel fragModel;
    public FragPresenter(FragView fragView){
        this.fragView=fragView;
        this.fragModel=new FragModel();

    }
    public void get(){
        fragModel.getData(new ModelCallBack() {
            @Override
            public void success(PicBean picBean) {
                if (fragView!=null){
                    fragView.success(picBean);
                }
            }

            @Override
            public void failure(Exception e) {
                if (fragView!=null){
                    fragView.failure(e);
                }

            }
        });

    }
}
