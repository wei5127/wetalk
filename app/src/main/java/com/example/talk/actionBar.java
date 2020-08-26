package com.example.talk;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by a123 on 2017/6/9.
 */

public class actionBar extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_bar);
    }
    // 點擊Menu時，系統使用當前Activity的onCreateOptionsMenu方法，並傳入一個實作Menu介面的menu物件提供你使用
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*
         * add()方法的四個參數，依次是：
         * 1、組別，如果不分組的話就寫Menu.NONE,
         * 2、Id，這個很重要，Android根據這個Id來確定不同的功能表
         * 3、順序，那個功能表現在在前面由這個參數的大小決定
         * 4、文字，功能表的顯示文字
         */
        menu.add(Menu.NONE, Menu.FIRST + 1, 5, "刪除").setIcon(
                android.R.drawable.ic_menu_delete);
// setIcon()方法為功能表設置圖示，這裏使用的是系統內定的圖示，同學們留意一下,以
// android.R開頭的資源是系統提供的，我們自己提供的資源是以R開頭的
        menu.add(Menu.NONE, Menu.FIRST + 2, 2, "儲存").setIcon(
                android.R.drawable.ic_menu_edit);
        menu.add(Menu.NONE, Menu.FIRST + 3, 6, "説明").setIcon(
                android.R.drawable.ic_menu_help);
        menu.add(Menu.NONE, Menu.FIRST + 4, 1, "新增").setIcon(
                android.R.drawable.ic_menu_add);
        menu.add(Menu.NONE, Menu.FIRST + 5, 4, "明細").setIcon(
                android.R.drawable.ic_menu_info_details);
        menu.add(Menu.NONE, Menu.FIRST + 6, 3, "傳送").setIcon(
                android.R.drawable.ic_menu_send);
// return true才會起作用
        return true;
    }
    //功能表項被選擇事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case Menu.FIRST + 1:
                Toast.makeText(this, "刪除選項被點擊了", Toast.LENGTH_LONG).show();
                break;
            case Menu.FIRST + 2:
                Toast.makeText(this, "儲存選項被點擊了", Toast.LENGTH_LONG).show();
                break;
            case Menu.FIRST + 3:
                Toast.makeText(this, "說明選項被點擊了", Toast.LENGTH_LONG).show();
                break;
            case Menu.FIRST + 4:
                Toast.makeText(this, "新增選項被點擊了", Toast.LENGTH_LONG).show();
                break;
            case Menu.FIRST + 5:
                Toast.makeText(this, "明細選項被點擊了", Toast.LENGTH_LONG).show();
                break;
            case Menu.FIRST + 6:
                Toast.makeText(this, "傳送選項被點擊了", Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
    //選項功能表被關閉事件，功能表被關閉有三種情形，menu按鈕被再次點擊、back按鈕被點擊或者用戶選擇了某一個功能表項
    @Override
    public void onOptionsMenuClosed(Menu menu){
        Toast.makeText(this, "選項功能表關閉了", Toast.LENGTH_LONG).show();
    }
    //功能表被顯示之前的事件
    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        Toast.makeText(this, "選項功能表顯示之前onPrepareOptionsMenu方法會被使用，你可以用此方法來根據當時的情況調整功能表", Toast.LENGTH_LONG).show();
//如果返回false，此方法就把用戶點擊menu的動作給取消了，onCreateOptionsMenu方法將不會被調用
        return true;
    }
}
