package com.example.wind.osnews.Bean;

import com.google.gson.annotations.SerializedName;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

/**
 * Created by wind on 17-7-16.
 */

public class FunimageBean extends BasePageBean<FunimageBean> {

    /**
     * title : 裙子太短，牵不到……
     * thumburl : http://ww3.sinaimg.cn/large/bd698b0fjw1eilzvrqm4gj20dx09874w.jpg
     * sourceurl : http://down.laifudao.com/images/tupian/201472219450.jpg
     * height : 332
     * width : 501
     * class : 1
     * url : http://www.laifudao.com/tupian/34315.htm
     */

    private String title;
    private String thumburl;
    private String sourceurl;
    private String height;
    private String width;
    @SerializedName("class")
    private String classX;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumburl() {
        return thumburl;
    }

    public void setThumburl(String thumburl) {
        this.thumburl = thumburl;
    }

    public String getSourceurl() {
        return sourceurl;
    }

    public void setSourceurl(String sourceurl) {
        this.sourceurl = sourceurl;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getClassX() {
        return classX;
    }

    public void setClassX(String classX) {
        this.classX = classX;
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
