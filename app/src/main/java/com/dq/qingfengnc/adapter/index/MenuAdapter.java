package com.dq.qingfengnc.adapter.index;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dq.qingfengnc.Interface.OnItemClickListener;
import com.dq.qingfengnc.R;
import com.dq.qingfengnc.bean.index.Index2;
import com.dq.qingfengnc.utils.BaseRecyclerViewHolder;
import com.dq.qingfengnc.utils.HttpPath;

import java.util.List;

/**
 * 首页 menu适配器
 * Created by jingang on 2018/1/10.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {
    private Context mContext;
    private List<Index2.DataBean.ChildBean> menuList;
    private OnItemClickListener onItemClickListener;

    public MenuAdapter(Context mContext, List<Index2.DataBean.ChildBean> menuList) {
        this.mContext = mContext;
        this.menuList = menuList;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MyViewHolder vh = new MyViewHolder(
                LayoutInflater.from(mContext).inflate(R.layout.item_menu, viewGroup, false)
        );
        return vh;
    }

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

        Glide.with(mContext)
                .load(HttpPath.IMG_LIUHE + menuList.get(position).getThumb())
                .placeholder(R.mipmap.icon_empty)
                .error(R.mipmap.icon_error)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(holder.img);

        holder.text.setText("" + menuList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class MyViewHolder extends BaseRecyclerViewHolder {
        private ImageView img;
        private TextView text;

        public MyViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.iv_item_goods_img);
            text = (TextView) view.findViewById(R.id.tv_item_goods_name);
        }
    }
}
