package com.wu.my.guagua.helper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.List;

/**
 * fragment的优化
 */
public class FragmentHelper {

    /**
     * @param manager  fragment管理者
     * @param list     装有fragment的集合
     * @param tabIndex 被点击按钮的下标
     * @param layoutId 被替换的布局ID

     *                 使用场景：fragment之间的替换，不考虑碎片之前是否创建过的情况下
     */
    public static void replaceFragment(FragmentManager manager, List<Fragment> list, int
            tabIndex, int layoutId) {
        //出初始化事务对象
        FragmentTransaction transaction = manager.beginTransaction();

        //事务执行碎片的替换
        transaction.replace(layoutId, list.get(tabIndex));
        //指定事务
        transaction.commit();
    }

    /**
     * @param manager  fragment管理者
     * @param list     装有fragment的集合
     * @param tabIndex 被点击按钮的下标
     * @param layoutId 被替换的布局ID

     *                 使用场景：fragment之间的替换，考虑碎片的是否创建过和减少碎片的频繁创建
     */
    public static void switchFragment(FragmentManager manager, List<Fragment> list, int
            tabIndex, int layoutId) {
        FragmentTransaction transaction = manager.beginTransaction();
        //判断fragment是否显示，如果显示，则将其隐藏
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isVisible()) {
                transaction.hide(list.get(i));
            }
        }
        Fragment toFragment = list.get(tabIndex);
        //判断fragment是否添加，添加直接显示，没有添加则添加
        if (toFragment.isAdded()) {
            transaction.show(toFragment);
        } else {
            transaction.add(layoutId, toFragment);
        }
        //执行事务
        transaction.commit();
    }
}
