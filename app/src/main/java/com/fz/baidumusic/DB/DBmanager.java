package com.fz.baidumusic.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by admin on 2017/4/24.
 */

public class DBmanager {
    private SQLiteDatabase database;
    private MyDBHelper helper;
    private Context context;
    private String name;

    public DBmanager(Context context, String name) {
        this.context = context;
        this.name = name;
    }

    private void initDb() {
        helper = new MyDBHelper(context, name);
        database = helper.getWritableDatabase();
    }

    public void select() {
        Cursor cursor = database.rawQuery("select * form user where ", new String[]{});
    }

    public void insert() {
        database.execSQL("insert into", new Object[]{});
    }
}
