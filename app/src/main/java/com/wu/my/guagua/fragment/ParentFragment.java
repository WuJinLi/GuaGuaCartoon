package com.wu.my.guagua.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.exception.DbException;
import com.wu.my.guagua.R;
import com.wu.my.guagua.activity.ClassifyActivity;
import com.wu.my.guagua.activity.DetailsActivity;
import com.wu.my.guagua.activity.HomePagerActivity;
import com.wu.my.guagua.activity.LoginActivity;
import com.wu.my.guagua.activity.SearchActivity;
import com.wu.my.guagua.activity.StartActivity;
import com.wu.my.guagua.adapter.BoListViewAdapter;
import com.wu.my.guagua.adapter.CGridViewAdapter;
import com.wu.my.guagua.adapter.RecomViewPagerAp;
import com.wu.my.guagua.bean.ClassifyBean;
import com.wu.my.guagua.bean.CollectBean;
import com.wu.my.guagua.helper.MyApplication;
import com.wu.my.guagua.helper.OkHttpClientHelper;
import com.wu.my.guagua.utils.URLConstants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 碎片
 */
public class ParentFragment extends Fragment {
    /**
     * 定义一个用于识别加载不同布局
     */
    private int tabIndex;
    private TabLayout tabLayout_recommend;
    private ViewPager viewPager_recommend;
    private List<Fragment> list_recommend = new ArrayList<>();
    private String[] tabTitles;
    private RecomViewPagerAp recomViewPagerAp;

    //更多
    private WebView webView_more;
    //书架
    private ImageView imageView_bookrack_login;
    private ListView listView_bookrack;
    private BoListViewAdapter bookrack_adapter;
    private List<CollectBean> list_bookrack = new ArrayList<>();

