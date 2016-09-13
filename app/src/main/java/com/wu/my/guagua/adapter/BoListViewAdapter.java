package com.wu.my.guagua.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wu.my.guagua.R;
import com.wu.my.guagua.bean.CollectBean;
import com.wu.my.guagua.helper.DataFormat;

import java.util.ArrayList;
import java.util.List;

/**
 * 收藏的实体类的适配器
 */
public class BoListViewAdapter extends BaseAdapter {
    private List<CollectBean> list = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    /**
     * 构造方法
     */
    public BoListViewAdapter(Context context, List<CollectBean> list) {
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
            convertView = inflater.inflate(R.layout.item_listview_bookrack, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        CollectBean bean = list.get(position);
        //如果对象不为空，进行赋值，否则不进行操作
        if (bean != null) {
            holder.simpleDraweeView_listview_bookrack_icon.setImageURI(bean.getThumb() + "");
            holder.textView_listView_bookrack_title.setText(bean.getTitle() + "");
            String updateTime = bean.getUpdateTime();
            //如果updateTime不为空，进行赋值，否则不进行操作
            if (updateTime != null) {
                holder.textView_listView_bookrack_updateTime.setText("更新时间:" + DataFormat
                        .dataFormat(updateTime));
            }
            holder.textView_listView_bookrack_upTo.setText("更新至:" + bean.getLastCharpterTitle());
        }
        return convertView;
    }
    //自定义内部类，实现布局的初始化
    class ViewHolder {
        private SimpleDraweeView simpleDraweeView_listview_bookrack_icon;
        private TextView textView_listView_bookrack_title;
        private TextView textView_listView_bookrack_updateTime;
        private TextView textView_listView_bookrack_upTo;

        public ViewHolder(View convertView) {
            simpleDraweeView_listview_bookrack_icon = (SimpleDraweeView) convertView.findViewById
                    (R.id.simpleDraweeView_listview_bookrack_icon);
            textView_listView_bookrack_title = (TextView) convertView.findViewById(R.id
                    .textView_listView_bookrack_title);
            textView_listView_bookrack_updateTime = (TextView) convertView.findViewById(R.id
                    .textView_listView_bookrack_updateTime);
            textView_listView_bookrack_upTo = (TextView) convertView.findViewById(R.id
                    .textView_listView_bookrack_upTo);
        }
    }

    //数据的刷新
    public void reload(List<CollectBean> _list, boolean isClear) {
        //判断是否清楚数据
        if (isClear) {
            list.clear();
        }
        //添加数据
        list.addAll(_list);
        //刷新数据
        notifyDataSetChanged();
    }
}
