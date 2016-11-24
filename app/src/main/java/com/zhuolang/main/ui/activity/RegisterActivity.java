package com.zhuolang.main.ui.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.zhuolang.main.R;
import com.zhuolang.main.database.MyDatabaseHelper;
import com.zhuolang.main.utils.SharedPrefsUtil;
import com.zhuolang.main.view.CustomWaitDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jat on 2016/11/1.
 */

public class RegisterActivity extends Activity {

           //定义注册用户类型的复选框对象
    private RadioGroup radiogroup;
    private EditText et_id;
    private EditText et_psd;
    private EditText et_name;
    private EditText et_phone;
//    private EditText et_gender;
    private Button bt_register;

    private String id;
    private String psd;
    private String name;
    private String phone;
    private String type="";
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        initView();
        initMotion();
    }
    private void initView() {
        //通过findViewById得到对应的控件对象
        et_id = (EditText) findViewById(R.id.et_register_id);
        et_phone = (EditText) findViewById(R.id.et_register_phone);
        et_psd = (EditText) findViewById(R.id.et_register_psd);
        et_name = (EditText) findViewById(R.id.et_register_name);

        bt_register = (Button) findViewById(R.id.bt_register_reg);

        radiogroup = (RadioGroup) findViewById(R.id.register_radiogro_type);
        dbHelper = new MyDatabaseHelper(this, "LibrarySystem.db", null, 3);
//        dbHelper.getWritableDatabase();//创建或打开数据库
    }

    /**
     * 初始化监听等
     */
    private void initMotion(){
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //开始组装数据
                values.put("UserAID", "3114002566");
                values.put("UserPassword", "123456");
                values.put("UserName", "张三");
                values.put("UserAge",18);
                values.put("UserClass","140803");
                values.put("UserSex",1);
                values.put("UserType",1);
                values.put("UserPhone", "18219111626");
                db.insert("user_tab", null, values);
                Toast.makeText(RegisterActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
