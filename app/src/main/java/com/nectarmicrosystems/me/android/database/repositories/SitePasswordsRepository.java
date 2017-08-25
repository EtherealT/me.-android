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

import com.nectarmicrosystems.me.android.modules.password_manager.entities.SitePassword;
import com.nectarmicrosystems.me.android.database.content_providers.SitePasswordsProvider;

import java.util.UUID;
import java.util.ArrayList;

/**
 * Created by Tobi Adeyinka on 2017. 08. 25..
 */

public class SitePasswordsRepository implements DatabaseRepository<SitePassword> {

    private Context context;

    public SitePasswordsRepository(Context context) {
        this.context = context;
    }

    @Override
    public void insert(SitePassword data) {
        ContentValues values = data.asContentValues();
        context.getContentResolver().insert(SitePasswordsProvider.CONTENT_URI, values);
    }

    @Override
    public void update(SitePassword data) {

    }

    @Override
    public void delete(UUID dataId) {
        context.getContentResolver().delete(SitePasswordsProvider.CONTENT_URI, null, null);
    }

    @Override
    public void deleteAll() {
        context.getContentResolver().delete(SitePasswordsProvider.CONTENT_URI, null, null);
    }

    @Override
    public ArrayList<SitePassword> getAll() {
        ArrayList<SitePassword> sitePasswords = new ArrayList<>();

        Cursor cursor = context.getApplicationContext()
                .getContentResolver()
                .query(SitePasswordsProvider.CONTENT_URI, null, null, null,null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) sitePasswords.add(SitePassword.fromCursor(cursor));
            cursor.close();
        }

        return sitePasswords;
    }

    @Override
    public SitePassword getById(UUID dataId) {
        return null;
    }
}
