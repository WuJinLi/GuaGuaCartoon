package com.wu.my.guagua.activity;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.wu.my.guagua.R;
import com.wu.my.guagua.adapter.SeListViewAdapter;
import com.wu.my.guagua.bean.SearchBean;
import com.wu.my.guagua.helper.OkHttpClientHelper;
import com.wu.my.guagua.utils.URLConstants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 搜索界面
 */
public class SearchActivity extends AppCompatActivity {

    private PullToRefreshListView listView_search;
    private TextView textView_search_title;
    private ImageView imageView_search_back;
    private Context mContext = this;
    private List<SearchBean.DataBean> list = new ArrayList<>();
    private SeListViewAdapter seListViewAdapter;
    private Handler handler = new Handler();
    private int page = 1;
    private String editContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //调用初始化UI的方法
        initView();
        //调用初始化数据的方法
        initData();
        //调获取网络数据的方法
        loadData();

        //设置适配器
        listView_search.setAdapter(seListViewAdapter);
        //给底部导航设置标题
        textView_search_title.setText(editContent);
        //顶部导航按钮实现点击事件，效果与返回键相同
        imageView_search_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    public void run() {
                        try {
                            Instrumentation inst = new Instrumentation();
                            inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                        } catch (Exception e) {
                        }
                    }
                }.start();
            }
        });
        //设置item点击事件
        listView_search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取item对应的对象，获取相关的数据
                SearchBean.DataBean dataBean = (SearchBean.DataBean) seListViewAdapter.getItem
                        (position);
                //通过dataBean获取相关的数据
                String comicId = dataBean.getComicId();
                String thumb = dataBean.getThumb();
                String title = dataBean.getTitle();
                Intent intent = new Intent();
                //设置跳转
                intent.setClass(SearchActivity.this, DetailsActivity.class);
                //intent装载数据
                intent.putExtra("comicId", comicId);
                intent.putExtra("thumb", thumb);
                intent.putExtra("title", title);
                //启动跳转
                startActivity(intent);
            }
        });

        //设置上拉加载下拉刷新监听
        listView_search.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            //下拉刷新
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //最新数据所在的页数
                page = 1;
                //刷新数据
                loadData();
            }

            //上拉加载
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //数据的累加
                page++;
                //刷新数据
                loadData();
            }
        });
    }

    //初始化数据的方法
    private void initData() {
        //初始化适配器
        seListViewAdapter = new SeListViewAdapter(mContext, list);
        //获取intent对象
        Intent intent = getIntent();
        //初始化editContent
        editContent = intent.getStringExtra("editContent");
    }


    //初始化UI的方法
    private void initView() {
        listView_search = (PullToRefreshListView) findViewById(R.id.listView_search);
        textView_search_title = (TextView) findViewById(R.id.textView_search_title);
        imageView_search_back = (ImageView) findViewById(R.id.imageView_search_back);
    }

    //连接网络加载数据
    private void loadData() {
        //拼接网址
        final String url = String.format(URLConstants.SEARCH, page, editContent);
        //开启子线程，获取网络数据
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    //获取网络数据json字符串
                    String jsonString = OkHttpClientHelper.getStringFromURL(mContext, url,
                            "search");
                    //gson解析数据
                    Gson gson = new Gson();
                    final SearchBean searchBean = gson.fromJson(jsonString, new
                            TypeToken<SearchBean>() {
                            }.getType());
                    //将解析的诗句赋值list
                    list = searchBean.getData();
                    //返回主线程更新UI
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (list != null) {
                                //根据page的值，选取不同的数据刷新方式
                                if (page == 1) {
                                    seListViewAdapter.reload(list, true);
                                } else {
                                    seListViewAdapter.reload(list, false);
                                }
                            } else {
                                Toast.makeText(mContext, "没有更多数据了", Toast.LENGTH_SHORT).show();
                            }
                            //刷新完成，动画消失
                            listView_search.onRefreshComplete();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
