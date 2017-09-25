package com.tobiadeyinka.me.android.database.tables;

import android.database.Cursor;
import android.content.ContentValues;
import android.support.annotation.Nullable;

/**
 * Created by Tobi Adeyinka on 2017. 09. 25..
 */

interface DatabaseTable {

    void insert(ContentValues cv);
    void update(ContentValues values, String selection, String[] selectionArgs);
    Cursor query(@Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder);
    void delete(@Nullable String selection, @Nullable String[] selectionArgs);

}
