package com.dq.qingfengnc.bean.bbs;

import java.util.List;

/**
 * 帖子分类列表
 * Created by jingang on 2018/3/20.
 */

public class BbsTypeList {

    /**
     * status : 1
     * data : {"list":[{"id":"3","typename":"精选","parentid":"0","orderby":"1"},{"id":"1","typename":"经典","parentid":"0","orderby":"0"},{"id":"2","typename":"经典1","parentid":"1","orderby":"0"},{"id":"4","typename":"精选1","parentid":"3","orderby":"0"},{"id":"5","typename":"精选2","parentid":"3","orderby":"0"}],"allcount":"5"}
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
         * list : [{"id":"3","typename":"精选","parentid":"0","orderby":"1"},{"id":"1","typename":"经典","parentid":"0","orderby":"0"},{"id":"2","typename":"经典1","parentid":"1","orderby":"0"},{"id":"4","typename":"精选1","parentid":"3","orderby":"0"},{"id":"5","typename":"精选2","parentid":"3","orderby":"0"}]
         * allcount : 5
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
             * typename : 精选
             * parentid : 0
             * orderby : 1
             */

            private String id;
            private String typename;
            private String parentid;
            private String orderby;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTypename() {
                return typename;
            }

            public void setTypename(String typename) {
                this.typename = typename;
            }

            public String getParentid() {
                return parentid;
            }

            public void setParentid(String parentid) {
                this.parentid = parentid;
            }

            public String getOrderby() {
                return orderby;
            }

            public void setOrderby(String orderby) {
                this.orderby = orderby;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "id='" + id + '\'' +
                        ", typename='" + typename + '\'' +
                        ", parentid='" + parentid + '\'' +
                        ", orderby='" + orderby + '\'' +
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
        return "BbsTypeList{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
