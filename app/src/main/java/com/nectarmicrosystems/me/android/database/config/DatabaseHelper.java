package com.nectarmicrosystems.me.android.database.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tobi Adeyinka on 2017. 08. 18..
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    DatabaseHelper(Context context){
        super(context, ConfigValues.DATABASE, null, ConfigValues.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
