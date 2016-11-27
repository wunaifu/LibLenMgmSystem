package com.zhuolang.main.ui.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhuolang.main.R;
import com.zhuolang.main.adapter.BookListAdapter;
import com.zhuolang.main.common.APPConfig;
import com.zhuolang.main.database.MyDatabaseHelper;
import com.zhuolang.main.model.Book;
import com.zhuolang.main.ui.activity.BookListDetailActivity;
import com.zhuolang.main.ui.activity.LendBookListDetailActivity;
import com.zhuolang.main.utils.SharedPrefsUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wnf on 2016/10/29.
 * “分享圈”界面的fragment
 */

public class ShareTabFragment extends Fragment implements AdapterView.OnItemClickListener{

    private View view = null;
    private EditText et_info;
    private TextView tv_byname;
    private TextView tv_byid;
    private TextView tv_hint;
    private String info;
    private int userType;
    private MyDatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private BookListAdapter adapter;
    private List<Book> bookList = new ArrayList<>();

    private ListView listView;
    private LinearLayout ll_share;
    private LinearLayout ll_notic;
    private LinearLayout ll_top;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){

        view=new View(getActivity());

        view = inflater.inflate(R.layout.share, container, false);
        Log.d("activityID", "这个是shareTabFragment----------:" + this.toString());

        dbHelper = new MyDatabaseHelper(getContext(), "LibrarySystem.db", null, 1);
        db = dbHelper.getWritableDatabase();
        userType = SharedPrefsUtil.getValue(getContext(), APPConfig.USERTYPE, 0);

        ll_share = (LinearLayout) view.findViewById(R.id.ll_share_share);
        ll_notic = (LinearLayout) view.findViewById(R.id.ll_share_notice);
        ll_top = (LinearLayout) view.findViewById(R.id.ll_share_top);
        listView = (ListView) view.findViewById(R.id.lv_share_list);
        listView.setOnItemClickListener(this);
        if (userType != 1) {
            ll_notic.setVisibility(View.GONE);
            ll_top.setBackgroundResource(R.drawable.listback03);
        }
        initMotion();
        return view;
    }

    public void initMotion() {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
