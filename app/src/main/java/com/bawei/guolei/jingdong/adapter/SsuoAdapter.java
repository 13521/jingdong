package com.bawei.guolei.jingdong.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.guolei.jingdong.R;
import com.bawei.guolei.jingdong.activity.XqActivity;
import com.bawei.guolei.jingdong.bean.SsuoBean;
import com.bumptech.glide.Glide;

/**
 * Created by Lenovo on 2017/12/10.
 */
public class SsuoAdapter extends RecyclerView.Adapter<SsuoAdapter.myholder>{
    //两个参数  上下文，和数据源
    private Context context;
    private SsuoBean ssuoBean;
    public SsuoAdapter(Context context, SsuoBean ssuoBean){
        this.context=context;
        this.ssuoBean=ssuoBean;

    }

    @Override
    public SsuoAdapter.myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载布局返回到holder
        View view=View.inflate(context, R.layout.sou_item,null);
        myholder myholder=new myholder(view);

        return myholder;
    }

    @Override
    public void onBindViewHolder(SsuoAdapter.myholder holder, final int position) {
        //通过数据源内的图片字符串 通过split截取成数组
        final String[] imgdata=ssuoBean.getData().get(position).getImages().split("\\|");
        Glide.with(context)
                .load(imgdata[0])
                .into(holder.item_li_iv);
        //设置控件 属性
        holder.item_li_tv1.setText(ssuoBean.getData().get(position).getTitle());
        holder.item_li_tv2.setText(ssuoBean.getData().get(position).getPrice()+"￥");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, XqActivity.class);
                intent.putExtra("title",ssuoBean.getData().get(position).getTitle());
                intent.putExtra("price",ssuoBean.getData().get(position).getPrice()+"￥");
                intent.putExtra("image",imgdata[0]);
                intent.putExtra("pid",ssuoBean.getData().get(position).getPid());
                intent.putExtra("price1",ssuoBean.getData().get(position).getBargainPrice()+"￥");
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return ssuoBean.getData()==null?0:ssuoBean.getData().size();
    }
    static class myholder extends RecyclerView.ViewHolder{
        ImageView item_li_iv=itemView.findViewById(R.id.item_li_iv);
        TextView item_li_tv1=itemView.findViewById(R.id.item_li_tv1);
        TextView item_li_tv2=itemView.findViewById(R.id.item_li_tv2);
        public myholder(View itemView) {
            super(itemView);

        }
    }
}
