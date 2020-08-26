package com.example.talk;


import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.talk.type.allTogether;
import com.example.talk.type.broadGame;
import com.example.talk.type.chat;
import com.example.talk.type.eat;
import com.example.talk.type.other;
import com.example.talk.type.purchase;
import com.example.talk.type.sing;
import com.example.talk.type.teamBuy;

import androidx.appcompat.app.AppCompatActivity;


public class mainTheme extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article);
        ListView lv= (ListView)findViewById(R.id.themeListView);
        //定義陣列
        String[] data ={
                "揪團",
                "唱歌",
                "聚餐",
                "團購",
                "代購",
                "桌游",
                "聊天",
                "分類討論區",
        };
        //為ListView提供陣列配接器
        lv.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,data));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                switch (position) {
                    case 0:
                        Intent it0=new Intent(mainTheme.this,allTogether.class);
                        startActivity(it0);
                        break;
                    case 1:
                        Intent it1=new Intent(mainTheme.this,sing.class);
                        startActivity(it1);
                        break;
                    case 2:
                        Intent it2=new Intent(mainTheme.this,eat.class);
                        startActivity(it2);
                        break;
                    case 3:
                        Intent it3=new Intent(mainTheme.this,teamBuy.class);
                        startActivity(it3);
                        break;
                    case 4:
                        Intent it4=new Intent(mainTheme.this,purchase.class);
                        startActivity(it4);
                        break;
                    case 5:
                        Intent it5=new Intent(mainTheme.this,broadGame.class);
                        startActivity(it5);
                        break;
                    case 6:
                        Intent it6=new Intent(mainTheme.this,chat.class);
                        startActivity(it6);
                        break;
                    default:
                        Intent it7=new Intent(mainTheme.this,other.class);
                        startActivity(it7);
                }
            }});


    }
}