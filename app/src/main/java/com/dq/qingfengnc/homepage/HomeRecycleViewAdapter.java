package com.dq.qingfengnc.homepage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dq.qingfengnc.Interface.HomePageInterface;
import com.dq.qingfengnc.R;
import com.dq.qingfengnc.adapter.index.AppimglistAdapter;
import com.dq.qingfengnc.adapter.index.GoodsListAdapter;
import com.dq.qingfengnc.adapter.index.MenuAdapter;
import com.dq.qingfengnc.bean.index.Index2;
import com.dq.qingfengnc.rollpagerview.ImageLoopAdapter;
import com.dq.qingfengnc.rollpagerview.OnItemClickListener;
import com.dq.qingfengnc.rollpagerview.RollPagerView;
import com.dq.qingfengnc.ui.GoodsDetailsActivity;
import com.dq.qingfengnc.view.MarqueTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 * Created by jingang on 2018/02/01.
 */

public class HomeRecycleViewAdapter extends RecyclerView.Adapter {

//    /**
//     * 类型1：搜索
//     */
//    public static final int TYPE_SEARCG = 0;
//
//    /**
//     * 类型2：banner
//     */
//    public static final int TYPE_BANNER = 1;
//    /**
//     * 类型3：菜单
//     */
//    public static final int TYPE_MENU = 2;
//    /**
//     * 类型4：图片组
//     */
//    public static final int TYPE_IMGLIST = 3;
//    /**
//     * 类型5：商品列表
//     */
//    public static final int TYPE_GOODSLIST = 4;

    /**
     * 类型：banner appimglist menu notice glist
     */
    public static final int TYPE_BANNER = 1;
    public static final int TYPE_APPIMGLIST = 2;
    public static final int TYPE_MENU = 3;
    public static final int TYPE_NOTICE = 4;
    public static final int TYPE_GLIST = 0;


    /**
     * 当前类型
     */
    public int currentType = TYPE_GLIST;

    private final Context mContext;
    private List<Index2.DataBean> dataList;
    /**
     * 以后用它来初始化布局
     */
    private final LayoutInflater mLayoutInflater;

    GridLayoutManager mManager;
    private Intent intent;
    private HomePageInterface hpInterface;

    public HomeRecycleViewAdapter(Context mContext, List<Index2.DataBean> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;

        //以后用它来初始化布局
        mLayoutInflater = LayoutInflater.from(mContext);

        mManager = null;
        intent = null;
    }

    public void setHpInterface(HomePageInterface hpInterface) {
        this.hpInterface = hpInterface;
    }

    /**
     * 相当于getView创建ViewHolder布局
     *
     * @param parent
     * @param viewType 当前的类型
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

//        if (viewType == TYPE_SEARCG) {
//            return new SearchViewHolder(mContext, mLayoutInflater.inflate(R.layout.layout_search, parent, false));
//        } else
//
        if (viewType == TYPE_BANNER) {
            return new BannerViewHolder(mContext, mLayoutInflater.inflate(R.layout.layout_banner, parent, false));
        } else if (viewType == TYPE_APPIMGLIST) {
            return new ImgListViewHolder(mContext, mLayoutInflater.inflate(R.layout.layout_imglist, parent, false));
        } else if (viewType == TYPE_MENU) {
            return new MenuViewHolder(mContext, mLayoutInflater.inflate(R.layout.layout_menu, parent, false));
        } else if (viewType == TYPE_NOTICE) {
            return new NoticeViewHolder(mContext, mLayoutInflater.inflate(R.layout.layout_notice, parent, false));
        } else if (viewType == TYPE_GLIST) {
            return new GoodsListViewHolder(mContext, mLayoutInflater.inflate(R.layout.layout_goodslist, parent, false));
        }
        return null;
    }

    /**
     * 相当于getView中的绑定数据模块
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_BANNER) {
            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
            bannerViewHolder.setData(dataList.get(position).getChild());
        }
        if (getItemViewType(position) == TYPE_APPIMGLIST) {
            ImgListViewHolder imgListViewHolder = (ImgListViewHolder) holder;
            imgListViewHolder.setData(dataList.get(position).getChild());
        }
        if (getItemViewType(position) == TYPE_MENU) {
            MenuViewHolder menuViewHolder = (MenuViewHolder) holder;
            menuViewHolder.setData(dataList.get(position).getChild());
        }
        if (getItemViewType(position) == TYPE_NOTICE) {
            NoticeViewHolder noticeViewHolder = (NoticeViewHolder) holder;
            noticeViewHolder.setData(dataList.get(position).getChild());
        }
        if (getItemViewType(position) == TYPE_GLIST) {
            GoodsListViewHolder goodsListViewHolder = (GoodsListViewHolder) holder;
            goodsListViewHolder.setData(dataList.get(position).getChild());
        }
    }

    /**
     * 总共有多少个item
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    /**
     * 得到类型
     */
    @Override
    public int getItemViewType(int position) {
        if (dataList.get(position).getModule().equals("banner")) {
            currentType = TYPE_BANNER;
        }
        if (dataList.get(position).getModule().equals("appimglist")) {
            currentType = TYPE_APPIMGLIST;
        }
        if (dataList.get(position).getModule().equals("menu")) {
            currentType = TYPE_MENU;
        }
        if (dataList.get(position).getModule().equals("notice")) {
            currentType = TYPE_NOTICE;
        }
        if (dataList.get(position).getModule().equals("glist")) {
            currentType = TYPE_GLIST;
        }
        return currentType;
    }

