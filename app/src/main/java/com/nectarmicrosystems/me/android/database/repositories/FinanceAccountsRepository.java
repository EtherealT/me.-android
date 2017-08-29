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

package com.nectarmicrosystems.me.android.database.repositories;

import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

import com.nectarmicrosystems.me.android.config.ConfigValues;
import com.nectarmicrosystems.me.android.modules.finance_manger.entities.FinanceAccount;
import com.nectarmicrosystems.me.android.database.content_providers.FinanceAccountsProvider;

import java.util.UUID;
import java.util.ArrayList;

/**
 * Created by Tobi Adeyinka on 2017. 08. 18..
 */

public class FinanceAccountsRepository implements DatabaseRepository<FinanceAccount> {

    private Context context;

    public FinanceAccountsRepository(Context context) {
        this.context = context;
    }

    @Override
    public void insert(FinanceAccount data) {
        ContentValues values = data.asContentValues();
        context.getContentResolver().insert(FinanceAccountsProvider.CONTENT_URI, values);
    }

    @Override
    public void update(FinanceAccount data) {
        ContentValues values = data.asContentValues();
        String selection = ConfigValues.ID + "=?";
        String[] selectionArgs = {data.getId().toString()};
        context.getContentResolver().update(FinanceAccountsProvider.CONTENT_URI, values, selection, selectionArgs);
    }

    @Override
    public void delete(UUID dataId) {
        String selection = ConfigValues.ID + "=?";
        String[] selectionArgs = {dataId.toString()};
        context.getContentResolver().delete(FinanceAccountsProvider.CONTENT_URI, selection, selectionArgs);
    }

    @Override
    public void deleteAll() {
        context.getContentResolver().delete(FinanceAccountsProvider.CONTENT_URI, null, null);
    }

    @Override
    public ArrayList<FinanceAccount> getAll() {
        ArrayList<FinanceAccount> accounts = new ArrayList<>();

        Cursor cursor = context.getContentResolver()
                .query(FinanceAccountsProvider.CONTENT_URI, ConfigValues.FINANCE_ACCOUNTS_TABLE_COLUMNS, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) accounts.add(FinanceAccount.fromCursor(cursor));
            cursor.close();
        }

        return accounts;
    }

    @Override
    public FinanceAccount getById(UUID dataId) {
        String selection = ConfigValues.ID + "=?";
        String[] selectionArgs = {dataId.toString()};

        Cursor cursor = context.getContentResolver()
                .query(FinanceAccountsProvider.CONTENT_URI, ConfigValues.FINANCE_ENTRIES_TABLE_COLUMNS, selection, selectionArgs, null);

        FinanceAccount account = null;

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToNext();
            account = FinanceAccount.fromCursor(cursor);
        }

        return account;
    }

}
