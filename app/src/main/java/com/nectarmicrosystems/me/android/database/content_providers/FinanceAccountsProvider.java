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

package com.nectarmicrosystems.me.android.database.content_providers;

import android.net.Uri;
import android.content.*;
import android.database.Cursor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.nectarmicrosystems.me.android.config.ConfigValues;
import com.nectarmicrosystems.me.android.database.tables.FinanceAccountsTable;

import java.util.UUID;

/**
 * Created by Tobi Adeyinka on 2017. 08. 18..
 */

public class FinanceAccountsProvider extends ContentProvider {

    private FinanceAccountsTable accountsTable;

    private static final String AUTHORITY = "com.nectarmicrosystems.me.android.database.content_providers.financeaccountsprovider";
    private static final String FINANCE_ACCOUNTS_BASE_PATH = "financeaccounts";

    private static final int FINANCE_ACCOUNT = 100;
    private static final int FINANCE_ACCOUNT_ID = 101;

    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + FINANCE_ACCOUNTS_BASE_PATH);

    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        sURIMatcher.addURI(AUTHORITY, FINANCE_ACCOUNTS_BASE_PATH, FINANCE_ACCOUNT);
        sURIMatcher.addURI(AUTHORITY, FINANCE_ACCOUNTS_BASE_PATH + "/*" , FINANCE_ACCOUNT_ID);
    }

    @Override
    public boolean onCreate() {
        accountsTable = new FinanceAccountsTable(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return accountsTable.query(selection, selectionArgs, sortOrder);
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        accountsTable.insert(values);
        return generateUri(UUID.fromString(values.getAsString(ConfigValues.ID)));
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        accountsTable.delete(selection, selectionArgs);
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        accountsTable.update(values, selection, selectionArgs);
        return 0;
    }

    public static Uri generateUri(UUID id) {
        return Uri.parse(CONTENT_URI.toString() + "/" + id.toString());
    }

}
