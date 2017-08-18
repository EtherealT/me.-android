package com.nectarmicrosystems.me.android.database.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.nectarmicrosystems.me.android.config.ConfigValues;

/**
 * Created by Tobi Adeyinka on 2017. 08. 18..
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    DatabaseHelper(Context context){
        super(context, ConfigValues.DATABASE, null, ConfigValues.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ConfigValues.FINANCE_ACCOUNTS_TABLE + " (" +
                ConfigValues.ID + " TEXT PRIMARY KEY NOT NULL, " +
                ConfigValues.NAME + " TEXT NOT NULL, " +
                ConfigValues.BALANCE + " TEXT NOT NULL, " +
                ConfigValues.ACCOUNT_TYPE + " TEXT NOT NULL) "
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
