package com.bawei.guolei.jingdong.presenter;

import com.bawei.guolei.jingdong.bean.ClassBean;
import com.bawei.guolei.jingdong.bean.PicBean;
import com.bawei.guolei.jingdong.model.ClassCallBack;
import com.bawei.guolei.jingdong.model.ClassModel;
import com.bawei.guolei.jingdong.model.ClasseCallBack;
import com.bawei.guolei.jingdong.model.ClasseModel;
import com.bawei.guolei.jingdong.view.ClassView;

/**
 * Created by Lenovo on 2017/12/8.
 */
public class ClassPresenter {

    private ClassView classView;
    private ClassModel classModel;
    private ClasseModel classeModel;
    public ClassPresenter(ClassView classView){
        this.classView=classView;
        this.classModel=new ClassModel();
        this.classeModel=new ClasseModel();

    }


    public void get(){
        classModel.getData(new ClassCallBack() {
            @Override
            public void success(PicBean pibean) {
                if (classView!=null){
                    classView.success(pibean);
                }
            }
        });
    }
    public void get2(int cid){
        classeModel.getDataA(new ClasseCallBack() {
            @Override
            public void successed(ClassBean classBean) {
                if (classView!=null){
                    classView.successed(classBean);
                }
            }
        },cid);
    }

}
