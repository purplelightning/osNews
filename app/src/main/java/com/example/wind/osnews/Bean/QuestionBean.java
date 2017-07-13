package com.example.wind.osnews.Bean;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

/**
 * Created by wind on 17-7-13.
 */

public class QuestionBean extends BasePageBean<QuestionBean.ResultBean.ItemsBean> {

    /**
     * code : 1
     * message : success
     * notice : {"like":0,"review":0,"letter":0,"mention":0,"fans":0}
     * result : {"items":[{"author":"局长","authorId":2720166,"authorPortrait":"https://static.oschina.net/uploads/user/1360/2720166_50.jpg?t=1470892376000","body":"OSCHINA 本期高手问答（2017 年 7 月 12 日 \u2014 7 月 18 日）我们请来了@叶金荣和@吴炳锡为大家解答 MySQL 中间件选型方面的问题。 叶金荣，知数堂...","commentCount":18,"id":2253505,"pubDate":"2017-07-11 20:49:08","title":"高手问答第 161 期 \u2014\u2014 追求性能和稳定，MySQL 中间件该如何选型？","type":0,"viewCount":2826},{"author":"OSC_Lucy","authorId":2982602,"authorPortrait":"https://static.oschina.net/uploads/user/1491/2982602_50.jpeg?t=1477365605000","body":"小编今天给大家看的这个笔试题 当年可是火遍大江南北 不妨你先看看到底会不会 这是关于一段令人疑惑的Java代码 下面我们来看一下Java代码 执行一下...","commentCount":4,"id":2253457,"pubDate":"2017-07-11 16:03:56","title":"让人疑惑的Java代码，竟成大多公司面试题热门","type":0,"viewCount":1358},{"author":"卓越的明天","authorId":3611542,"authorPortrait":"https://www.oschina.net/img/portrait.gif","body":"这两天遇到了一个比较诡异的问题，就是编辑Hive的UDF函数，并提交需要执行MapReduce的SQL后，提示报错 org.apache.hadoop.hive.ql.exec.UDFArgume...","commentCount":0,"id":2254322,"pubDate":"2017-07-13 21:04:16","title":"Hive UDF函数报错UDFArgumentException: The UDF implementation class 'xxxxx' is not present inthe class path","type":0,"viewCount":1},{"author":"page_zxy","authorId":2812149,"authorPortrait":"https://static.oschina.net/uploads/user/1406/2812149_50.jpg?t=1465288211000","body":"mysql: -- 获取上个月最后一天 select LAST_DAY(CONCAT('2017-7-13','-01-01') - interval 1 month) from dual; -- 获取前一天日期 select DATE_SU...","commentCount":0,"id":2254321,"pubDate":"2017-07-13 21:02:09","title":"spark sql 如何获取上月最后一天，和 昨天日期？","type":0,"viewCount":0},{"author":"liucf3995","authorId":2300595,"authorPortrait":"https://www.oschina.net/img/portrait.gif","body":"1.9.6 nginx 启用HTTP 2 的条件是：只要编译了http 2 模块 ，就会启用HTTP 2,（不需要任何HTTP 2配置）。 1.9.7 nginx启用HTTP 2：编译了http 2模块...","commentCount":5,"id":2254170,"pubDate":"2017-07-12 22:15:26","title":"nginx 不能按照虚拟主机来启用HTTP2","type":0,"viewCount":93},{"author":"weijiang","authorId":56141,"authorPortrait":"https://www.oschina.net/img/portrait.gif","body":"倌崖吵撬诠科椭液铝涸每拦我酚牢蚁苛痈戳状盼颈菲季爬掖载凳桨檀","commentCount":0,"id":2254307,"pubDate":"2017-07-13 19:58:05","title":"鸦洗撕簧榷袒奄翘蒙于","type":0,"viewCount":7},{"author":"woooooody","authorId":3332573,"authorPortrait":"https://static.oschina.net/uploads/user/1666/3332573_50.jpeg?t=1498551266000","body":"Trigger trigger = TriggerBuilder\n                     .newTrigger()\n                     .startNow()\n                     .withSchedule(r...","commentCount":3,"id":2254156,"pubDate":"2017-07-12 18:06:07","title":"Quartz的SimpleTrigger如何设置不在准点执行？","type":0,"viewCount":26},{"author":"学编程的小伟","authorId":3581217,"authorPortrait":"https://static.oschina.net/uploads/user/1790/3581217_50.jpeg?t=1499332971000","body":"我们公司是把图片放在aws上  让我用s3可是我跟着网上的做 发现却是这个样子 ClientConfiguration clientCfg = new ClientConfiguration();\nclien...","commentCount":0,"id":2254306,"pubDate":"2017-07-13 19:33:24","title":"s3 的链接的方法是过期了吗？","type":0,"viewCount":3},{"author":"weijiang","authorId":56141,"authorPortrait":"https://www.oschina.net/img/portrait.gif","body":"dfsgfs萨菲的阿萨德asddfsgfs萨菲的阿萨德asddfsgfs萨菲的阿萨德asd","commentCount":0,"id":2254279,"pubDate":"2017-07-13 19:17:44","title":"dfsgfs萨菲的阿萨德asd","type":0,"viewCount":5},{"author":"沙发土豆1991","authorId":3520471,"authorPortrait":"https://static.oschina.net/uploads/user/1760/3520471_50.jpeg?t=1496566731000","body":"求问，原先程序用tomcat跑很正常，想通过nginx做反向代理，安装nginx插件之后，用nginx无法跑程序 intellij idea该怎么配置才能实现呢？...","commentCount":1,"id":2254255,"pubDate":"2017-07-13 16:45:35","title":"nginx在intellij idea中怎么设置？","type":0,"viewCount":25},{"author":"沙发土豆1991","authorId":3520471,"authorPortrait":"https://static.oschina.net/uploads/user/1760/3520471_50.jpeg?t=1496566731000","body":"原来的项目用tomcat在本地能够很好的运行，但是现在希望解决高并发图片访问过大的问题，希望引入Nginx，Nginx在本地安装完成，然后和tomcat也能链接...","commentCount":3,"id":2254228,"pubDate":"2017-07-13 14:05:43","title":"关于Nginx的部署","type":0,"viewCount":93},{"author":"一脸懵逼的码农","authorId":3366562,"authorPortrait":"https://static.oschina.net/uploads/user/1683/3366562_50.jpg?t=1489733170000","body":"某个网站每天8点到10点间 每隔10分钟更新一次数据 但是并非准时更新（一般可能延迟几秒或者几分钟更新）。现在我这边想要实时获取该网站更新的数据...","commentCount":1,"id":2254277,"pubDate":"2017-07-13 18:42:59","title":"关于实时获取网站数据的一个问题","type":0,"viewCount":13},{"author":"小石头网","authorId":3608491,"authorPortrait":"https://static.oschina.net/uploads/user/1804/3608491_50.jpg?t=1499780333000","body":"'VHmcrcyYyNKpms+q0mZoWZ9UoZhni6WblllXlYh1i7d1iIyIq4m3tJV9sIi5WJVnhGlkVluMc0Rrl6ikmKSi0J5WpNXVmtHHpZnGXYmkrKvLoptdUt5FQWpVlqGkoK3Kn6RRnoOc...","commentCount":1,"id":2254262,"pubDate":"2017-07-13 17:13:55","title":"php加密 请高手解密","type":0,"viewCount":18},{"author":"yyy3","authorId":2411762,"authorPortrait":"https://www.oschina.net/img/portrait.gif","body":"","commentCount":0,"id":2254275,"pubDate":"2017-07-13 18:18:04","title":"js   怎么确定标签中的内容在哪个标签下","type":0,"viewCount":7},{"author":"Li_Lee","authorId":3606933,"authorPortrait":"https://static.oschina.net/uploads/user/1803/3606933_50.jpg?t=1499760835000","body":"@JFinal 你好，想跟你请教个问题：将Excel中的内容导入，但只能导入其中的两条，后来的内容不能导入，这是为什么呢","commentCount":1,"id":2254035,"pubDate":"2017-07-12 08:39:12","title":"事务如何回滚","type":0,"viewCount":56},{"author":"dubstep","authorId":2961498,"authorPortrait":"https://static.oschina.net/uploads/user/1480/2961498_50.jpeg?t=1499751615000","body":"@JFinal 请问怎么判断数据库中某张表是否存在？","commentCount":2,"id":2252482,"pubDate":"2017-07-11 10:03:14","title":"请问Jfinal中怎么判断数据库中某张表是否存在？","type":0,"viewCount":49},{"author":"认真做事开心做人","authorId":2879450,"authorPortrait":"https://www.oschina.net/img/portrait.gif","body":"如题","commentCount":4,"id":2254116,"pubDate":"2017-07-12 14:58:27","title":"适配ie8使用哪个版本jQuery，$('')获取不到对象啊，求救","type":0,"viewCount":46},{"author":"安静的敲代码","authorId":2292604,"authorPortrait":"https://static.oschina.net/uploads/user/1146/2292604_50.jpg?t=1418811436000","body":"在spring mvc项目中，一般请求参数的校验都是通过 hibernate-validator来实现。但是，在有些项目中，譬如APP接口，这时候，某些请求参数不一定是某...","commentCount":4,"id":2252502,"pubDate":"2017-07-11 11:28:44","title":"Spring MVC项目请求参数校验","type":0,"viewCount":91},{"author":"Gmupload","authorId":1245614,"authorPortrait":"https://static.oschina.net/uploads/user/622/1245614_50.jpg?t=1443159881000","body":"这个问题我其实遇到很久了，目前解决方案是手动注入service，并且把工具类也手动注入。 场景： 在spring中，我们经常会定义工具类来做一些奇怪的事...","commentCount":6,"id":2254189,"pubDate":"2017-07-13 09:55:08","title":"Spring中，使用工具类无法自动注入service","type":0,"viewCount":80},{"author":"哎码","authorId":2398274,"authorPortrait":"https://static.oschina.net/uploads/user/1199/2398274_50.png?t=1458654464000","body":"页面有一段是这样的: &lt;td class=\"center\" colspan=\"2\"&gt;\n  &lt;span class=\"red\"&gt;{{pd.receivableFine}}元&lt;/span&gt;\n&lt;/td&gt; 现在我已经改变了pd.receivab...","commentCount":0,"id":2254267,"pubDate":"2017-07-13 17:28:33","title":"vue数据改变 但页面未渲染","type":0,"viewCount":10}],"nextPageToken":"DBA816934CD0AA59","prevPageToken":"0997C855C600E421","requestCount":20,"responseCount":20,"totalResults":1000}
     * time : 2017-07-13 21:29:08
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
    public List getItemDatas() {
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
         * items : [{"author":"局长","authorId":2720166,"authorPortrait":"https://static.oschina.net/uploads/user/1360/2720166_50.jpg?t=1470892376000","body":"OSCHINA 本期高手问答（2017 年 7 月 12 日 \u2014 7 月 18 日）我们请来了@叶金荣和@吴炳锡为大家解答 MySQL 中间件选型方面的问题。 叶金荣，知数堂...","commentCount":18,"id":2253505,"pubDate":"2017-07-11 20:49:08","title":"高手问答第 161 期 \u2014\u2014 追求性能和稳定，MySQL 中间件该如何选型？","type":0,"viewCount":2826},{"author":"OSC_Lucy","authorId":2982602,"authorPortrait":"https://static.oschina.net/uploads/user/1491/2982602_50.jpeg?t=1477365605000","body":"小编今天给大家看的这个笔试题 当年可是火遍大江南北 不妨你先看看到底会不会 这是关于一段令人疑惑的Java代码 下面我们来看一下Java代码 执行一下...","commentCount":4,"id":2253457,"pubDate":"2017-07-11 16:03:56","title":"让人疑惑的Java代码，竟成大多公司面试题热门","type":0,"viewCount":1358},{"author":"卓越的明天","authorId":3611542,"authorPortrait":"https://www.oschina.net/img/portrait.gif","body":"这两天遇到了一个比较诡异的问题，就是编辑Hive的UDF函数，并提交需要执行MapReduce的SQL后，提示报错 org.apache.hadoop.hive.ql.exec.UDFArgume...","commentCount":0,"id":2254322,"pubDate":"2017-07-13 21:04:16","title":"Hive UDF函数报错UDFArgumentException: The UDF implementation class 'xxxxx' is not present inthe class path","type":0,"viewCount":1},{"author":"page_zxy","authorId":2812149,"authorPortrait":"https://static.oschina.net/uploads/user/1406/2812149_50.jpg?t=1465288211000","body":"mysql: -- 获取上个月最后一天 select LAST_DAY(CONCAT('2017-7-13','-01-01') - interval 1 month) from dual; -- 获取前一天日期 select DATE_SU...","commentCount":0,"id":2254321,"pubDate":"2017-07-13 21:02:09","title":"spark sql 如何获取上月最后一天，和 昨天日期？","type":0,"viewCount":0},{"author":"liucf3995","authorId":2300595,"authorPortrait":"https://www.oschina.net/img/portrait.gif","body":"1.9.6 nginx 启用HTTP 2 的条件是：只要编译了http 2 模块 ，就会启用HTTP 2,（不需要任何HTTP 2配置）。 1.9.7 nginx启用HTTP 2：编译了http 2模块...","commentCount":5,"id":2254170,"pubDate":"2017-07-12 22:15:26","title":"nginx 不能按照虚拟主机来启用HTTP2","type":0,"viewCount":93},{"author":"weijiang","authorId":56141,"authorPortrait":"https://www.oschina.net/img/portrait.gif","body":"倌崖吵撬诠科椭液铝涸每拦我酚牢蚁苛痈戳状盼颈菲季爬掖载凳桨檀","commentCount":0,"id":2254307,"pubDate":"2017-07-13 19:58:05","title":"鸦洗撕簧榷袒奄翘蒙于","type":0,"viewCount":7},{"author":"woooooody","authorId":3332573,"authorPortrait":"https://static.oschina.net/uploads/user/1666/3332573_50.jpeg?t=1498551266000","body":"Trigger trigger = TriggerBuilder\n                     .newTrigger()\n                     .startNow()\n                     .withSchedule(r...","commentCount":3,"id":2254156,"pubDate":"2017-07-12 18:06:07","title":"Quartz的SimpleTrigger如何设置不在准点执行？","type":0,"viewCount":26},{"author":"学编程的小伟","authorId":3581217,"authorPortrait":"https://static.oschina.net/uploads/user/1790/3581217_50.jpeg?t=1499332971000","body":"我们公司是把图片放在aws上  让我用s3可是我跟着网上的做 发现却是这个样子 ClientConfiguration clientCfg = new ClientConfiguration();\nclien...","commentCount":0,"id":2254306,"pubDate":"2017-07-13 19:33:24","title":"s3 的链接的方法是过期了吗？","type":0,"viewCount":3},{"author":"weijiang","authorId":56141,"authorPortrait":"https://www.oschina.net/img/portrait.gif","body":"dfsgfs萨菲的阿萨德asddfsgfs萨菲的阿萨德asddfsgfs萨菲的阿萨德asd","commentCount":0,"id":2254279,"pubDate":"2017-07-13 19:17:44","title":"dfsgfs萨菲的阿萨德asd","type":0,"viewCount":5},{"author":"沙发土豆1991","authorId":3520471,"authorPortrait":"https://static.oschina.net/uploads/user/1760/3520471_50.jpeg?t=1496566731000","body":"求问，原先程序用tomcat跑很正常，想通过nginx做反向代理，安装nginx插件之后，用nginx无法跑程序 intellij idea该怎么配置才能实现呢？...","commentCount":1,"id":2254255,"pubDate":"2017-07-13 16:45:35","title":"nginx在intellij idea中怎么设置？","type":0,"viewCount":25},{"author":"沙发土豆1991","authorId":3520471,"authorPortrait":"https://static.oschina.net/uploads/user/1760/3520471_50.jpeg?t=1496566731000","body":"原来的项目用tomcat在本地能够很好的运行，但是现在希望解决高并发图片访问过大的问题，希望引入Nginx，Nginx在本地安装完成，然后和tomcat也能链接...","commentCount":3,"id":2254228,"pubDate":"2017-07-13 14:05:43","title":"关于Nginx的部署","type":0,"viewCount":93},{"author":"一脸懵逼的码农","authorId":3366562,"authorPortrait":"https://static.oschina.net/uploads/user/1683/3366562_50.jpg?t=1489733170000","body":"某个网站每天8点到10点间 每隔10分钟更新一次数据 但是并非准时更新（一般可能延迟几秒或者几分钟更新）。现在我这边想要实时获取该网站更新的数据...","commentCount":1,"id":2254277,"pubDate":"2017-07-13 18:42:59","title":"关于实时获取网站数据的一个问题","type":0,"viewCount":13},{"author":"小石头网","authorId":3608491,"authorPortrait":"https://static.oschina.net/uploads/user/1804/3608491_50.jpg?t=1499780333000","body":"'VHmcrcyYyNKpms+q0mZoWZ9UoZhni6WblllXlYh1i7d1iIyIq4m3tJV9sIi5WJVnhGlkVluMc0Rrl6ikmKSi0J5WpNXVmtHHpZnGXYmkrKvLoptdUt5FQWpVlqGkoK3Kn6RRnoOc...","commentCount":1,"id":2254262,"pubDate":"2017-07-13 17:13:55","title":"php加密 请高手解密","type":0,"viewCount":18},{"author":"yyy3","authorId":2411762,"authorPortrait":"https://www.oschina.net/img/portrait.gif","body":"","commentCount":0,"id":2254275,"pubDate":"2017-07-13 18:18:04","title":"js   怎么确定标签中的内容在哪个标签下","type":0,"viewCount":7},{"author":"Li_Lee","authorId":3606933,"authorPortrait":"https://static.oschina.net/uploads/user/1803/3606933_50.jpg?t=1499760835000","body":"@JFinal 你好，想跟你请教个问题：将Excel中的内容导入，但只能导入其中的两条，后来的内容不能导入，这是为什么呢","commentCount":1,"id":2254035,"pubDate":"2017-07-12 08:39:12","title":"事务如何回滚","type":0,"viewCount":56},{"author":"dubstep","authorId":2961498,"authorPortrait":"https://static.oschina.net/uploads/user/1480/2961498_50.jpeg?t=1499751615000","body":"@JFinal 请问怎么判断数据库中某张表是否存在？","commentCount":2,"id":2252482,"pubDate":"2017-07-11 10:03:14","title":"请问Jfinal中怎么判断数据库中某张表是否存在？","type":0,"viewCount":49},{"author":"认真做事开心做人","authorId":2879450,"authorPortrait":"https://www.oschina.net/img/portrait.gif","body":"如题","commentCount":4,"id":2254116,"pubDate":"2017-07-12 14:58:27","title":"适配ie8使用哪个版本jQuery，$('')获取不到对象啊，求救","type":0,"viewCount":46},{"author":"安静的敲代码","authorId":2292604,"authorPortrait":"https://static.oschina.net/uploads/user/1146/2292604_50.jpg?t=1418811436000","body":"在spring mvc项目中，一般请求参数的校验都是通过 hibernate-validator来实现。但是，在有些项目中，譬如APP接口，这时候，某些请求参数不一定是某...","commentCount":4,"id":2252502,"pubDate":"2017-07-11 11:28:44","title":"Spring MVC项目请求参数校验","type":0,"viewCount":91},{"author":"Gmupload","authorId":1245614,"authorPortrait":"https://static.oschina.net/uploads/user/622/1245614_50.jpg?t=1443159881000","body":"这个问题我其实遇到很久了，目前解决方案是手动注入service，并且把工具类也手动注入。 场景： 在spring中，我们经常会定义工具类来做一些奇怪的事...","commentCount":6,"id":2254189,"pubDate":"2017-07-13 09:55:08","title":"Spring中，使用工具类无法自动注入service","type":0,"viewCount":80},{"author":"哎码","authorId":2398274,"authorPortrait":"https://static.oschina.net/uploads/user/1199/2398274_50.png?t=1458654464000","body":"页面有一段是这样的: &lt;td class=\"center\" colspan=\"2\"&gt;\n  &lt;span class=\"red\"&gt;{{pd.receivableFine}}元&lt;/span&gt;\n&lt;/td&gt; 现在我已经改变了pd.receivab...","commentCount":0,"id":2254267,"pubDate":"2017-07-13 17:28:33","title":"vue数据改变 但页面未渲染","type":0,"viewCount":10}]
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
             * author : 局长
             * authorId : 2720166
             * authorPortrait : https://static.oschina.net/uploads/user/1360/2720166_50.jpg?t=1470892376000
             * body : OSCHINA 本期高手问答（2017 年 7 月 12 日 — 7 月 18 日）我们请来了@叶金荣和@吴炳锡为大家解答 MySQL 中间件选型方面的问题。 叶金荣，知数堂...
             * commentCount : 18
             * id : 2253505
             * pubDate : 2017-07-11 20:49:08
             * title : 高手问答第 161 期 —— 追求性能和稳定，MySQL 中间件该如何选型？
             * type : 0
             * viewCount : 2826
             */

            private String author;
            private int authorId;
            private String authorPortrait;
            private String body;
            private int commentCount;
            private int id;
            private String pubDate;
            private String title;
            private int type;
            private int viewCount;

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getAuthorId() {
                return authorId;
            }

            public void setAuthorId(int authorId) {
                this.authorId = authorId;
            }

            public String getAuthorPortrait() {
                return authorPortrait;
            }

            public void setAuthorPortrait(String authorPortrait) {
                this.authorPortrait = authorPortrait;
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

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
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
