package com.fz.baidumusic.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin on 2017/4/24.
 */

public class MyDBHelper extends SQLiteOpenHelper {
    public MyDBHelper(Context context, String name) {
        super(context, name, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
