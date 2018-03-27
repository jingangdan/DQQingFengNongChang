package com.dq.qingfengnc.utils;

/**
 * Description：接口地址
 * Created by jingang on 2017/11/2.
 */

public class HttpPath {

    /*总的请求头*/
    public static final String PATH = "http://www.dequanhuibao.com/addons/sz_yi/core/api/index.php?";

    /*
    * 搜索
    * 参数：
    * i: shopid
    * keywords:搜索关键字
    * */
    public static final String SHOP_SEARCH = "api=shop/Goods/search&i=1604&";

    /**
     * 登录
     * &openid=*******&stamp=1234567890&doc=*********
     */
    public static final String SHOP_GOODS_LOGIN = "api=shop/Member/login&i=1604&";

    /*
    * 优惠券列表
    * 参数：
    * 登录验证
    * used  默认空  1已使用，
    * past  默认空 1已过期
    * page 页码
    * */
    public static final String SHOP_MEMBER_COUPON = "api=shop/Member/coupon&i=1604&";

    /**
     * 优惠券领取列表
     * 参数 ：
     * 登录验证
     * page：页码
     */
    public static final String SHOP_COUPON_INDEX = "api=shop/Coupon/index&i=1604&";

    /*
    * 优惠券详情
    * 参数：
    * id=
    * 登录验证
    * */
    public static final String SHOP_COUPON_DETAIL = "api=shop/Coupon/detail&i=1604&";

    /*获取推荐商品*/
    public static final String SHOP_GOODS_RECOMMENT = "api=shop/Goods/recommand&i=1604";

    /**
     * 请求头
     */
    public static final String PATHS = "http://liuhe.dequanhuibao.com/Api/";

    /**
     * 图片头部
     */
    public static final String IMG_HEADER = "http://www.dequanhuibao.com/";

    public static final String NEW_HEADER = "http://liuhe.dequanhuibao.com/";

    public static final String KEY = "&key=ivKDDIZHF2b0Gjgvv2QpdzfCmhOpya5k";


    /**
     * 检查版本更新
     * 参数：
     * version=1.0.2
     */
    public static final String CHECK_VERSION = "Sys/checkversion?";

    /**
     * 1.
     * 验证手机号是否已经注册
     * <p>
     * 方式：get/post
     * 参数：
     * phone: 手机号
     */
    public static final String ACCOUNT_CHECKPHONE = "Account/checkphone?";


    /**
     * 2.
     * 发送验证码
     * 方式：post/get
     * 参数：
     * phone：手机号
     * type：类型
     * <p>
     * type类型：
     * 1 => '注册reg', wu
     * 2 => '快速登录fastlogin', /
     * 3 => '找回密码repwd', you
     * 4 => '微信绑定手机号', /
     * 5 => '更换手机号-旧', you
     * 6 => '更换手机号-新', wu
     * 7 => '修改密码' you
     */
    public static final String ACCOUNT_VERIFY = "Account/verify?";


    /**
     * 3.
     * 注册
     * 方式：post/get
     * 参数：
     * phone手机号
     * verify验证码
     * pwd密码
     */
    public static final String ACCOUNT_REG = "Account/reg?";

    /**
     * 4.
     * 登录
     * 方式：post/get
     * 参数：
     * phone手机号
     * pwd密码
     */
    public static final String ACCOUNT_LOGIN = "Account/login?";

    /**
     * 5.
     * 退出登录
     * 方式：post/get
     * 参数：
     * phone手机号
     * token 登录状态码
     * timestamp 时间戳
     * sign 签名
     */
    public static final String ACCOUNT_LOGINOUT = "Account/loginout?";

    /**
     * 6.
     * 忘记密码找回
     * 方式：post/get
     * 参数：
     * phone手机号
     * verify验证码
     * pwd密码
     */
    public static final String ACCOUNT_BACKPWD = "Account/backpwd?";

    /**
     * 7.
     * 获取用户信息
     * 方式：post/get
     * 参数：
     * phone手机号
     * token 登录状态码
     * timestamp 时间戳
     * sign 签名
     */
    public static final String MEM_MEMBER = "Member/member?";

    /**
     * 8.
     * 修改用户信息
     * 方式：post/get
     * 参数：
     * phone手机号
     * token 登录状态码
     * sex性别
     * region 地区列表id
     * $_FILES['file']用户头像（这个不能同时上传的话跟我说，我给改）
     * timestamp 时间戳
     * sign签名
     */
    public static final String MEM_EDITINFO = "Member/editinfo?";

