package com.dq.qingfengnc.bean.bbs;

import java.util.List;

/**
 * 帖子评论
 * Created by jingang on 2018/3/21.
 */

public class FdComment {

    /**
     * status : 1
     * data : {"list":[{"id":"1","bbsid":"2","mid":"2","comment":"水电费第三方士大夫士大夫","addtime":"1521343009","rname":"186****4364","headimgurl":"/Public/web/img/ic_header.png"},{"id":"5","bbsid":"2","mid":"2","comment":"是的发送到发送到","addtime":"1521343009","rname":"186****4364","headimgurl":"/Public/web/img/ic_header.png"},{"id":"6","bbsid":"2","mid":"2","comment":"沙发斯蒂芬","addtime":"1521343009","rname":"186****4364","headimgurl":"/Public/web/img/ic_header.png"},{"id":"7","bbsid":"2","mid":"2","comment":"的地方规定","addtime":"1521343009","rname":"186****4364","headimgurl":"/Public/web/img/ic_header.png"},{"id":"8","bbsid":"2","mid":"2","comment":"水电费水电费双方都","addtime":"1521343009","rname":"186****4364","headimgurl":"/Public/web/img/ic_header.png"},{"id":"9","bbsid":"2","mid":"2","comment":"的发送到发送到","addtime":"1521343009","rname":"186****4364","headimgurl":"/Public/web/img/ic_header.png"},{"id":"10","bbsid":"2","mid":"2","comment":"是的发送到发送到","addtime":"1521343009","rname":"186****4364","headimgurl":"/Public/web/img/ic_header.png"},{"id":"11","bbsid":"2","mid":"2","comment":"沙发斯蒂芬斯蒂芬","addtime":"1521343009","rname":"186****4364","headimgurl":"/Public/web/img/ic_header.png"}],"allcount":"8"}
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
         * list : [{"id":"1","bbsid":"2","mid":"2","comment":"水电费第三方士大夫士大夫","addtime":"1521343009","rname":"186****4364","headimgurl":"/Public/web/img/ic_header.png"},{"id":"5","bbsid":"2","mid":"2","comment":"是的发送到发送到","addtime":"1521343009","rname":"186****4364","headimgurl":"/Public/web/img/ic_header.png"},{"id":"6","bbsid":"2","mid":"2","comment":"沙发斯蒂芬","addtime":"1521343009","rname":"186****4364","headimgurl":"/Public/web/img/ic_header.png"},{"id":"7","bbsid":"2","mid":"2","comment":"的地方规定","addtime":"1521343009","rname":"186****4364","headimgurl":"/Public/web/img/ic_header.png"},{"id":"8","bbsid":"2","mid":"2","comment":"水电费水电费双方都","addtime":"1521343009","rname":"186****4364","headimgurl":"/Public/web/img/ic_header.png"},{"id":"9","bbsid":"2","mid":"2","comment":"的发送到发送到","addtime":"1521343009","rname":"186****4364","headimgurl":"/Public/web/img/ic_header.png"},{"id":"10","bbsid":"2","mid":"2","comment":"是的发送到发送到","addtime":"1521343009","rname":"186****4364","headimgurl":"/Public/web/img/ic_header.png"},{"id":"11","bbsid":"2","mid":"2","comment":"沙发斯蒂芬斯蒂芬","addtime":"1521343009","rname":"186****4364","headimgurl":"/Public/web/img/ic_header.png"}]
         * allcount : 8
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
             * id : 1
             * bbsid : 2
             * mid : 2
             * comment : 水电费第三方士大夫士大夫
             * addtime : 1521343009
             * rname : 186****4364
             * headimgurl : /Public/web/img/ic_header.png
             */

            private String id;
            private String bbsid;
            private String mid;
            private String comment;
            private String addtime;
            private String rname;
            private String headimgurl;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getBbsid() {
                return bbsid;
            }

            public void setBbsid(String bbsid) {
                this.bbsid = bbsid;
            }

            public String getMid() {
                return mid;
            }

            public void setMid(String mid) {
                this.mid = mid;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public String getAddtime() {
                return addtime;
            }

            public void setAddtime(String addtime) {
                this.addtime = addtime;
            }

            public String getRname() {
                return rname;
            }

            public void setRname(String rname) {
                this.rname = rname;
            }

            public String getHeadimgurl() {
                return headimgurl;
            }

            public void setHeadimgurl(String headimgurl) {
                this.headimgurl = headimgurl;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "id='" + id + '\'' +
                        ", bbsid='" + bbsid + '\'' +
                        ", mid='" + mid + '\'' +
                        ", comment='" + comment + '\'' +
                        ", addtime='" + addtime + '\'' +
                        ", rname='" + rname + '\'' +
                        ", headimgurl='" + headimgurl + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "allcount='" + allcount + '\'' +
                    ", list=" + list +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "FdComment{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
