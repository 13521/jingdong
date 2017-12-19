package com.bawei.guolei.jingdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.guolei.jingdong.R;
import com.bawei.guolei.jingdong.adapter.FragAdapter;
import com.bawei.guolei.jingdong.bean.PicBean;
import com.bawei.guolei.jingdong.presenter.FragPresenter;
import com.bawei.guolei.jingdong.view.FragView;

/**
 * Created by Lenovo on 2017/12/6.
 */
public class Fragment_tu1 extends Fragment implements FragView{

    private RecyclerView recyclerView;
    private FragAdapter adapter;
    private GridLayoutManager manager;
    private FragPresenter presenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tu1,container,false);
        recyclerView = view.findViewById(R.id.recyclerVi_01);
        presenter = new FragPresenter(this);
        presenter.get();
        adapter = new FragAdapter(getActivity());
        manager = new GridLayoutManager(getActivity(),5);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        return view;
    }


    @Override
    public void success(PicBean picBean) {
        adapter.addData(picBean);


    }

    @Override
    public void failure(Exception e) {

    }
}
