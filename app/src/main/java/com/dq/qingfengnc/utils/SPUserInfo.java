package com.dq.qingfengnc.utils;

import android.app.Application;
import android.text.TextUtils;

import com.dq.qingfengnc.application.MyApplication;
import com.dq.qingfengnc.bean.account.Login;

/**
 * Description：
 * Created by jingang on 2017/11/17.
 */

public class SPUserInfo {
    Application app;

    public SPUserInfo(Application application) {
        this.app = application;
    }

    /*获取用户登录状态*/
    public String getLogin() {
        android.content.SharedPreferences sp = app.getSharedPreferences("loginList", 0);
        return sp.getString("login", "");
    }

    /*存储用户登录状态*/
    public boolean saveLogin(String info) {
        android.content.SharedPreferences sp = app.getSharedPreferences("loginList", 0);
        return sp.edit().putString("login", info).commit();
    }

    /*获取用户登录返回信息*/
    public String getLoginReturn() {
        android.content.SharedPreferences sp = app.getSharedPreferences("loginReturnList", 0);
        return sp.getString("login", "");
    }

    /*存储用户登录返回信息*/
    public boolean saveLoginReturn(String info) {
        android.content.SharedPreferences sp = app.getSharedPreferences("loginReturnList", 0);
        //更新uid
        if (!TextUtils.isEmpty(info)) {
            MyApplication.uid = GsonUtil.gsonIntance().gsonToBean(info, Login.class).getData().getUid();
        }

        return sp.edit().putString("login", info).commit();
    }

}