    /**
     * 上传图片
     * 方式：post/get
     * 参数：
     * $_FILES['file']用户头像（这个不能同时上传的话 跟我说，我给改）
     * 用户登陆验证（phone,token）
     */
    public static final String MEM_UPIMG = "Member/upimg?";

    /**
     * 9.
     * 获取省市列表
     */
    public static final String COMMON_REGION = "Common/region";

    /**
     * 10.
     * 获取顶级分类
     * 方式：post/get
     */
    public static final String GOODS_CATE = "Goods/cate";

    /**
     * 11.
     * 获取子分类(二、三级)
     * 方式：post/get
     * 参数：id 上级分类
     */
    public static final String GOODS_CATECHILDREN = "Goods/catechildren?";

    /**
     * 13.
     * 搜索商品
     * 方式：post/get
     * 参数：
     * cate 分类
     * custom 自定义分类
     * key 关键字
     * ishot 热销 0/1
     * isrecommand 推荐 0/1
     * isnew 新品 0/1
     * isdiscount 促销 0/1
     * issendfree 包邮 0/1
     * istime 限时 0/1
     * page 页数
     * price 价格排序 asc/desc
     * sales销量排序 asc/desc
     * comment 评价排序 asc/desc
     */
    public static final String GOODS_SEARCH = "Goods/search?";

    /**
     * 14.
     * 商品详情
     * 方式：post/get
     * 参数：
     * id 商品id
     * token （不用加密，没登陆就不传）
     * phone（不用加密，没登陆就不传）
     */
    public static final String GOODS_DETAIL = "Goods/detail?";

    /**
     * 14.
     * 首页
     * 方式：get/post
     * -url链接
     * article文章
     * cate分类
     * goods商品
     * custom自定义分类
     * articlecate文章分类
     * search  搜索
     * url # 不做操作
     */
    public static final String INDEXT_INDEX = "Index/index";

    /**
     * 15.
     * 添加购物车
     * 方式：post/get
     * 参数：
     * goodsid 商品id
     * optioned 规格id
     * count	添加数量（正负）
     * 用户登陆验证（phone,token）
     */
    public static final String CART_ADD = "Cart/add?";

    /**
     * 16.
     * 获取购物车
     * 方式：post/get
     * 参数：
     * 用户登陆验证（phone,token）
     */
    public static final String CART_GET = "Cart/get?";

    /**
     * 17.
     * 删除购物车
     * 方式：post/get
     * 参数：
     * ids 商品id集合，逗号隔开
     * 用户登陆验证（phone,token）
     */
    public static final String CART_DEL = "Cart/del?";

    /**
     * 获取配送费
     * 方式：post/get
     * 参数：
     * cityid  市id
     * goodsid 商品id
     * optioned 规格
     * num 数量
     */
    public static final String CONFIRM_DISPATCH = "Confirm/dispatch";

    /**
     * 18.
     * 添加收货地址
     * 方式：post/get
     * 参数：
     * regionid 选择区域的id
     * isdefault	是否设为默认
     * addr 详细地址
     * contact 联系人
     * mobile 联系人电话
     * 用户登陆验证（phone,token）
     */
    public static final String MEMBER_ADDADDR = "Member/addaddr?";

    /**
     * 19.
     * 修改收货地址
     * 方式：post/get
     * 参数：
     * id 要修改的收货地址id
     * regionid 选择区域的id
     * isdefault	是否设为默认
     * addr 详细地址
     * contact 联系人
     * mobile 联系人电话
     * 用户登陆验证（phone,token）
     */
    public static final String MEMBER_EDITADDR = "Member/editaddr?";

    /**
     * 20.
     * 获取收货地址
     * 方式：post/get
     * 参数：
     * 用户登陆验证（phone,token）
     */
    public static final String MEMBER_GETADDR = "Member/getaddr?";

    /**
     * 21.
     * 删除收货地址
     * 方式：post/get
     * 参数：
     * id 要删除的收货地址id
     * 用户登陆验证（phone,token）
     */
    public static final String MEMBER_DELADDR = "Member/deladdr?";

    /**
     * 22.
     * 设置默认收货地址
     * 方式：post/get
     * 参数：
     * id 要修改的收货地址id
     * 用户登陆验证（phone,token）
     */
    public static final String MEMBER_DEGAULTADDR = "Member/defaultaddr?";


