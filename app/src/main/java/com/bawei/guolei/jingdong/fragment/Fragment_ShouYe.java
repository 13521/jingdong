package com.bawei.guolei.jingdong.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.bawei.guolei.jingdong.GlideImageLoader;
import com.bawei.guolei.jingdong.R;
import com.bawei.guolei.jingdong.activity.EWMActivity;
import com.bawei.guolei.jingdong.activity.SouSuoActivty;
import com.bawei.guolei.jingdong.adapter.FraggrAdapter;
import com.bawei.guolei.jingdong.adapter.FraglsAdapter;
import com.bawei.guolei.jingdong.bean.ShowBean;
import com.bawei.guolei.jingdong.presenter.FraglsPresenter;
import com.bawei.guolei.jingdong.presenter.ViewPresenter;
import com.bawei.guolei.jingdong.view.FraglsView;
import com.bawei.guolei.jingdong.view.ViewpaView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/12/6.
 */
public class Fragment_ShouYe extends Fragment implements View.OnClickListener,ViewpaView,FraglsView{


    private ViewPager viewPager;

    private LinearLayout mHeadLayout;
    private CheckBox mEw;
    private TextView mEt;
    private ViewPresenter presenter;
    private List<String> images=new ArrayList<>();
    private Banner mBanner;
    private RecyclerView recyclerView;
    private FraglsAdapter lsAdapter;
    private FraglsPresenter lsPresenter;
    private LinearLayoutManager manager;
    private RecyclerView recyclerView1;
    private FraggrAdapter frAdapter;
    private GridLayoutManager manager1;
    private ViewFlipper vf;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.fragment1,container,false);


        //方法
        initView(view);
        //跑马灯
        vf = (ViewFlipper) view.findViewById(R.id.view_filpper);
        vf.addView(View.inflate(getActivity(), R.layout.item_paomadeng, null));

        //京东轮播图
        presenter = new ViewPresenter(this);
        presenter.get1();

        //京东秒杀列表
        recyclerView = view.findViewById(R.id.recycle_viewls);
        lsPresenter = new FraglsPresenter(this);
        lsPresenter.get1();

        //京东推荐
        recyclerView1 = view.findViewById(R.id.recycle_ls);


        return view;

    }
    //方法设定
    private void initView(View view) {
        mBanner = view.findViewById(R.id.banner);
        mEw = (CheckBox) view.findViewById(R.id.ew);
        mEw.setOnClickListener(this);
        mEt = (TextView) view.findViewById(R.id.et);
        mEt.setOnClickListener(this);
        mHeadLayout = (LinearLayout) view.findViewById(R.id.head_layout);

        //轮播图
        viewPager = view.findViewById(R.id.viewpager);
        final List<Fragment> list=new ArrayList<>();





        //京东九宫格轮播
        list.add(new Fragment_tu1());
        list.add(new Fragment_tu2());
        //
        viewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });



    }
    //搜索和扫一扫点击

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ew:
                Intent it2=new Intent(getActivity(), EWMActivity.class);
                startActivity(it2);
                break;
            case R.id.et:
                Intent it=new Intent(getActivity(),SouSuoActivty.class);
                startActivity(it);
                break;


        }




    }

    //京东轮播图方法
    @Override
    public void success(ShowBean sbean) {
        setBannerImage(sbean);

    }
    //京东秒杀调用成功方法
    @Override
    public void successes(ShowBean shBean) {
        //京东秒杀
        lsAdapter = new FraglsAdapter(getActivity());
        manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        lsAdapter.addData(shBean);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(lsAdapter);

        //为你推荐
        frAdapter = new FraggrAdapter(getActivity());
        manager1 = new GridLayoutManager(getActivity(),2);
        frAdapter.addData(shBean);
        recyclerView1.setLayoutManager(manager1);
        recyclerView1.setAdapter(frAdapter);

    }
    //京东轮播图加载

    private void setBannerImage(ShowBean sbean) {
        System.out.println("sbean"+sbean.getData().get(0).getTitle());
        if(sbean!=null){
            List<ShowBean.DataBean> data=sbean.getData();
            for(int i=0;i<data.size();i++){
                images.add(data.get(i).getIcon());


            }
        }
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合

        mBanner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }




}
