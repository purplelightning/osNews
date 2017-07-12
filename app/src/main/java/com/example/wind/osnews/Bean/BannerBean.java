package com.example.wind.osnews.Bean;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

/**
 * Created by wind on 17-7-12.
 */

public class BannerBean extends BasePageBean<BannerBean.ResultBean.ItemsBean> {

    /**
     * code : 1
     * message : success
     * notice : {"like":0,"review":0,"letter":0,"mention":0,"fans":0}
     * result : {"items":[{"detail":"","href":"https://www.oschina.net/news/86691/gitee-enterprises-3-0","id":86691,"img":"https://static.oschina.net/uploads/cooperation/75410/google-beta-natural-language-api_7d09ff0e-189b-4fb3-9d4e-29c71e5eb222.jpg","name":"码云企业版 3.0 倾情上线","pubDate":"2017-07-12 09:54:40","type":6},{"detail":"","href":"https://www.oschina.net/event/2246165","id":2246165,"img":"https://static.oschina.net/uploads/cooperation/75323/ubuntu-forum-black-sql_f7f0589b-52af-4fa8-b928-fe2657bceec9.jpg","name":"源创会 | 济南站开始报名啦！","pubDate":"2017-06-26 17:08:23","type":5},{"detail":"","href":"https://www.oschina.net/question/2720166_2253505","id":2253505,"img":"https://static.oschina.net/uploads/cooperation/78083/chrome55-save-at-least-35-percent-memory_08459fce-3f06-43ca-80a5-07b90cc4bb3c.png","name":"MySQL 中间件该如何选型？","pubDate":"2017-07-12 10:10:18","type":2},{"detail":"","href":"https://www.oschina.net/news/86648/business-interview","id":86648,"img":"https://static.oschina.net/uploads/cooperation/77929/top-income-programming-languages-2016_298846e5-99b9-4edd-8bdf-fc74067367bc.jpg","name":"创业公司操蛋的面试过程","pubDate":"2017-07-11 14:01:25","type":6},{"detail":"","href":"https://www.oschina.net/news/86650/ai-language","id":86650,"img":"https://static.oschina.net/uploads/cooperation/78455/intellij-idea-2016-3-public-preview_9ea3cbd5-930d-45b0-83b1-79ecd4d6e245.jpg","name":"AI 自创\u201c非人类语言\u201d互相交流","pubDate":"2017-07-11 14:02:27","type":6}],"nextPageToken":"61AF0C190D6BD629","prevPageToken":"3EA621243546C8A5","requestCount":5,"responseCount":5,"totalResults":5}
     * time : 2017-07-12 23:20:52
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
         * items : [{"detail":"","href":"https://www.oschina.net/news/86691/gitee-enterprises-3-0","id":86691,"img":"https://static.oschina.net/uploads/cooperation/75410/google-beta-natural-language-api_7d09ff0e-189b-4fb3-9d4e-29c71e5eb222.jpg","name":"码云企业版 3.0 倾情上线","pubDate":"2017-07-12 09:54:40","type":6},{"detail":"","href":"https://www.oschina.net/event/2246165","id":2246165,"img":"https://static.oschina.net/uploads/cooperation/75323/ubuntu-forum-black-sql_f7f0589b-52af-4fa8-b928-fe2657bceec9.jpg","name":"源创会 | 济南站开始报名啦！","pubDate":"2017-06-26 17:08:23","type":5},{"detail":"","href":"https://www.oschina.net/question/2720166_2253505","id":2253505,"img":"https://static.oschina.net/uploads/cooperation/78083/chrome55-save-at-least-35-percent-memory_08459fce-3f06-43ca-80a5-07b90cc4bb3c.png","name":"MySQL 中间件该如何选型？","pubDate":"2017-07-12 10:10:18","type":2},{"detail":"","href":"https://www.oschina.net/news/86648/business-interview","id":86648,"img":"https://static.oschina.net/uploads/cooperation/77929/top-income-programming-languages-2016_298846e5-99b9-4edd-8bdf-fc74067367bc.jpg","name":"创业公司操蛋的面试过程","pubDate":"2017-07-11 14:01:25","type":6},{"detail":"","href":"https://www.oschina.net/news/86650/ai-language","id":86650,"img":"https://static.oschina.net/uploads/cooperation/78455/intellij-idea-2016-3-public-preview_9ea3cbd5-930d-45b0-83b1-79ecd4d6e245.jpg","name":"AI 自创\u201c非人类语言\u201d互相交流","pubDate":"2017-07-11 14:02:27","type":6}]
         * nextPageToken : 61AF0C190D6BD629
         * prevPageToken : 3EA621243546C8A5
         * requestCount : 5
         * responseCount : 5
         * totalResults : 5
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
             * detail :
             * href : https://www.oschina.net/news/86691/gitee-enterprises-3-0
             * id : 86691
             * img : https://static.oschina.net/uploads/cooperation/75410/google-beta-natural-language-api_7d09ff0e-189b-4fb3-9d4e-29c71e5eb222.jpg
             * name : 码云企业版 3.0 倾情上线
             * pubDate : 2017-07-12 09:54:40
             * type : 6
             */

            private String detail;
            private String href;
            private int id;
            private String img;
            private String name;
            private String pubDate;
            private int type;

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
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

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
