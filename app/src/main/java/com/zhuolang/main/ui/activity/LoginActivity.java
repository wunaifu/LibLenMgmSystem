package com.zhuolang.main.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zhuolang.main.R;
import com.zhuolang.main.common.APPConfig;
import com.zhuolang.main.utils.SharedPrefsUtil;
import com.zhuolang.main.view.CustomWaitDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jat on 2016/11/1.
 */

public class LoginActivity extends Activity {

    private EditText et_login_account;
    private EditText et_login_psd;
    private Button bt_login_login;
    private TextView tv_login_find;
    private TextView tv_login_register;

    private String account;
    private String psd;
    private int type;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        boolean is_login = SharedPrefsUtil.getValue(this,APPConfig.IS_LOGIN,false);
//        boolean is_login=false;
        if (is_login){
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            this.startActivity(intent);
            finish();
        }{
            init();
            initMotion();
        }

    }

    /**
     * 初始化控件
     */
    private void init(){
        et_login_account = (EditText)findViewById(R.id.et_login_account);//账号，对应phone
        et_login_psd = (EditText)findViewById(R.id.et_login_psd);
        bt_login_login = (Button)findViewById(R.id.bt_login_login);
        tv_login_find = (TextView)findViewById(R.id.tv_login_find);
        tv_login_register = (TextView)findViewById(R.id.tv_login_register);
    }

    /**
     * 初始化监听等
     */
    private void initMotion(){

    }
}
