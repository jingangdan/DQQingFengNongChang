package com.dq.qingfengnc.ui.memcen;

import android.os.Bundle;

import com.dq.qingfengnc.R;
import com.dq.qingfengnc.base.BaseActivity;

/**
 * Description：绑定手机
 * Created by jingang on 2017/11/25.
 */

public class MobileActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile);
    }

    @Override
    protected void initWidght() {
        super.initWidght();
        setTitleName("绑定手机");
    }
}
