package com.example.talk;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by a123 on 2017/5/29.
 */
public class connectdb {
    String sql ="";
    ResultSet rs=null;

    public ResultSet connectdb(String SQLstr) {
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
            sql = SQLstr;
            Connection cn = DriverManager.getConnection(url, user, password);
            Statement st = cn.createStatement();
            rs = st.executeQuery(sql);
            return rs;

        } catch (SQLException ex) {
            Log.e(" SQLError", "err:" + ex.getMessage());
            return rs;
        }


    }
}

