package com.wu.my.guagua.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ScrollView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.wu.my.guagua.R;
import com.wu.my.guagua.activity.DetailsActivity;
import com.wu.my.guagua.adapter.AdvertViewPger;
import com.wu.my.guagua.adapter.HGridViewAdapter;
import com.wu.my.guagua.adapter.RGridViewAdapter;
import com.wu.my.guagua.adapter.UListViewAdapter;
import com.wu.my.guagua.adapter.WGridViewAdapter;
import com.wu.my.guagua.bean.AdvertBean;
import com.wu.my.guagua.bean.HotloadBean;
import com.wu.my.guagua.bean.RecommendBean;
import com.wu.my.guagua.bean.UpdateLaterBean;
import com.wu.my.guagua.bean.WonderfulBean;
import com.wu.my.guagua.helper.OkHttpClientHelper;
import com.wu.my.guagua.utils.URLConstants;
import com.wu.my.guagua.view.MyGridView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 推荐页面ViewPager的碎片
 */
public class RecommendFragment extends Fragment {
    private int tabIndex;
    Gson gson = new Gson();
    private Handler handler = new Handler();
    private int page = 0;
    //热门连载的属性
    private List<Fragment> list = new ArrayList<>();
    private PullToRefreshScrollView pScrollView_hotload;
    private ViewPager viewPager_hotload;
    private MyGridView myGirdView_hotload;
    private AdvertViewPger advertViewPger;
    private List<AdvertBean.DataBean> list_advert = new ArrayList<>();
    private HGridViewAdapter gridView_hoiload_adapter;
    private List<HotloadBean.DataBean> list_gridView_hotload = new ArrayList<>();
    //小编推荐的属性
    private PullToRefreshGridView gridView_recommend;
    private RGridViewAdapter gridView_recommend_adapter;
    private List<RecommendBean.DataBean> list_recommend = new ArrayList<>();

    //精彩港漫的属性
    private PullToRefreshGridView gridView_wonderul;
    private WGridViewAdapter gridView_wonderful_adapter;
    private List<WonderfulBean.DataBean> list_wonderful = new ArrayList<>();

