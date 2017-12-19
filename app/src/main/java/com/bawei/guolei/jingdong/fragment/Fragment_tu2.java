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
import com.bawei.guolei.jingdong.adapter.FragAdapter2;
import com.bawei.guolei.jingdong.bean.PicBean;
import com.bawei.guolei.jingdong.presenter.FragPresenter;
import com.bawei.guolei.jingdong.view.FragView;

/**
 * Created by Lenovo on 2017/12/6.
 */
public class Fragment_tu2 extends Fragment implements FragView{

    private RecyclerView recyclerView;
    private FragAdapter2 adapter2;
    private GridLayoutManager manager;
    private FragPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tu2,container,false);
        recyclerView = view.findViewById(R.id.recyclerVi_02);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new FragPresenter(this);
        presenter.get();


        adapter2 = new FragAdapter2(getActivity());
        manager = new GridLayoutManager(getActivity(),5);
        recyclerView.setAdapter(adapter2);
        recyclerView.setLayoutManager(manager);

    }

    @Override
    public void success(PicBean picBean) {
        adapter2.addData(picBean);
    }

    @Override
    public void failure(Exception e) {

    }
}
