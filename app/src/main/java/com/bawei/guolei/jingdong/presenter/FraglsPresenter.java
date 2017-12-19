package com.bawei.guolei.jingdong.presenter;

import com.bawei.guolei.jingdong.bean.ShowBean;
import com.bawei.guolei.jingdong.model.FraglsCallBack;
import com.bawei.guolei.jingdong.model.FraglsModel;
import com.bawei.guolei.jingdong.view.FraglsView;

/**
 * Created by Lenovo on 2017/12/9.
 */
public class FraglsPresenter {

   private FraglsView fraglsView;
    private FraglsModel fraglsModel;
    public FraglsPresenter(FraglsView fraglsView){
        this.fraglsView=fraglsView;
        this.fraglsModel=new FraglsModel();

    }
    public void get1(){
        fraglsModel.getData(new FraglsCallBack() {
            @Override
            public void successes(ShowBean shBean) {
                if (fraglsView!=null){
                    fraglsView.successes(shBean);
                }
            }
        });
    }
}
