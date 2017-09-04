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

package com.tobiadeyinka.me.android.database.repositories;

import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

import com.tobiadeyinka.me.android.config.ConfigValues;
import com.tobiadeyinka.me.android.modules.finance_manager.entities.FinanceEntry;
import com.tobiadeyinka.me.android.database.content_providers.FinanceEntriesProvider;

import java.util.UUID;
import java.util.ArrayList;

/**
 * Created by Tobi Adeyinka on 2017. 08. 25..
 */

public class FinanceEntriesRepository implements DatabaseRepository<FinanceEntry> {

    private Context context;

    public FinanceEntriesRepository(Context context) {
        this.context = context;
    }

    @Override
    public void insert(FinanceEntry data) {
        ContentValues values = data.asContentValues();
        context.getContentResolver().insert(FinanceEntriesProvider.CONTENT_URI, values);
    }

    @Override
    public void update(FinanceEntry data) {
        ContentValues values = data.asContentValues();
        String selection = ConfigValues.ID + "=?";
        String[] selectionArgs = {data.getId().toString()};
        context.getContentResolver().update(FinanceEntriesProvider.CONTENT_URI, values, selection, selectionArgs);
    }

    @Override
    public void delete(UUID dataId) {
        String selection = ConfigValues.ID + "=?";
        String[] selectionArgs = {dataId.toString()};
        context.getContentResolver().delete(FinanceEntriesProvider.CONTENT_URI, selection, selectionArgs);
    }

    @Override
    public void deleteAll() {
        context.getContentResolver().delete(FinanceEntriesProvider.CONTENT_URI, null, null);
    }

    @Override
    public ArrayList<FinanceEntry> getAll() {
        ArrayList<FinanceEntry> entries = new ArrayList<>();

        Cursor cursor = context.getContentResolver()
                .query(FinanceEntriesProvider.CONTENT_URI, ConfigValues.FINANCE_ENTRIES_TABLE_COLUMNS, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) entries.add(FinanceEntry.fromCursor(cursor));
            cursor.close();
        }

        return entries;
    }

    @Override
    public FinanceEntry getById(UUID dataId) {
        String selection = ConfigValues.ID + "=?";
        String[] selectionArgs = {dataId.toString()};

        Cursor cursor = context.getContentResolver()
                .query(FinanceEntriesProvider.CONTENT_URI, ConfigValues.FINANCE_ENTRIES_TABLE_COLUMNS, selection, selectionArgs, null);

        FinanceEntry entry = null;

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToNext();
            entry = FinanceEntry.fromCursor(cursor);
        }

        return entry;
    }
}
