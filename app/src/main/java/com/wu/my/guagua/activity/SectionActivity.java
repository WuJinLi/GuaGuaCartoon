package com.wu.my.guagua.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wu.my.guagua.R;
import com.wu.my.guagua.adapter.SeGridViewAdapter;
import com.wu.my.guagua.bean.SectionBean;
import com.wu.my.guagua.helper.OkHttpClientHelper;
import com.wu.my.guagua.utils.URLConstants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 章节列表的
 */
public class SectionActivity extends AppCompatActivity {

    private ListView listView_section;
    private SeGridViewAdapter adapter;
    private List<SectionBean.DataBean> list = new ArrayList<>();
    private Context mContext = this;
    private Intent intent;
    private Handler handler = new Handler();
    static int[] arrId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);
        //调用初始化UI的方法
        initView();
        //调用初始化数据的方法
        initData();
        //gridView_section设置适配器
        listView_section.setAdapter(adapter);
        //gridView_section设置item监听事件，点击item进行页面跳转
        listView_section.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //根据适配器，获取点击item所对应的对象
                SectionBean.DataBean dataBean = (SectionBean.DataBean) adapter.getItem(position);
                //获取要传递的数据
                int id2 = dataBean.getId();
                //intent1进行页面的跳转个数据的携带
                Intent intent1 = new Intent(SectionActivity.this, CartoonActivity.class);
                intent1.putExtra("id2", id2);
                startActivity(intent1);
            }
        });


    }

    /**
     * 初始化UI控件
     */
    private void initView() {
        listView_section = (ListView) findViewById(R.id.listView_section);
    }

    /**
     * 初始化数据的方法
     */
    private void initData() {
        //初始化adapter
        adapter = new SeGridViewAdapter(mContext, list);
        //获取intent对象
        intent = getIntent();
        //从intent对象获取传入的数据
        String id = intent.getStringExtra("id1");
        String comicId = intent.getStringExtra("comicId");
        //根据intent携带的数据进行网址的拼接
        final String sectionUrl = String.format(URLConstants.SECTION_DETAILS, id, comicId);

        //开启子线程，进行网络访问
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //获取json串
                    String jsonString = OkHttpClientHelper.getStringFromURL(mContext, sectionUrl,
                            "section");
                    //根据gson解析数据
                    Gson gson = new Gson();
                    SectionBean sectionBean = gson.fromJson(jsonString, new
                            TypeToken<SectionBean>() {
                            }.getType());
                    //讲解析的数据赋值于list
                    list = sectionBean.getData();
                    arrId = new int[list.size()];
                    for (int i = 0; i < list.size(); i++) {
                        arrId[i] = list.get(i).getId();
                    }
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
}
