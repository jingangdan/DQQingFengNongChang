package com.dq.qingfengnc.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dq.qingfengnc.R;
import com.dq.qingfengnc.adapter.SimpleFragmentPagerAdapter;
import com.dq.qingfengnc.base.BaseFragment;
import com.dq.qingfengnc.bean.bbs.BbsTypeList;
import com.dq.qingfengnc.ui.PublishedArticlesActivity;
import com.dq.qingfengnc.utils.GsonUtil;
import com.dq.qingfengnc.utils.HttpPath;
import com.dq.qingfengnc.utils.HttpxUtils;
import com.dq.qingfengnc.view.NoScrollViewPager;

import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 发现
 * Created by jingang on 2018/2/5.
 */
public class FMForum extends BaseFragment implements ViewPager.OnPageChangeListener {

    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.tb_noScrollViewPage)
    NoScrollViewPager tbNoScrollViewPage;
    @Bind(R.id.tv_forum_title)
    TextView tvForumTitle;
    @Bind(R.id.tv_forum_publish)
    TextView tvForumPublish;



    private String[] titles;
    private List<Fragment> fragments = new ArrayList<>();
    private ForumFragment mFragment;

    private SimpleFragmentPagerAdapter sfpAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm_find, container, false);
        ButterKnife.bind(this, view);
        tvForumTitle.setText("老友记");

        getForum("0", "0");

        return view;
    }

    /**
     * 获取帖子分类列表
     *
     * @param id
     * @param parentid
     */
    public void getForum(String id, String parentid) {
        Map<String, String> map = new HashMap<>();
        // map.put("id", id);
        map.put("parentid", parentid);

        HttpxUtils.Get(HttpPath.HEADER_LIUHE + HttpPath.BBS_BBSTYPE, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("FMForum", "BBS_BBSTYPE" + result);
                BbsTypeList data = GsonUtil.gsonIntance().gsonToBean(result, BbsTypeList.class);
                if (data.getStatus() == 1) {
                    titles = new String[data.getData().getList().size()];
                    for (int i = 0; i < data.getData().getList().size(); i++) {
                        titles[i] = data.getData().getList().get(i).getTypename();
                        mFragment = new ForumFragment();//其他
                        Bundle bundle = new Bundle();
                        bundle.putString("bbstypeid", data.getData().getList().get(i).getId());
                        mFragment.setArguments(bundle);
                        fragments.add(mFragment);
                    }
                }

                setTabLayout();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("FMForum ", "获取失败" + ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    public void setTabLayout() {
        Log.e("FMForum", "" + titles.toString());
        sfpAdapter = new SimpleFragmentPagerAdapter(getActivity().getSupportFragmentManager(), getActivity(), fragments, titles);
        tbNoScrollViewPage.setAdapter(sfpAdapter);
        //tbNoScrollViewPage.setCurrentItem(page);

        tbNoScrollViewPage.setOffscreenPageLimit(titles.length);
        tbNoScrollViewPage.setOnPageChangeListener(this);
        tabLayout.setupWithViewPager(tbNoScrollViewPage);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    protected void lazyLoad() {

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

    @OnClick(R.id.tv_forum_publish)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_forum_publish:
                Intent intent = new Intent(getActivity(),PublishedArticlesActivity.class);
                startActivity(intent);
                break;
        }
    }
}
