package com.dq.qingfengnc.bean.index;

import java.util.List;

/**
 * Created by asus on 2018/3/21.
 */

public class Index2 {

    /**
     * status : 1
     * data : [{"id":"19","module":"banner","child":[{"id":"20","title":"休闲零食","thumb":"http://new.dequanhuibao.com/attachment/admin//20180109/1515482176_2030471201.png","width":"100","type":"cate","content":"544","module_id":"19","explain":"美食-美食-休闲零食","displayorder":"0"},{"id":"21","title":"奢华服装","thumb":"http://new.dequanhuibao.com/attachment/admin//20180109/1515482148_1621848798.jpg","width":"100","type":"cate","content":"469","module_id":"19","explain":"服饰-女装","displayorder":"0"},{"id":"22","title":"优惠专区","thumb":"http://new.dequanhuibao.com/attachment/admin//20180109/1515482127_1034125863.jpg","width":"100","type":"cate","content":"719","module_id":"19","explain":"数码产品","displayorder":"0"}]},{"id":"20","module":"appimglist","child":[{"id":"23","title":"养老专区","thumb":"/attachment/admin//20180320/1521546432_1952339248.png","width":"100","type":"url","content":"#","module_id":"20","explain":"#","displayorder":"1"}]},{"id":"21","module":"menu","child":[]},{"id":"22","module":"notice","child":[{"id":"24","title":"\u201c兰陵王\u201d杯临沂慈善助学行动","thumb":"","width":"100","type":"article","content":"3","module_id":"22","explain":"\u201c兰陵王\u201d杯临沂慈善助学行动\u201c十大慈善公益组织\u201d\u201c十大慈善义工\u201d表彰大会温情举行","displayorder":"0"}]},{"id":"23","module":"appimglist","child":[{"id":"25","title":"","thumb":"/attachment/admin//20180320/1521546557_221193109.png","width":"100","type":"url","content":"#","module_id":"23","explain":"#","displayorder":"0"}]},{"id":"24","module":"appimglist","child":[{"id":"26","title":"","thumb":"/attachment/admin//20180320/1521546610_1847119098.png","width":"100","type":"url","content":"#","module_id":"24","explain":"#","displayorder":"0"}]},{"id":"25","module":"glist","child":[{"id":"25738","thumb":"/attachment/images/sz_yi/1604/2017/12/c44oWBP2484Wipa5BwNdeMi22iECNw.png","goodsname":"红灯记肉松蚕豆兰花豆250g独立小包炒货零食品年货","marketprice":"7.80","productprice":"9.90"}]},{"id":"26","module":"appimglist","child":[{"id":"29","title":"","thumb":"/attachment/admin//20180320/1521546817_570100194.png","width":"100","type":"url","content":"#","module_id":"26","explain":"#","displayorder":"0"}]},{"id":"27","module":"glist","child":[{"id":"25738","thumb":"/attachment/images/sz_yi/1604/2017/12/c44oWBP2484Wipa5BwNdeMi22iECNw.png","goodsname":"红灯记肉松蚕豆兰花豆250g独立小包炒货零食品年货","marketprice":"7.80","productprice":"9.90"},{"id":"25639","thumb":"/attachment/images/sz_yi/1604/2017/12/ZTTksQqKHJbcu99ZuGTZ9X9xD1hQXu.jpg","goodsname":"爱亿华  美之力  胶原蛋白棉花糖酸奶  58g 软糖糖果零食","marketprice":"7.50","productprice":"0.00"},{"id":"25618","thumb":"/attachment/images/sz_yi/1604/2017/12/WjlsLKWqMeBUwz9BSkl6Ej6QvS6sV9.jpg","goodsname":"口水娃爆米花生豆干炒米薯片休闲膨化食品年货50包圣诞零食大礼包","marketprice":"57.80","productprice":"69.00"},{"id":"25583","thumb":"/attachment/images/1604/2017/12/mb391dbGcbzcL9278cPL9bbl2c97v9.jpg","goodsname":"奶油葵花籽 美味奶油瓜子坚果炒货休闲零食","marketprice":"7.00","productprice":"9.00"}]}]
     */

    private int status;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 19
         * module : banner
         * child : [{"id":"20","title":"休闲零食","thumb":"http://new.dequanhuibao.com/attachment/admin//20180109/1515482176_2030471201.png","width":"100","type":"cate","content":"544","module_id":"19","explain":"美食-美食-休闲零食","displayorder":"0"},{"id":"21","title":"奢华服装","thumb":"http://new.dequanhuibao.com/attachment/admin//20180109/1515482148_1621848798.jpg","width":"100","type":"cate","content":"469","module_id":"19","explain":"服饰-女装","displayorder":"0"},{"id":"22","title":"优惠专区","thumb":"http://new.dequanhuibao.com/attachment/admin//20180109/1515482127_1034125863.jpg","width":"100","type":"cate","content":"719","module_id":"19","explain":"数码产品","displayorder":"0"}]
         */

        private String id;
        private String module;
        private List<ChildBean> child;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getModule() {
            return module;
        }

        public void setModule(String module) {
            this.module = module;
        }

        public List<ChildBean> getChild() {
            return child;
        }

        public void setChild(List<ChildBean> child) {
            this.child = child;
        }

        public static class ChildBean {
            /**
             * id : 20
             * title : 休闲零食
             * thumb : http://new.dequanhuibao.com/attachment/admin//20180109/1515482176_2030471201.png
             * width : 100
             * type : cate
             * content : 544
             * module_id : 19
             * explain : 美食-美食-休闲零食
             * displayorder : 0
             */

            private String id;
            private String title;
            private String thumb;
            private String width;
            private String type;
            private String content;
            private String module_id;
            private String explain;
            private String displayorder;

            //商品列表
            private String goodsname;
            private String marketprice;
            private String productprice;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getModule_id() {
                return module_id;
            }

            public void setModule_id(String module_id) {
                this.module_id = module_id;
            }

            public String getExplain() {
                return explain;
            }

            public void setExplain(String explain) {
                this.explain = explain;
            }

            public String getDisplayorder() {
                return displayorder;
            }

            public void setDisplayorder(String displayorder) {
                this.displayorder = displayorder;
            }

            public String getGoodsname() {
                return goodsname;
            }

            public void setGoodsname(String goodsname) {
                this.goodsname = goodsname;
            }

            public String getMarketprice() {
                return marketprice;
            }

            public void setMarketprice(String marketprice) {
                this.marketprice = marketprice;
            }

            public String getProductprice() {
                return productprice;
            }

            public void setProductprice(String productprice) {
                this.productprice = productprice;
            }
        }
    }
}
