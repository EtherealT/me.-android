/*
 *  Copyright 2017 Oluwatobi Adeyinka
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package com.nectarmicrosystems.me.android.database.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.nectarmicrosystems.me.android.config.ConfigValues;

/**
 * Created by Tobi Adeyinka on 2017. 08. 18..
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context){
        super(context, ConfigValues.DATABASE, null, ConfigValues.DATABASE_VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.execSQL("PRAGMA foreign_keys=ON");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ConfigValues.FINANCE_ACCOUNTS_TABLE + " (" +
                ConfigValues.ID + " TEXT PRIMARY KEY NOT NULL, " +
                ConfigValues.NAME + " TEXT NOT NULL, " +
                ConfigValues.BALANCE + " TEXT NOT NULL, " +
                ConfigValues.CURRENCY + " TEXT NOT NULL, " +
                ConfigValues.ACCOUNT_TYPE + " TEXT NOT NULL)"
        );

        db.execSQL("CREATE TABLE " + ConfigValues.FINANCE_ENTRIES_TABLE + " (" +
                ConfigValues.ID + " TEXT PRIMARY KEY NOT NULL, " +
                ConfigValues.DATE + " TEXT NOT NULL, " +
                ConfigValues.AMOUNT + " TEXT NOT NULL, " +
                ConfigValues.DESCRIPTION + " TEXT, " +
                ConfigValues.ACCOUNT_ID + " TEXT NOT NULL, " +
                ConfigValues.ENTRY_TYPE + " TEXT NOT NULL, " +
                "FOREIGN KEY (" + ConfigValues.ACCOUNT_ID + ") REFERENCES " + ConfigValues.FINANCE_ACCOUNTS_TABLE + " (" + ConfigValues.ID + "))"
        );

        db.execSQL("CREATE TABLE " + ConfigValues.SITE_PASSWORDS_TABLE + " (" +
                ConfigValues.ID + " TEXT PRIMARY KEY NOT NULL, " +
                ConfigValues.SITE_NAME + " TEXT NOT NULL, " +
                ConfigValues.ACCOUNT_IDENTIFIER + " TEXT NOT NULL, " +
                ConfigValues.PASSWORD + " TEXT NOT NULL, " +
                ConfigValues.LOGO_RESOURCE_ID + " TEXT NOT NULL)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
