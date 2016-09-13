package com.wu.my.guagua.activity;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wu.my.guagua.R;
import com.wu.my.guagua.adapter.CommListViewAdapter;
import com.wu.my.guagua.bean.CommentBean;
import com.wu.my.guagua.helper.OkHttpClientHelper;
import com.wu.my.guagua.utils.URLConstants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 评论页面
 */
public class CommentActivity extends AppCompatActivity {

    private ListView listView_comment;
    private List<CommentBean.DataBean.CommentListBean> list = new ArrayList<>();
    private CommListViewAdapter adapter;
    private String comicId;
    private Context mContext = this;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        //调用初始化UI的方法
        initView();
        //调用连接网络获取数据的方法
        initList();
        //调用初始化数据的方法
        initData();
    }


    private void initView() {
        listView_comment = (ListView) findViewById(R.id.listView_comment);
        adapter = new CommListViewAdapter(mContext, list);
    }

    //开启子线程。连接网络获取数据
    private void initList() {
        //获取传入的数值
        comicId = getIntent().getStringExtra("comicId");
        new Thread(new Runnable() {
            @Override
            public void run() {
                //拼凑网址
                String url = String.format(URLConstants.COMMENT, comicId);
                try {
                    //获取json字符串
                    String jsonString = OkHttpClientHelper.getStringFromURL(mContext, url,
                            "comment");
                    //gson解析数据
                    Gson gson = new Gson();
                    CommentBean commentBean = gson.fromJson(jsonString, new
                            TypeToken<CommentBean>() {
                            }.getType());
                    //获取数据给list赋值
                    list = commentBean.getData().getComment_list();
                    //返回主线程进行UI的更新
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //刷新数据
                            adapter.reload(list, false);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initData() {
        //为listView_comment设置适配器
        listView_comment.setAdapter(adapter);
    }


}
