package com.bawei.guolei.jingdong.presenter;

import com.bawei.guolei.jingdong.bean.ShowBean;
import com.bawei.guolei.jingdong.model.ViewCallBack;
import com.bawei.guolei.jingdong.model.ViewModel;
import com.bawei.guolei.jingdong.view.ViewpaView;

/**
 * Created by Lenovo on 2017/12/7.
 */
public class ViewPresenter {

    private ViewpaView viewpaView;
    private ViewModel viewModel;
    public ViewPresenter(ViewpaView viewpaView){
        this.viewpaView=viewpaView;
        this.viewModel=new ViewModel();

    }
    public void get1(){
        viewModel.getData(new ViewCallBack() {
            @Override
            public void success(ShowBean sbean) {
                if (viewpaView!=null){
                    viewpaView.success(sbean);
                }
            }
        });
    }
}
