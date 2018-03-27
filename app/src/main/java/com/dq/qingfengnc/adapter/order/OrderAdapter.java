package com.dq.qingfengnc.adapter.order;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dq.qingfengnc.Interface.OnItemClickListener;
import com.dq.qingfengnc.Interface.OrderInterface;
import com.dq.qingfengnc.R;
import com.dq.qingfengnc.bean.order.Order;
import com.dq.qingfengnc.utils.BaseRecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单列表
 * Created by jingang on 2018/1/20.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {
    private Context mContext;
    private List<Order.DataBean> orderList;
    private OrderInterface orderInterface;
    OrderGoodsAdapter orderGoodsAdapter = null;
    private List<Order.DataBean.GoodslistBean> goodsList = new ArrayList<>();

    private OnItemClickListener onItemClickListener;

    public OrderAdapter(Context mContext, List<Order.DataBean> orderList) {
        this.mContext = mContext;
        this.orderList = orderList;
    }

    public void setOrderInterface(OrderInterface orderInterface) {
        this.orderInterface = orderInterface;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MyViewHolder vh = new MyViewHolder(
                LayoutInflater.from(mContext).inflate(R.layout.item_order, viewGroup, false)
        );
        return vh;
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int i) {
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = holder.getLayoutPosition(); // 1
                    onItemClickListener.onItemClick(holder.itemView, position); // 2
                }
            });
        }

        holder.ordersn.setText("" + orderList.get(i).getOrdersn());
        holder.status.setText("" + orderList.get(i).getStatus());
        holder.allcount.setText("" + orderList.get(i).getAllcount());
        holder.pay_money.setText("" + orderList.get(i).getPay_money());

        String status = orderList.get(i).getStatus();
        String comment = orderList.get(i).getIs_comment();
        String refund = orderList.get(i).getRefund();

        if (status.equals("0")) {
            holder.status.setText("未支付");
            holder.but_pay.setVisibility(View.VISIBLE);
            holder.but_kuaidi.setVisibility(View.GONE);
            holder.but_collect.setVisibility(View.GONE);
            holder.but_del.setVisibility(View.VISIBLE);
            holder.but_comment.setVisibility(View.GONE);
            holder.but_close.setVisibility(View.VISIBLE);
            holder.but_refund.setVisibility(View.GONE);

        } else if (status.equals("1")) {
            if (refund.equals("0")) {
                holder.status.setText("已支付");
                holder.but_refund.setVisibility(View.VISIBLE);
            } else if (refund.equals("1")) {
                holder.status.setText("已支付-申请退款");
                holder.but_refund.setVisibility(View.GONE);
            } else if (refund.equals("2")) {
                holder.status.setText("已支付-商家确认");
                holder.but_refund.setVisibility(View.GONE);
            } else if (refund.equals("3")) {
                holder.status.setText("已支付-退款成功");
                holder.but_refund.setVisibility(View.GONE);
            } else if (refund.equals("-1")) {
                holder.status.setText("已支付-拒绝申请");
                holder.but_refund.setVisibility(View.GONE);
            }

            holder.but_pay.setVisibility(View.GONE);
            holder.but_kuaidi.setVisibility(View.GONE);
            holder.but_collect.setVisibility(View.GONE);
            holder.but_del.setVisibility(View.GONE);
            holder.but_comment.setVisibility(View.GONE);
            holder.but_close.setVisibility(View.GONE);

        } else if (status.equals("2")) {
            holder.status.setText("已发货");
            holder.but_pay.setVisibility(View.GONE);
            holder.but_kuaidi.setVisibility(View.VISIBLE);
            holder.but_collect.setVisibility(View.VISIBLE);
            holder.but_del.setVisibility(View.GONE);
            holder.but_comment.setVisibility(View.GONE);
            holder.but_close.setVisibility(View.GONE);
            holder.but_refund.setVisibility(View.GONE);
        } else if (status.equals("3")) {
            holder.status.setText("已收货");
            holder.but_pay.setVisibility(View.GONE);
            holder.but_kuaidi.setVisibility(View.VISIBLE);
            holder.but_collect.setVisibility(View.GONE);
            holder.but_del.setVisibility(View.VISIBLE);
            holder.but_close.setVisibility(View.GONE);
            holder.but_refund.setVisibility(View.GONE);
            if (comment.equals("0")) {
                holder.status.setText("已收货-待评价");
                holder.but_comment.setClickable(true);
                holder.but_comment.setVisibility(View.VISIBLE);
            } else if (comment.equals("1")) {
                holder.status.setText("已收货-已评价");
                holder.but_comment.setClickable(false);
                holder.but_comment.setVisibility(View.GONE);
            }
        } else if (status.equals("-1")) {
            holder.status.setText("已关闭");
            holder.but_pay.setVisibility(View.GONE);
            holder.but_kuaidi.setVisibility(View.GONE);
            holder.but_collect.setVisibility(View.GONE);
            holder.but_del.setVisibility(View.VISIBLE);
            holder.but_comment.setVisibility(View.GONE);
            holder.but_close.setVisibility(View.GONE);
            holder.but_refund.setVisibility(View.GONE);
        }

        orderGoodsAdapter = new OrderGoodsAdapter(mContext, orderList.get(i).getGoodslist());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        holder.recyclerView.setAdapter(orderGoodsAdapter);

//        orderGoodsAdapter.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//
//            }
//        });

         /*支付*/
        holder.but_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderInterface.doOrderPay(orderList.get(i).getOrdersn());
            }
        });

        /*查看快递*/
        holder.but_kuaidi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderInterface.doOrderKuaidi(orderList.get(i).getExpress(), orderList.get(i).getExpressorder());
            }
        });

        /*确认收货*/
        holder.but_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderInterface.doOrderEdit(orderList.get(i).getId(), "finish", i);
            }
        });

        /*删除*/
        holder.but_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderInterface.doOrderEdit(orderList.get(i).getId(), "del", i);
            }
        });

        /*关闭*/
        holder.but_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderInterface.doOrderEdit(orderList.get(i).getId(), "close", i);
            }
        });

        /*评价*/
        holder.but_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderInterface.doOrderComment(orderList.get(i).getId(), i);
            }
        });

        /*退款*/
        holder.but_refund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderInterface.deRefund(orderList.get(i).getId(), orderList.get(i).getPay_money(), i);
                //orderInterface.deRefund(orderList.get(i).getId(), orderList.get(i).getPay_money(), i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class MyViewHolder extends BaseRecyclerViewHolder {
        TextView ordersn, status;
        RecyclerView recyclerView;
        TextView allcount;
        TextView pay_money;

        Button but_pay, but_kuaidi, but_collect, but_comment, but_del, but_close, but_refund;

        public MyViewHolder(View view) {
            super(view);
            ordersn = view.findViewById(R.id.tv_order_ordersn);
            status = view.findViewById(R.id.tv_order_status);
            recyclerView = view.findViewById(R.id.rv_order);
            allcount = view.findViewById(R.id.tv_order_allcount);
            pay_money = view.findViewById(R.id.tv_order_pay_money);

            but_pay = view.findViewById(R.id.but_order_pay);
            but_collect = view.findViewById(R.id.but_order_collect);
            but_kuaidi = view.findViewById(R.id.but_order_kuaidi);
            but_comment = view.findViewById(R.id.but_order_comment);
            but_del = view.findViewById(R.id.but_order_del);
            but_close = view.findViewById(R.id.but_order_close);
            but_refund = view.findViewById(R.id.but_order_refund);
        }
    }

}
