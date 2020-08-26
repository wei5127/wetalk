package com.example.talk;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import android.os.Looper;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by a123 on 2017/5/29.
 */
public class register extends AppCompatActivity {
    String INaccount,INpassword;
    //int supplier;
    //double price;
    //int sale,total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


    }
    public void register(View v){
        EditText account=(EditText)findViewById(R.id.RGaccount);
        INaccount=account.getText().toString();
        EditText password=(EditText)findViewById(R.id.RGpassword);
        INpassword=password.getText().toString();
        //INpassword=Integer.parseInt(password.getText().toString());
        //EditText et3=(EditText)findViewById(R.id.);
        //supplier=Integer.parseInt(et3.getText().toString());
        //EditText et4=(EditText)findViewById(R.id.etPrice);
        //price=Double.parseDouble(et4.getText().toString());
        //EditText et5=(EditText)findViewById(R.id.etQty);
        //total=Integer.parseInt(et5.getText().toString());
        new Thread(new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Looper.prepare();
                insertRecord();
                Looper.loop();
            }

        }).start();
    }
    public void insertRecord(){
        Connection con=null;
        PreparedStatement  insert= null;


        String insertStatement =
                "insert into data_info( account , password) values ( ? , ? )";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =  DriverManager.getConnection("jdbc:mysql://35.185.154.19:3306/wetalk","user","user");

            con.setAutoCommit(false);
            insert = con.prepareStatement(insertStatement);
            insert.setString(1, INaccount);
            insert.setString(2, INpassword);
            //insert.setDouble(3, price);
            //insert.setInt(4, sale);
            //insert.setInt(5, total);
            int rs= insert.executeUpdate();
            con.commit();

            insert.close();
            con.setAutoCommit(true);
            Toast.makeText(this,"Insert Suceess", Toast.LENGTH_LONG).show();
        } catch (Exception e ) {
            Log.e("Insert Error",e.getMessage());
            if (con != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    con.rollback();
                } catch(SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        Intent it=new Intent(this,mainTheme.class);
        startActivity(it);

    }
    public void cancel(View v){
        Intent it=new Intent(this,index.class);

        startActivity(it);

    }






}