package com.nectarmicrosystems.me.android.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tobi Adeyinka on 2017. 08. 18..
 */

class DatabaseHelper extends SQLiteOpenHelper {

    DatabaseHelper(Context context){
        super(context, DatabaseConfig.DATABASE, null, DatabaseConfig.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
