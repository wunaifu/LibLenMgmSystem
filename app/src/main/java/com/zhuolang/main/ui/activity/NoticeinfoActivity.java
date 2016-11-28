package com.zhuolang.main.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuolang.main.R;
import com.zhuolang.main.common.APPConfig;
import com.zhuolang.main.database.MyDatabaseHelper;
import com.zhuolang.main.utils.SharedPrefsUtil;

/**
 * Created by wnf on 2016/11/1.
 */

public class NoticeinfoActivity extends Activity implements View.OnClickListener{


    private ImageView imageViewBack;
    private Button bt_updateInfo;

    private TextView tv_title;
    private TextView tv_time;
    private TextView tv_content;

    private String title;
    private String time;
    private String content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticeinfo);
        title = getIntent().getStringExtra("noticeTitle");
        time = getIntent().getStringExtra("noticeTime");
        content = getIntent().getStringExtra("noticeTontent");
        initView();
        initDatas();
    }
    private void initView() {
        tv_content=(TextView)findViewById(R.id.tv_noticeinfo_content);
        tv_time=(TextView)findViewById(R.id.tv_noticeinfo_time);
        tv_title=(TextView)findViewById(R.id.tv_noticeinfo_title);
        imageViewBack=(ImageView)findViewById(R.id.iv_noticeinfo_back);

        imageViewBack.setOnClickListener(this);
        tv_title.setText(title);
        tv_time.setText(time);
        tv_content.setText("\t\t"+content);
    }

    private void initDatas() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_noticeinfo_back:
                finish();
                break;
            default:
                break;
        }
    }
}
