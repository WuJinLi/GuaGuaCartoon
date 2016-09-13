package com.wu.my.guagua.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wu.my.guagua.R;
import com.wu.my.guagua.bean.DetailsBean;
import com.wu.my.guagua.helper.DataFormat;

import java.util.List;

/**
 * 详情的适配器
 */
public class DeListViewAdapter extends BaseAdapter {
    private Context context;
    private List<DetailsBean.DataBean.ComicSrcBean> list;
    private LayoutInflater inflater;

    public DeListViewAdapter(Context context, List<DetailsBean.DataBean.ComicSrcBean> list) {
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
            convertView = inflater.inflate(R.layout.item_listview_details, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        DetailsBean.DataBean.ComicSrcBean comicSrcBean = list.get(position);
        holder.textView_item_details_title.setText(comicSrcBean.getTitle());
        holder.textView_item_details_lastCharpterTitle.setText(comicSrcBean.getLastCharpterTitle());
        String lastCharpterUpdateTime = comicSrcBean.getLastCharpterUpdateTime() + "";
        String updateTimeFormat = DataFormat.dataFormat(lastCharpterUpdateTime);
        holder.textView_item_details_lastCharpterUpdateTime.setText(updateTimeFormat);
        return convertView;
    }

    //自定义内部类，实现布局的初始化
    class ViewHolder {
        private TextView textView_item_details_title;
        private TextView textView_item_details_lastCharpterTitle;
        private TextView textView_item_details_lastCharpterUpdateTime;

        public ViewHolder(View convertView) {
            textView_item_details_title = (TextView) convertView.findViewById(R.id
                    .textView_item_details_title);
            textView_item_details_lastCharpterTitle = (TextView) convertView.findViewById(R.id
                    .textView_item_details_lastCharpterTitle);
            textView_item_details_lastCharpterUpdateTime = (TextView) convertView.findViewById(R
                    .id.textView_item_details_lastCharpterUpdateTime);
        }
    }

    public void reload(List<DetailsBean.DataBean.ComicSrcBean> _list, boolean isClear) {
        if (isClear) {
            list.clear();
        }
        list.addAll(_list);
        notifyDataSetChanged();
    }
}
