package com.nectarmicrosystems.me.android.modules.finance_manger.entities;

import android.database.Cursor;
import android.content.ContentValues;

import com.nectarmicrosystems.me.android.config.ConfigValues;

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

    public FinanceAccount(String name, BigDecimal balance, FinanceAccountType accountType) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
    }

    private FinanceAccount(UUID id, String name, BigDecimal balance, FinanceAccountType accountType){
        this.id = id;
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
    }

    public static FinanceAccount fromCursor(Cursor cursor){
        int idColumnIndex = cursor.getColumnIndex(ConfigValues.ID);
        int nameColumnIndex = cursor.getColumnIndex(ConfigValues.NAME);
        int balanceColumnIndex = cursor.getColumnIndex(ConfigValues.BALANCE);
        int accountTypeColumnIndex = cursor.getColumnIndex(ConfigValues.ACCOUNT_TYPE);

        UUID id = UUID.fromString(cursor.getString(idColumnIndex));
        String name = cursor.getString(nameColumnIndex);
        BigDecimal balance = new BigDecimal(cursor.getDouble(balanceColumnIndex));
        FinanceAccountType accountType = FinanceAccountType.valueOf(cursor.getString(accountTypeColumnIndex));

        return new FinanceAccount(id, name, balance, accountType);
    }

    /*
     * get content values representation of instance
     */
    public ContentValues asContentValues(){
        ContentValues cv = new ContentValues();
        cv.put(ConfigValues.ID, id.toString());
        cv.put(ConfigValues.NAME, name);
        cv.put(ConfigValues.BALANCE, balance.toString());
        cv.put(ConfigValues.ACCOUNT_TYPE, accountType.toString());
        return cv;
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
        if (o == null || getClass() != o.getClass()) return false;

        FinanceAccount that = (FinanceAccount) o;
        return id.equals(that.id)
                && name.equals(that.name)
                && balance.equals(that.balance)
                && accountType == that.accountType;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + balance.hashCode();
        result = 31 * result + accountType.hashCode();
        return result;
    }

}
