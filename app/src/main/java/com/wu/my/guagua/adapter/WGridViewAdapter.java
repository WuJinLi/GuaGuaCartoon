package com.wu.my.guagua.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wu.my.guagua.R;
import com.wu.my.guagua.bean.RecommendBean;
import com.wu.my.guagua.bean.WonderfulBean;

import java.util.List;

/**
 * 精彩港漫的适配器
 */
public class WGridViewAdapter extends BaseAdapter{
    private Context context;
    private List<WonderfulBean.DataBean> list;
    private LayoutInflater inflater;

    public WGridViewAdapter(Context context, List<WonderfulBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_gridview, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        WonderfulBean.DataBean dataBean = list.get(position);
        String iconUrl = dataBean.getThumb();
        holder.simpleDraweeView_item_icon.setImageURI(Uri.parse(iconUrl));
        holder.textView_item_title.setText(dataBean.getTitle());
        holder.textView_item_count.setText(dataBean.getLastCharpter().getTitle());
        return convertView;
    }
    //自定义内部类，实现布局的初始化
    class ViewHolder {
        private SimpleDraweeView simpleDraweeView_item_icon;
        private TextView textView_item_title;
        private TextView textView_item_count;

        public ViewHolder(View convertView) {
            simpleDraweeView_item_icon = (SimpleDraweeView) convertView.findViewById(R.id
                    .simpleDraweeView_item_icon);
            textView_item_title = (TextView) convertView.findViewById(R.id.textView_item_title);
            textView_item_count = (TextView) convertView.findViewById(R.id.textView_item_count);
        }
    }

    //重新加载数据
    public void reload(List<WonderfulBean.DataBean> _list, boolean isClear) {
        //是否清空数据
        if (isClear) {
            list.clear();
        }
        //添加数据
        list.addAll(_list);
        //刷新数据
        notifyDataSetChanged();
    }
}
