package com.dq.qingfengnc.view.goodsdetails;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dq.qingfengnc.R;
import com.dq.qingfengnc.utils.ImageUtils;


/**
 * 显示大图的实现，并且可以放大缩小
 *
 * @author http://yecaoly.taobao.com
 */
@SuppressLint("ValidFragment")
public class PictrueFragment extends Fragment {

    //private int resId;
    private String imgUrl = "";

//	@SuppressLint("ValidFragment")
//	public PictrueFragment(int resId){
//
//		this.resId=resId;
//	}

    public PictrueFragment(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.scale_pic_item, null);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
        initView(view);
        return view;
    }

    private void initView(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.scale_pic_item);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
        //imageView.setImageResource(resId);

        ImageUtils.loadIntoUseFitWidth(getActivity(),
                imgUrl,
                R.mipmap.icon_empty,
                R.mipmap.icon_error,
                imageView);

    }


}
