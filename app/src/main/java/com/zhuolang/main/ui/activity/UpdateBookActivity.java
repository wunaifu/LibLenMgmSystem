package com.zhuolang.main.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.zhuolang.main.R;
import com.zhuolang.main.common.APPConfig;
import com.zhuolang.main.utils.SharedPrefsUtil;

/**
 * Created by Administrator on 2016/11/22.
 */
public class UpdateBookActivity extends Activity implements View.OnClickListener{

    private ImageView iv_addbook;
    private ImageView iv_delbook;
    private ImageView iv_updatebook;
    private ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatebook);
        iv_addbook = (ImageView) this.findViewById(R.id.image_updateboook_add);
        iv_updatebook = (ImageView) this.findViewById(R.id.image_updateboook_update);
        iv_delbook = (ImageView) this.findViewById(R.id.image_updateboook_delete);
        iv_back = (ImageView) this.findViewById(R.id.image_updatebook_back);
        iv_addbook.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        iv_updatebook.setOnClickListener(this);
        iv_delbook.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        clickImage(v);
    }
    private void clickImage(View v){
        switch (v.getId()){
            case R.id.image_updateboook_add:
                Intent intent = new Intent();
                intent.setClass(UpdateBookActivity.this, AddBookActivity.class);
                this.startActivity(intent);
                break;
            case R.id.image_updateboook_update:
                Intent intent1 = new Intent();
                intent1.setClass(UpdateBookActivity.this, UpdateBookListActivity.class);
                this.startActivity(intent1);
                break;
            case R.id.image_updateboook_delete:
                Intent intent2 = new Intent();
                intent2.setClass(UpdateBookActivity.this, DelBookListActivity.class);
                this.startActivity(intent2);
                break;
            case R.id.image_updatebook_back:
                Intent intent3 = new Intent();
                intent3.setClass(UpdateBookActivity.this, MainActivity.class);
                intent3.putExtra("Flagf", "false");
                startActivity(intent3);
                finish();
                break;
            default:
                break;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            Intent intent = new Intent();
            intent.setClass(UpdateBookActivity.this, MainActivity.class);
            intent.putExtra("Flagf", "false");
            startActivity(intent);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}