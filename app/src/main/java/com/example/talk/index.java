package com.example.talk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);


    }
    //登入
    public void login(View v){
        Intent it=new Intent(this,login.class);
        startActivity(it);

    }
    //註冊按鈕
    public void register(View v){
        Intent it=new Intent(this,register.class);
        startActivity(it);
    }
    //點擊圖片進入主題選擇
    public void chooseTheme(View v){
        Intent it=new Intent(this,mainTheme.class);
        startActivity(it);
    }

}
