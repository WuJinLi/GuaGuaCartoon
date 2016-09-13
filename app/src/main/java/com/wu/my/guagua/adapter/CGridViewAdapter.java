package com.wu.my.guagua.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;
import com.wu.my.guagua.R;
import com.wu.my.guagua.bean.ClassifyBean;
import com.wu.my.guagua.utils.CircleTransformation;

import java.util.List;

/**
 * 推荐中viewpager的适配器
 */
public class CGridViewAdapter extends BaseAdapter {
    private List<ClassifyBean.DataBean> list;
    private Context context;
    private LayoutInflater inflater;

    public CGridViewAdapter(Context context, List<ClassifyBean.DataBean> list) {
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
            convertView = inflater.inflate(R.layout.item_gridview_classify, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //为控件进行赋值
        ClassifyBean.DataBean dataBean = list.get(position);
        String title = dataBean.getTitle();
        String thumb = dataBean.getThumb();
//        if (thumb != null) {
//            holder.simpleDraweeView_gridView_classify_icon.setImageURI(thumb);
//        }
        Picasso.with(context)
                .load(thumb)
                .config(Bitmap.Config.ARGB_8888)
                .transform(new CircleTransformation())
                .into(holder.imageView_gridView_classify_icon);
        holder.textView_gridView_classify_title.setText(title);
        return convertView;
    }
    //自定义内部类，实现布局的初始化
    class ViewHolder {
        private ImageView imageView_gridView_classify_icon;
        private TextView textView_gridView_classify_title;

        public ViewHolder(View convertView) {
            imageView_gridView_classify_icon = (ImageView) convertView.findViewById
                    (R.id.imageView_gridView_classify_icon);
            textView_gridView_classify_title = (TextView) convertView.findViewById(R.id
                    .textView_gridView_classify_title);
        }
    }

    //刷新数据
    public void reload(List<ClassifyBean.DataBean> _list, boolean isClear) {
        if (isClear) {
            list.clear();
        }
        //添加数据
        list.addAll(_list);
        //刷新数据
        notifyDataSetChanged();
    }
}
