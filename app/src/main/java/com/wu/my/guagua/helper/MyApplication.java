package com.wu.my.guagua.helper;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.lidroid.xutils.DbUtils;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.Picasso;
public class MyApplication extends Application {

    private Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        //调用初始化okhttp的方法
        initOkHttp();
        //调用该初始化fresco的方法
        initFresco();
        //调用初始化Picasso的方法
        initPicasso();
    }

    //初始化Picasso的方法
    private void initFresco() {
        Fresco.initialize(context);
    }

    //初始化okhttp的方法
    private void initOkHttp() {
        OkHttpClient okHttpClient = OkHttpClientHelper.getOkHttpSingletonInstance();
    }

    //初始化fresco的方法
    private void initPicasso() {
        //创建builder对象，并且设置属性
        Picasso.Builder builder = new Picasso.Builder(this)
                .defaultBitmapConfig(Bitmap.Config.RGB_565);

        //创建picasso对象
        Picasso picasso = builder.build();
        //将picasso对象实现单例
        Picasso.setSingletonInstance(picasso);

    }

}
