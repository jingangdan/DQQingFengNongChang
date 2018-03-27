package com.dq.qingfengnc.adapter.find;

import android.content.Context;

import com.dq.qingfengnc.R;
import com.dq.qingfengnc.bean.Find;
import com.dq.qingfengnc.view.lrecyclerview.ListBaseAdapter;
import com.dq.qingfengnc.view.lrecyclerview.SuperViewHolder;

import java.util.List;

/**
 * Created by jingang on 2018/2/6.
 */

public class FindAdapter extends ListBaseAdapter<Find> {

    private List<Find> mList;

    public FindAdapter(Context context, List<Find> mList) {
        super(context);
        this.mList = mList;

    }

    @Override
    public int getLayoutId() {
        return R.layout.sample_item_text;
    }

    @Override
    public void onBindItemHolder(SuperViewHolder holder, int position) {
        Find item = mDataList.get(position);
//        TextView titleText = holder.getView(R.id.info_text);
//        titleText.setText(item.title);
    }
}

