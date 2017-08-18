package com.nectarmicrosystems.me.android.database.tables;

import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import android.support.annotation.Nullable;

import com.nectarmicrosystems.me.android.config.ConfigValues;
import com.nectarmicrosystems.me.android.database.config.DatabaseHelper;

/**
 * Created by Tobi Adeyinka on 2017. 08. 18..
 */

public class FinanceAccountsTable {

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper databaseHelper;

    public FinanceAccountsTable(Context context) {
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
        database = databaseHelper.getWritableDatabase();
    }

    public void insert(ContentValues cv){
        database.insert(ConfigValues.FINANCE_ACCOUNTS_TABLE, null, cv);
    }

    public void update(ContentValues values, String selection, String[] selectionArgs) {

    }

    @Nullable
    public Cursor query(@Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return database.query(
                ConfigValues.FINANCE_ACCOUNTS_TABLE,
                ConfigValues.FINANCE_ACCOUNTS_TABLE_COLUMNS,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );
    }

    public void delete(@Nullable String selection, @Nullable String[] selectionArgs){
        database.delete(
                ConfigValues.FINANCE_ACCOUNTS_TABLE,
                selection,
                selectionArgs
        );
    }
}
