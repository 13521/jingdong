package com.bawei.guolei.jingdong.presenter;

import com.bawei.guolei.jingdong.bean.AddBean;
import com.bawei.guolei.jingdong.model.AddCallBack;
import com.bawei.guolei.jingdong.model.AddModel;
import com.bawei.guolei.jingdong.view.AddView;

/**
 * Created by Lenovo on 2017/12/15.
 */

public class AddPresenter {
    private AddView addView;
    private AddModel addModel;
    public AddPresenter(AddView addView){
        this.addView=addView;
        this.addModel=new AddModel();

    }
      public void get3(int pid){
        addModel.getData(new AddCallBack() {
            @Override
            public void success(AddBean addBean) {
              if (addView!=null){
                  addView.success(addBean);
              }
            }
        },pid);

      }
}
