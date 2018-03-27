package com.dq.qingfengnc.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.dq.qingfengnc.R;
import com.dq.qingfengnc.adapter.bbs.ForumAdapter;
import com.dq.qingfengnc.application.MyApplication;
import com.dq.qingfengnc.base.BaseFragment;
import com.dq.qingfengnc.bean.bbs.BbsList;
import com.dq.qingfengnc.ui.ForumDetailActivity;
import com.dq.qingfengnc.utils.CodeUtils;
import com.dq.qingfengnc.utils.GsonUtil;
import com.dq.qingfengnc.utils.HttpPath;
import com.dq.qingfengnc.utils.HttpxUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 论坛—首页
 * Created by jingang on 2018/3/20.
 */

public class ForumFragment extends BaseFragment {
    @Bind(R.id.plv)
    PullToRefreshListView plv;
    @Bind(R.id.search_result_lv)
    LinearLayout searchResultLv;

    private ForumAdapter mAdapter;
    private List<BbsList.DataBean.ListBean> list = new ArrayList<>();
    private String bbstypeid = "";
    private int page = 1, pagesize = 20;
    //当前选择的item
    private int numItem = 0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm_forum_home, null);
        ButterKnife.bind(this, view);

        initPlv();
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (getArguments() != null) {
                bbstypeid = getArguments().getString("bbstypeid");
                if (!"".equals(bbstypeid)) {
                    page = 1;
                    getBbsList(bbstypeid, "", "", "");
                }
            }
        }
    }

    public void initPlv() {
        mAdapter = new ForumAdapter(list, getActivity());
        plv.setAdapter(mAdapter);
        plv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                numItem = position - 1;
                BbsList.DataBean.ListBean listBean = list.get(position-1);
                addRead(listBean.getId());
                Intent intent = new Intent(getActivity(),ForumDetailActivity.class);
                if(!TextUtils.isEmpty(listBean.getId())){
                    intent.putExtra("id",listBean.getId());
                }
                if(!TextUtils.isEmpty(listBean.getMid())){
                    intent.putExtra("mid", listBean.getMid());
                }
                if(!TextUtils.isEmpty(listBean.getRname())){
                    intent.putExtra("rname", listBean.getRname());
                }
                if(!TextUtils.isEmpty(listBean.getBbstitle())){
                    intent.putExtra("title",listBean.getBbstitle());
                }
                if(!TextUtils.isEmpty(listBean.getAddtime())){
                    intent.putExtra("addtime",listBean.getAddtime());
                }
                intent.putExtra("zanis", listBean.getZanis());
                intent.putExtra("recordis", listBean.getRecordis());
                Log.e("mmmmmmm1111",listBean.getRecordis());
                startActivityForResult(intent,0);
            }
        });
        plv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page = 1;
                getBbsList(bbstypeid, "", "", "");
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                getBbsList(bbstypeid, "", "", "");
            }
        });
    }

    /**
     * 获取帖子列表
     * Page		当前页数  可选  默认第一页
     * Pagesize  每页显示条数  可选 默认前20条
     * Bbstypeid	帖子分类	可选
     * Mid			会员编号	可选
     * Id			帖子编号	可选
     * Bestid		精选标记（0非精选，1精选）  可选
     */
    public void getBbsList(String bbstypeid, String mid, String id, String bestid) {
        Map<String, String> map = new HashMap<>();
        map.put("page", "" + page);
        map.put("pagesize", "" + pagesize);
        map.put("bbstypeid", bbstypeid);
        map.put("uid", MyApplication.uid);
//        map.put("mid", mid);
//        map.put("id", id);
//        map.put("bestis", bestid);

        Log.e("FMForum", "BBS_BBSTList-map" + map.toString());
        HttpxUtils.Get(HttpPath.HEADER_LIUHE + HttpPath.BBS_BBSLIST, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("FMForum", "BBS_BBSTList" + result);
                BbsList data = GsonUtil.gsonIntance().gsonToBean(result, BbsList.class);
                if (data.getStatus() == 1) {

                    if (page == 1) {
                        list.clear();
                    }
                    if (data.getData().getList().size() == 0) {
                        if (page == 1) {
                            toast("还没有数据");
                        } else {
                            toast("已经到底了");
                        }
                    } else {
                        list.addAll(data.getData().getList());
                        page += 1;
                    }
                    mAdapter.notifyDataSetChanged();
                    plv.onRefreshComplete();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    /**
     * 添加浏览量
     * @param id:帖子id
     */
    public void addRead(String id){
        Map<String, String> map = new HashMap<>();
        map.put("bbsid", id);

        Log.e("FMForum", "BBS_BBSTList-map" + map.toString());
        HttpxUtils.Get(HttpPath.HEADER_LIUHE + HttpPath.BBS_SETHITS, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("FMForum", "BBS_BBSTAddRead" + result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    @Override
    protected void lazyLoad() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == CodeUtils.FORUM_DETAIL_ZAN) {
            boolean result_zan = data.getBooleanExtra("result_zan",false);
            boolean result_coolect = data.getBooleanExtra("result_collect",false);
            toast(result_zan+"    "+result_coolect);
            if (result_zan && "0".equals(list.get(numItem).getZanis())){
                //点赞并且之前没赞过
                list.get(numItem).setZanis("1");
                list.get(numItem).setZan(""+(Integer.parseInt(list.get(numItem).getZan())+1));
            }
            //收藏
            list.get(numItem).setRecordis(result_coolect?"1":"0");
            Log.e("mmmmmmm3333",result_coolect?"1":"0");
            Log.e("mmmmmmm444",list.get(numItem).getRecordis());
            mAdapter.notifyDataSetChanged();
        }
    }
}
