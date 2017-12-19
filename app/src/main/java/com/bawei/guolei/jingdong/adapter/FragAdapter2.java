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
public class FragAdapter2 extends RecyclerView.Adapter<FragAdapter2.IViewHodler> {


    private Context context;

    List<PicBean.DataBean> plist;

    public FragAdapter2(Context context) {
        this.context = context;

    }

    public void addData(PicBean picbean) {
        if (plist == null) {
            plist = new ArrayList<>();
        }
        plist.addAll(picbean.getData());
        notifyDataSetChanged();

    }

    @Override
    public IViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_layout2, null);

        return new IViewHodler(view);
    }


    @Override
    public void onBindViewHolder(IViewHodler holder, int position) {
        holder.simple02.setImageURI(plist.get(position+8).getIcon());
        holder.textView02.setText(plist.get(position+8).getName());


    }

    @Override
    public int getItemCount() {
        return plist == null ? 0 : plist.size();
    }

    static class IViewHodler extends RecyclerView.ViewHolder{

        SimpleDraweeView simple02=itemView.findViewById(R.id.simple_02);

        TextView textView02=itemView.findViewById(R.id.text_view_02);
        public IViewHodler(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
