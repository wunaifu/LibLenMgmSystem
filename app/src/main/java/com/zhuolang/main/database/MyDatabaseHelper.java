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
            +"UserSex varchar(5),"
            +"UserAdress varchar(28),"
            +"UserPassword varchar(30))";

    public static final String CREATE_BOOK="create table book_tab("
            +"BookId varchar(20) primary key,"
            +"BookName varchar(30),"
            +"BookType varchar(20),"
            +"BookAuthor varchar(20),"
            +"BookPublisher varchar(30),"
            +"BookPublyear varchar(15),"
            +"BookPrice varchar(10),"
            +"BookAddress varchar(30),"
            +"BookNumber int,"
            +"BookLoanable int,"
            +"BookContent varchar(65))";

    public static final String CREATE_LENDREAD="create table lendread_tab("
            +"LendId integer primary key autoincrement,"
            +"BookId varchar(20),"
            +"UserId varchar(20),"
            +"LoadTime Date,"
            +"ReturnTime Date,"
            +"Number int,"
            +"Days varchar(6))";

    public static final String CREATE_NOTICE="create table notice_tab("
            +"NoticeId integer primary key autoincrement,"
            +"NoticeTitle varchar(15),"
            +"NoticeTime Date,"
            +"NoticeContent varchar(150))";

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
        db.execSQL(CREATE_NOTICE);
        Toast.makeText(mContext,"Create succeeded",Toast.LENGTH_SHORT).show();
    }

    @Override//更新数据库
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user_tab");//将存在的表删除，再调用更新函数
        db.execSQL("drop table if exists book_tab");
        db.execSQL("drop table if exists lendread_tab");
        db.execSQL("drop table if exists notice_tab");
        onCreate(db);
    }
}




