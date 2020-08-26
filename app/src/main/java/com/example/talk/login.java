package com.example.talk;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.StrictMode;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import androidx.appcompat.app.AppCompatActivity;


public class login extends AppCompatActivity {
    String INaccount,INpassword;
    //ResultSet rs=null;
    EditText EdAccount;
    EditText EdPass;
    ResultSet rs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


    }

    public void login(View v) {
        EdAccount = (EditText) findViewById(R.id.LGNaccount);
        EdPass = (EditText) findViewById(R.id.LGNpassword);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        execute();//連接資料庫
        //******** 比對資料庫帳號密碼
        try {
            while (rs.next()) {
                String act = rs.getString("account");//取得帳號密碼
                String pass = rs.getString("password");

                if ((act.equals(EdAccount.getText().toString())) && (pass.equals(EdPass.getText().toString())))//比對到資料
                {
                    Intent it = new Intent(this, index.class);//登入成功轉頁
                    it.putExtra("useraccount", EdAccount.getText().toString());//傳遞帳號
                    super.startActivity(it);
                    Toast.makeText(this, "登入成功", Toast.LENGTH_SHORT).show();
                    finish();
                    return;//底下程式都不執行
                }
                // Toast.makeText(this, "重新登入", Toast.LENGTH_SHORT).show();//登入失敗 重新登入
            }
            Toast.makeText(this, "重新登入", Toast.LENGTH_SHORT).show();//登入失敗 重新登入
        } catch (SQLException ex) {
            Log.e(" SQLError", "err:" + ex.getMessage());
        }
        // Toast.makeText(this, "重新登入", Toast.LENGTH_SHORT).show();//登入失敗 重新登入
    }
    //key, value ,editText.getText().tostring();
//
//    接收端
//    string msg=super.getIntent().getStringExtra("key值")
    public void execute() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            //  String url="jdbc:mysql://10.0.2.2:3306/data_info";
            String url = "jdbc:mysql://35.185.154.19:3306/wetalk";
            String user = "user";
            String password = "user";
            String sql = "select account,password from data_info";
            Connection cn = DriverManager.getConnection(url,user,password);
            Statement st = cn.createStatement();
            rs = st.executeQuery(sql);

        } catch (SQLException ex) {
            Log.e(" SQLError", "err:" + ex.getMessage());
        }
    }
    public void register(View v){
        Intent it=new Intent(this,register.class);
        startActivity(it);

    }
}
