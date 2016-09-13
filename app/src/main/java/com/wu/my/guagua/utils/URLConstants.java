package com.wu.my.guagua.utils;

/**
 * 常量类，存放网址
 */
public class URLConstants {
    // 广告栏
    public final static String ADVERTI_PATH = "http://csapi.dm300" +
            ".com:21889/android/recom/editorrecomlist?pagesize=4&platform_id=0";
    //热门
    public final static String HOTLOAD_PATH = "http://csapi.dm300" +
            ".com:21889/android/recom/hotlist?pagesize=30&page=%d";
    //小编推荐
    public final static String RECOMMEND_PATH = "http://csapi.dm300" +
            ".com:21889/android/recom/editorlist?pagesize=30&page=%d";
    //精彩港漫
    public final static String WONDERFUL_CARTOOM = "http://csapi.dm300" +
            ".com:21889/android/recom/hothklist?pagesize=30&page=%d";
    //最近更新
    public final static String UPDATE_LATER = "http://csapi.dm300" +
            ".com:21889/android/search/recentupdate?pagesize=30&page=%d";
    //漫画详情：
    public final static String DETAILS = "http://csapi.dm300" +
            ".com:21889/android/comic/info?comicsrcid=0&comicid=%s";
    //更多
    public final static String MORE_PATH = "http://www.bilibili.com/";
    //评论
    public final static String COMMENT = "http://csapi.dm300" +
            ".com:21889/android/comment/getCommentList?parent_id=0&pagesize=30&page=1&root_id=0" +
            "&comicid=%s";
    //搜索
    public final static String SEARCH = "http://csapi.dm300" +
            ".com:21889/android/search/query?pagesize=30&page=%d&keyword=%s";
    //分类
    public final static String CLASSIFY = "http://csapi.dm300.com:21889/android/search/category";
    //章节列表
    public final static String SECTION_DETAILS = "http://csapi.dm300" +
            ".com:21889/android/comic/charpterlist?comicsrcid=%s&comicid=%s";
    //漫画
    public final static String CARTOON_PATH = "http://csapi.dm300" +
            ".com:21889/android/comic/charpterinfo?charpterid=%d";

    //分类2
    public final static String CLASSIFY_TWO = "http://csapi.dm300" +
            ".com:21889/android/search/categorylist?cateId=%d&pagesize=30&tophot=1&page=%d";
}
