package com.wu.my.guagua.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wu.my.guagua.R;
import com.wu.my.guagua.bean.ClassifyTBean;
import com.wu.my.guagua.bean.SearchBean;

import java.util.List;

/**
 * 搜索页面listView的适配器
 */
public class SeListViewAdapter extends BaseAdapter {
    private List<SearchBean.DataBean> list;
    private Context context;
    private LayoutInflater inflater;

    public SeListViewAdapter(Context context, List<SearchBean.DataBean> list) {
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
            convertView = inflater.inflate(R.layout.item_listview_updatelater, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        SearchBean.DataBean dataBean = list.get(position);
        holder.textView_listView_title.setText(dataBean.getTitle() + "");
        holder.textView_listView_authorname.setText("作者：" + dataBean.getAuthorName() + "");
        holder.textView_listView_type.setText("类型：" + dataBean.getComicType() + "");
        holder.textView_listView_last.setText("最新：" + dataBean.getLastCharpter().getTitle() + "");
        holder.simpleDraweeView_listview_updatelater_icon.setImageURI(Uri.parse(dataBean.getThumb
                ()));
        return convertView;
    }

    class ViewHolder {
        private SimpleDraweeView simpleDraweeView_listview_updatelater_icon;
        private TextView textView_listView_title;
        private TextView textView_listView_authorname;
        private TextView textView_listView_type;
        private TextView textView_listView_last;
        //自定义内部类，实现布局的初始化
        public ViewHolder(View convertView) {
            simpleDraweeView_listview_updatelater_icon = (SimpleDraweeView) convertView
                    .findViewById(R.id.simpleDraweeView_listview_updatelater_icon);
            textView_listView_last = (TextView) convertView.findViewById(R.id
                    .textView_listView_last);
            textView_listView_title = (TextView) convertView.findViewById(R.id
                    .textView_listView_title);
            textView_listView_type = (TextView) convertView.findViewById(R.id
                    .textView_listView_type);
            textView_listView_authorname = (TextView) convertView.findViewById(R.id
                    .textView_listView_authorname);

        }
    }

    //重新加载数据
    public void reload(List<SearchBean.DataBean> _list, boolean isClear) {
        //是否清除原来的数据
        if (isClear) {
            list.clear();
        }
        //添加新的数据
        list.addAll(_list);
        //刷新数据
        notifyDataSetChanged();
    }
}