    class SearchViewHolder extends RecyclerView.ViewHolder {
        private final Context mContext;
        private LinearLayout linearLayout;
        private ImageView iv_search;
        private EditText editText;

        public SearchViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            linearLayout = itemView.findViewById(R.id.lin_hp_search);
            iv_search = itemView.findViewById(R.id.iv_hp_sreach);
            editText = itemView.findViewById(R.id.et_hp_search);
        }

        public void setData() {
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //暴露search接口
                    hpInterface.doSearch();
                }
            });

            editText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //暴露search接口
                    hpInterface.doSearch();
                }
            });

        }
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        private Context mContext;
        RollPagerView rollPagerView;

        public BannerViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            rollPagerView = itemView.findViewById(R.id.rollPagerView);

            DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
            int width = dm.widthPixels;
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) rollPagerView.getLayoutParams();
            params.height = width / 3;//宽高比 1:3
            rollPagerView.setLayoutParams(params);
        }

        public void setData(final List<Index2.DataBean.ChildBean> bannerBeans) {
            rollPagerView.setAdapter(new ImageLoopAdapter(rollPagerView, mContext, bannerBeans));
            rollPagerView.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    //暴露banner接口
                    hpInterface.doHomePage(
                            position,
                            bannerBeans.get(position).getTitle(),
                            bannerBeans.get(position).getType(),
                            bannerBeans.get(position).getContent()
                    );
                }
            });
        }

    }

    class MenuViewHolder extends RecyclerView.ViewHolder {

        private final Context mContext;
        private RecyclerView recyclerView;

        public MenuViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            recyclerView = (RecyclerView) itemView.findViewById(R.id.rv_menu);
        }

        public void setData(final List<Index2.DataBean.ChildBean> menuBeans) {
            mManager = new GridLayoutManager(mContext, 5, GridLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(mManager);
            final MenuAdapter menuAdapter = new MenuAdapter(mContext, menuBeans);
            recyclerView.setAdapter(menuAdapter);

            menuAdapter.setOnItemClickListener(new com.dq.qingfengnc.Interface.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    hpInterface.doHomePage(
                            position,
                            menuBeans.get(position).getTitle(),
                            menuBeans.get(position).getType(),
                            menuBeans.get(position).getContent()
                    );
                }
            });

        }
    }

    class ImgListViewHolder extends RecyclerView.ViewHolder {
        private Context mContext;
        private RecyclerView recyclerView;

        public ImgListViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            recyclerView = (RecyclerView) itemView.findViewById(R.id.rv_imglist);
        }

        public void setData(final List<Index2.DataBean.ChildBean> appimglistBeans) {

            mManager = new GridLayoutManager(mContext, 4, GridLayoutManager.VERTICAL, false);
            mManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    String imgwidth = appimglistBeans.get(position).getWidth();
                    if (imgwidth.equals("50")) {
                        return 2;
                    } else if (imgwidth.equals("100")) {
                        return 4;
                    } else if (imgwidth.equals("25")) {
                        return 1;
                    }
                    return 1;
                }
            });

            recyclerView.setLayoutManager(mManager);
            final AppimglistAdapter appimglistAdapter = new AppimglistAdapter(mContext, appimglistBeans);
            recyclerView.setAdapter(appimglistAdapter);

            appimglistAdapter.setOnItemClickListener(new com.dq.qingfengnc.Interface.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    hpInterface.doHomePage(
                            position,
                            appimglistBeans.get(position).getTitle(),
                            appimglistBeans.get(position).getType(),
                            appimglistBeans.get(position).getContent()
                    );
                }
            });

        }
    }

    class GoodsListViewHolder extends RecyclerView.ViewHolder {

        private final Context mContext;
        private RecyclerView recyclerView;

        public GoodsListViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            recyclerView = (RecyclerView) itemView.findViewById(R.id.rv_goodslist);
        }

        public void setData(final List<Index2.DataBean.ChildBean> glistBeans) {
            mManager = new GridLayoutManager(mContext, 2, GridLayoutManager.VERTICAL, false);
            mManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (!TextUtils.isEmpty(glistBeans.get(position).getWidth())) {
                        String imgwidth = glistBeans.get(position).getWidth();
                        if (imgwidth.equals("50")) {
                            return 1;
                        } else if (imgwidth.equals("100")) {
                            return 2;
                        }
                    }
                    return 1;
                }
            });
            recyclerView.setLayoutManager(mManager);

            GoodsListAdapter goodsListAdapter = new GoodsListAdapter(mContext, glistBeans);
            recyclerView.setAdapter(goodsListAdapter);

            goodsListAdapter.setOnItemClickListener(new com.dq.qingfengnc.Interface.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    intent = new Intent(mContext, GoodsDetailsActivity.class);
                    intent.putExtra("gid", glistBeans.get(position).getId());
                    mContext.startActivity(intent);
                }
            });
        }
    }

    class NoticeViewHolder extends RecyclerView.ViewHolder {
        private final Context mContext;
        private MarqueTextView marqueTextView;
        private List<String> str_marqueeView = new ArrayList<>();

        public NoticeViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            marqueTextView = itemView.findViewById(R.id.marqueTextView);
        }

        public void setData(List<Index2.DataBean.ChildBean> noticeBeans) {
            str_marqueeView.add(noticeBeans.get(0).getTitle());
            str_marqueeView.add(noticeBeans.get(0).getTitle());
            str_marqueeView.add(noticeBeans.get(0).getTitle());

            marqueTextView.startWithList(str_marqueeView);

        }
    }

}


