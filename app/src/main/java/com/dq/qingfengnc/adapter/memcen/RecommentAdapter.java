package com.dq.qingfengnc.adapter.memcen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dq.qingfengnc.Interface.OnItemClickListener;
import com.dq.qingfengnc.Interface.OnItemLongClickListener;
import com.dq.qingfengnc.R;
import com.dq.qingfengnc.bean.memcen.Recomment;
import com.dq.qingfengnc.utils.BaseRecyclerViewHolder;
import com.dq.qingfengnc.utils.HttpPath;
import com.dq.qingfengnc.utils.ImageUtils;

import java.util.List;

/**
 * Description：推荐商品适配器
 * Created by jingang on 2017/11/24.
 */

public class RecommentAdapter extends RecyclerView.Adapter<RecommentAdapter.MyViewHolder> {

    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    private Context mContext;
    private List<Recomment.DataBean.GoodsBean> goodsList;

    public RecommentAdapter(Context mContext, List<Recomment.DataBean.GoodsBean> goodsList) {
        this.mContext = mContext;
        this.goodsList = goodsList;
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MyViewHolder vh = new MyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.item_hp_goods, parent,
                false));
        return vh;
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        if (mOnItemClickListener != null) {
            //为ItemView设置监听器
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition(); // 1
                    mOnItemClickListener.onItemClick(holder.itemView, position); // 2
                }
            });
        }
        if (mOnItemLongClickListener != null) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemLongClickListener.onItemLongClick(holder.itemView, position);
                    //返回true 表示消耗了事件 事件不会继续传递
                    return true;
                }
            });
        }

        String img = goodsList.get(position).getThumb();

        ImageUtils.loadIntoUseFitWidth(mContext,
                HttpPath.IMG_LIUHE + img,
                R.mipmap.icon_empty002,
                R.mipmap.icon_error002,
                holder.img);

        holder.tv_name.setText("" + goodsList.get(position).getTitle());

        holder.tv_pricenow.setText("¥" + goodsList.get(position).getCostprice());

        holder.tv_priceold.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.tv_priceold.setText("¥" + goodsList.get(position).getMarketprice());


    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }

    class MyViewHolder extends BaseRecyclerViewHolder {

        private ImageView img;
        private TextView tv_name, tv_pricenow, tv_priceold;

        public MyViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.iv_item_hp_img);
            tv_name = (TextView) view.findViewById(R.id.tv_item_hp_name);
            tv_pricenow = (TextView) view.findViewById(R.id.tv_item_hp_tv_pricenow);
            tv_priceold = (TextView) view.findViewById(R.id.tv_item_hp_priceold);
        }
    }
}
