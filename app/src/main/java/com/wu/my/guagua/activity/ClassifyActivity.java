package com.wu.my.guagua.activity;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
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
import com.wu.my.guagua.adapter.ClassifyListViewAdapter;
import com.wu.my.guagua.bean.ClassifyTBean;
import com.wu.my.guagua.helper.OkHttpClientHelper;
import com.wu.my.guagua.utils.URLConstants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 分类详情页面
 */
public class ClassifyActivity extends AppCompatActivity {

    //UI控件的声明
    private PullToRefreshListView listView_classify;
    private ImageView imageView_classify_back;
    private TextView textView_classify_title;
    private Context mContext = this;
    //适配器的声明
    private ClassifyListViewAdapter classifyListViewAdapter;
    //数据源集合的声明
    private List<ClassifyTBean.DataBean> list = new ArrayList<>();
    private Handler handler = new Handler();
    //顶部标题内容的声明
    private String title;
    private int page = 1;
    private int cateId;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify);
        //调用初始化UI控件的方法
        initView();
        //调用初始化数据的方法
        initData();
        //调用联网下载数据的方法
        loadData();
        //初始化适配器
        classifyListViewAdapter = new ClassifyListViewAdapter(mContext, list);
        //给UI控件设置适配器
        listView_classify.setAdapter(classifyListViewAdapter);


        //为UI控件赋值
        textView_classify_title.setText(title);
        //为imageView设置点击事件实现返回键的功能
        imageView_classify_back.setOnClickListener(new View.OnClickListener() {
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

        //给item添加点击事件
        listView_classify.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //通过classifyListViewAdapter获取点击的item对应的对象
                ClassifyTBean.DataBean dataBean = (ClassifyTBean.DataBean)
                        classifyListViewAdapter.getItem(position);
                //通过对象获取相关的属性
                String title = dataBean.getTitle();
                String thumb = dataBean.getThumb();
                String comicId = dataBean.getComicId();
                //初始化intent对象
                Intent intent1 = new Intent();
                intent1.setClass(ClassifyActivity.this, DetailsActivity.class);
                //intent装载数据
                intent1.putExtra("comicId", comicId);
                intent1.putExtra("thumb", thumb);
                intent1.putExtra("title", title);
                //启动跳转
                startActivity(intent1);
            }
        });
        //设置上拉加载下拉刷新
        listView_classify.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>
                () {
            //下拉加载最新数据
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page = 1;
                loadData();
            }

            //上拉加载更多数据
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page++;
                loadData();
            }
        });
    }

    private void initData() {
        //获得intent对象
        Intent intent = getIntent();
        //通intent对象获取携带的数据
        cateId = intent.getIntExtra("cateId", -1);
        title = intent.getStringExtra("title");
    }

    /**
     * 初始化数据
     */
    private void loadData() {
        //拼接网址
        final String url = String.format(URLConstants.CLASSIFY_TWO, cateId, page);

        //开启子线程，实现网络数据的加载
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //利用工具类获取数据的json数据串
                    String jsonString = OkHttpClientHelper.getStringFromURL(mContext, url,
                            "classify");
                    //gson数据解析
                    Gson gson = new Gson();
                    ClassifyTBean tBean = gson.fromJson(jsonString, new TypeToken<ClassifyTBean>() {
                    }.getType());
                    //将解析的数据赋值给list
                    list = tBean.getData();
                    //返回主线程更新UI
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (list != null) {
                                //刷新数据
                                if (page == 1) {
                                    classifyListViewAdapter.reload(list, true);
                                } else {
                                    classifyListViewAdapter.reload(list, false);
                                }
                            } else {
                                Toast.makeText(mContext, "没有更所数据啦", Toast.LENGTH_SHORT).show();
                            }
                            listView_classify.onRefreshComplete();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * UI控件的初始化
     */
    private void initView() {
        listView_classify = (PullToRefreshListView) findViewById(R.id.listView_classify);
        imageView_classify_back = (ImageView) findViewById(R.id.imageView_classify_back);
        textView_classify_title = (TextView) findViewById(R.id.textView_classify_title);


    }
}
