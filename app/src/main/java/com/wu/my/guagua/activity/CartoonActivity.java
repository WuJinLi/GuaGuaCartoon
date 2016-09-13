package com.wu.my.guagua.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wu.my.guagua.R;
import com.wu.my.guagua.adapter.CRecyclerViewAdapter;
import com.wu.my.guagua.bean.CartoonBean;
import com.wu.my.guagua.helper.OkHttpClientHelper;
import com.wu.my.guagua.utils.URLConstants;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 查看漫画的页面
 */
public class CartoonActivity extends AppCompatActivity {

    //对UI控件的声明
    private RecyclerView recyclerView_cartoon;
    private TextView textView_cartoon_updateTime;
    private TextView textView_cartoon_title;
    private TextView textView_cartoon_progress;
    private TextView textView_cartoon_electric;
    private TextView textView_cartoon_nextAndUp;
    private SeekBar seekbar_cartoon_light;
    //声明数据源，泛型为String
    private List<String> list_cartoon = new ArrayList<>();
    //声明适配器
    private CRecyclerViewAdapter cartoonAdapter;
    private Intent intent;
    //初始化handler进行子线程和UI线程的数据传递
    private Handler handler = new Handler();
    private Context mContext = this;
    private String title;
    private int id1;
    private Context context = this;
    private int[] arrId1;
    private int position;
    private int length;
    //判断状态的标记
    private boolean island = false;
    private boolean islight=false;
    private LinearLayoutManager layoutManager;//布局管理器



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartoon);
        //调用初始化控件的方法
        initView();
        //调用初始化数据的方法
        initData();
        //调用加载网络数据的方法
        loadData();
        //调用初始化数组的方法
        initArr();
        //recyclerView_cartoon设置固定高度
        recyclerView_cartoon.setHasFixedSize(true);
        //初始化布局管理器
        layoutManager = new LinearLayoutManager(mContext);
        //为recyclerView_cartoon设置布局管理器
        recyclerView_cartoon.setLayoutManager(layoutManager);
        //初始化adapter
        cartoonAdapter = new CRecyclerViewAdapter(mContext, list_cartoon);
        //为recyclerView_cartoon设置适配器
        recyclerView_cartoon.setAdapter(cartoonAdapter);


        //为recyclerView_cartoon添加滚动事件监听
        recyclerView_cartoon.addOnScrollListener(new RecyclerView.OnScrollListener() {
            //
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //获取当前显示页的位置
                final int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                //更新文本框的信息
                textView_cartoon_progress.setText((firstVisibleItemPosition + 1) + "/" +
                        list_cartoon.size());

                //如果当显示页等于当前加载总页数或者第一页，出现文本框提示用户加载数据
                if (firstVisibleItemPosition == list_cartoon.size() - 1) {
                    //显示可视化界面，加载下一张
                    textView_cartoon_nextAndUp.setText("加载下一章");
                    //文本框显示
                    textView_cartoon_nextAndUp.setVisibility(View.VISIBLE);
                } else if (firstVisibleItemPosition == 0) {
                    //显可视化界面，加载上一章
                    textView_cartoon_nextAndUp.setText("加载上一章");
                    //文本框显示
                    textView_cartoon_nextAndUp.setVisibility(View.VISIBLE);
                } else {
                    //文本框隐藏
                    textView_cartoon_nextAndUp.setVisibility(View.INVISIBLE);
                }


                //文本出现，提示用户加载上一页或者下一页
                textView_cartoon_nextAndUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //获取当前网址的参数在数组集合中的位置
                        for (int i = 0; i < arrId1.length; i++) {
                            //遍历数组，进行判断，相等输出所在的角标
                            if (id1 == arrId1[i]) {
                                position = i;
                            }
                        }
                        //滑到底部，加载下一页
                        if (firstVisibleItemPosition == list_cartoon.size() - 1) {
                            //获取下一页网址所在位置
                            int down = position + 1;
                            //判断该集合是否存在该位置，存在，加载获取对应的网址，不存在提示用户
                            if (down < arrId1.length) {
                                //获取网址参数
                                id1 = arrId1[down];
                                //加载数据
                                loadData();
                            } else {
                                //不存在数据，提示用户
                                Toast.makeText(context, "已经到底啦", Toast.LENGTH_SHORT).show();
                            }
                        }

                        //滑到顶部，点击加载上一页
                        if (firstVisibleItemPosition == 0) {
                            //计算上一页所在的角标
                            int up = position - 1;
                            //判断角标是否大于0，大于0存在上一页，否则没有可加载的数据
                            if (up >= 0) {
                                //获取上一页对应的网址参数
                                id1 = arrId1[up];
                                //加载数据
                                loadData();
                            } else {
                                //没有更多数据提醒用户
                                Toast.makeText(context, "已经到顶啦", Toast.LENGTH_SHORT).show();
                            }
                        }
                        //文本框消失
                        textView_cartoon_nextAndUp.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
        //调用更新UI的方法
        initUI();


    }


    private void initArr() {
        length = SectionActivity.arrId.length;
        arrId1 = new int[length];
        for (int i = 0; i < length; i++) {
            arrId1[i] = SectionActivity.arrId[i];
        }
    }

    private void initData() {
        //获取intent对象
        intent = getIntent();
        id1 = intent.getIntExtra("id2", -1);
        Log.i("id1", id1 + "");
    }

    /**
     * 实现视图底部电量，日期，进度的UI显示
     */
    private void initUI() {
        //获取系统当前日期
        //初始化日期模板
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //将获取的日期转换成模板格式
        String date = sDateFormat.format(new java.util.Date());
        //给UI控件添加数据
        textView_cartoon_updateTime.setText("时间:" + date);
        //意图过滤器，接收指定的广播
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        //初始化广播接收者对象
        BatteryReceiver receiver = new BatteryReceiver();
        //注册广播接收器
        registerReceiver(receiver, filter);
        //为textView_cartoon_title设置属性值
        textView_cartoon_title.setText(title);
    }


    /**
     * 获取传值，拼凑网址，获取数据
     */
    private void loadData() {
        //根据intent中的传递数值，拼接网址
        final String cartoonUrl = String.format(URLConstants.CARTOON_PATH, id1);
        //开启子线程，网络访问
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //获取json字符串
                    String jsonString = OkHttpClientHelper.getStringFromURL(mContext, cartoonUrl,
                            "cartoon");
                    //Gson解析数据
                    Gson gson = new Gson();
                    //解析数据获取实体对象
                    CartoonBean bean = gson.fromJson(jsonString, new
                            TypeToken<CartoonBean>() {
                            }.getType());
                    //根据实体对象来获取属性值赋值给集合
                    list_cartoon = bean.getData().getAddrs();
                    title = bean.getData().getTitle();
                    Log.i("title", title + "");
                    //返回主线程进行UI的更新
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //刷新数据
                            cartoonAdapter.reload(list_cartoon, true);
                            textView_cartoon_title.setText(title);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 初始化UI控件
     */
    private void initView() {
        textView_cartoon_nextAndUp = (TextView) findViewById(R.id.textView_cartoon_nextAndUp);
        recyclerView_cartoon = (RecyclerView) findViewById(R.id.recyclerView_cartoon);
        textView_cartoon_updateTime = (TextView) findViewById(R.id.textView_cartoon_updateTime);
        textView_cartoon_title = (TextView) findViewById(R.id.textView_cartoon_title);
        textView_cartoon_progress = (TextView) findViewById(R.id.textView_cartoon_progress);
        textView_cartoon_electric = (TextView) findViewById(R.id.textView_cartoon_electric);

        seekbar_cartoon_light= (SeekBar) findViewById(R.id.seekbar_cartoon_light);

    }

    public void onClick(View view) {
        int screenOder = 0;
        switch (view.getId()) {
            case R.id.bt_changeScreem:
                if (island) {
                    screenOder = LinearLayoutManager.HORIZONTAL;
                    island = false;
                } else {
                    screenOder = LinearLayoutManager.VERTICAL;
                    island = true;
                }
                layoutManager = new LinearLayoutManager(mContext, screenOder, false);
                recyclerView_cartoon.setLayoutManager(layoutManager);
                break;
            //点击调节亮度按钮显示调节亮度的seekBar
            case R.id.bt_changelight:
                //根据标记为的状态来确定seekBar的显示状态
                if (islight){
                    //如果标记为true，seekBar隐藏
                    seekbar_cartoon_light.setVisibility(View.GONE);
                    //改变标记状态
                    islight=false;
                }else{
                    //显示seekBar
                    seekbar_cartoon_light.setVisibility(View.VISIBLE);
                    //改变标记状态
                    islight=true;
                    //设置seekBar最大的范围
                    seekbar_cartoon_light.setMax(10);
                    //给seekBar设置监听事件，用于调节屏幕亮度
                    seekbar_cartoon_light.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                        //进度条改变的操作，也就是滑动是的操作
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean
                                fromUser) {
                            //动态的调节屏幕亮度
                            setScreenBrightness((float)seekBar.getProgress()/10);
                        }
                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {

                        }
                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {

                        }
                    });
                }
                break;
        }
    }

    //设置屏幕亮度的函数
    private void setScreenBrightness(float num){
        //获取屏幕属性对象
        WindowManager.LayoutParams layoutParams=super.getWindow().getAttributes();
        layoutParams.screenBrightness=num;//设置屏幕的亮度
        super.getWindow().setAttributes(layoutParams);
    }

    /**
     * 自定义BroadcastReceiver，接收系统广播
     */
    private class BatteryReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            // 获得当前电量
            int current = intent.getExtras().getInt("level");
            // 获得总电量
            int total = intent.getExtras().getInt("scale");
            //电量显示格式
            int percent = current * 100 / total;
            //为控件设置电量数据值
            textView_cartoon_electric.setText("电量:" + percent + "%");
        }
    }
}
