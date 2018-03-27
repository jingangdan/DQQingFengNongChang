package com.dq.qingfengnc.fragment.memcen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dq.qingfengnc.R;
import com.dq.qingfengnc.base.BaseFragment;

/**
 * Description：我的订单（已完成）
 * Created by jingang on 2017/11/1.
 */

public class FMorderReFund extends BaseFragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fm_tablayout, null);
        return view;
    }

    public static FMorderReFund newInstance(String order) {
        Bundle bundle = new Bundle();
        bundle.putString("order", order);
        FMorderReFund fragment = new FMorderReFund();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            System.out.println("in");

        } else {
            System.out.println("move");
        }
    }

    @Override
    protected void lazyLoad() {

    }
}
