package com.bawei.guolei.jingdong.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.guolei.jingdong.R;
import com.bawei.guolei.jingdong.bean.ClassBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/12/8.
 */
public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ViewHolder> {
    private Context context;
    private List<ClassBean.DataBean> clist;
    public ClassAdapter(Context context){
        this.context=context;


    }

    @Override
    public ClassAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.reitem_layout,null);


        return new ViewHolder(view);
    }
    public void addData(ClassBean classBean){
          if (clist==null){
              clist=new ArrayList<>();
          }
        clist.addAll(classBean.getData());
        notifyDataSetChanged();

    }


    @Override
    public void onBindViewHolder(ClassAdapter.ViewHolder holder, int position) {
            holder.title.setText(clist.get(position).getName());
        ClasseAdapter classeAdapter = new ClasseAdapter(context, clist.get(position).getList());
        GridLayoutManager manager=new GridLayoutManager(context,4);
        holder.recycleView.setAdapter(classeAdapter);
        holder.recycleView.setLayoutManager(manager);


    }

    @Override
    public int getItemCount() {
        return clist==null?0:clist.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
         TextView title=itemView.findViewById(R.id.text_viewfl);
         RecyclerView recycleView=itemView.findViewById(R.id.recycle_fl);
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
