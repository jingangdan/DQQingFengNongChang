package com.dq.qingfengnc.Interface;

/**
 * 订单操作接口
 * Created by jingang on 2018/1/20.
 */

public interface OrderInterface {
    /**
     * 支付
     */
    void doOrderPay(String ordersn);

    /**
     * 评价
     *
     * @param id
     * @param position
     */
    void doOrderComment(String id, int position);

    /**
     * 查看物流
     *
     * @param type   快递公司编号订单详情提供
     * @param postid 快递单号
     */
    void doOrderKuaidi(String type, String postid);

    /**
     * 确认收货 删除 关闭
     *
     * @param id   订单id
     * @param type del删除','close关闭','finish确认收货
     */
    void doOrderEdit(String id, String type, int position);

    /**
     * 退款
     *
     * @param id       订单id
     * @param price
     * @param position 组件位置
     */
    void deRefund(String id, String price, int position);


}
