package com.wu.my.guagua.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.lidroid.xutils.DbUtils;
import com.wu.my.guagua.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 程序启动的起始页面
 */
public class StartActivity extends AppCompatActivity {
    public static DbUtils dbUtils;//操作数据库对象的创建
    private Context mContext=this;//上下文对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbUtils=DbUtils.create(mContext,"collect1.db");
        setContentView(R.layout.activity_start);
        //调用初始化控件的方法
        Timer timer = new Timer();
        TimerTask task = new TimerTask(){
            @Override
            public void run() {
                //小勇页面跳转的方法
                goToActivity();
            }
        };
        timer.schedule(task, 2000);
    }
    private void goToActivity() {
        //初始化intent，并设置调整转明细
        Intent intent = new Intent();
        intent.setClass(StartActivity.this, HomePagerActivity.class);
        //启动页面跳转
        startActivity(intent);
        //页面跳转后销毁当前页面
        finish();
    }
}
