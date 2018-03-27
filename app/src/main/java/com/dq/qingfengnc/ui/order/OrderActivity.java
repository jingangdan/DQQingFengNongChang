package com.dq.qingfengnc.ui.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.dq.qingfengnc.R;
import com.dq.qingfengnc.adapter.SimpleFragmentPagerAdapter;
import com.dq.qingfengnc.base.BaseActivity;
import com.dq.qingfengnc.fragment.memcen.FMOrderAll;
import com.dq.qingfengnc.fragment.memcen.FMOrderNoCollect;
import com.dq.qingfengnc.fragment.memcen.FMOrderNoPay;
import com.dq.qingfengnc.fragment.memcen.FMOrderNoSend;
import com.dq.qingfengnc.fragment.memcen.FMorderOK;
import com.dq.qingfengnc.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Description：我的订单
 * Created by jingang on 2017/11/1.
 */

public class OrderActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.tb_noScrollViewPage)
    NoScrollViewPager noScrollViewPager;

    private String[] titles = new String[]{"全部", "待支付", "待发货", "待收货", "已完成"};
    private List<Fragment> fragments = new ArrayList<>();

    private SimpleFragmentPagerAdapter sfpAdapter;

    /*接收页面传值*/
    private Intent intent;
    private int page = 0;
    private String phone = "", token = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout);
        ButterKnife.bind(this);
        intent = getIntent();
        page = intent.getExtras().getInt("page");
        phone = intent.getStringExtra("phone");
        token = intent.getStringExtra("token");

        fragments.add(FMOrderAll.newInstance(phone, token));
        fragments.add(FMOrderNoPay.newInstance(phone, token));
        fragments.add(FMOrderNoSend.newInstance(phone, token));

        fragments.add(FMOrderNoCollect.newInstance(phone, token));
        fragments.add(FMorderOK.newInstance(phone, token));
        //fragments.add(FMorderReFund.newInstance("FMorderReFund"));

        sfpAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), this, fragments, titles);
        noScrollViewPager.setAdapter(sfpAdapter);

        noScrollViewPager.setCurrentItem(page);


        noScrollViewPager.setOffscreenPageLimit(titles.length);

        noScrollViewPager.setOnPageChangeListener(this);
        tabLayout.setupWithViewPager(noScrollViewPager);
    }

    @Override
        protected void initWidght() {
        super.initWidght();
        setTitleName("我的订单");

    }

    public void setFragments() {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
