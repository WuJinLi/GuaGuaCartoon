package com.wu.my.guagua.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wu.my.guagua.R;
import com.wu.my.guagua.bean.AdvertBean;

import java.util.List;

/**
 * 广告栏中viewpager的适配器
 */
public class AdvertViewPger extends PagerAdapter {
    private Context context;
    private List<AdvertBean.DataBean> list;
    private LayoutInflater inflater;

    public AdvertViewPger(Context context, List<AdvertBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * @param container
     * @param position
     * @return 填充布局，加载viewpage内具体内容
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.item_viewpager_hotload_adv, container, false);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id
                .simpleDraweeView);
        TextView textView_viewpager_hotload_title = (TextView) view.findViewById(R.id
                .textView_viewpager_hotload_title);
        //给imageView textView设置内容
        //获取DataBean对象
        AdvertBean.DataBean dataBean = list.get(position);
        //给textView_viewpager_hotload_title设置文本信息
        textView_viewpager_hotload_title.setText(dataBean.getTitle());
        //利用fresco框架下载网络图片
        simpleDraweeView.setImageURI(Uri.parse(dataBean.getThumb()));
        //将填充的布局填充的container
        container.addView(view);
        return view;
    }

    /**
     *viewpager划过的item进行销毁
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    //重新加载数据
    public void reLoad(List<AdvertBean.DataBean> _list, boolean isClear) {
        //是否清楚数据
        if (isClear) {
            list.clear();
        }
        //添加数据
        list.addAll(_list);
        //刷新数据
        notifyDataSetChanged();
    }
}
