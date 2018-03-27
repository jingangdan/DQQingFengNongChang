package com.dq.qingfengnc.adapter.memcen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dq.qingfengnc.Interface.OnItemClickListener;
import com.dq.qingfengnc.R;
import com.dq.qingfengnc.bean.memcen.CouponsList;
import com.dq.qingfengnc.utils.BaseRecyclerViewHolder;
import com.dq.qingfengnc.utils.HttpPath;
import com.dq.qingfengnc.utils.ImageUtils;

import java.util.List;

/**
 * Description：优惠券适配器
 * Created by jingang on 2017/11/21.
 */

public class CouponsListAdapter extends RecyclerView.Adapter<CouponsListAdapter.MyViewHolder> {
    private Context mContext;
    private List<CouponsList.DataBean> couponsList;
    private OnItemClickListener onItemClickListener;

    public CouponsListAdapter(Context mContext, List<CouponsList.DataBean> couponsList) {
        this.mContext = mContext;
        this.couponsList = couponsList;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder vh = new MyViewHolder(
                LayoutInflater.from(mContext).inflate(R.layout.item_coupons, parent, false)
        );
        return vh;
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = holder.getLayoutPosition(); // 1
                    onItemClickListener.onItemClick(holder.itemView, position); // 2
                }
            });
        }

        ImageUtils.loadIntoUseFitWidth(mContext,
                HttpPath.IMG_LIUHE + couponsList.get(position).getThumb(),
                R.mipmap.icon_empty002,
                R.mipmap.icon_error002,
                holder.iv_thumb);
        holder.tv_timedays.setVisibility(View.VISIBLE);
        holder.tv_get.setVisibility(View.VISIBLE);

        holder.tv_timedays.setText("即领取日内：" + couponsList.get(position).getTimedays() + "天有效");

        holder.tv_couponname.setText("" + couponsList.get(position).getCouponname());
        holder.tv_gettime.setText("每人限：" + couponsList.get(position).getGetmax() + "张");
        holder.tv_deduct.setText("¥" + couponsList.get(position).getDeduct());


    }

    @Override
    public int getItemCount() {
        return couponsList.size();
    }

    public class MyViewHolder extends BaseRecyclerViewHolder {
        private ImageView iv_thumb;
        private TextView tv_couponname, tv_gettime, tv_deduct;
        private TextView tv_timedays, tv_get;

        public MyViewHolder(View view) {
            super(view);
            iv_thumb = (ImageView) view.findViewById(R.id.iv_item_coupons_thumb);
            tv_couponname = (TextView) view.findViewById(R.id.tv_item_coupons_couponname);
            tv_gettime = (TextView) view.findViewById(R.id.tv_item_coupons_gettime);
            tv_deduct = (TextView) view.findViewById(R.id.tv_item_coupons_deduct);

            tv_timedays = (TextView) view.findViewById(R.id.tv_item_coupons_timedays);
            tv_get = (TextView) view.findViewById(R.id.tv_item_coupons_get);

        }
    }
}
