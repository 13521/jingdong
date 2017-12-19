package com.bawei.guolei.jingdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bawei.guolei.jingdong.R;
import com.bawei.guolei.jingdong.adapter.ClassAdapter;
import com.bawei.guolei.jingdong.adapter.ClassListAdapter;
import com.bawei.guolei.jingdong.bean.ClassBean;
import com.bawei.guolei.jingdong.bean.PicBean;
import com.bawei.guolei.jingdong.presenter.ClassPresenter;
import com.bawei.guolei.jingdong.view.ClassView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/12/6.
 */
public class Fragment_Class extends Fragment implements ClassView{

    private ListView listView;
    private ClassPresenter presenter;
    private List<PicBean.DataBean> list=new ArrayList<>();
    private ClassListAdapter adapter;
    private RecyclerView recyclerView;
    private ClassAdapter classadapter;
    private LinearLayoutManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment2,container,false);
        listView = view.findViewById(R.id.listView);
        recyclerView = view.findViewById(R.id.recycleView_fl);
        presenter = new ClassPresenter(this);
        presenter.get();

        adapter = new ClassListAdapter(list,getActivity());
        listView.setAdapter(adapter);
        classadapter = new ClassAdapter(getActivity());
        recyclerView.setAdapter(classadapter);
        manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                presenter.get2(i);
            }
        });

         return view;

    }


    @Override
    public void success(PicBean pibean) {
        adapter.addData(pibean);

    }

    @Override
    public void successed(ClassBean classBean) {
        classadapter.addData(classBean);
    }
}
