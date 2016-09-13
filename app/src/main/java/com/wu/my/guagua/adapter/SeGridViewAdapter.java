package com.wu.my.guagua.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.wu.my.guagua.R;
import com.wu.my.guagua.bean.SectionBean;

import java.util.List;

/**
 * 搜索页面的网格的适配器
 */
public class SeGridViewAdapter extends BaseAdapter {
    private List<SectionBean.DataBean> list;
    private Context context;
    private LayoutInflater inflater;

    public SeGridViewAdapter(Context context, List<SectionBean.DataBean> list) {
        this.list = list;
        this.context = context;
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
            convertView = inflater.inflate(R.layout.item_gridview_section, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        SectionBean.DataBean dataBean = list.get(position);
        holder.textView_gridView_section_sections.setText(dataBean.getTitle());
        return convertView;
    }

    //自定义内部类，实现布局的初始化
    class ViewHolder {
        private TextView textView_gridView_section_sections;
        public ViewHolder(View convertView) {
            textView_gridView_section_sections = (TextView) convertView.findViewById(R.id
                    .textView_gridView_section_sections);
        }
    }

    //重新加载数据
    public void reload(List<SectionBean.DataBean> _list, boolean isClear) {
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
