package com.dq.qingfengnc.bean.bbs;

import java.util.List;

/**
 * 帖子列表
 * Created by jingang on 2018/3/20.
 */

public class BbsList {
    /**
     * status : 1
     * data : {"list":[{"id":"3","orderby":"1","bbstypeid":"3","bbstitle":"春天老人吃什么水果好","thumb":"/attachment/admin//20180321/1521623089_347940641.jpg","mid":"5","intro":null,"hits":"59","zan":"4","bestis":"1","addtime":"1521339474","zanis":"1","recordis":"1","rname":"183****1017"},{"id":"6","orderby":"0","bbstypeid":"3","bbstitle":"香蕉不能和八种食物一起吃","thumb":"/attachment/admin/20180322/1521690320_959880563.jpg","mid":"","intro":null,"hits":"17","zan":"1","bestis":"0","addtime":"1521690477","zanis":"0","recordis":"0"},{"id":"7","orderby":"0","bbstypeid":"3","bbstitle":"老人可以吃春笋吗","thumb":"/attachment/admin//20180322/1521691151_754340287.jpg","mid":"","intro":null,"hits":"15","zan":"1","bestis":"0","addtime":"1521691218","zanis":"0","recordis":"0"},{"id":"8","orderby":"0","bbstypeid":"3","bbstitle":"老年人喝羊奶好吗","thumb":"/attachment/admin//20180322/1521691388_1957057413.jpg","mid":"","intro":null,"hits":"17","zan":"1","bestis":"0","addtime":"1521691455","zanis":"0","recordis":"0"},{"id":"10","orderby":"0","bbstypeid":"3","bbstitle":"气血不足吃阿胶管用吗","thumb":"/attachment/admin//20180322/1521695284_646761965.jpg","mid":"","intro":null,"hits":"13","zan":"2","bestis":"0","addtime":"1521695320","zanis":"0","recordis":"1"},{"id":"11","orderby":"0","bbstypeid":"3","bbstitle":"颈椎风湿吃什么好","thumb":"/attachment/admin//20180322/1521695453_1884347074.png","mid":"","intro":null,"hits":"12","zan":"1","bestis":"0","addtime":"1521695506","zanis":"0","recordis":"0"},{"id":"12","orderby":"0","bbstypeid":"3","bbstitle":"适合老人吃的猪骨菠菜汤","thumb":"/attachment/admin//20180322/1521695621_504921693.jpg","mid":"","intro":null,"hits":"9","zan":"1","bestis":"0","addtime":"1521695658","zanis":"0","recordis":"0"},{"id":"13","orderby":"0","bbstypeid":"3","bbstitle":"适合老人吃的豆腐炖鱼","thumb":"/attachment/admin//20180322/1521695752_271694520.jpg","mid":"","intro":null,"hits":"9","zan":"0","bestis":"0","addtime":"1521695784","zanis":"0","recordis":"0"},{"id":"14","orderby":"0","bbstypeid":"3","bbstitle":"适合老人吃的酱茄子","thumb":"/attachment/admin//20180322/1521695941_1333669097.jpg","mid":"","intro":null,"hits":"14","zan":"1","bestis":"0","addtime":"1521695973","zanis":"0","recordis":"0"},{"id":"15","orderby":"0","bbstypeid":"3","bbstitle":"适合老人吃的韭黄炒鸡蛋","thumb":"/attachment/admin//20180322/1521696035_1857055269.jpg","mid":"","intro":null,"hits":"8","zan":"1","bestis":"0","addtime":"1521696240","zanis":"0","recordis":"0"},{"id":"16","orderby":"0","bbstypeid":"3","bbstitle":"适合老人吃的食物都有哪些","thumb":"/attachment/admin//20180322/1521696350_980168396.jpg","mid":"","intro":null,"hits":"7","zan":"0","bestis":"0","addtime":"1521696402","zanis":"0","recordis":"0"},{"id":"17","orderby":"0","bbstypeid":"3","bbstitle":"让老人长寿的饮食方法","thumb":"/attachment/admin//20180322/1521696711_1282784437.jpg","mid":"","intro":null,"hits":"8","zan":"1","bestis":"0","addtime":"1521696746","zanis":"0","recordis":"0"},{"id":"22","orderby":"0","bbstypeid":"3","bbstitle":"老年人健身后如何选择饮食","thumb":"/attachment/admin//20180322/1521697722_1113234510.jpg","mid":"","intro":null,"hits":"8","zan":"1","bestis":"0","addtime":"1521697751","zanis":"0","recordis":"0"}],"allcount":"13"}
     */

