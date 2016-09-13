package com.wu.my.guagua.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 推荐中ViewPager的适配器
 */
public class RecomViewPagerAp extends FragmentPagerAdapter {
    private List<Fragment> list;
    private String[] tabTitles;
    public RecomViewPagerAp(FragmentManager fm, List<Fragment> list, String[] tabTitles) {
        super(fm);
        this.list = list;
        this.tabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    /**
     * 给tabLayout添加标题
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
