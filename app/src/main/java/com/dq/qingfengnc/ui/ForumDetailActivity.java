package com.dq.qingfengnc.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dq.qingfengnc.R;
import com.dq.qingfengnc.adapter.bbs.FdCommentAdapter;
import com.dq.qingfengnc.application.MyApplication;
import com.dq.qingfengnc.base.BaseActivity;
import com.dq.qingfengnc.bean.account.Login;
import com.dq.qingfengnc.bean.addr.AddrReturn;
import com.dq.qingfengnc.bean.bbs.BbsDetail;
import com.dq.qingfengnc.bean.bbs.FdComment;
import com.dq.qingfengnc.utils.CodeUtils;
import com.dq.qingfengnc.utils.DateUtils;
import com.dq.qingfengnc.utils.GsonUtil;
import com.dq.qingfengnc.utils.HttpPath;
import com.dq.qingfengnc.utils.HttpxUtils;
import com.dq.qingfengnc.utils.MD5Util;
import com.dq.qingfengnc.utils.MyListView;
import com.dq.qingfengnc.utils.SPUserInfo;

import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 帖子详情
 * Created by jingang on 2018/3/20.
 */

public class ForumDetailActivity extends BaseActivity {
    @Bind(R.id.tv_fd_title)
    TextView tvFdTitle;
    @Bind(R.id.tv_fd_addtime)
    TextView tvFdAddtime;
    @Bind(R.id.wv_forum_detail)
    WebView wvForumDetail;
    @Bind(R.id.lin_gd_content)
    LinearLayout linGdContent;
    @Bind(R.id.et_fd)
    EditText etFd;
    @Bind(R.id.tv_fd_comment)
    TextView tvFdComment;
    @Bind(R.id.tv_fd_zan)
    TextView tvFdZan;
    @Bind(R.id.tv_fd_record)
    TextView tvFdRecord;
    @Bind(R.id.lin_fd_header)
    LinearLayout linFdHeader;
    @Bind(R.id.tv_fd_rname)
    TextView tvFdRname;
    @Bind(R.id.mlv_fd_comment)
    MyListView mlvFdComment;

    private WebSettings webSettings;
    private String bbsid = "", mid = "", rname = "'", title = "", addtime = "", content = "";
    private int page = 1, pagesize = 20;

    private FdCommentAdapter commentAdapter;
    private List<FdComment.DataBean.ListBean> commentList = new ArrayList<>();

    private SPUserInfo spUserInfo;
    private String phone = "", token = "", uid = "";

