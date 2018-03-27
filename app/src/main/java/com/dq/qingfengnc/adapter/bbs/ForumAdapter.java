package com.dq.qingfengnc.adapter.bbs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.dq.qingfengnc.R;
import com.dq.qingfengnc.application.MyApplication;
import com.dq.qingfengnc.base.MyCommentViewHolder;
import com.dq.qingfengnc.base.MyCommonAdapter;
import com.dq.qingfengnc.bean.bbs.BbsList;
import com.dq.qingfengnc.utils.GlideUtils;
import com.dq.qingfengnc.utils.HttpPath;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 帖子适配器
 * Created by jingang on 2018/3/20.
 */

public class ForumAdapter extends MyCommonAdapter<BbsList.DataBean.ListBean> {

    @Bind(R.id.item_tv_forum_rname)
    TextView rname;
    @Bind(R.id.item_tv_forum_addtime)
    TextView addtime;
    @Bind(R.id.item_tv_forum_bbstitle)
    TextView title;
    @Bind(R.id.item_tv_forum_hits)
    TextView hits;
    @Bind(R.id.item_tv_forum_zan)
    TextView zan;
    @Bind(R.id.item_iv_forum_thumb)
    ImageView thumb;

    public ForumAdapter(List<BbsList.DataBean.ListBean> list, Context mContext) {
        super(list, mContext, R.layout.item_forum);
    }

    @Override
    public void setDate(MyCommentViewHolder commentViewHolder, int position) {
        ButterKnife.bind(this, commentViewHolder.getConverView());
        BbsList.DataBean.ListBean listBean = list.get(position);
        if (!TextUtils.isEmpty(listBean.getThumb())) {
            GlideUtils.loadImageView(mContext, HttpPath.IMG_LIUHE + listBean.getThumb(), thumb);
        }
        if (!TextUtils.isEmpty(listBean.getRname())) {
            rname.setText(listBean.getRname());
        }
        if (!TextUtils.isEmpty(listBean.getAddtime())) {
            addtime.setText(listBean.getAddtime());
        }
        if (!TextUtils.isEmpty(listBean.getBbstitle())) {
            title.setText(listBean.getBbstitle());
        }
        if (!TextUtils.isEmpty(listBean.getHits())) {
            hits.setText(listBean.getHits() + "人看过");
        }
        if (!TextUtils.isEmpty(listBean.getZan())) {
            zan.setText(listBean.getZan());
        }
        //判断点赞否
        int drawLeft = "1".equals(listBean.getZanis())?R.mipmap.icon_lt_dz_ed:R.mipmap.icon_lt_dz_nor;
        Drawable drawable = ContextCompat.getDrawable(mContext, drawLeft);
        //为drawable设置宽高,不设置则不显示
        drawable.setBounds(0, 0, MyApplication.bbs_iconSize, MyApplication.bbs_iconSize);
        zan.setCompoundDrawables(drawable,null,null,null);
    }
}
