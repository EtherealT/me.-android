package com.nectarmicrosystems.me.android.database.content_providers;

import android.content.UriMatcher;
import android.net.Uri;
import android.database.Cursor;
import android.content.ContentValues;
import android.content.ContentProvider;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.nectarmicrosystems.me.android.database.tables.FinanceAccountsTable;

/**
 * Created by Tobi Adeyinka on 2017. 08. 18..
 */

public class FinanceAccountsProvider extends ContentProvider {

    private FinanceAccountsTable accountsTable;

    private static final String AUTHORITY = "com.nectarmicrosystems.me.android.database.content_providers.financeaccountsprovier";
    private static final String FINANCE_ACCOUNTS_BASE_PATH = "financeaccounts";

    private static final int FINANCE_ACCOUNT = 100;
    private static final int FINANCE_ACCOUNT_ID = 101;

    private static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + FINANCE_ACCOUNTS_BASE_PATH);

    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        sURIMatcher.addURI(AUTHORITY, FINANCE_ACCOUNTS_BASE_PATH, FINANCE_ACCOUNT);
        sURIMatcher.addURI(AUTHORITY, FINANCE_ACCOUNTS_BASE_PATH + "/*" , FINANCE_ACCOUNT_ID);
    }

    @Override
    public boolean onCreate() {
        accountsTable = new FinanceAccountsTable(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