    private boolean isZan = false,isCoolection = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_detail);
        ButterKnife.bind(this);

        initComment();

        bbsid = getIntent().getStringExtra("id");
        mid = getIntent().getStringExtra("mid");
        rname = getIntent().getStringExtra("rname");
        title = getIntent().getStringExtra("title");
        addtime = getIntent().getStringExtra("addtime");
        isZan =  "1".equals(getIntent().getStringExtra("zanis"))?true:false;
        isCoolection = "1".equals(getIntent().getStringExtra("recordis"))?true:false;
        Log.e("mmmmmmm2222",getIntent().getStringExtra("recordis"));
        if (!TextUtils.isEmpty(title)) {
            tvFdTitle.setText(title);
        }
        if (!TextUtils.isEmpty(addtime)) {
            tvFdAddtime.setText(DateUtils.time(addtime));
        }
        if (!TextUtils.isEmpty(rname)) {
            tvFdRname.setText(rname);
        }
        if (!TextUtils.isEmpty(bbsid)) {
            getComment();
        }
        //点赞，收藏
        tvFdZan.setCompoundDrawables(null,getDrawableTop(
                isZan?R.mipmap.icon_lt_dz_ed:R.mipmap.icon_lt_dz_nor),null,null);
        tvFdRecord.setCompoundDrawables(null,getDrawableTop(
                isCoolection?R.mipmap.icon_lt_sc_ed:R.mipmap.icon_lt_sc_nor),null,null);

        getBbsDetail();
    }

    /*判断登录状态*/
    public boolean isLogin() {
        spUserInfo = new SPUserInfo(getApplication());
        if (spUserInfo.getLogin().equals("1")) {
            if (!(spUserInfo.getLoginReturn().equals(""))) {
                Login login = GsonUtil.gsonIntance().gsonToBean(spUserInfo.getLoginReturn(), Login.class);
                phone = login.getData().getPhone();
                token = login.getData().getToken();
                uid = login.getData().getUid();

                return true;
            }
        }
        return false;
    }

    /*初始化评论列表*/
    public void initComment() {
        commentAdapter = new FdCommentAdapter(commentList, this);
        mlvFdComment.setAdapter(commentAdapter);
    }

    /*帖子内容*/
    public void getWebHTML(String html_bady) {
        wvForumDetail.getSettings().setJavaScriptEnabled(true);
        webSettings = wvForumDetail.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setJavaScriptEnabled(false);

        String head = "<head>" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> " +
                "<style>img{max-width: 100%; width:auto; height:auto;}</style>" +
                "</head>";
        String html = "<html>" + head + "<body>" + html_bady + "</body></html>";

        wvForumDetail.loadDataWithBaseURL(HttpPath.IMG_LIUHE, html, "text/html", "utf-8", null);

    }

    /*获取评论列表*/
    public void getComment() {
        Map<String, String> map = new HashMap<>();
        map.put("page", "" + page);
        map.put("pagesize", "" + pagesize);
        map.put("bbsid", bbsid);
        HttpxUtils.Get(HttpPath.HEADER_LIUHE + HttpPath.BBS_BBSCOMMENT, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("FMForum_Comment", result);
                FdComment comment = GsonUtil.gsonIntance().gsonToBean(result, FdComment.class);
                if (comment.getStatus() == 1) {
                    commentList.clear();
                    commentList.addAll(comment.getData().getList());
                    commentAdapter.notifyDataSetChanged();
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

    /*添加评论*/
    public void setComment(String comment) {
        Map<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("bbsid", bbsid);
        map.put("phone", phone);
        map.put("timestamp", "" + (System.currentTimeMillis() / 1000));
        map.put("token", token);
        map.put("comment", comment);
//        final String PATH = "bbsid=" + bbsid + "&comment=" + comment + "&mid=" + mid + "&phone=" + phone + "&timestamp=" + (System.currentTimeMillis() / 1000) + "&token=" + token;

        String sign = "bbsid=" + bbsid + "&comment=" + etFd.getText().toString()+ "&phone=" + phone + "&timestamp=" + (System.currentTimeMillis() / 1000) + "&token=" + token + "uid=" + uid  + "&key=ivKDDIZHF2b0Gjgvv2QpdzfCmhOpya5k";
        map.put("sign", MD5Util.getMD5String(sign));


        HttpxUtils.Get(HttpPath.HEADER_LIUHE + HttpPath.BBS_ADDCOMMENT,
                map,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("FMForum_add_Comment", result);
                        AddrReturn addrReturn = GsonUtil.gsonIntance().gsonToBean(result, AddrReturn.class);
                        if (addrReturn.getStatus() == 1) {
                            toast("" + addrReturn.getData());
                            getComment();
                            etFd.setText("");
                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("FMForum_add_Comment", "添加失败" + ex.toString());
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });
    }

    public void setZan() {
        Map<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("bbsid", bbsid);
        map.put("phone", phone);
        map.put("timestamp", "" + (System.currentTimeMillis() / 1000));
        map.put("token", token);

        String sign = "bbsid=" + bbsid + "&phone=" + phone + "&timestamp=" + (System.currentTimeMillis() / 1000) + "&token=" + token + "uid=" + uid + "&key=ivKDDIZHF2b0Gjgvv2QpdzfCmhOpya5k";
        map.put("sign", MD5Util.getMD5String(sign));

        Log.e("ADD_COLLECTION-map", map.toString());
        HttpxUtils.Get(HttpPath.HEADER_LIUHE + HttpPath.BBS_SETZAN,
                map,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("FMForum_add_Zan", result);
                        AddrReturn addrReturn = GsonUtil.gsonIntance().gsonToBean(result, AddrReturn.class);
                        if (addrReturn.getStatus() == 1) {
                            toast("" + addrReturn.getData());
                            getComment();
                            etFd.setText("");
                            isZan = true;
                            setResults();
                            //
                            tvFdZan.setCompoundDrawables(null,getDrawableTop(R.mipmap.icon_lt_dz_ed),null,null);
                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("FMForum_add_Comment", "添加失败" + ex.toString());
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
     *
     */
    public void setResults(){
        Intent intent = new Intent();
        intent.putExtra("result_zan",isZan);
        intent.putExtra("result_collect",isCoolection);
        setResult(CodeUtils.FORUM_DETAIL_ZAN,intent);
    }

    @OnClick({R.id.tv_fd_comment, R.id.tv_fd_zan, R.id.tv_fd_record})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_fd_comment:
                if (isLogin()) {
                    if (!TextUtils.isEmpty(etFd.getText().toString())) {
//                        try {
//                            setComment(URLEncoder.encode(etFd.getText().toString(), "UTF-8"));
//                        } catch (UnsupportedEncodingException e) {
//                            e.printStackTrace();
//                        }
                        setComment(etFd.getText().toString());
                    }
                } else {
                    dialog();
                }

                break;
            case R.id.tv_fd_zan:
                if (isLogin()) {
                    setZan();
                } else {
                    dialog();
                }
                break;
            case R.id.tv_fd_record:
                if (isLogin()) {
                    if (isCoolection){
                        removeCollection();
                    }else {
                        addCollection();
                    }
                } else {
                    dialog();
                }
                break;
        }
    }

    /**
     * 收藏帖子
     */
    public void addCollection(){
        Map<String, String> map = new HashMap<>();
        map.put("id", bbsid);
        map.put("phone", phone);
        map.put("timestamp", "" + (System.currentTimeMillis() / 1000));
        map.put("token", token);
        map.put("type", "bbs");
        String sign = "id=" + bbsid + "&phone=" + phone + "&timestamp=" + (System.currentTimeMillis() / 1000) + "&token=" + token +"&type=bbs" + "&key=ivKDDIZHF2b0Gjgvv2QpdzfCmhOpya5k";
        map.put("sign", MD5Util.getMD5String(sign));

        Log.e("ADD_COLLECTION-map", map.toString());
        HttpxUtils.Get(HttpPath.HEADER_LIUHE + HttpPath.BBS_ADD_COLLECTION, map,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("FMForum_ADD_COLLECTION", result);
                        //
                        AddrReturn addrReturn = GsonUtil.gsonIntance().gsonToBean(result, AddrReturn.class);
                        if (addrReturn.getStatus() == 1) {
                            isCoolection = true;
                            toast("" + addrReturn.getData());
                            tvFdRecord.setCompoundDrawables(null,getDrawableTop(R.mipmap.icon_lt_sc_ed),null,null);
                            setResults();
                        }
                        if (addrReturn.getStatus() == 0){
                            toast("" + addrReturn.getData());
                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("FMForum_ADD_COLLECTION", "添加失败" + ex.toString());
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
     * 取消收藏帖子
     */
    public void removeCollection(){
        Map<String, String> map = new HashMap<>();
        map.put("id", bbsid);
        map.put("phone", phone);
        map.put("timestamp", "" + (System.currentTimeMillis() / 1000));
        map.put("token", token);
        map.put("type", "bbs");
        String sign = "id=" + bbsid + "&phone=" + phone + "&timestamp=" + (System.currentTimeMillis() / 1000) + "&token=" + token +"&type=bbs" + "&key=ivKDDIZHF2b0Gjgvv2QpdzfCmhOpya5k";
        map.put("sign", MD5Util.getMD5String(sign));

        Log.e("ADD_COLLECTION-map", map.toString());

        HttpxUtils.Get(HttpPath.HEADER_LIUHE + HttpPath.BBS_DEL_COLLECTION,
                map,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.e("FMForum_DEL_COLLECTION", result);
                        AddrReturn addrReturn = GsonUtil.gsonIntance().gsonToBean(result, AddrReturn.class);
                        if (addrReturn.getStatus() == 1) {
                            isCoolection = false;
                            toast("" + addrReturn.getData());
                            tvFdRecord.setCompoundDrawables(null,getDrawableTop(R.mipmap.icon_lt_sc_nor),null,null);
                            setResults();
                        }
                        if (addrReturn.getStatus() == 0){
                            toast("" + addrReturn.getData());
                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.e("FMForum_DEL_COLLECTION", "添加失败" + ex.toString());
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
     * 获取帖子详情
     */
    public void getBbsDetail() {
        Map<String, String> map = new HashMap<>();
        map.put("id", bbsid);

        Log.e("FMForum", "BBS_BBSTList-map" + map.toString());
        HttpxUtils.Get(HttpPath.HEADER_LIUHE + HttpPath.BBS_BBSLIST, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("FMForum", "BBS_BBSTList" + result);
                BbsDetail data = GsonUtil.gsonIntance().gsonToBean(result, BbsDetail.class);
                if (data.getStatus() == 1) {
                    content = data.getData().getList().get(0).getContent();
                    if (!TextUtils.isEmpty(content)) {
                        getWebHTML(content);
                    }
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
     * 获取drawable
     * @param icon
     */
    public Drawable getDrawableTop(int icon){
        Drawable drawable = ContextCompat.getDrawable(this, icon);
        //为drawable设置宽高,不设置则不显示
        drawable.setBounds(0, 0, MyApplication.bbs_iconSize, MyApplication.bbs_iconSize);
        return drawable;
    }

    /*弹出框*/
    protected void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("确定登录？");
        builder.setTitle("提示：未登录");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent intent = new Intent(ForumDetailActivity.this, LoginActivity.class);
                startActivityForResult(intent, CodeUtils.FORUM_DETAIL);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        builder.create().show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CodeUtils.FORUM_DETAIL) {
            if (resultCode == CodeUtils.LOGIN) {
                isLogin();
            }
        }
    }
}
