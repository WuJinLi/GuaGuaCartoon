package com.wu.my.guagua.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ListView;
import android.widget.Toast;


import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.exception.DbException;

import com.wu.my.guagua.R;
import com.wu.my.guagua.adapter.DeListViewAdapter;
import com.wu.my.guagua.bean.CollectBean;
import com.wu.my.guagua.bean.CommentBean;
import com.wu.my.guagua.bean.DetailsBean;
import com.wu.my.guagua.helper.MyApplication;
import com.wu.my.guagua.helper.OkHttpClientHelper;
import com.wu.my.guagua.utils.URLConstants;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.Utils;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityBase;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityHelper;

/**
 * 漫画详情页面
 */
public class DetailsActivity extends AppCompatActivity implements SwipeBackActivityBase
{

    private Context mContext = this;//上下文对象
    private ListView listView_details;
    private FloatingActionButton fab;//收藏按钮
    private Toolbar toolbar;
    private SimpleDraweeView simpleDraweeView_details;
    private SwipeBackActivityHelper mHelper;//侧滑返回对象

    private DeListViewAdapter deListViewAdapter;
    private DetailsBean.DataBean detailsBeanDB = new DetailsBean.DataBean();

    public static List<CollectBean> list_collect = new ArrayList<>();
    private List<DetailsBean.DataBean.ComicSrcBean> list_details = new ArrayList<>();

    private Intent intent;
    private String comicId;
    private String title;
    private String thumb;
    private String lastCharpterUpdateTime;
    private String lastCharpterTitle;
    private Handler handler = new Handler();
    private boolean isCollect=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //调用初始化UI控件的方法
        initView();
        //初始化适配器
        deListViewAdapter = new DeListViewAdapter(mContext, list_details);
        //调用获取网络数据的方法
        loadList();
        //调用初始化数据的方法
        initData();
        //调用收藏的方法
        collect();
    }

    /**
     * 点击收藏
     */
    private void collect() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //初始化CollectBean对象
                CollectBean bean = new CollectBean(title, lastCharpterUpdateTime, thumb, comicId,
                        lastCharpterTitle);
                try {
                    //获取数据库的数据
                    list_collect = StartActivity.dbUtils.findAll(CollectBean.class);
                    //数据不为空，进行去重的操作
                        if (list_collect != null) {
                            Log.i("msg", "!null ");
                            //与数据库中的每一个元素比对，是否重复
                            for (int i = 0; i < list_collect.size(); i++) {
                                if (title.equals(list_collect.get(i).getTitle())) {
                                    isCollect=true;
                                    break;
                                }
                            }

                            //如果重复，给予用户提示
                            if(isCollect){
                                Snackbar.make(toolbar, "请勿重复收藏", Snackbar.LENGTH_LONG).show();
                            }else{
                                //利用框架向数据库存储数据
                                StartActivity.dbUtils.save(bean);
                                //向list总添加数据
                                list_collect.add(bean);
                                //用户提示，添加成功
                                Snackbar.make(toolbar, "收藏成功", Snackbar.LENGTH_LONG).show();
                            }
                        }else{
                            Log.i("msg","null");
                            StartActivity.dbUtils.save(bean);
                            Snackbar.make(toolbar, "收藏成功", Snackbar.LENGTH_LONG).show();
                        }

                } catch (DbException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    //初始化数据的方法
    private void initData() {

        mHelper = new SwipeBackActivityHelper(this);
        mHelper.onActivityCreate();
        //初始化adapter
        listView_details.setAdapter(deListViewAdapter);
        //获取intent携带的数据
        thumb = intent.getStringExtra("thumb");
        title = intent.getStringExtra("title");
        //设置toolbar的属性
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        //加载网络图片
        simpleDraweeView_details.setImageURI(Uri.parse(thumb));

        //给listView_details设置item点击事件
        listView_details.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //通过adapter获取item的对象
                DetailsBean.DataBean.ComicSrcBean comicSrcBean = (DetailsBean.DataBean
                        .ComicSrcBean) deListViewAdapter.getItem(position);
                String id1 = comicSrcBean.getId();
                //将获取的数据放置在intent中，进行页面跳转并且传值
                Intent intent1 = new Intent(DetailsActivity.this, SectionActivity.class);
                intent1.putExtra("id1", id1);
                intent1.putExtra("comicId", comicId);
                //启动页面跳转
                startActivity(intent1);
            }
        });
    }


    //连接网络，获取数据
    private void loadList() {
        //获取intent对象
        intent = getIntent();
        //获取intent携带的数据
        comicId = intent.getStringExtra("comicId");
        //开启子线程，获取网络数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                //拼接网址
                String url = String.format(URLConstants.DETAILS, comicId);
                try {
                    //获取网络数据json字符串
                    String jsonString = OkHttpClientHelper.getStringFromURL(mContext, url,
                            "details");
                    //gson解析数据
                    Gson gson = new Gson();
                    DetailsBean detailsBean = gson.fromJson(jsonString, new
                            TypeToken<DetailsBean>() {
                            }.getType());
                    //将解析的数据给list_details进行赋值
                    list_details = detailsBean.getData().getComicSrc();
                    detailsBeanDB = detailsBean.getData();
                    lastCharpterUpdateTime = list_details.get(0).getLastCharpterUpdateTime() + "";
                    lastCharpterTitle = list_details.get(0).getLastCharpterTitle();
                    //返回主线程，更新UI
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //刷新数据
                            deListViewAdapter.reload(list_details, false);
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
        fab = (FloatingActionButton) findViewById(R.id.fab);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        listView_details = (ListView) findViewById(R.id.listView_details);
        simpleDraweeView_details = (SimpleDraweeView) findViewById(R.id.simpleDraweeView_details);
    }

    /**
     * 菜单的布局的填充和加载
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //将菜单填充到menu中
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //菜单选项的功能
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //页面跳转，实现评论
            case R.id.action_comment:
                //初始化intent对象，设置属性，进行页面跳转
                Intent intent = new Intent();
                intent.setClass(DetailsActivity.this, CommentActivity.class);
                intent.putExtra("comicId", comicId);
                startActivity(intent);
                break;
            case R.id.action_introduce:
                //创建对话框对象
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                //设置对话框的标题
                builder.setTitle(title);
                //Log.i("intro", intro);
                //设置对话框的内容
                builder.setMessage(detailsBeanDB.getIntro());
                //设置对话框的按钮
                builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                //显示对话框
                builder.create().show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    ///////////////////////////////////////////////////////////////////////////
// SwipeBackActivityBase中的抽象方法
//////////////////////////////////////////////////////////////////////

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }

    @Override
    public View findViewById(int id) {
        View v = super.findViewById(id);
        if (v == null && mHelper != null)
            return mHelper.findViewById(id);
        return v;
    }
    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return mHelper.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    @Override
    public void scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
    }

}
