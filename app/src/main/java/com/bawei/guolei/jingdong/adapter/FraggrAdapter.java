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
public class FraggrAdapter extends RecyclerView.Adapter<FraggrAdapter.ViewHolder> {

    private Context context;
    private List<ShowBean.TuijianBean.ListBean> list;
    public FraggrAdapter(Context context){
        this.context=context;

    }
    public void addData(ShowBean shBean){
        if (list==null){
            list=new ArrayList<>();
        }
        list.addAll(shBean.getTuijian().getList());
        notifyDataSetChanged();

    }

    @Override
    public FraggrAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.grid_layout,null);
//        View view = LayoutInflater.from(context).inflate(R.layout.grid_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FraggrAdapter.ViewHolder holder, int position) {
        String [] arr=list.get(position).getImages().split("\\|");
        holder.simple.setImageURI(arr[0]);
        holder.textView.setText(list.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView simple=itemView.findViewById(R.id.simple_gr);
        TextView textView=itemView.findViewById(R.id.text_gr);
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
