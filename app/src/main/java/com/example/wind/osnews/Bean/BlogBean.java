package com.example.wind.osnews.Bean;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

/**
 * Created by wind on 17-7-13.
 */

public class BlogBean extends BasePageBean<BlogBean.ResultBean.ItemsBean>{

    /**
     * code : 1
     * message : success
     * notice : {"like":0,"review":0,"letter":0,"mention":0,"fans":0}
     * result : {"items":[{"author":"课课家IT","body":"　　不少网友问到，电脑和手机安装了杀毒软件，可是还是会中毒，要怎样才...","commentCount":0,"href":"https://my.oschina.net/u/3186363/blog/1359417","id":1359417,"original":true,"pubDate":"2017-07-13 19:23:53","recommend":false,"title":"如何识别钓鱼网站","type":3,"viewCount":2},{"author":"kingzfan","body":"12年毕业开始做java开发。 13年-15年做了两年的cobol开发 15年至今17年0...","commentCount":0,"href":"https://my.oschina.net/u/2402049/blog/1359415","id":1359415,"original":true,"pubDate":"2017-07-13 19:20:38","recommend":false,"title":"170713_SPECIAL_DAY","type":3,"viewCount":7},{"author":"关河","body":"Spring技术内幕阅读如下： IOC容器的初始化过程一般包括三个步骤： 一、...","commentCount":0,"href":"https://my.oschina.net/guanhe/blog/1359414","id":1359414,"original":true,"pubDate":"2017-07-13 19:17:29","recommend":false,"title":"Spring技术内幕1\u2014\u2014IOC容器的初始化过程","type":3,"viewCount":3},{"author":"小黑202","body":"  我是用ionic3做的，直接上代码，分三个文件： 1.html 1.1页面写蒙版如...","commentCount":0,"href":"https://my.oschina.net/u/2365397/blog/1359411","id":1359411,"original":true,"pubDate":"2017-07-13 19:01:08","recommend":false,"title":"添加蒙版，弹出悬浮框","type":3,"viewCount":2},{"author":"海蛎子大呲花","body":"public int removeDuplicates(int[] nums) {\n\t\tif (nums.length == 0) {...","commentCount":0,"href":"https://my.oschina.net/zhangtuoDMU/blog/1359409","id":1359409,"original":true,"pubDate":"2017-07-13 18:57:56","recommend":false,"title":"LeetCode[26][easy] Remove Duplicates from Sorted Array","type":3,"viewCount":2},{"author":"jiangwu","body":"问题描述： 找出用户名id为\u2019AAMkADExM2M5NjQ2LWUzYzctNDFkMC1h\u2018的用户...","commentCount":0,"href":"https://my.oschina.net/u/232595/blog/1359407","id":1359407,"original":false,"pubDate":"2017-07-13 18:50:15","recommend":false,"title":"MySQL查询区分大小写","type":3,"viewCount":3},{"author":"Ryan-瑞恩","body":"1.源码地址： https://github.com/cloudera/livy   2. 安装 Debian/Ubu...","commentCount":0,"href":"https://my.oschina.net/Rayn/blog/1359397","id":1359397,"original":true,"pubDate":"2017-07-13 18:31:43","recommend":false,"title":"livy 为 apache Spark 提供REST 接口交互","type":3,"viewCount":3},{"author":"火力全開","body":"在Spar看中，我们知道一切的操作都是基于RDD的。在使用中，RDD有一种非常...","commentCount":0,"href":"https://my.oschina.net/u/2935389/blog/1359396","id":1359396,"original":false,"pubDate":"2017-07-13 18:30:38","recommend":false,"title":"reduceByKey和groupByKey区别与用法","type":3,"viewCount":1},{"author":"wangxuwei","body":"C语言泛型，可以仿照 C库函数 qsort 的方式 用户提供 一些回调函数。 数...","commentCount":0,"href":"https://my.oschina.net/u/2245781/blog/1359394","id":1359394,"original":false,"pubDate":"2017-07-13 18:27:37","recommend":false,"title":" C语言泛型初探----C链表","type":3,"viewCount":1},{"author":"wemall微信商城","body":"企业在做小程序的时候，总是希望给用户提供更好的个人体验。用户体验越好...","commentCount":0,"href":"https://my.oschina.net/baiduwemall/blog/1359393","id":1359393,"original":true,"pubDate":"2017-07-13 18:27:22","recommend":false,"title":"小程序新功能开放，给用户更好的体验!","type":3,"viewCount":1},{"author":"ganfanghua","body":"在Windows 7 中如何配置MySQL 5.6的主从复制   工具/原料 Windows 7 64...","commentCount":0,"href":"https://my.oschina.net/ganfanghua/blog/1359390","id":1359390,"original":false,"pubDate":"2017-07-13 18:20:19","recommend":false,"title":"mysql主从数据库配置 -- 学习篇二","type":3,"viewCount":2},{"author":"earnpls","body":"本工具为Pytorch中文网提供，为earnp/imitation仿站工具，可以快速提取网...","commentCount":0,"href":"https://my.oschina.net/earnp/blog/1359375","id":1359375,"original":false,"pubDate":"2017-07-13 17:58:09","recommend":false,"title":"Mac／Linux／Windos下仿站工具，基于Python的仿站工具，earnp/imitation仿站工具","type":3,"viewCount":2},{"author":"stocket","body":"准备工作:appkey和secret两个码。(在极光官网管理页面新增相关应用，就会...","commentCount":0,"href":"https://my.oschina.net/u/1411360/blog/1359370","id":1359370,"original":false,"pubDate":"2017-07-13 17:53:07","recommend":false,"title":"极光推送服务器端（JAVA）","type":3,"viewCount":2},{"author":"神奇Sam","body":"java在jdk1.5中引入了注解，spring框架也正好把java注解发挥得淋漓尽致。...","commentCount":0,"href":"https://my.oschina.net/magicalSam/blog/1359369","id":1359369,"original":true,"pubDate":"2017-07-13 17:52:47","recommend":false,"title":"Spring 自定义注解，配置简单日志注解","type":3,"viewCount":1},{"author":"渺渺星辰","body":"自己自学python,偶然间看到笨方法学python(作者是Zed Shaw)这一本书,在接...","commentCount":0,"href":"https://my.oschina.net/WYU3CHEN/blog/1359368","id":1359368,"original":true,"pubDate":"2017-07-13 17:52:03","recommend":false,"title":"笨方法学python ","type":3,"viewCount":2},{"author":"发芽的土豆丶","body":"在我们的日常工作中，或多或少的需要绘制一些图表，可能是某个会议的流程...","commentCount":0,"href":"https://my.oschina.net/u/3432667/blog/1359352","id":1359352,"original":true,"pubDate":"2017-07-13 17:42:55","recommend":false,"title":"Edraw Max（亿图图示）教程：如何自定义组织结构图展示的信息","type":3,"viewCount":0},{"author":"Gmupload","body":"1.freemarker视图配置 &lt;!-- freemarker视图解析器 --&gt;\n\t&lt;bean id=\"freem...","commentCount":0,"href":"https://my.oschina.net/gmupload/blog/1359349","id":1359349,"original":true,"pubDate":"2017-07-13 17:39:45","recommend":false,"title":"Freemarker的一些记录","type":3,"viewCount":0},{"author":"殘留回憶","body":"抢购、秒杀是如今很常见的一个应用场景，主要需要解决的问题有两个： 1 ...","commentCount":0,"href":"https://my.oschina.net/qqlet/blog/1359346","id":1359346,"original":true,"pubDate":"2017-07-13 17:38:52","recommend":false,"title":"php结合redis实现高并发下的抢购、秒杀功能","type":3,"viewCount":0},{"author":"王小盼","body":"1、添加用户，首先用adduser命令添加一个普通用户，命令如下：\n　　#ad...","commentCount":0,"href":"https://my.oschina.net/u/2601842/blog/1359342","id":1359342,"original":true,"pubDate":"2017-07-13 17:35:14","recommend":false,"title":"Linux 添加用户 并且给用户超级管理员权限","type":3,"viewCount":1},{"author":"软件达人","body":"据国外媒体报道，目前，科学家最新研究表明，人们喜爱饮用的低因咖啡可能...","commentCount":0,"href":"https://my.oschina.net/mindmanager/blog/1359324","id":1359324,"original":true,"pubDate":"2017-07-13 17:23:59","recommend":false,"title":"大量饮用低因咖啡不环保？将潜在破坏臭氧层","type":3,"viewCount":4}],"nextPageToken":"DBA816934CD0AA59","prevPageToken":"0997C855C600E421","requestCount":20,"responseCount":20,"totalResults":1000}
     * time : 2017-07-13 20:01:59
     */

