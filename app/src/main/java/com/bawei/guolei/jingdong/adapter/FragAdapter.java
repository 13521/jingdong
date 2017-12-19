package com.bawei.guolei.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.guolei.jingdong.R;
import com.bawei.guolei.jingdong.bean.PicBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2017/12/6.
 */
public class FragAdapter extends RecyclerView.Adapter<FragAdapter.IViewHodler> {

    private Context context;

    List<PicBean.DataBean> plist;

    public FragAdapter(Context context){
        this.context=context;

    }
    public void addData(PicBean picbean){
        if (plist==null){
            plist=new ArrayList<>();
        }
        plist.addAll(picbean.getData());

        notifyDataSetChanged();

    }

    @Override
    public IViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_layout, null);

        return new IViewHodler(view);
    }


    @Override
    public void onBindViewHolder(IViewHodler holder, int position) {
        holder.simple01.setImageURI(plist.get(position).getIcon());
        holder.textView01.setText(plist.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return plist==null?0:plist.size();
    }

    static class IViewHodler extends RecyclerView.ViewHolder {
        SimpleDraweeView simple01=itemView.findViewById(R.id.simple_01);
        TextView textView01=itemView.findViewById(R.id.text_view_01);
        public IViewHodler(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }

}