    //最近更新的属性
    private PullToRefreshListView listView_updatelater;
    private UListViewAdapter listView_updatelater_adapter;
    private List<UpdateLaterBean.DataBean> list_updatelater = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabIndex = getArguments().getInt("tabIndex");
        initData();
        advertViewPger = new AdvertViewPger(getContext(), list_advert);
        gridView_hoiload_adapter = new HGridViewAdapter(getContext(), list_gridView_hotload);
        gridView_recommend_adapter = new RGridViewAdapter(getContext(), list_recommend);
        gridView_wonderful_adapter = new WGridViewAdapter(getContext(), list_wonderful);
        listView_updatelater_adapter = new UListViewAdapter(getContext(), list_updatelater);
    }

    //初始化数据源，及list的赋值
    private void initData() {
        switch (tabIndex) {
            case 0:
                //开启子线程，加载网络数据
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String hotloadUrl = String.format(URLConstants.HOTLOAD_PATH, page);
                        try {
                            String jsonString = OkHttpClientHelper.getStringFromURL(getContext(),
                                    URLConstants.ADVERTI_PATH, "adverti");
                            String jsonString_grid_hotload = OkHttpClientHelper.getStringFromURL
                                    (getContext(), hotloadUrl, "hotload");
                            AdvertBean advert = gson.fromJson(jsonString, new
                                    TypeToken<AdvertBean>() {
                                    }.getType());

                            list_advert = advert.getData();
                            HotloadBean hotloadBean = gson.fromJson(jsonString_grid_hotload, new
                                    TypeToken<HotloadBean>() {
                                    }.getType());

                            list_gridView_hotload = hotloadBean.getData();
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    //刷新数据
                                    advertViewPger.reLoad(list_advert, false);
                                    if (page == 1) {
                                        gridView_hoiload_adapter.reload(list_gridView_hotload,
                                                true);
                                    } else {
                                        gridView_hoiload_adapter.reload(list_gridView_hotload,
                                                false);
                                    }
                                    //数据刷新完成，动画消失
                                    pScrollView_hotload.onRefreshComplete();
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
            case 1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String recommendUrl = String.format(URLConstants.RECOMMEND_PATH, page);
                        try {
                            String jsonString = OkHttpClientHelper.getStringFromURL(getContext(),
                                    recommendUrl, "recommend");
                            RecommendBean recommendBean = gson.fromJson(jsonString, new
                                    TypeToken<RecommendBean>() {
                                    }.getType());
                            list_recommend = recommendBean.getData();

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if (page == 1) {
                                        gridView_recommend_adapter.reload(list_recommend, true);
                                    } else {
                                        gridView_recommend_adapter.reload(list_recommend, false);
                                    }
                                    //刷新完成，动画消失
                                    gridView_recommend.onRefreshComplete();
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
            case 2:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String wonderfulUrl = String.format(URLConstants.WONDERFUL_CARTOOM,
                                    page);
                            String jsonString = OkHttpClientHelper.getStringFromURL(getContext(),
                                    wonderfulUrl, "wonderful");
                            WonderfulBean wonderfulBean = gson.fromJson(jsonString, new
                                    TypeToken<WonderfulBean>() {
                                    }.getType());
                            list_wonderful = wonderfulBean.getData();

                            //返回主线程
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    //刷新数据
                                    if (page == 1) {
                                        gridView_wonderful_adapter.reload(list_wonderful, true);
                                    } else {
                                        gridView_wonderful_adapter.reload(list_wonderful, false);
                                    }
                                    //刷新完成，动画消失
                                    gridView_wonderul.onRefreshComplete();
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }).start();
                break;
            case 3:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String updateUrl = String.format(URLConstants.UPDATE_LATER, page);
                            String jsonString = OkHttpClientHelper.getStringFromURL(getContext(),
                                    updateUrl, "updatelater");
                            UpdateLaterBean updateLaterBean = gson.fromJson(jsonString, new
                                    TypeToken<UpdateLaterBean>() {
                                    }.getType());
                            list_updatelater = updateLaterBean.getData();

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if (page == 1) {
                                        listView_updatelater_adapter.reload(list_updatelater, true);
                                    } else {
                                        listView_updatelater_adapter.reload(list_updatelater,
                                                false);
                                    }
                                    //完成刷新，动画消失
                                    listView_updatelater.onRefreshComplete();
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
    Bundle savedInstanceState) {
        View view = null;
        switch (tabIndex) {
            case 0:
                view = inflater.inflate(R.layout.hotload, container, false);
                pScrollView_hotload = (PullToRefreshScrollView) view.findViewById(R.id
                        .pScrollView_hotload);
                viewPager_hotload = (ViewPager) view.findViewById(R.id.viewPager_hotload);
                myGirdView_hotload = (MyGridView) view.findViewById(R.id.myGridView_hotload);
                break;
            case 1:
                view = inflater.inflate(R.layout.gridview_double_recommend, container, false);
                gridView_recommend = (PullToRefreshGridView) view.findViewById(R.id
                        .gridview_double_recomend);
                break;
            case 2:
                view = inflater.inflate(R.layout.gridview_double_recommend, container, false);
                gridView_wonderul = (PullToRefreshGridView) view.findViewById(R.id
                        .gridview_double_recomend);
                break;
            case 3:
                view = inflater.inflate(R.layout.listview_updatelater, container, false);
                listView_updatelater = (PullToRefreshListView) view.findViewById(R.id
                        .listView_updatelater);
                break;
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        switch (tabIndex) {
            case 0:
                //设置适配器
                viewPager_hotload.setAdapter(advertViewPger);
                myGirdView_hotload.setAdapter(gridView_hoiload_adapter);
                //设置上拉加载下拉刷新
                pScrollView_hotload.setOnRefreshListener(new PullToRefreshBase
                        .OnRefreshListener2<ScrollView>() {
                    //上拉加载
                    @Override
                    public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                        //最新数据所在页
                        page = 0;
                        //加载数据
                        initData();
                    }

                    //下拉加载
                    @Override
                    public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                        //页数累加
                        page++;
                        //刷新数据
                        initData();
                    }
                });

                //点击item进行页面的跳转
                myGirdView_hotload.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long
                            id) {
                        //获取item对应的对象
                        HotloadBean.DataBean dataBean = (HotloadBean.DataBean)
                                gridView_hoiload_adapter.getItem(position);
                        //根据对象来获取里边的属性值
                        String comicId = dataBean.getComicId();
                        String title = dataBean.getTitle();
                        String thumb = dataBean.getThumb();
                        //进行页面的跳转
                        goToActivity(comicId, thumb, title);
                    }
                });
                break;
            case 1:
                //为gridView_recommend设置适配器
                gridView_recommend.setAdapter(gridView_recommend_adapter);
                //为gridView_recommend设置刷新监听器
                gridView_recommend.setOnRefreshListener(new PullToRefreshBase
                        .OnRefreshListener2<GridView>() {
                    @Override
                    public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                        //设置加载数据为第一页
                        page = 0;
                        //加载数据
                        initData();
                    }

                    @Override
                    public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                        //页数累计增加，加载更多的数据
                        page++;
                        //加载数据
                        initData();
                    }
                });
                //设置item点击事件
                gridView_recommend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long
                            id) {
                        //获取item的对象，并获取数据，页面跳转传值
                        RecommendBean.DataBean dataBean = (RecommendBean.DataBean)
                                gridView_recommend_adapter.getItem(position);
                        String title = dataBean.getTitle();
                        String comicId = dataBean.getComicId();
                        String thumb = dataBean.getThumb();
                        //调用页面跳转的方法
                        goToActivity(comicId, thumb, title);
                    }
                });
                break;
            case 2:
                //给gridView_wonderul设置适配器
                gridView_wonderul.setAdapter(gridView_wonderful_adapter);
                //设置上拉加载下拉刷新
                gridView_wonderul.setOnRefreshListener(new PullToRefreshBase
                        .OnRefreshListener2<GridView>() {
                    //下拉刷新
                    @Override
                    public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                        //最新数据所在页
                        page = 0;
                        //加载数据
                        initData();
                    }

                    //上拉加载
                    @Override
                    public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                        //数据页累加
                        page++;
                        //加载数据
                        initData();
                    }
                });

                //设置item点击事件
                gridView_wonderul.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long
                            id) {
                        //获取item的对象，并获取数据，页面跳转传值
                        WonderfulBean.DataBean dataBean = (WonderfulBean.DataBean)
                                gridView_wonderful_adapter.getItem(position);
                        String title = dataBean.getTitle();
                        String comicId = dataBean.getComicId();
                        String thumb = dataBean.getThumb();
                        goToActivity(comicId, thumb, title);
                    }
                });
                break;
            case 3:
                listView_updatelater.setAdapter(listView_updatelater_adapter);
                //为listView_updatelater设置上拉加载，下拉刷新
                listView_updatelater.setOnRefreshListener(new PullToRefreshBase
                        .OnRefreshListener2<ListView>() {
                    //下拉刷新
                    @Override
                    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                        //最新数据所在页
                        page = 0;
                        //加载数据
                        initData();
                    }

                    //上拉加载
                    @Override
                    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                        //数据页累加
                        page++;
                        //加载数据
                        initData();
                    }
                });

                //设置item点击事件
                listView_updatelater.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long
                            id) {
                        //获取item的对象，并获取数据，页面跳转传值
                        UpdateLaterBean.DataBean dataBean = (UpdateLaterBean.DataBean)
                                listView_updatelater_adapter.getItem(position);
                        String title = dataBean.getTitle();
                        String thumb = dataBean.getThumb();
                        String comicId = dataBean.getComicId();
                        //调用页面跳转的方法
                        goToActivity(comicId, thumb, title);

                    }
                });
                break;
        }
    }

    /**
     * 创建RecommendFragment对象
     */
    public static RecommendFragment newInstance(int tabIndex) {
        Bundle bundle = new Bundle();
        bundle.putInt("tabIndex", tabIndex);
        RecommendFragment fragment = new RecommendFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    /**
     * 进行页面跳转
     */
    public void goToActivity(String comicId, String thumb, String title) {
        Intent intent = new Intent();
        //设置跳转
        intent.setClass(getActivity(), DetailsActivity.class);
        //intent装载数据
        intent.putExtra("comicId", comicId);
        intent.putExtra("thumb", thumb);
        intent.putExtra("title", title);
        //启动跳转
        startActivity(intent);
    }
}
