package com.example.wind.osnews.Bean;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

/**
 * Created by wind on 17-7-16.
 */

public class JokeBean extends BasePageBean {


    /**
     * title : 套路啊
     * content : 　　妈妈给儿子微信：儿子妈咪爱你哟~<br/><br/>　　儿子感动，立马回了个：妈咪么么哒！<br/><br/>　　妈妈秒回：你这个兔崽子果然在玩手机，赶快给老娘写作业去！
     * poster :
     * url : http://www.laifudao.com/wangwen/122860.htm
     */

    private String title;
    private String content;
    private String poster;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public List getItemDatas() {
        return getItemDatas();
    }
}
