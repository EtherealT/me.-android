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

package com.tobiadeyinka.me.android.modules.finance_manager.entities;

import android.database.Cursor;
import android.content.ContentValues;

import com.tobiadeyinka.me.android.config.ConfigValues;

import java.util.UUID;
import java.math.BigDecimal;

/**
 * Created by Tobi Adeyinka on 2017. 08. 18..
 */

public class FinanceAccount {

    /*
     * unique auto generated id of an account
     */
    private final UUID id;
    private String name;
    private BigDecimal balance;
    private FinanceAccountType accountType;
    private Currency currency;

    public FinanceAccount(String name, BigDecimal balance, FinanceAccountType accountType, Currency currency) {
        id = UUID.randomUUID();
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
        this.currency = currency;
    }

    private FinanceAccount(UUID id, String name, BigDecimal balance, FinanceAccountType accountType, Currency currency){
        this.id = id;
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
        this.currency = currency;
    }

    public static FinanceAccount fromCursor(Cursor cursor){
        int idColumnIndex = cursor.getColumnIndex(ConfigValues.ID);
        int nameColumnIndex = cursor.getColumnIndex(ConfigValues.NAME);
        int balanceColumnIndex = cursor.getColumnIndex(ConfigValues.BALANCE);
        int accountTypeColumnIndex = cursor.getColumnIndex(ConfigValues.ACCOUNT_TYPE);
        int currencyColumnIndex = cursor.getColumnIndex(ConfigValues.CURRENCY);

        UUID id = UUID.fromString(cursor.getString(idColumnIndex));
        String name = cursor.getString(nameColumnIndex);
        BigDecimal balance = new BigDecimal(cursor.getDouble(balanceColumnIndex));
        FinanceAccountType accountType = FinanceAccountType.valueOf(cursor.getString(accountTypeColumnIndex));
        Currency currency = Currency.valueOf(cursor.getString(currencyColumnIndex));

        return new FinanceAccount(id, name, balance, accountType, currency);
    }

    /*
     * get content values representation of instance
     */
    public ContentValues asContentValues(){
        ContentValues cv = new ContentValues();
        cv.put(ConfigValues.ID, id.toString());
        cv.put(ConfigValues.NAME, name);
        cv.put(ConfigValues.BALANCE, balance.toString());
        cv.put(ConfigValues.CURRENCY, currency.toString());
        cv.put(ConfigValues.ACCOUNT_TYPE, accountType.toString());
        return cv;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FinanceAccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(FinanceAccountType accountType) {
        this.accountType = accountType;
    }

    /*
     * remove the amount from the balance and return the new balance
     */
    public BigDecimal withdraw(BigDecimal amount){
        balance = balance.subtract(amount);
        return balance;
    }

    /*
     * add the amount to the balance and return the new balance
     */
    public BigDecimal deposit(BigDecimal amount){
        balance = balance.add(amount);
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinanceAccount)) return false;

        FinanceAccount account = (FinanceAccount) o;
        return id.equals(account.id)
                && name.equals(account.name)
                && balance.equals(account.balance)
                && accountType == account.accountType
                && currency == account.currency;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + balance.hashCode();
        result = 31 * result + accountType.hashCode();
        result = 31 * result + currency.hashCode();
        return result;
    }
}
