package com.zhuolang.main.ui.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhuolang.main.R;
import com.zhuolang.main.adapter.BookListAdapter;
import com.zhuolang.main.common.APPConfig;
import com.zhuolang.main.database.MyDatabaseHelper;
import com.zhuolang.main.model.Book;
import com.zhuolang.main.utils.SharedPrefsUtil;
import com.zhuolang.main.view.CustomWaitDialog;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wnf on 2016/11/25.
 */
public class BookListActivity extends Activity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private ImageView img_back;

    private MyDatabaseHelper dbHelper;
    private BookListAdapter adapter;
    private List<Book> books = new ArrayList<>();
    private List<Book> bookList = new ArrayList<>();

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
            if (msg.obj.equals("true")) {
                adapter = new BookListAdapter(BookListActivity.this, bookList);
                listView.setAdapter(adapter);
            }else {
                Toast.makeText(BookListActivity.this, "没有找到图书，请确认", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booklist);
        dbHelper = new MyDatabaseHelper(this, "LibrarySystem.db", null, 1);
        listView = (ListView) findViewById(R.id.lv_booklist_list);
        listView.setOnItemClickListener(this);
        img_back = (ImageView) findViewById(R.id.img_booklist_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initMotion();
    }

    public void initMotion() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String flag = "false";
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("book_tab", null, null, null, null, null, null);
                Message message = new Message();
                message.what = 0;
                if (!cursor.moveToFirst()) {
                    flag="false";
                    message.obj = flag;
                    handler.sendMessage(message);
                } else {
                    //遍历Cursor对象，取出数据
                    do {
                        Book book = new Book();
                        book.setBookNumber(cursor.getInt(cursor.getColumnIndex("BookNumber")) + "");
                        if (!book.getBookNumber().equals("0")) {
                            book.setBookId(cursor.getString(cursor.getColumnIndex("BookId")));
                            book.setBookName(cursor.getString(cursor.getColumnIndex("BookName")));
                            book.setBookType(cursor.getString(cursor.getColumnIndex("BookType")));
                            book.setBookAuthor(cursor.getString(cursor.getColumnIndex("BookAuthor")));
                            book.setBookPublisher(cursor.getString(cursor.getColumnIndex("BookPublisher")));
                            book.setBookPublyear(cursor.getString(cursor.getColumnIndex("BookPublyear")));
                            book.setBookPrice(cursor.getString(cursor.getColumnIndex("BookPrice")));
                            book.setBookAddress(cursor.getString(cursor.getColumnIndex("BookAddress")));
                            book.setBookLoanable(cursor.getInt(cursor.getColumnIndex("BookLoanable")) + "");
                            book.setBookConten(cursor.getString(cursor.getColumnIndex("BookContent")));
                            Log.d("testrun", "BookLoanable" + book.getBookLoanable());
                            bookList.add(book);
                            flag = "true";
                        }
                    } while (cursor.moveToNext());
                    cursor.close();
//                    adapter = new BookListAdapter(BookListActivity.this, bookList);
//                    listView.setAdapter(adapter);

                    message.obj = flag;
                    handler.sendMessage(message);
                }
            }
        }).start();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.setClass(BookListActivity.this, BookListDetailActivity.class);
        Book book = new Book();
        book = bookList.get(position);
        Gson gson = new Gson();
        String bookJS=gson.toJson(book);
        intent.putExtra("bookInfo",bookJS);
        startActivity(intent);
    }
}
