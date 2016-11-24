package com.zhuolang.main.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by wnf on 2016/11/17.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper{

    public static final String CREATE_USER="create table user_tab("
            +"UserId varchar(20) primary key,"
            +"UserName varchar(20),"
            +"UserAge int,"
            +"UserPhone varchar(15),"
            +"UserClass varchar(20),"
            +"UserType int,"
            +"UserSex int,"
            +"UserPassword varchar(30))";

    public static final String CREATE_BOOK="create table book_tab("
            +"BookId varchar(20) primary key,"
            +"BookName varchar(20),"
            +"BookType int,"
            +"BookAuthor varchar(15),"
            +"BookPublisher varchar(30),"
            +"BookPrice int,"
            +"BookNumber int)";

    public static final String CREATE_LENDREAD="create table lendread_tab("
            +"BookId varchar(20),"
            +"UserId varchar(20),"
            +"LoadTime Date,"
            +"ReturnTime Date,"
            +"Days int)";



    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//创建数据库
        db.execSQL(CREATE_USER);//执行建表语句
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_LENDREAD);
        Toast.makeText(mContext,"Create succeeded",Toast.LENGTH_SHORT).show();
    }

    @Override//更新数据库
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user_tab");//将存在的表删除，再调用更新函数
        db.execSQL("drop table if exists book_tab");
        db.execSQL("drop table if exists lendread_tab");
        onCreate(db);
    }
}




