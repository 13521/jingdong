package com.bawei.guolei.jingdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.guolei.jingdong.R;
import com.bawei.guolei.jingdong.adapter.ShopAdapter;
import com.bawei.guolei.jingdong.bean.ShopBean;
import com.bawei.guolei.jingdong.presenter.ShopPresenter;
import com.bawei.guolei.jingdong.view.ShopView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Lenovo on 2017/12/6.
 */
public class Fragment_Card extends Fragment implements ShopView{
    @BindView(R.id.third_recyclerView)
    RecyclerView thirdRecyclerView;
    @BindView(R.id.third_allselect)
    CheckBox thirdAllselect;
    @BindView(R.id.third_totalprice)
    TextView thirdTotalprice;
    @BindView(R.id.third_totalnum)
    TextView thirdTotalnum;
    @BindView(R.id.third_submit)
    TextView thirdSubmit;
    @BindView(R.id.third_pay_linear)
    LinearLayout thirdPayLinear;
    Unbinder unbinder;
    private ShopPresenter shopPresenter;
    private ShopAdapter adapter;
    private LinearLayoutManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4, container, false);
        unbinder = ButterKnife.bind(this, view);

        shopPresenter = new ShopPresenter(this);
        shopPresenter.getData();

        adapter = new ShopAdapter(getActivity());
        manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

        thirdRecyclerView.setLayoutManager(manager);
        thirdRecyclerView.setAdapter(adapter);

        adapter.setListener(new ShopAdapter.UpdateUiListener() {
            @Override
            public void setTotal(String total, String num, boolean allCheck) {
                thirdAllselect.setChecked(allCheck);
                thirdTotalnum.setText(num);
                thirdTotalprice.setText(total);
            }
        });


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @Override
    public void success(ShopBean shopBean) {
              adapter.add(shopBean);
    }

    @OnClick(R.id.third_allselect)
    public void onViewClicked() {
        adapter.selectAll(thirdAllselect.isChecked());
    }


}
