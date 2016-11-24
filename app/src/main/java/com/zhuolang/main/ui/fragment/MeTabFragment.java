package com.zhuolang.main.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zhuolang.main.R;

/**
 * Created by wnf on 2016/10/29.
 * “我”界面的fragment
 */


public class MeTabFragment extends Fragment implements View.OnClickListener{

    private View view = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){

        view=new View(getActivity());

        view = inflater.inflate(R.layout.me, container, false);
        Log.d("activityID", "这个是meTabFragment----------:" + this.toString());

        initView(view);
        return view;

    }

    private void initView(View view) {

    }

    @Override
    public void onClick(View v) {

    }


}