    private int code;
    private String message;
    private NoticeBean notice;
    private ResultBean result;
    private String time;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NoticeBean getNotice() {
        return notice;
    }

    public void setNotice(NoticeBean notice) {
        this.notice = notice;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public List<ResultBean.ItemsBean> getItemDatas() {
        return result.getItems();
    }

    public static class NoticeBean {
        /**
         * like : 0
         * review : 0
         * letter : 0
         * mention : 0
         * fans : 0
         */

        private int like;
        private int review;
        private int letter;
        private int mention;
        private int fans;

        public int getLike() {
            return like;
        }

        public void setLike(int like) {
            this.like = like;
        }

        public int getReview() {
            return review;
        }

        public void setReview(int review) {
            this.review = review;
        }

        public int getLetter() {
            return letter;
        }

        public void setLetter(int letter) {
            this.letter = letter;
        }

        public int getMention() {
            return mention;
        }

        public void setMention(int mention) {
            this.mention = mention;
        }

        public int getFans() {
            return fans;
        }

        public void setFans(int fans) {
            this.fans = fans;
        }
    }

    public static class ResultBean {
        /**
         * items : [{"author":"课课家IT","body":"　　不少网友问到，电脑和手机安装了杀毒软件，可是还是会中毒，要怎样才...","commentCount":0,"href":"https://my.oschina.net/u/3186363/blog/1359417","id":1359417,"original":true,"pubDate":"2017-07-13 19:23:53","recommend":false,"title":"如何识别钓鱼网站","type":3,"viewCount":2},{"author":"kingzfan","body":"12年毕业开始做java开发。 13年-15年做了两年的cobol开发 15年至今17年0...","commentCount":0,"href":"https://my.oschina.net/u/2402049/blog/1359415","id":1359415,"original":true,"pubDate":"2017-07-13 19:20:38","recommend":false,"title":"170713_SPECIAL_DAY","type":3,"viewCount":7},{"author":"关河","body":"Spring技术内幕阅读如下： IOC容器的初始化过程一般包括三个步骤： 一、...","commentCount":0,"href":"https://my.oschina.net/guanhe/blog/1359414","id":1359414,"original":true,"pubDate":"2017-07-13 19:17:29","recommend":false,"title":"Spring技术内幕1\u2014\u2014IOC容器的初始化过程","type":3,"viewCount":3},{"author":"小黑202","body":"  我是用ionic3做的，直接上代码，分三个文件： 1.html 1.1页面写蒙版如...","commentCount":0,"href":"https://my.oschina.net/u/2365397/blog/1359411","id":1359411,"original":true,"pubDate":"2017-07-13 19:01:08","recommend":false,"title":"添加蒙版，弹出悬浮框","type":3,"viewCount":2},{"author":"海蛎子大呲花","body":"public int removeDuplicates(int[] nums) {\n\t\tif (nums.length == 0) {...","commentCount":0,"href":"https://my.oschina.net/zhangtuoDMU/blog/1359409","id":1359409,"original":true,"pubDate":"2017-07-13 18:57:56","recommend":false,"title":"LeetCode[26][easy] Remove Duplicates from Sorted Array","type":3,"viewCount":2},{"author":"jiangwu","body":"问题描述： 找出用户名id为\u2019AAMkADExM2M5NjQ2LWUzYzctNDFkMC1h\u2018的用户...","commentCount":0,"href":"https://my.oschina.net/u/232595/blog/1359407","id":1359407,"original":false,"pubDate":"2017-07-13 18:50:15","recommend":false,"title":"MySQL查询区分大小写","type":3,"viewCount":3},{"author":"Ryan-瑞恩","body":"1.源码地址： https://github.com/cloudera/livy   2. 安装 Debian/Ubu...","commentCount":0,"href":"https://my.oschina.net/Rayn/blog/1359397","id":1359397,"original":true,"pubDate":"2017-07-13 18:31:43","recommend":false,"title":"livy 为 apache Spark 提供REST 接口交互","type":3,"viewCount":3},{"author":"火力全開","body":"在Spar看中，我们知道一切的操作都是基于RDD的。在使用中，RDD有一种非常...","commentCount":0,"href":"https://my.oschina.net/u/2935389/blog/1359396","id":1359396,"original":false,"pubDate":"2017-07-13 18:30:38","recommend":false,"title":"reduceByKey和groupByKey区别与用法","type":3,"viewCount":1},{"author":"wangxuwei","body":"C语言泛型，可以仿照 C库函数 qsort 的方式 用户提供 一些回调函数。 数...","commentCount":0,"href":"https://my.oschina.net/u/2245781/blog/1359394","id":1359394,"original":false,"pubDate":"2017-07-13 18:27:37","recommend":false,"title":" C语言泛型初探----C链表","type":3,"viewCount":1},{"author":"wemall微信商城","body":"企业在做小程序的时候，总是希望给用户提供更好的个人体验。用户体验越好...","commentCount":0,"href":"https://my.oschina.net/baiduwemall/blog/1359393","id":1359393,"original":true,"pubDate":"2017-07-13 18:27:22","recommend":false,"title":"小程序新功能开放，给用户更好的体验!","type":3,"viewCount":1},{"author":"ganfanghua","body":"在Windows 7 中如何配置MySQL 5.6的主从复制   工具/原料 Windows 7 64...","commentCount":0,"href":"https://my.oschina.net/ganfanghua/blog/1359390","id":1359390,"original":false,"pubDate":"2017-07-13 18:20:19","recommend":false,"title":"mysql主从数据库配置 -- 学习篇二","type":3,"viewCount":2},{"author":"earnpls","body":"本工具为Pytorch中文网提供，为earnp/imitation仿站工具，可以快速提取网...","commentCount":0,"href":"https://my.oschina.net/earnp/blog/1359375","id":1359375,"original":false,"pubDate":"2017-07-13 17:58:09","recommend":false,"title":"Mac／Linux／Windos下仿站工具，基于Python的仿站工具，earnp/imitation仿站工具","type":3,"viewCount":2},{"author":"stocket","body":"准备工作:appkey和secret两个码。(在极光官网管理页面新增相关应用，就会...","commentCount":0,"href":"https://my.oschina.net/u/1411360/blog/1359370","id":1359370,"original":false,"pubDate":"2017-07-13 17:53:07","recommend":false,"title":"极光推送服务器端（JAVA）","type":3,"viewCount":2},{"author":"神奇Sam","body":"java在jdk1.5中引入了注解，spring框架也正好把java注解发挥得淋漓尽致。...","commentCount":0,"href":"https://my.oschina.net/magicalSam/blog/1359369","id":1359369,"original":true,"pubDate":"2017-07-13 17:52:47","recommend":false,"title":"Spring 自定义注解，配置简单日志注解","type":3,"viewCount":1},{"author":"渺渺星辰","body":"自己自学python,偶然间看到笨方法学python(作者是Zed Shaw)这一本书,在接...","commentCount":0,"href":"https://my.oschina.net/WYU3CHEN/blog/1359368","id":1359368,"original":true,"pubDate":"2017-07-13 17:52:03","recommend":false,"title":"笨方法学python ","type":3,"viewCount":2},{"author":"发芽的土豆丶","body":"在我们的日常工作中，或多或少的需要绘制一些图表，可能是某个会议的流程...","commentCount":0,"href":"https://my.oschina.net/u/3432667/blog/1359352","id":1359352,"original":true,"pubDate":"2017-07-13 17:42:55","recommend":false,"title":"Edraw Max（亿图图示）教程：如何自定义组织结构图展示的信息","type":3,"viewCount":0},{"author":"Gmupload","body":"1.freemarker视图配置 &lt;!-- freemarker视图解析器 --&gt;\n\t&lt;bean id=\"freem...","commentCount":0,"href":"https://my.oschina.net/gmupload/blog/1359349","id":1359349,"original":true,"pubDate":"2017-07-13 17:39:45","recommend":false,"title":"Freemarker的一些记录","type":3,"viewCount":0},{"author":"殘留回憶","body":"抢购、秒杀是如今很常见的一个应用场景，主要需要解决的问题有两个： 1 ...","commentCount":0,"href":"https://my.oschina.net/qqlet/blog/1359346","id":1359346,"original":true,"pubDate":"2017-07-13 17:38:52","recommend":false,"title":"php结合redis实现高并发下的抢购、秒杀功能","type":3,"viewCount":0},{"author":"王小盼","body":"1、添加用户，首先用adduser命令添加一个普通用户，命令如下：\n　　#ad...","commentCount":0,"href":"https://my.oschina.net/u/2601842/blog/1359342","id":1359342,"original":true,"pubDate":"2017-07-13 17:35:14","recommend":false,"title":"Linux 添加用户 并且给用户超级管理员权限","type":3,"viewCount":1},{"author":"软件达人","body":"据国外媒体报道，目前，科学家最新研究表明，人们喜爱饮用的低因咖啡可能...","commentCount":0,"href":"https://my.oschina.net/mindmanager/blog/1359324","id":1359324,"original":true,"pubDate":"2017-07-13 17:23:59","recommend":false,"title":"大量饮用低因咖啡不环保？将潜在破坏臭氧层","type":3,"viewCount":4}]
         * nextPageToken : DBA816934CD0AA59
         * prevPageToken : 0997C855C600E421
         * requestCount : 20
         * responseCount : 20
         * totalResults : 1000
         */

        private String nextPageToken;
        private String prevPageToken;
        private int requestCount;
        private int responseCount;
        private int totalResults;
        private List<ItemsBean> items;

        public String getNextPageToken() {
            return nextPageToken;
        }

        public void setNextPageToken(String nextPageToken) {
            this.nextPageToken = nextPageToken;
        }

        public String getPrevPageToken() {
            return prevPageToken;
        }

        public void setPrevPageToken(String prevPageToken) {
            this.prevPageToken = prevPageToken;
        }

        public int getRequestCount() {
            return requestCount;
        }

        public void setRequestCount(int requestCount) {
            this.requestCount = requestCount;
        }

        public int getResponseCount() {
            return responseCount;
        }

        public void setResponseCount(int responseCount) {
            this.responseCount = responseCount;
        }

        public int getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(int totalResults) {
            this.totalResults = totalResults;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * author : 课课家IT
             * body : 　　不少网友问到，电脑和手机安装了杀毒软件，可是还是会中毒，要怎样才...
             * commentCount : 0
             * href : https://my.oschina.net/u/3186363/blog/1359417
             * id : 1359417
             * original : true
             * pubDate : 2017-07-13 19:23:53
             * recommend : false
             * title : 如何识别钓鱼网站
             * type : 3
             * viewCount : 2
             */

            private String author;
            private String body;
            private int commentCount;
            private String href;
            private int id;
            private boolean original;
            private String pubDate;
            private boolean recommend;
            private String title;
            private int type;
            private int viewCount;

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getBody() {
                return body;
            }

            public void setBody(String body) {
                this.body = body;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public boolean isOriginal() {
                return original;
            }

            public void setOriginal(boolean original) {
                this.original = original;
            }

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
            }

            public boolean isRecommend() {
                return recommend;
            }

            public void setRecommend(boolean recommend) {
                this.recommend = recommend;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getViewCount() {
                return viewCount;
            }

            public void setViewCount(int viewCount) {
                this.viewCount = viewCount;
            }
        }
    }
}
