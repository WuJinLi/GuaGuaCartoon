package com.wu.my.guagua.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wu.my.guagua.R;

import java.util.List;

/**
 * 查看漫画的适配器
 */
public class CRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> list;
    private Context context;
    private LayoutInflater inflater;

    public CRecyclerViewAdapter(Context context, List<String> list) {
        this.list = list;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //填充布局，
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recyclerview, parent, false);
        return new MyViewHolder(view);
    }

    //对UI控件进行赋值
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //给控件赋值
        String cartoonUrl = list.get(position);
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).simpleDraweeView_recyclerView_icon.setImageURI(cartoonUrl);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    //自定义内部类，实现布局的初始化
    class MyViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView simpleDraweeView_recyclerView_icon;
        public MyViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView_recyclerView_icon = (SimpleDraweeView) itemView.findViewById(R.id
                    .simpleDraweeView_recyclerView_icon);
        }
    }

    //刷新数据
    public void reload(List<String> _list, boolean isClear) {
        //根据isClear来判断，数否刷新数据
        if (isClear) {
            list.clear();
        }
        //添加新数据
        list.addAll(_list);
        //刷新数据
        notifyDataSetChanged();
    }

}
