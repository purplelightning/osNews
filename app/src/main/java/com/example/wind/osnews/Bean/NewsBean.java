package com.example.wind.osnews.Bean;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

/**
 * Created by wind on 17-7-12.
 */

public class NewsBean extends BasePageBean {

    /**
     * code : 1
     * message : success
     * notice : {"like":0,"review":0,"letter":0,"mention":0,"fans":0}
     * result : {"items":[{"author":"王练","body":"Apache Spark 2.2.0 正式发布，这也是 2.x 系列的第三个版本。此版本移除了 Structured Streaming 的实验标记（experimental tag），意味着已可以...","commentCount":3,"href":"https://www.oschina.net/news/86700/apache-spark-2-2-0","id":86700,"pubDate":"2017-07-12 18:08:36","recommend":true,"title":"Apache Spark 2.2.0 正式发布，提高可用性和稳定性","type":6,"viewCount":276},{"author":"两味真火","body":"Ecma 国际公布了第八版的 ECMAScript 语言规范 ECMAScript 2017(或 ES8)。ECMAScript是一种由Ecma国际（前身为欧洲计算机制造商协会）通过ECMA-26...","commentCount":8,"href":"https://www.oschina.net/news/86699/ecmascript-2017standards","id":86699,"pubDate":"2017-07-12 17:08:08","recommend":true,"title":"ECMAScript 2017 语言规范发布","type":6,"viewCount":734},{"author":"两味真火","body":"本文经机器之心（微信公众号：almosthuman2014）授权转载，禁止二次转载 项目链接：https://github.com/dselsam/certigrad 编译：李泽南、蒋思源 ...","commentCount":4,"href":"https://www.oschina.net/news/86698/mit-open-source-certigrad","id":86698,"pubDate":"2017-07-12 16:59:32","recommend":true,"title":"斯坦福开源无 Bug 的随机计算图 Certigrad","type":6,"viewCount":574},{"author":"王练","body":"Element React 1.0.18 已发布，更新如下： 修复可搜索的 Select 在输入选项中不存在的值时关闭下拉框后未清空手输值的问题；支持 filterable 的可搜...","commentCount":0,"href":"https://www.oschina.net/news/86697/element-react-1-0-18","id":86697,"pubDate":"2017-07-12 16:52:59","recommend":true,"title":"Element React 1.0.18 发布，ElementUI 的 React 版本","type":6,"viewCount":335},{"author":"达尔文","body":"由 Linux 基金会发起创建的开源区块链分布式账本 \u2014\u2014 Hyperledger Fabric，已经迎来了 1.0 版本。该项目着重于性能和可靠性，以及推动区块链和分布...","commentCount":1,"href":"https://www.oschina.net/news/86696/hyperledger-fabric-1-0","id":86696,"pubDate":"2017-07-12 15:13:27","recommend":true,"title":"Hyperledger Fabric 1.0，基于区块链的分布式账本","type":6,"viewCount":489},{"author":"白_猫","body":"SD框架更新至2.1.1版本可以通过Composer一键安装。 {\r\n  \"require\": {\r\n    \"tmtbe/swooledistributed\":\">2.0.0\"\r\n  },\r\n \"autoload\": ...","commentCount":6,"href":"https://www.oschina.net/news/86695/swooledistributed-2-1-1","id":86695,"pubDate":"2017-07-12 11:05:36","recommend":false,"title":"SD 框架更新至 2.1.1 版本，可通过 Composer 一键安装","type":6,"viewCount":880},{"author":"淡漠悠然","body":"Nginx 1.12.1 和 1.13.3 已发布，两个版本的更新内容相同： Security: a specially crafted request might result in an integer overflow and in...","commentCount":6,"href":"https://www.oschina.net/news/86694/nginx-1-12-1-and-1-13-3","id":86694,"pubDate":"2017-07-12 09:28:03","recommend":false,"title":"Nginx 1.12.1 和1.13.3 发布，高性能 Web 服务器","type":6,"viewCount":1668},{"author":"Tuesday","body":"Qampp 2.6.3 正式发布了。有以下更新： + Apache 2.4.27   (openssl 1.1.0f)   + MySQL 5.7.18  User: root, Pass: root   + PHP 7.1.7   ...","commentCount":15,"href":"https://www.oschina.net/news/86693/qampp-2-6-3","id":86693,"pubDate":"2017-07-12 09:11:46","recommend":false,"title":"Qampp 2.6.3 正式发布，PHP Win 环境包","type":6,"viewCount":665},{"author":"keyword","body":"这一周里 DWSurvey 有哪些变化呢 主要变更： 为方便大家部署安装，增加了Docker支持。 同时开通DWSurvey官方Docker账号，详情请看Reader me 修复：...","commentCount":2,"href":"https://www.oschina.net/news/86692/add-docker-support","id":86692,"pubDate":"2017-07-12 08:43:35","recommend":false,"title":"DWSurvey 新特性：增加 docker 支持，方便快速安装","type":6,"viewCount":514},{"author":"开源中国码云","body":"厌倦了在一堆项目管理、代码托管、文档管理\u2026\u2026\u2026工具之间来回切换？ 真正的高效开发，需要更专业、更轻量的工具。 最懂开发者的码云，潜心打造了企...","commentCount":39,"href":"https://www.oschina.net/news/86691/gitee-enterprises-3-0","id":86691,"pubDate":"2017-07-12 08:26:32","recommend":false,"title":"只为高效、流畅开发 \u2014\u2014 码云企业版 3.0 倾情上线","type":6,"viewCount":1964},{"author":"两味真火","body":"本次演讲将介绍浪潮拥抱开源、贡献开源的战略发展，以及浪潮在Linux、Ceph、Openstack等开源软件方面的主要工作和贡献。","commentCount":44,"href":"https://www.oschina.net/event/2246165","id":2246165,"pubDate":"2017-07-12 08:22:26","recommend":false,"title":"济南源创会，介绍浪潮拥抱开源、贡献开源的战略发展","type":5,"viewCount":159},{"author":"两味真火","body":"开源在政府中无处不在，但许多政府部门仍在为开源软件项目的选择、承包和贡献等具体细节而挣扎着。GCN 和业内的开源倡导者进行了交流，并提出了五个...","commentCount":2,"href":"https://www.oschina.net/translate/5-strategies-open-source","id":10003913,"pubDate":"2017-07-12 08:21:26","recommend":false,"title":"协作翻译 | 如何理智地对待开源？","type":4,"viewCount":813},{"author":"两味真火","body":"OSCHINA 本期高手问答（2017 年 7 月 12 日 \u2014 7 月 18 日）我们请来了@叶金荣和@吴炳锡为大家解答 MySQL 中间件选型方面的问题。...","commentCount":16,"href":"https://www.oschina.net/question/2720166_2253505","id":2253505,"pubDate":"2017-07-12 08:20:33","recommend":false,"title":"高手问答 | 追求性能和稳定，MySQL 中间件该如何选型","type":2,"viewCount":2358},{"author":"两味真火","body":"索引是存储引擎用于快速查找记录的一种数据结构，通过合理的使用数据库索引可以大大提高系统的访问性能，接下来主要介绍在MySql数据库中索引类型，...","commentCount":20,"href":"https://my.oschina.net/feinik/blog/1305784","id":1305784,"pubDate":"2017-07-12 08:19:19","recommend":false,"title":"每日一博 | 如何理解并正确使用 MySql 索引","type":3,"viewCount":2354},{"author":"两味真火","body":"NumberPickerDialog 是纯数字（单个）选择器弹窗。","commentCount":0,"href":"https://git.oschina.net/vigiles/numberpickerdialog","id":86686,"pubDate":"2017-07-12 08:18:27","recommend":false,"title":"码云推荐 | 纯数字选择器弹窗 NumberPickerDialog","type":0,"viewCount":8},{"author":"达尔文","body":"Apache HTTP Server 2.2.34 发布了。这是 2.2 系列的最终维护版，预计 2.2 系列版本就此停止发布。详情。 Apache HTTP Server（简称Apache）是Apa...","commentCount":6,"href":"https://www.oschina.net/news/86685/apache-http-server-2-2-34","id":86685,"pubDate":"2017-07-12 08:17:51","recommend":false,"title":"Apache HTTP Server 2.2.34 发布，最终维护版","type":6,"viewCount":1552},{"author":"两味真火","body":"RediSearch是一个高性能的全文搜索引擎，可作为一个Redis Module 运行在Redis上，是由RedisLabs团队开发的。","commentCount":13,"href":"https://www.oschina.net/p/redisearch","id":45611,"pubDate":"2017-07-12 08:17:21","recommend":false,"title":"RediSearch \u2014\u2014 高性能全文搜索引擎","type":1,"viewCount":2152},{"author":"两味真火","body":"IT工程师在婚姻市场一度是香饽饽，如今不再是抢手货，不被婚姻介绍网站、甚至传统媒人放在心上。","commentCount":0,"href":"https://my.oschina.net/xxiaobian/blog/1345625?nocache=1499790258947","id":86683,"pubDate":"2017-07-12 08:16:33","recommend":false,"title":"OSChina 周三乱弹 \u2014\u2014 我们 IT 工程师会缺女友？","type":0,"viewCount":8},{"author":"两味真火","body":"微信小程序今天迎来了一次全方位的升级，同时获得多项新技能，涉及多个方面。 界面方面，小程序可以调整顶部标题栏的颜色了，还能获取页面布局，比...","commentCount":18,"href":"https://www.oschina.net/news/86682/mina-add-7-skill","id":86682,"pubDate":"2017-07-12 08:15:25","recommend":false,"title":"微信小程序全面升级：7 项实用新技能","type":6,"viewCount":2566},{"author":"达尔文","body":"Visual Studio Code 1.14 发布了。 主要更新内容： Integrated Terminal improvements - 支持查找，选择/复制多个页面。 Command Palette MRU list...","commentCount":26,"href":"https://www.oschina.net/news/86681/visual-studio-code-1-14","id":86681,"pubDate":"2017-07-12 08:07:20","recommend":false,"title":"Visual Studio Code 1.14 发布","type":6,"viewCount":2844}],"nextPageToken":"DBA816934CD0AA59","prevPageToken":"0997C855C600E421","requestCount":20,"responseCount":20,"totalResults":79684}
     * time : 2017-07-12 21:16:48
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
         * items : [{"author":"王练","body":"Apache Spark 2.2.0 正式发布，这也是 2.x 系列的第三个版本。此版本移除了 Structured Streaming 的实验标记（experimental tag），意味着已可以...","commentCount":3,"href":"https://www.oschina.net/news/86700/apache-spark-2-2-0","id":86700,"pubDate":"2017-07-12 18:08:36","recommend":true,"title":"Apache Spark 2.2.0 正式发布，提高可用性和稳定性","type":6,"viewCount":276},{"author":"两味真火","body":"Ecma 国际公布了第八版的 ECMAScript 语言规范 ECMAScript 2017(或 ES8)。ECMAScript是一种由Ecma国际（前身为欧洲计算机制造商协会）通过ECMA-26...","commentCount":8,"href":"https://www.oschina.net/news/86699/ecmascript-2017standards","id":86699,"pubDate":"2017-07-12 17:08:08","recommend":true,"title":"ECMAScript 2017 语言规范发布","type":6,"viewCount":734},{"author":"两味真火","body":"本文经机器之心（微信公众号：almosthuman2014）授权转载，禁止二次转载 项目链接：https://github.com/dselsam/certigrad 编译：李泽南、蒋思源 ...","commentCount":4,"href":"https://www.oschina.net/news/86698/mit-open-source-certigrad","id":86698,"pubDate":"2017-07-12 16:59:32","recommend":true,"title":"斯坦福开源无 Bug 的随机计算图 Certigrad","type":6,"viewCount":574},{"author":"王练","body":"Element React 1.0.18 已发布，更新如下： 修复可搜索的 Select 在输入选项中不存在的值时关闭下拉框后未清空手输值的问题；支持 filterable 的可搜...","commentCount":0,"href":"https://www.oschina.net/news/86697/element-react-1-0-18","id":86697,"pubDate":"2017-07-12 16:52:59","recommend":true,"title":"Element React 1.0.18 发布，ElementUI 的 React 版本","type":6,"viewCount":335},{"author":"达尔文","body":"由 Linux 基金会发起创建的开源区块链分布式账本 \u2014\u2014 Hyperledger Fabric，已经迎来了 1.0 版本。该项目着重于性能和可靠性，以及推动区块链和分布...","commentCount":1,"href":"https://www.oschina.net/news/86696/hyperledger-fabric-1-0","id":86696,"pubDate":"2017-07-12 15:13:27","recommend":true,"title":"Hyperledger Fabric 1.0，基于区块链的分布式账本","type":6,"viewCount":489},{"author":"白_猫","body":"SD框架更新至2.1.1版本可以通过Composer一键安装。 {\r\n  \"require\": {\r\n    \"tmtbe/swooledistributed\":\">2.0.0\"\r\n  },\r\n \"autoload\": ...","commentCount":6,"href":"https://www.oschina.net/news/86695/swooledistributed-2-1-1","id":86695,"pubDate":"2017-07-12 11:05:36","recommend":false,"title":"SD 框架更新至 2.1.1 版本，可通过 Composer 一键安装","type":6,"viewCount":880},{"author":"淡漠悠然","body":"Nginx 1.12.1 和 1.13.3 已发布，两个版本的更新内容相同： Security: a specially crafted request might result in an integer overflow and in...","commentCount":6,"href":"https://www.oschina.net/news/86694/nginx-1-12-1-and-1-13-3","id":86694,"pubDate":"2017-07-12 09:28:03","recommend":false,"title":"Nginx 1.12.1 和1.13.3 发布，高性能 Web 服务器","type":6,"viewCount":1668},{"author":"Tuesday","body":"Qampp 2.6.3 正式发布了。有以下更新： + Apache 2.4.27   (openssl 1.1.0f)   + MySQL 5.7.18  User: root, Pass: root   + PHP 7.1.7   ...","commentCount":15,"href":"https://www.oschina.net/news/86693/qampp-2-6-3","id":86693,"pubDate":"2017-07-12 09:11:46","recommend":false,"title":"Qampp 2.6.3 正式发布，PHP Win 环境包","type":6,"viewCount":665},{"author":"keyword","body":"这一周里 DWSurvey 有哪些变化呢 主要变更： 为方便大家部署安装，增加了Docker支持。 同时开通DWSurvey官方Docker账号，详情请看Reader me 修复：...","commentCount":2,"href":"https://www.oschina.net/news/86692/add-docker-support","id":86692,"pubDate":"2017-07-12 08:43:35","recommend":false,"title":"DWSurvey 新特性：增加 docker 支持，方便快速安装","type":6,"viewCount":514},{"author":"开源中国码云","body":"厌倦了在一堆项目管理、代码托管、文档管理\u2026\u2026\u2026工具之间来回切换？ 真正的高效开发，需要更专业、更轻量的工具。 最懂开发者的码云，潜心打造了企...","commentCount":39,"href":"https://www.oschina.net/news/86691/gitee-enterprises-3-0","id":86691,"pubDate":"2017-07-12 08:26:32","recommend":false,"title":"只为高效、流畅开发 \u2014\u2014 码云企业版 3.0 倾情上线","type":6,"viewCount":1964},{"author":"两味真火","body":"本次演讲将介绍浪潮拥抱开源、贡献开源的战略发展，以及浪潮在Linux、Ceph、Openstack等开源软件方面的主要工作和贡献。","commentCount":44,"href":"https://www.oschina.net/event/2246165","id":2246165,"pubDate":"2017-07-12 08:22:26","recommend":false,"title":"济南源创会，介绍浪潮拥抱开源、贡献开源的战略发展","type":5,"viewCount":159},{"author":"两味真火","body":"开源在政府中无处不在，但许多政府部门仍在为开源软件项目的选择、承包和贡献等具体细节而挣扎着。GCN 和业内的开源倡导者进行了交流，并提出了五个...","commentCount":2,"href":"https://www.oschina.net/translate/5-strategies-open-source","id":10003913,"pubDate":"2017-07-12 08:21:26","recommend":false,"title":"协作翻译 | 如何理智地对待开源？","type":4,"viewCount":813},{"author":"两味真火","body":"OSCHINA 本期高手问答（2017 年 7 月 12 日 \u2014 7 月 18 日）我们请来了@叶金荣和@吴炳锡为大家解答 MySQL 中间件选型方面的问题。...","commentCount":16,"href":"https://www.oschina.net/question/2720166_2253505","id":2253505,"pubDate":"2017-07-12 08:20:33","recommend":false,"title":"高手问答 | 追求性能和稳定，MySQL 中间件该如何选型","type":2,"viewCount":2358},{"author":"两味真火","body":"索引是存储引擎用于快速查找记录的一种数据结构，通过合理的使用数据库索引可以大大提高系统的访问性能，接下来主要介绍在MySql数据库中索引类型，...","commentCount":20,"href":"https://my.oschina.net/feinik/blog/1305784","id":1305784,"pubDate":"2017-07-12 08:19:19","recommend":false,"title":"每日一博 | 如何理解并正确使用 MySql 索引","type":3,"viewCount":2354},{"author":"两味真火","body":"NumberPickerDialog 是纯数字（单个）选择器弹窗。","commentCount":0,"href":"https://git.oschina.net/vigiles/numberpickerdialog","id":86686,"pubDate":"2017-07-12 08:18:27","recommend":false,"title":"码云推荐 | 纯数字选择器弹窗 NumberPickerDialog","type":0,"viewCount":8},{"author":"达尔文","body":"Apache HTTP Server 2.2.34 发布了。这是 2.2 系列的最终维护版，预计 2.2 系列版本就此停止发布。详情。 Apache HTTP Server（简称Apache）是Apa...","commentCount":6,"href":"https://www.oschina.net/news/86685/apache-http-server-2-2-34","id":86685,"pubDate":"2017-07-12 08:17:51","recommend":false,"title":"Apache HTTP Server 2.2.34 发布，最终维护版","type":6,"viewCount":1552},{"author":"两味真火","body":"RediSearch是一个高性能的全文搜索引擎，可作为一个Redis Module 运行在Redis上，是由RedisLabs团队开发的。","commentCount":13,"href":"https://www.oschina.net/p/redisearch","id":45611,"pubDate":"2017-07-12 08:17:21","recommend":false,"title":"RediSearch \u2014\u2014 高性能全文搜索引擎","type":1,"viewCount":2152},{"author":"两味真火","body":"IT工程师在婚姻市场一度是香饽饽，如今不再是抢手货，不被婚姻介绍网站、甚至传统媒人放在心上。","commentCount":0,"href":"https://my.oschina.net/xxiaobian/blog/1345625?nocache=1499790258947","id":86683,"pubDate":"2017-07-12 08:16:33","recommend":false,"title":"OSChina 周三乱弹 \u2014\u2014 我们 IT 工程师会缺女友？","type":0,"viewCount":8},{"author":"两味真火","body":"微信小程序今天迎来了一次全方位的升级，同时获得多项新技能，涉及多个方面。 界面方面，小程序可以调整顶部标题栏的颜色了，还能获取页面布局，比...","commentCount":18,"href":"https://www.oschina.net/news/86682/mina-add-7-skill","id":86682,"pubDate":"2017-07-12 08:15:25","recommend":false,"title":"微信小程序全面升级：7 项实用新技能","type":6,"viewCount":2566},{"author":"达尔文","body":"Visual Studio Code 1.14 发布了。 主要更新内容： Integrated Terminal improvements - 支持查找，选择/复制多个页面。 Command Palette MRU list...","commentCount":26,"href":"https://www.oschina.net/news/86681/visual-studio-code-1-14","id":86681,"pubDate":"2017-07-12 08:07:20","recommend":false,"title":"Visual Studio Code 1.14 发布","type":6,"viewCount":2844}]
         * nextPageToken : DBA816934CD0AA59
         * prevPageToken : 0997C855C600E421
         * requestCount : 20
         * responseCount : 20
         * totalResults : 79684
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
             * author : 王练
             * body : Apache Spark 2.2.0 正式发布，这也是 2.x 系列的第三个版本。此版本移除了 Structured Streaming 的实验标记（experimental tag），意味着已可以...
             * commentCount : 3
             * href : https://www.oschina.net/news/86700/apache-spark-2-2-0
             * id : 86700
             * pubDate : 2017-07-12 18:08:36
             * recommend : true
             * title : Apache Spark 2.2.0 正式发布，提高可用性和稳定性
             * type : 6
             * viewCount : 276
             */

            private String author;
            private String body;
            private int commentCount;
            private String href;
            private int id;
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
