package com.bawei.guolei.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.guolei.jingdong.R;
import com.bawei.guolei.jingdong.bean.ClassBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Lenovo on 2017/12/8.
 */
public class ClasseAdapter extends RecyclerView.Adapter<ClasseAdapter.ViewHolder> {
    private Context context;
    private List<ClassBean.DataBean.ListBean> cslist;
    public ClasseAdapter(Context context,List<ClassBean.DataBean.ListBean> cslist){
        this.context=context;
        this.cslist=cslist;

    }


    @Override
    public ClasseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.recitem_layout,null);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClasseAdapter.ViewHolder holder, int position) {
          holder.simple.setImageURI(cslist.get(position).getIcon());
        holder.textview.setText(cslist.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return cslist==null?0:cslist.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
      SimpleDraweeView simple=itemView.findViewById(R.id.simple_flz);
        TextView textview=itemView.findViewById(R.id.text_flz);
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
