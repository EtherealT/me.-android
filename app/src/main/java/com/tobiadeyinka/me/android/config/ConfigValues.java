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

package com.tobiadeyinka.me.android.config;

/**
 * Created by Tobi Adeyinka on 2017. 08. 18..
 */

public abstract class ConfigValues {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE = "com.tobiadeyinka.me";

    public static final String SITE_PASSWORDS_TABLE = "site_passwords";
    public static final String FINANCE_ENTRIES_TABLE = "finance_entries";
    public static final String FINANCE_ACCOUNTS_TABLE = "finance_accounts";

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String DATE = "date";
    public static final String AMOUNT = "amount";
    public static final String BALANCE = "balance";
    public static final String RANKING = "ranking";
    public static final String CURRENCY = "currency";
    public static final String PASSWORD = "password";
    public static final String SITE_NAME = "site_name";
    public static final String ENTRY_TYPE = "entry_type";
    public static final String ACCOUNT_ID = "account_id";
    public static final String DESCRIPTION = "description";
    public static final String ACCOUNT_TYPE = "account_type";
    public static final String LOGO_RESOURCE_ID = "logo_resource_id";
    public static final String ACCOUNT_IDENTIFIER = "account_identifier";

    public static final String[] FINANCE_ACCOUNTS_TABLE_COLUMNS = {ID, NAME, BALANCE, ACCOUNT_TYPE, CURRENCY};
    public static final String[] FINANCE_ENTRIES_TABLE_COLUMNS = {ID, DATE, AMOUNT, DESCRIPTION, ACCOUNT_ID, ENTRY_TYPE};
    public static final String[] SITE_PASSWORDS_TABLE_COLUMNS = {ID, RANKING, SITE_NAME, ACCOUNT_IDENTIFIER, PASSWORD, LOGO_RESOURCE_ID};

}
