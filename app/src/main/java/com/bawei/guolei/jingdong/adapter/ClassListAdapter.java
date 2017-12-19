package com.bawei.guolei.jingdong.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bawei.guolei.jingdong.R;
import com.bawei.guolei.jingdong.bean.PicBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017/12/8.
 */
public class ClassListAdapter extends BaseAdapter {
    private Context context;
    private List<PicBean.DataBean> list;
    public ClassListAdapter(List<PicBean.DataBean> list, Context context) {
        this.list=list;
        this.context=context;

        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));

    }
    public void addData(PicBean pibean) {
        if (list==null){
            list=new ArrayList<>();
        }
        list.addAll(pibean.getData());
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        IViewHolder holder;
        if (view==null){
            view=View.inflate(context, R.layout.two_item,null);
            holder=new IViewHolder();
            holder.simple=view.findViewById(R.id.left_simple);
            holder.textview=view.findViewById(R.id.title_tv);
            view.setTag(holder);

        }else{
            holder= (IViewHolder) view.getTag();
        }
        holder.textview.setText(list.get(i).getName());
        ImageLoader.getInstance().displayImage(list.get(i).getIcon(),holder.simple);

        return view;
    }



    class IViewHolder{
        SimpleDraweeView simple;
        TextView textview;
    }
}