    private int status;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * list : [{"id":"3","orderby":"1","bbstypeid":"3","bbstitle":"春天老人吃什么水果好","thumb":"/attachment/admin//20180321/1521623089_347940641.jpg","mid":"5","intro":null,"hits":"59","zan":"4","bestis":"1","addtime":"1521339474","zanis":"1","recordis":"1","rname":"183****1017"},{"id":"6","orderby":"0","bbstypeid":"3","bbstitle":"香蕉不能和八种食物一起吃","thumb":"/attachment/admin/20180322/1521690320_959880563.jpg","mid":"","intro":null,"hits":"17","zan":"1","bestis":"0","addtime":"1521690477","zanis":"0","recordis":"0"},{"id":"7","orderby":"0","bbstypeid":"3","bbstitle":"老人可以吃春笋吗","thumb":"/attachment/admin//20180322/1521691151_754340287.jpg","mid":"","intro":null,"hits":"15","zan":"1","bestis":"0","addtime":"1521691218","zanis":"0","recordis":"0"},{"id":"8","orderby":"0","bbstypeid":"3","bbstitle":"老年人喝羊奶好吗","thumb":"/attachment/admin//20180322/1521691388_1957057413.jpg","mid":"","intro":null,"hits":"17","zan":"1","bestis":"0","addtime":"1521691455","zanis":"0","recordis":"0"},{"id":"10","orderby":"0","bbstypeid":"3","bbstitle":"气血不足吃阿胶管用吗","thumb":"/attachment/admin//20180322/1521695284_646761965.jpg","mid":"","intro":null,"hits":"13","zan":"2","bestis":"0","addtime":"1521695320","zanis":"0","recordis":"1"},{"id":"11","orderby":"0","bbstypeid":"3","bbstitle":"颈椎风湿吃什么好","thumb":"/attachment/admin//20180322/1521695453_1884347074.png","mid":"","intro":null,"hits":"12","zan":"1","bestis":"0","addtime":"1521695506","zanis":"0","recordis":"0"},{"id":"12","orderby":"0","bbstypeid":"3","bbstitle":"适合老人吃的猪骨菠菜汤","thumb":"/attachment/admin//20180322/1521695621_504921693.jpg","mid":"","intro":null,"hits":"9","zan":"1","bestis":"0","addtime":"1521695658","zanis":"0","recordis":"0"},{"id":"13","orderby":"0","bbstypeid":"3","bbstitle":"适合老人吃的豆腐炖鱼","thumb":"/attachment/admin//20180322/1521695752_271694520.jpg","mid":"","intro":null,"hits":"9","zan":"0","bestis":"0","addtime":"1521695784","zanis":"0","recordis":"0"},{"id":"14","orderby":"0","bbstypeid":"3","bbstitle":"适合老人吃的酱茄子","thumb":"/attachment/admin//20180322/1521695941_1333669097.jpg","mid":"","intro":null,"hits":"14","zan":"1","bestis":"0","addtime":"1521695973","zanis":"0","recordis":"0"},{"id":"15","orderby":"0","bbstypeid":"3","bbstitle":"适合老人吃的韭黄炒鸡蛋","thumb":"/attachment/admin//20180322/1521696035_1857055269.jpg","mid":"","intro":null,"hits":"8","zan":"1","bestis":"0","addtime":"1521696240","zanis":"0","recordis":"0"},{"id":"16","orderby":"0","bbstypeid":"3","bbstitle":"适合老人吃的食物都有哪些","thumb":"/attachment/admin//20180322/1521696350_980168396.jpg","mid":"","intro":null,"hits":"7","zan":"0","bestis":"0","addtime":"1521696402","zanis":"0","recordis":"0"},{"id":"17","orderby":"0","bbstypeid":"3","bbstitle":"让老人长寿的饮食方法","thumb":"/attachment/admin//20180322/1521696711_1282784437.jpg","mid":"","intro":null,"hits":"8","zan":"1","bestis":"0","addtime":"1521696746","zanis":"0","recordis":"0"},{"id":"22","orderby":"0","bbstypeid":"3","bbstitle":"老年人健身后如何选择饮食","thumb":"/attachment/admin//20180322/1521697722_1113234510.jpg","mid":"","intro":null,"hits":"8","zan":"1","bestis":"0","addtime":"1521697751","zanis":"0","recordis":"0"}]
         * allcount : 13
         */

        private String allcount;
        private List<ListBean> list;

        public String getAllcount() {
            return allcount;
        }

        public void setAllcount(String allcount) {
            this.allcount = allcount;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 3
             * orderby : 1
             * bbstypeid : 3
             * bbstitle : 春天老人吃什么水果好
             * thumb : /attachment/admin//20180321/1521623089_347940641.jpg
             * mid : 5
             * intro : null
             * hits : 59
             * zan : 4
             * bestis : 1
             * addtime : 1521339474
             * zanis : 1
             * recordis : 1
             * rname : 183****1017
             */

            private String id;
            private String orderby;
            private String bbstypeid;
            private String bbstitle;
            private String thumb;
            private String mid;
            private Object intro;
            private String hits;
            private String zan;
            private String bestis;
            private String addtime;
            private String zanis;
            private String recordis;
            private String rname;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOrderby() {
                return orderby;
            }

            public void setOrderby(String orderby) {
                this.orderby = orderby;
            }

            public String getBbstypeid() {
                return bbstypeid;
            }

            public void setBbstypeid(String bbstypeid) {
                this.bbstypeid = bbstypeid;
            }

            public String getBbstitle() {
                return bbstitle;
            }

            public void setBbstitle(String bbstitle) {
                this.bbstitle = bbstitle;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getMid() {
                return mid;
            }

            public void setMid(String mid) {
                this.mid = mid;
            }

            public Object getIntro() {
                return intro;
            }

            public void setIntro(Object intro) {
                this.intro = intro;
            }

            public String getHits() {
                return hits;
            }

            public void setHits(String hits) {
                this.hits = hits;
            }

            public String getZan() {
                return zan;
            }

            public void setZan(String zan) {
                this.zan = zan;
            }

            public String getBestis() {
                return bestis;
            }

            public void setBestis(String bestis) {
                this.bestis = bestis;
            }

            public String getAddtime() {
                return addtime;
            }

            public void setAddtime(String addtime) {
                this.addtime = addtime;
            }

            public String getZanis() {
                return zanis;
            }

            public void setZanis(String zanis) {
                this.zanis = zanis;
            }

            public String getRecordis() {
                return recordis;
            }

            public void setRecordis(String recordis) {
                this.recordis = recordis;
            }

            public String getRname() {
                return rname;
            }

            public void setRname(String rname) {
                this.rname = rname;
            }
        }
    }
}
