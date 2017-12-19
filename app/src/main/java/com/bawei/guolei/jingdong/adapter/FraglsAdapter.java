package com.bawei.guolei.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.guolei.jingdong.R;
import com.bawei.guolei.jingdong.bean.ShowBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/12/9.
 */
public class FraglsAdapter extends RecyclerView.Adapter<FraglsAdapter.ViewHolder> {
    private Context context;

    private List<ShowBean.MiaoshaBean.ListBeanX> list;
    public FraglsAdapter(Context context){
        this.context=context;

    }
    public void addData(ShowBean shBean){
        if (list==null){
            list=new ArrayList<>();
        }
        list.addAll(shBean.getMiaosha().getList());
        notifyDataSetChanged();

    }

    @Override
    public FraglsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.fritem_layout,null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FraglsAdapter.ViewHolder holder, int position) {
        String [] arr=list.get(position).getImages().split("\\|");
            holder.simple.setImageURI(arr[0]);
        holder.textview.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
         SimpleDraweeView simple=itemView.findViewById(R.id.simple_fr);
        TextView textview=itemView.findViewById(R.id.text_viewfr);
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
