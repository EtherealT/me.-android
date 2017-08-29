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

package com.nectarmicrosystems.me.android.modules.password_manager.entities;

import android.database.Cursor;
import android.content.ContentValues;

import com.nectarmicrosystems.me.R;
import com.nectarmicrosystems.me.android.config.ConfigValues;

import java.util.UUID;

/**
 * Created by Tobi Adeyinka on 2017. 08. 25..
 */

public class SitePassword {

    /*
     * unique auto generated instance id
     */
    private final UUID id;

    /*
     * site/app logo drawable resource id
     */
    private int logoResourceId;
    private String siteName;
    private String password;

    /*
     * account identifier e.g email / username
     */
    private String accountIdentifier;

    public SitePassword(String siteName, String accountIdentifier, String password, int logoResourceId) {
        id = UUID.randomUUID();
        this.siteName = siteName;
        this.accountIdentifier = accountIdentifier;
        this.password = password;
        this.logoResourceId = logoResourceId;
    }

    public SitePassword(String siteName, String accountIdentifier, String password) {
        id = UUID.randomUUID();
        this.siteName = siteName;
        this.accountIdentifier = accountIdentifier;
        this.password = password;
        logoResourceId = R.mipmap.ic_default_site_logo;
    }

    private SitePassword(UUID id, String siteName, String accountIdentifier, String password, int logoResourceId) {
        this.id = id;
        this.siteName = siteName;
        this.accountIdentifier = accountIdentifier;
        this.password = password;
        this.logoResourceId = logoResourceId;
    }

    public static SitePassword fromCursor(Cursor cursor){
        int idColumnIndex = cursor.getColumnIndex(ConfigValues.ID);
        UUID id = UUID.fromString(cursor.getString(idColumnIndex));

        int siteNameColumnIndex = cursor.getColumnIndex(ConfigValues.SITE_NAME);
        String siteName = cursor.getString(siteNameColumnIndex);

        int accountIdentifierColumnIndex = cursor.getColumnIndex(ConfigValues.ACCOUNT_IDENTIFIER);
        String accountIdentifier = cursor.getString(accountIdentifierColumnIndex);

        int passwordColumnIndex = cursor.getColumnIndex(ConfigValues.PASSWORD);
        String password = cursor.getString(passwordColumnIndex);

        int logoResourceIdColumnIndex = cursor.getColumnIndex(ConfigValues.LOGO_RESOURCE_ID);
        int logoResourceId = cursor.getInt(logoResourceIdColumnIndex);

        return new SitePassword(id, siteName, accountIdentifier, password, logoResourceId);
    }

    public ContentValues asContentValues(){
        ContentValues cv = new ContentValues();
        cv.put(ConfigValues.ID, id.toString());
        cv.put(ConfigValues.SITE_NAME, siteName);
        cv.put(ConfigValues.ACCOUNT_IDENTIFIER, accountIdentifier);
        cv.put(ConfigValues.PASSWORD, password);
        cv.put(ConfigValues.LOGO_RESOURCE_ID, logoResourceId);
        return cv;
    }

    public UUID getId() {
        return id;
    }

    public int getLogoResourceId() {
        return logoResourceId;
    }

    public void setLogoResourceId(int logoResourceId) {
        this.logoResourceId = logoResourceId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SitePassword)) return false;

        SitePassword that = (SitePassword) o;

        return logoResourceId == that.logoResourceId
                && id.equals(that.id)
                && siteName.equals(that.siteName)
                && password.equals(that.password);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + logoResourceId;
        result = 31 * result + siteName.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
