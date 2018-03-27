package com.dq.qingfengnc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dq.qingfengnc.R;
import com.dq.qingfengnc.utils.HttpPath;
import com.dq.qingfengnc.view.goodsdetails.PictrueFragment;
import com.dq.qingfengnc.view.HackyViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * 显示大图界面
 *
 * @author http://yecaoly.taobao.com
 *         <p>
 *         1
 */
public class ShowBigPictrueActivity extends FragmentActivity {

    private HackyViewPager viewPager;
    /**
     * 得到上一个界面点击图片的位置
     */
    private Intent intent;
    private int position = 0;
    private String pics = "";
    private List<String> picsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_big_pictrue_a);
        intent = getIntent();
        position = intent.getIntExtra("position", 0);
        pics = intent.getStringExtra("picslist");

        picsList = GoodsDetailsActivity.picsList;

        initViewPager();

    }

    private void initViewPager() {

        viewPager = (HackyViewPager) findViewById(R.id.viewPager_show_bigPic);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        //跳转到第几个界面
        viewPager.setCurrentItem(position);


    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //int show_resId = resId[position];
            String show_resId = HttpPath.IMG_HEADER + picsList.get(position).toString();

            return new PictrueFragment(show_resId);
        }

        @Override
        public int getCount() {
            return picsList.size();
            //return resId.length;
        }
    }

}
