package com.zhuolang.main.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuolang.main.R;

/**
 * Created by wnf on 2016/10/29.
 * 首页界面fragment
 */


public class HomepageTabFragment extends Fragment implements View.OnClickListener {

    private View view = null;

    private String type;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        view = new View(getActivity());
        view = inflater.inflate(R.layout.homepage, container, false);
        Log.d("activityID", "这个是HomepageTabFragment----------:" + this.toString());
        initView(view);
        return view;
    }

    /*
     *初始化数据
     */
    private void initView(View view) {

    }

    @Override
    public void onClick(View v) {

    }



}
