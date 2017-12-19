package com.bawei.guolei.jingdong.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.guolei.jingdong.R;
import com.bawei.guolei.jingdong.adapter.SsuoAdapter;
import com.bawei.guolei.jingdong.bean.SsuoBean;
import com.bawei.guolei.jingdong.presenter.SsuoPresenter;
import com.bawei.guolei.jingdong.view.SsuoView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

public class SouSuoActivty extends AppCompatActivity implements SsuoView{

    private ImageView fanhui;
    private EditText sousuo;
    private Button mSoso;
    private  int num=1;
    private  int  aa=1;
    private XRecyclerView mXrv;
    Handler handler=new Handler();
    private LinearLayoutManager manager;
    private SsuoAdapter adapter;
    private SsuoPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sou_suo);
        presenter= new SsuoPresenter(this,this);

        //寻找控件
        initView();
        mSoso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击搜索按钮时触发presenter的获取数据方法
                presenter.getdata(sousuo.getText().toString(),"1");
            }
        });
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    private void initView() {
        fanhui = (ImageView) findViewById(R.id.denglufanhui);
        sousuo = (EditText) findViewById(R.id.et);
        mSoso = (Button) findViewById(R.id.soso);
        mXrv = (XRecyclerView) findViewById(R.id.xrv);




    }
    @Override
    public void ShowView(SsuoBean ssuoBean) {


        //view 层 的方法 用来更新ui
        Toast.makeText(SouSuoActivty.this,ssuoBean.getMsg(),Toast.LENGTH_SHORT).show();
        manager = new LinearLayoutManager(SouSuoActivty.this);
        mXrv.setLayoutManager(manager);
        adapter = new SsuoAdapter(SouSuoActivty.this,ssuoBean);
        mXrv.setAdapter(adapter);
        //XRecyclerview的上拉下拉方法
        mXrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //刷新
                        presenter.getdata(sousuo.getText().toString(),"1");
                        adapter.notifyDataSetChanged();
                        mXrv.refreshComplete();


                    }
                },900);

            }

            @Override
            public void onLoadMore() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //加载
                        num++;
                        presenter.getdata(sousuo.getText().toString(),num+"");
                        adapter.notifyDataSetChanged();
                        mXrv.loadMoreComplete();

                    }
                },900);

            }
        });

    }


    //实现presenter内部的防止内存溢出方法
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destory();
    }



}
