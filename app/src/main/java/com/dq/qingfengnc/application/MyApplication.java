package com.dq.qingfengnc.application;

import android.app.Application;

import com.dq.qingfengnc.bean.account.Login;
import com.dq.qingfengnc.utils.GsonUtil;
import com.dq.qingfengnc.utils.SPUserInfo;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Description：
 * Created by jingang on 2017/11/18.
 */

public class MyApplication extends Application {
    // 微信开放平台appid
    public static final String WX_APP_ID = "wxf00c62b2cd722747".trim();
    public static final String WX_APP_SECRET = "4a2a9c4af1f023558413c7da331ddc74".trim();
    private static MyApplication ins;

    public static IWXAPI api;

    public static String uid = "";
    public static int bbs_iconSize = 60;

    public static MyApplication getIns() {
        return ins;
    }

    /**
     * set Application instance
     */
    private void setIns() {
        ins = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        setIns();
//        regToWx();
        setWxApp();

        getUid();
    }

    public void setWxApp() {
        api = WXAPIFactory.createWXAPI(this, WX_APP_ID, true);
        api.registerApp(WX_APP_ID);
    }

    /**
     * 将应用的注册到微信
     */
    private void regToWx() {
        // 通过WXAPIFactory工厂，获取IWXAPI的实例
        IWXAPI wxApi = WXAPIFactory.createWXAPI(this, WX_APP_ID, true);
        // 将应用的注册到微信
        wxApi.registerApp(WX_APP_ID);
    }

    /**
     *  获取uid
     * @return:uid
     */
    public void getUid(){
        //
        SPUserInfo spUserInfo = new SPUserInfo(this);
        if (spUserInfo.getLogin().equals("1")) {
            if (!(spUserInfo.getLoginReturn().equals(""))) {
                Login login = GsonUtil.gsonIntance().gsonToBean(spUserInfo.getLoginReturn(), Login.class);
                uid =  login.getData().getUid();
            }
        }
    }
}

