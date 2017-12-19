package com.bawei.guolei.jingdong.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.guolei.jingdong.R;
import com.bawei.guolei.jingdong.bean.AddBean;
import com.bawei.guolei.jingdong.presenter.AddPresenter;
import com.bawei.guolei.jingdong.view.AddView;
import com.facebook.drawee.view.SimpleDraweeView;

public class XqActivity extends AppCompatActivity implements AddView{

    private TextView title;
    private TextView price;
    private TextView oldprice;
    private Button button;
    private Button addbutton;
    private String titles;
    private String prices;
    private String prices1;
    private String images;
    private int pids;
    private SimpleDraweeView banner;
    private AddPresenter addPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xq);

        banner = (SimpleDraweeView) findViewById(R.id.banner_xq);
        title = (TextView) findViewById(R.id.title_xq);
        price = (TextView) findViewById(R.id.price_xq);
        oldprice = (TextView) findViewById(R.id.oldsprice_xq);
        button = (Button) findViewById(R.id.card);
        addbutton = (Button) findViewById(R.id.add);

        Intent intent = getIntent();
        titles = intent.getStringExtra("title");
        prices = intent.getStringExtra("price");
        prices1 = intent.getStringExtra("price1");
        images = intent.getStringExtra("image");
        pids = intent.getIntExtra("pid", 0);
        
        initPresenter();
        initView();
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPresenter.get3(pids);


            }
        });


    }

    private void initPresenter() {
        addPresenter = new AddPresenter(this);
    }

    private void initView() {
        title.setText(titles);
        price.setText("现价："+prices);
        oldprice.setText("原价："+prices1);
        banner.setImageURI(images);



    }

    @Override
    public void success(AddBean addBean) {
         if (addBean!=null){
             Toast.makeText(XqActivity.this,"加入成功",Toast.LENGTH_SHORT).show();

         }else{
             Toast.makeText(XqActivity.this,"加入失败",Toast.LENGTH_SHORT).show();
         }
    }
}