    /**
     * 23.（1）
     * 提交订单前确认（购物车）
     * 方式：post/get
     * 参数：
     * cartids  购物车id 集合 逗号隔开
     * cityid 配送地址的市级id  在收货地址里面有
     * 用户登陆验证（phone,token）
     */
    public static final String CONFIRM_CHECKORDER = "Confirm/checkorder?";

    /**
     * 23.（2）
     * 提交订单前确认（购物车）
     * 方式：post/get
     * 参数：
     * goodsid  购物车id 集合 逗号隔开
     * optionid
     * count
     * addrid 收货地址的id
     * 用户登陆验证（phone,token）
     */
    public static final String CONFIRM_BUYNOW = "Confirm/buynow?";

    /**
     * 24.(1)
     * 提交订单(购物车)
     * 方式：post/get
     * 参数：
     * cartids  购物车id 集合 逗号隔开
     * addrid收货地址的id
     * remark 备注[{shopid:remark}]备注
     * 用户登陆验证（phone,token）
     */
    public static final String ORDER_ADD = "Order/add?";

    /**
     * 24.(2)
     * 提交订单（商品详情）
     * 方式：post/get
     * 参数：
     * goodsid
     * optionid
     * count
     * addrid收货地址的id
     * remark备注[{shopid:remark}]备注
     * 用户登陆验证（phone,token）
     */
    public static final String ORDER_BUYNOW = "Order/buynow?";

    /**
     * 25.
     * 获取订单列表
     * 方式：post/get
     * 参数：
     * status 订单状态 全部获取传空
     * 用户登陆验证（phone,token）
     * <p>
     * 注：订单状态 status  0生成订单未支付1支付2发货3确认收获 -1关闭订单
     * 是否已经评价 is_recomment 0未评价 1已评价
     * 退款refund 0正常，1申请退款 2商家确认 3退款成功 -1拒绝申请
     */
    public static final String ORDER_GETIST = "Order/getlist?";

    /**
     * 26.
     * 快递100快递查询接口
     * 方式：get
     * 参数：type 快递公司编号订单详情提供
     * postid快递单号
     */
    public static final String KUAIDI = "https://www.kuaidi100.com/query?";

    /**
     * 27.
     * 订单退款
     * 方式：post/get
     * 参数：
     * id 订单id
     * remark 退款原因—文字
     * 用户登陆验证（phone,token）
     * <p>
     * 注：订单状态status=1作可以删除
     */
    public static final String ORDER_REFUND = "Order/refund?";

    /**
     * 28.
     * 订单状态修改
     * 方式：post/get
     * 参数：
     * id 订单id
     * type操作
     * 用户登陆验证（phone,token）
     * <p>
     * 注：type = ['del删除','close关闭','finish确认收货']
     * 删除——必须先执行关闭操作才能删除，status==-1
     * 关闭——订单状态是未支付的时候才能关闭status==0
     * 确认收获——只有当发货的状态才能收货status==2
     */
    public static final String ORDER_EDIT = "Order/edit?";

    /**
     * 29.
     * 订单详情
     * 方式：post/get
     * 参数：
     * id 订单id
     * 用户登陆验证（phone,token）
     */
    public static final String ORDER_DETAIL = "Order/detail?";

    /**
     * 30.
     * 订单评价
     * 方式：post/get
     * 参数：
     * orderid 订单id
     * remark  json数组
     * {"222":{"score":5,"comment":"*******"},
     * "333":{"score":4,"comment":"*******"}}
     * <p>
     * 用户登录验证（phone,token）
     */
    public static final String ORDER_COMMENT = "Order/comment?";

    /**
     * 31.
     * 余额充值-生成订单
     * 方式：post/get
     * 参数：
     * money 充值金额（整数）
     * 用户登录验证（phone,token）
     */
    public static final String RECHARGE_ORDER = "Recharge/order?";

    /**
     * 32.
     * 选择支付方式
     * 方式：post/get
     * 参数：
     * ordersn 订单号
     * 用户登录验证（phone,token）
     */
    public static final String PAY_PAYTYPE = "Pay/paytype?";

    /**
     * 33.
     * 调用第三方支付前，在第三方下单
     * 方式：post/get
     * 参数：
     * ordersn 订单号
     * paytype  支付方式balance---余额支付 wxpay---微信支付 alipay---支付宝支付
     * 用户登录验证（phone,token）
     */
    public static final String PAY_ORDER = "Pay/order?";

