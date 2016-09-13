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
import com.wu.my.guagua.bean.CommentBean;
import com.wu.my.guagua.helper.DataFormat;

import org.w3c.dom.ls.LSException;

import java.util.List;

/**
 * 评论页面的适配器
 */
public class CommListViewAdapter extends BaseAdapter {
    private List<CommentBean.DataBean.CommentListBean> list;
    private Context context;
    private LayoutInflater inflater;

    public CommListViewAdapter(Context context, List<CommentBean.DataBean.CommentListBean> list) {
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
            convertView = inflater.inflate(R.layout.item_listview_comment, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        CommentBean.DataBean.CommentListBean dataBean = list.get(position);
        holder.simpleDraweeView_item_comment_icon.setImageURI(Uri.parse(dataBean.getUser_thumb()));
        holder.textView_item_comment_nickmame.setText(dataBean.getNickname());
        holder.textView_item_comment_postTime.setText(DataFormat.dataFormat(dataBean.getPost_time
                ()));
        holder.textView_item_comment_replayNo.setText(dataBean.getReply_no());
        holder.textView_item_comment_content.setText(dataBean.getContent());
        return convertView;
    }
    //自定义内部类，实现布局的初始化
    class ViewHolder {
        private SimpleDraweeView simpleDraweeView_item_comment_icon;
        private TextView textView_item_comment_nickmame;
        private TextView textView_item_comment_postTime;
        private TextView textView_item_comment_replayNo;
        private TextView textView_item_comment_content;

        public ViewHolder(View convertView) {
            simpleDraweeView_item_comment_icon = (SimpleDraweeView) convertView.findViewById(R.id
                    .simpleDraweeView_item_comment_icon);
            textView_item_comment_nickmame = (TextView) convertView.findViewById(R.id
                    .textView_item_comment_nickmame);
            textView_item_comment_postTime = (TextView) convertView.findViewById(R.id
                    .textView_item_comment_postTime);
            textView_item_comment_replayNo = (TextView) convertView.findViewById(R.id
                    .textView_item_comment_replayNo);
            textView_item_comment_content = (TextView) convertView.findViewById(R.id
                    .textView_item_comment_content);
        }
    }

    //重新加载数据
    public void reload(List<CommentBean.DataBean.CommentListBean> _list, boolean isClear) {
        //是否清空原来的数据
        if (isClear) {
            list.clear();
        }
        //添加数据
        list.addAll(_list);
        //刷新数据
        notifyDataSetChanged();
    }
}
