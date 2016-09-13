package com.wu.my.guagua.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lidroid.xutils.DbUtils;
import com.wu.my.guagua.R;
import com.wu.my.guagua.fragment.ParentFragment;
import com.wu.my.guagua.helper.FragmentHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用程序的主界面
 */
public class HomePagerActivity extends AppCompatActivity {

    /**
     * 定义上下文对象
     */
    private Context mContext;
    /**
     * 定义控件RadioGroup
     */
    private RadioGroup radioGroup_homepage;

    /**
     * 定义一个radionButton数组，存放多个radionButton对象
     */
    private RadioButton[] arrRadioButton;
    /**
     * 定义一个无类型数组，存放drawable对象
     */
    private TypedArray arrDrawable;
    /**
     * 定义变量用于在按返回键的方法进行判断
     */
    private boolean isBack = false;
    /**
     * 初始化数装有多个fragment的集合
     */
    private List<Fragment> list_fragment = new ArrayList<>();
    /**
     * 定义fragmentManger（碎片管理者）
     */
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pager);
        //创建数据库

        //调用初始化数据的方法
        initData();
        //调用初始化控件的方法
        initView();

        //调用初始化底部导航的方法
        initTab();
    }


    /**
     * 初始化UI控件
     */
    private void initView() {
        radioGroup_homepage = (RadioGroup) findViewById(R.id.radioGroup_homepage);
        FragmentHelper.replaceFragment(manager, list_fragment, 0, R.id.layout_container);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        //初始化上下文对象
        mContext = this;
        //初始化图片资源集合
        arrDrawable = getResources().obtainTypedArray(R.array.arrdrawable);
        arrRadioButton = new RadioButton[arrDrawable.length()];
        //初始化碎片管理者
        manager = getSupportFragmentManager();
        //为list_fragment进行赋值
        for (int i = 0; i < arrDrawable.length(); i++) {
            ParentFragment parentFragment = ParentFragment.newInstance(i);
            list_fragment.add(parentFragment);
        }
    }

    /**
     * 初始化底部导航拦
     */
    private void initTab() {
        for (int i = 0; i < arrDrawable.length(); i++) {
            //初始化radioButton对象
            RadioButton radioButton = new RadioButton(mContext);
            //获取Drawable对象
            Drawable iconDrawable = arrDrawable.getDrawable(i);
            //设置按钮的样式
            radioButton.setButtonDrawable(android.R.color.transparent);
            //设置按钮的背景图案
            radioButton.setBackground(iconDrawable);
            //设置宽度和高度
            int earchWidth = getResources().getDisplayMetrics().widthPixels / arrDrawable.length();
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(earchWidth,
                    RadioGroup.LayoutParams.WRAP_CONTENT);
            radioButton.setLayoutParams(layoutParams);
            //为每一个radionButton赋值
            arrRadioButton[i] = radioButton;
            radioGroup_homepage.addView(radioButton);
        }
        arrRadioButton[0].setChecked(true);
        radioGroup_homepage
                .setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                @Override
                                                public void onCheckedChanged
                                                        (RadioGroup group, int
                                                                checkedId) {
                                                    //根据被选择的按钮动态的创建指定的碎片
                                                    for (int i = 0; i < arrDrawable
                                                            .length(); i++) {
                                                        if (arrRadioButton[i].getId()
                                                                == checkedId) {
                                                            //调用动态创建碎片的方法
                                                                FragmentHelper.switchFragment
                                                                        (manager,
                                                                                list_fragment, i, R
                                                                                        .id
                                                                                        .layout_container);
                                                        }
                                                    }
                                                }
                                            }

                );
    }

    /**
     * 点击返回键弹出对话框提示用户是否退出
     */
    @Override
    public void onBackPressed() {
        //通过标记isBack来弹出对话框
        if (!isBack) {
            //初始化对话框
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            //为对话框属性（显示的内容，取消和确认按钮）
            builder.setMessage("确认退出？");
            builder.setNegativeButton("取消", null);
            //点击确认按钮退出界面
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            //显示对话框
            builder.create().show();
        }
    }
}