    /**
     * 34.
     * 添加收藏
     * 方式：post/get
     * 参数：
     * type  收藏类型--- collect收藏商品   collect_shop收藏店铺（暂无）
     * id 收藏的商品id 或者店铺id
     * 用户登录验证（phone,token）
     */
    public static final String MEM_ADDRECORD = "Member/addrecord?";

    /**
     * 35.
     * 取消收藏
     * 方式：post/get
     * 参数：
     * type  收藏类型--- collect收藏商品   collect_shop收藏店铺（暂无）
     * id 收藏的商品id 或者店铺id
     * 用户登录验证（phone,token）
     */
    public static final String MEM_DELRECORD = "Member/delrecord?";

    /**
     * 36.
     * 获取收藏列表  获取浏览历史
     * 方式：post/get
     * 参数：
     * type  类型--- browse  浏览历史  collect收藏商品   collect_shop收藏店铺（暂无）
     * page 当前页
     * 用户登录验证（phone,token）
     */
    public static final String MEM_RECORDLIST = "Member/recordlist?";

    /**
     * 签到
     * 方式：post/get
     * 参数：
     * 用户登录验证
     */
    public static final String ACTIVITY_SIGN = "ActivitySign/sign?";

    /**
     * 获取签到信息
     * 方式：post/get
     * 参数：
     * 用户登录验证
     */
    public static final String ACTIVITYSIGN_INDEX = "ActivitySign/index?";

    /**
     * 分享
     * 方式：post/get
     * 参数：
     * 用户登陆验证：
     * goodsid
     */
    public static final String POSTER_INDEX = "Poster/index?";


    //论坛

    public static final String HEADER_LIUHE = "http://liuhe.dequanhuibao.com/Api/";
    public static final String IMG_LIUHE = "http://liuhe.dequanhuibao.com/";
    /**
     * 1.
     * 获取帖子分类列表
     * 方式：post/get
     * 参数：
     * id 			分类编号 可选
     * Parentid  	父分类编号 可选
     */
    public static final String BBS_BBSTYPE = "Bbs/bbstypelist?";

    /**
     * 2.
     * 获取帖子列表
     * 方式：post/get
     * 参数：
     * Page		当前页数  可选  默认第一页
     * Pagesize  每页显示条数  可选 默认前20条
     * Bbstypeid	帖子分类	可选
     * Mid			会员编号	可选
     * Id			帖子编号	可选
     * Bestid		精选标记（0非精选，1精选）  可选
     */
    public static final String BBS_BBSLIST = "Bbs/bbslist?";

    /**
     * 3.
     * 获取评论列表
     * 方式：post/get
     * 参数：
     * Page		当前页数  可选  默认第一页
     * Pagesize  每页显示条数  可选 默认前20条
     * Mid			会员编号	可选
     * bbsid		帖子编号	可选
     */
    public static final String BBS_BBSCOMMENT = "Bbs/bbscomment?";

    /**
     * 4.
     * 添加评论
     * 方式：post/get
     * 参数：
     * bbsid 必须  帖子编号
     * mid 必须    会员编号
     * comment 必须 评论内容
     */
    public static final String BBS_ADDCOMMENT = "Bbs/addcomment?";

    /**
     * 4.
     * 增加帖子浏览次数
     * 方式：post/get
     * 参数：
     * Bbsid 帖子编号  必选
     */
    public static final String BBS_SETHITS = "Bbs/sethits?";

    /**
     * 5.
     * 获取帖子浏览次数
     * 方式：post/get
     * 参数：
     * Bbsid 帖子编号  必选
     */
    public static final String BBS_BBSHITS = "Bbs/bbshits?";

    /**
     * 6.
     * 增加帖子点赞次数
     * 方式：post/get
     * 参数：
     * Bbsid 帖子编号  必选
     */
    public static final String BBS_SETZAN = "Bbs/setzan?type=bbs&";

    /**
     * 7.
     * 获取帖子点赞次数
     * 方式：post/get
     * 参数：
     * Bbsid 帖子编号  必选
     */
    public static final String s = "Bbs/bbszan?";

    /**
     * 8.
     * 添加收藏
     * 方式：post/get
     * 参数：
     * Bbsid 帖子编号  必选
     */
    public static final String BBS_ADD_COLLECTION = "Member/addrecord?";

    /**
     * 9.
     * 获取帖子点赞次数
     * 方式：post/get
     * 参数：
     * Bbsid 帖子编号  必选
     */
    public static final String BBS_DEL_COLLECTION = "Member/delrecord?";

}