    //分类
    private EditText editText_classify_search;
    private ImageView imageView_classify_search;
    private GridView gridView_classify;
    private List<ClassifyBean.DataBean> list_classify = new ArrayList<>();
    private CGridViewAdapter cGridViewAdapter;
    private String classifyUrl = URLConstants.CLASSIFY;
    private Handler handler = new Handler();
    private String editContent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取宿主传来的数值
        tabIndex = getArguments().getInt("tabIndex");
        tabTitles = getResources().getStringArray(R.array.tabTitles);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
    Bundle savedInstanceState) {
        View view = null;
        switch (tabIndex) {
            case 0:
                view = inflater.inflate(R.layout.recommend_layout, container, false);
                tabLayout_recommend = (TabLayout) view.findViewById(R.id.tabLayout_recommend);
                viewPager_recommend = (ViewPager) view.findViewById(R.id.viewPager_recommend);
                viewPager_recommend.setOffscreenPageLimit(4);
                break;
            case 1:
                view = inflater.inflate(R.layout.bookrack, container, false);
                imageView_bookrack_login = (ImageView) view.findViewById(R.id
                        .imageView_bookrack_login);
                listView_bookrack = (ListView) view.findViewById(R.id.listView_bookrack);
                break;
            case 2:
                view = inflater.inflate(R.layout.classify, container, false);
                editText_classify_search = (EditText) view.findViewById(R.id
                        .editText_classify_search);
                imageView_classify_search = (ImageView) view.findViewById(R.id
                        .imageView_classify_search);
                gridView_classify = (GridView) view.findViewById(R.id.gridView_classify);
                break;
            case 3:
                view = inflater.inflate(R.layout.more_layout, container, false);
                webView_more = (WebView) view.findViewById(R.id.webView_more);
                break;
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        switch (tabIndex) {
            case 0:
                //调用创建推荐的方法
                cteateRecommend();
                break;
            case 1:
                //调用创建书架的方法
                creatBookrack();
                break;
            case 2:
                //调用常见分类的方法
                creatClassify();
                break;
            case 3:
                //调用创建更多的方法
                createMore();
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        switch (tabIndex) {
            case 1:
                //加载数据库的数据
                try {
                    //从数据库中获取数据
                    list_bookrack = StartActivity.dbUtils.findAll(CollectBean.class);
                } catch (DbException e) {
                    e.printStackTrace();
                }
                //如果数据不为空，设置适配器
                if (list_bookrack != null) {
                    //初始化适配器
                    bookrack_adapter = new BoListViewAdapter(getContext(), list_bookrack);
                    //listView_bookrack设置适配器
                    listView_bookrack.setAdapter(bookrack_adapter);
                } else {
                    //没有数据给予用户提示
                    Toast.makeText(getContext(), "没有收藏的书籍", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    /**
     * 书架的功能
     */
    private void creatBookrack() {
        //点击图片，跳转到用户登录界面
        imageView_bookrack_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });


        //为listView设置item点击
        listView_bookrack.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long
                    id) {
                //获取item对应的对象，获取对象的属性值
                CollectBean collectBean = (com.wu.my.guagua.bean.CollectBean)
                        bookrack_adapter.getItem(position);
                String title = collectBean.getTitle();
                String thumb = collectBean.getThumb();
                String comicId = collectBean.getComicId();

                //初始化intent对象
                Intent intent1 = new Intent();
                intent1.setClass(getActivity(), DetailsActivity.class);
                //intent装载数据
                intent1.putExtra("comicId", comicId);
                intent1.putExtra("thumb", thumb);
                intent1.putExtra("title", title);
                //启动跳转
                startActivity(intent1);
            }
        });
        //长按事件进行数据的删除
        listView_bookrack.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long
                    id) {
                //获取item对应的对象，获取对象的属性值
                CollectBean bean = (CollectBean) bookrack_adapter.getItem(position);
                final int id1 = bean.getId();

                //自定义对话框，对对话框的属性进行设置
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                //设置标题
                builder.setTitle("确认删除收藏？");
                //设置取消按钮
                builder.setNegativeButton("取消", null);
                //设置确定按钮
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            //根据所选的item进行数据的删除
                            StartActivity.dbUtils.deleteById(CollectBean.class, id1);
                            DetailsActivity.list_collect.remove(position);
                            //重新加载数据
                            list_bookrack = StartActivity.dbUtils.findAll(CollectBean.class);
                            //刷新数据
                            //bookrack_adapter=new BoListViewAdapter(getContext(),list_bookrack);
                            //listView_bookrack.setAdapter(bookrack_adapter);
                            bookrack_adapter.reload(list_bookrack, true);
                        } catch (DbException e) {
                            e.printStackTrace();
                        }
                    }
                });
                //对话框的显示
                builder.create().show();
                return false;
            }

        });

    }

    /**
     * 分类中搜索和分类
     */
    private void creatClassify() {

        imageView_classify_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断输入框内容是否为空，为空提醒用户重新输入否则进行页面跳转
                editContent = editText_classify_search.getText() + "";
                if ("".equals(editContent)) {
                    Toast.makeText(getContext(), "搜索框内容不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    //初始化intent对象，携带数据进行页面跳转
                    Intent intent = new Intent(getActivity(), SearchActivity.class);
                    intent.putExtra("editContent", editContent);
                    //启动页面跳转
                    startActivity(intent);
                }
            }
        });

        //初始化适配器
        cGridViewAdapter = new CGridViewAdapter(getContext(), list_classify);
        //调用从网络获取数据的方法
        getListFromNet();
        //为gridView_classify设置适配器
        gridView_classify.setAdapter(cGridViewAdapter);

        //gridView_classify设置item的点击事件
        gridView_classify.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取点item对应的对象
                ClassifyBean.DataBean dataBean = (ClassifyBean.DataBean) cGridViewAdapter.getItem
                        (position);
                //通过对象获取对象的属性值
                int cateId = dataBean.getCateId();
                String title = dataBean.getTitle();
                //初始化intent对象进行页面的跳转和传值
                Intent intent = new Intent(getActivity(), ClassifyActivity.class);
                intent.putExtra("cateId", cateId);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });
    }


    /**
     * 更多页面显示的webView的创建
     */
    private void createMore() {
        //让webView_more代替系统浏览器
        webView_more.setWebViewClient(new WebViewClient());
        //让WebView支持alert这些特殊的javascript语句
        webView_more.setWebChromeClient(new WebChromeClient());
        //让WebView支持普通的JavaScript语句
        webView_more.getSettings().setJavaScriptEnabled(true);
        //为webView_more设置加载网址
        webView_more.loadUrl(URLConstants.MORE_PATH);
    }


    /**
     * @param tabIndex
     * @return 此方法用于实现fragment对象的单例
     */
    public static ParentFragment newInstance(int tabIndex) {
        //初始化Bundle对象，用于携带数据
        Bundle bundle = new Bundle();
        //给Bundle对象添加数据
        bundle.putInt("tabIndex", tabIndex);
        ParentFragment fragment = new ParentFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    /**
     * 推荐页面的创建，包括tabLayout和viewpager
     */
    private void cteateRecommend() {
        for (int i = 0; i < tabTitles.length; i++) {
            //初始化碎片对象
            RecommendFragment recommendFragment = RecommendFragment.newInstance(i);
            //将对象添加到list集合中
            list_recommend.add(recommendFragment);
        }
        //初始化适配器
        recomViewPagerAp = new RecomViewPagerAp(getActivity().getSupportFragmentManager(),
                list_recommend, tabTitles);
        //给viewPager设置适配器
        viewPager_recommend.setAdapter(recomViewPagerAp);
        //tablayout和viewPager实现联动效果
        tabLayout_recommend.setupWithViewPager(viewPager_recommend);
    }

    /**
     * 从网络获取数据，解析，添加在数据源list_classify
     */
    public void getListFromNet() {
        //开启子线程，连接网络
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //通过框架获取网络数据
                    String jsonString = OkHttpClientHelper.getStringFromURL(getContext(),
                            classifyUrl, "classify");
                    //利用gson解析网络数据
                    Gson gson = new Gson();
                    //从解析的数据获取
                    ClassifyBean classifyBean = gson.fromJson(jsonString, new
                            TypeToken<ClassifyBean>() {
                            }.getType());
                    list_classify = classifyBean.getData();
                    //范湖主线程更新UI
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //刷新数据
                            cGridViewAdapter.reload(list_classify, false);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
