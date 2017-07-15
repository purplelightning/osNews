package com.example.wind.osnews.Utils;

/**
 * Description : 接口API的URL
 */
public class Urls {

    //http://c.m.163.com/nc/article/headline/T1348647909107/0-20.html  头条

    public static final int PAZE_SIZE = 20;

    public static final String HOST = "http://c.m.163.com/";
    public static final String END_URL = "-" + PAZE_SIZE + ".html";
    public static final String END_DETAIL_URL = "/full.html";
    // 头条
    public static final String TOP_URL = HOST + "nc/article/headline/";
    public static final String TOP_ID = "T1348647909107";
    // 新闻详情
    public static final String NEW_DETAIL = HOST + "nc/article/";

    public static final String COMMON_URL = HOST + "nc/article/list/";

    // 汽车
    public static final String CAR_ID = "T1348654060988";
    // 笑话
    public static final String JOKE_ID = "T1350383429665";
    // nba
    public static final String NBA_ID = "T1348649145984";


    //weather的url需要拼接才能得到完整的url
    public static final String WEATHER = "http://weatherapi.market.xiaomi.com/wtr-v2/weather?cityId=";

    // 图片
    public static final String IMAGES_URL = "http://api.laifudao.com/open/tupian.json";

    //
    public static final String APPKEY = "3771c3180f6dd01a974767a2ebc763f1";

    //头条
    public static final String TOU_TIAO="http://v.juhe.cn/toutiao/index?type=shehui&key="+ APPKEY;

}