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

package com.tobiadeyinka.me.android.database.tables;

import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import android.support.annotation.Nullable;

import com.tobiadeyinka.me.android.config.ConfigValues;
import com.tobiadeyinka.me.android.database.config.DatabaseHelper;

/**
 * Created by Tobi Adeyinka on 2017. 08. 25..
 */

public class SitePasswordsTable implements DatabaseTable {

    private SQLiteDatabase database;

    public SitePasswordsTable(Context context) {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        database = databaseHelper.getWritableDatabase();
    }

    @Override
    public void insert(ContentValues cv){
        database.insert(ConfigValues.SITE_PASSWORDS_TABLE, null, cv);
    }

    @Override
    public void update(ContentValues values, String selection, String[] selectionArgs) {
        database.update(
                ConfigValues.SITE_PASSWORDS_TABLE,
                values,
                selection,
                selectionArgs
        );
    }

    @Override
    @Nullable
    public Cursor query(@Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return database.query(
                ConfigValues.SITE_PASSWORDS_TABLE,
                ConfigValues.SITE_PASSWORDS_TABLE_COLUMNS,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );
    }

    @Override
    public void delete(@Nullable String selection, @Nullable String[] selectionArgs){
        database.delete(
                ConfigValues.SITE_PASSWORDS_TABLE,
                selection,
                selectionArgs
        );
    }

}
