package com.zhuolang.main.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zhuolang.main.R;
import com.zhuolang.main.model.Book;
import com.zhuolang.main.utils.TimeUtil;

import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.Date;

/**
 * Created by hzg on 2016/11/3.
 */
public class BookListDetailActivity extends Activity {

    private ImageView imageViewback;
    private TextView tv_bookId;
    private TextView tv_bookName;
    private TextView tv_bookType;
    private TextView tv_bookAuthor;
    private TextView tv_bookPublisher;
    private TextView tv_bookPublyear;
    private TextView tv_bookPrice;
    private TextView tv_bookAddress;
    private TextView tv_bookNumber;
    private TextView tv_bookLoanable;
    private TextView tv_bookContent;

    private Book book = new Book();
    private String bookInfoStr="";
    private Gson gson = new Gson();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booklistdetail);

        bookInfoStr=getIntent().getStringExtra("bookInfo");
        book=gson.fromJson(bookInfoStr, Book.class);

        initView();
        initModel();

    }

    private void initView(){
        imageViewback= (ImageView) findViewById(R.id.image_booklistdetail_back);
        tv_bookId = (TextView) findViewById(R.id.tv_booklistdetail_id);
        tv_bookName = (TextView) findViewById(R.id.tv_booklistdetail_name);
        tv_bookType = (TextView) findViewById(R.id.tv_booklistdetail_type);
        tv_bookAuthor = (TextView) findViewById(R.id.tv_booklistdetail_author);
        tv_bookPublisher = (TextView) findViewById(R.id.tv_booklistdetail_publisher);
        tv_bookPublyear = (TextView) findViewById(R.id.tv_booklistdetail_publyear);
        tv_bookPrice = (TextView) findViewById(R.id.tv_booklistdetail_price);
        tv_bookAddress = (TextView) findViewById(R.id.tv_booklistdetail_address);
        tv_bookNumber = (TextView) findViewById(R.id.tv_booklistdetail_amount);
        tv_bookLoanable = (TextView) findViewById(R.id.tv_booklistdetail_loadableamount);
        tv_bookContent = (TextView) findViewById(R.id.tv_booklistdetail_content);
    }
    private void initModel(){
        tv_bookId.setText("  编号:"+book.getBookId());
        tv_bookName.setText(book.getBookName());
        tv_bookType.setText(book.getBookType());
        tv_bookAuthor.setText(book.getBookAuthor());
        tv_bookPublisher.setText(book.getBookPublisher());
        tv_bookPublyear.setText(book.getBookPublyear());
        tv_bookPrice.setText(book.getBookPrice());
        tv_bookAddress.setText(book.getBookAddress());
        tv_bookNumber.setText(book.getBookNumber());
        tv_bookLoanable.setText(book.getBookLoanable());
        tv_bookContent.setText("\t\t内容简介："+book.getBookConten());

        imageViewback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
