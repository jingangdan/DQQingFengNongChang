package com.dq.qingfengnc.adapter.bbs;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.dq.qingfengnc.R;
import com.dq.qingfengnc.base.MyCommentViewHolder;
import com.dq.qingfengnc.base.MyCommonAdapter;
import com.dq.qingfengnc.bean.bbs.FdComment;
import com.dq.qingfengnc.utils.DateUtils;
import com.dq.qingfengnc.utils.GlideUtils;
import com.dq.qingfengnc.utils.HttpPath;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 评论适配器
 * Created by jingang on 2018/3/21.
 */

public class FdCommentAdapter extends MyCommonAdapter<FdComment.DataBean.ListBean> {

    @Bind(R.id.psiv_item_comment_header)
    ImageView ivHeader;
    @Bind(R.id.tv_item_comment_rname)
    TextView rname;
    @Bind(R.id.tv_item_comment_addtime)
    TextView addtime;
    @Bind(R.id.tv_item_comment_comment)
    TextView comment;

    public FdCommentAdapter(List<FdComment.DataBean.ListBean> list, Context mContext) {
        super(list, mContext, R.layout.item_fd_comment);
    }

    @Override
    public void setDate(MyCommentViewHolder commentViewHolder, int position) {
        ButterKnife.bind(this, commentViewHolder.getConverView());
        if (!TextUtils.isEmpty(list.get(position).getHeadimgurl())) {
            GlideUtils.loadImageViewHead(mContext, HttpPath.NEW_HEADER + list.get(position).getHeadimgurl(), ivHeader);
        }
        if (!TextUtils.isEmpty(list.get(position).getRname())) {
            rname.setText(list.get(position).getRname());
        }
        if (!TextUtils.isEmpty(list.get(position).getAddtime())) {
            addtime.setText(DateUtils.time(list.get(position).getAddtime()));
        }
        if (!TextUtils.isEmpty(list.get(position).getComment())) {
            comment.setText(list.get(position).getComment());
        }
    }
}
