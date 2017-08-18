package com.nectarmicrosystems.me.android.modules.finance_manger.entities;

import android.database.Cursor;
import android.content.ContentValues;

import com.nectarmicrosystems.me.android.utilities.Common;
import com.nectarmicrosystems.me.android.config.ConfigValues;

import java.util.Date;
import java.util.UUID;
import java.math.BigDecimal;

/**
 * Created by Tobi Adeyinka on 2017. 08. 18..
 */

class FinanceEntry {

    /*
     * unique auto generated id of an account
     */
    private final UUID id;
    private Date date;
    private BigDecimal amount;
    private String description;
    private UUID accountId;
    private FinanceEntryType entryType;

    FinanceEntry(Date date, BigDecimal amount, String description, UUID accountId, FinanceEntryType entryType) {
        id = UUID.randomUUID();
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.accountId = accountId;
        this.entryType = entryType;
    }

    private FinanceEntry(UUID id, Date date, BigDecimal amount, String description, UUID accountId, FinanceEntryType entryType){
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.accountId = accountId;
        this.entryType = entryType;
    }

    public static FinanceEntry fromCursor(Cursor cursor){
        int idColumnIndex = cursor.getColumnIndex(ConfigValues.ID);
        int dateColumnIndex = cursor.getColumnIndex(ConfigValues.DATE);
        int amountColumnIndex = cursor.getColumnIndex(ConfigValues.AMOUNT);
        int descriptionColumnIndex = cursor.getColumnIndex(ConfigValues.DESCRIPTION);
        int accountIdColumnIndex = cursor.getColumnIndex(ConfigValues.ACCOUNT_ID);
        int entryTypeColumnIndex = cursor.getColumnIndex(ConfigValues.ENTRY_TYPE);

        UUID id = UUID.fromString(cursor.getString(idColumnIndex));
        Date date = Common.dateFromString(cursor.getString(dateColumnIndex));
        BigDecimal amount = new BigDecimal(cursor.getDouble(amountColumnIndex));
        String description = cursor.getString(descriptionColumnIndex);
        UUID accountId = UUID.fromString(cursor.getString(accountIdColumnIndex));
        FinanceEntryType entryType = FinanceEntryType.valueOf(cursor.getString(entryTypeColumnIndex));

        return new FinanceEntry(id, date, amount, description, accountId, entryType);
    }

    /*
     * get content values representation of instance
     */
    public ContentValues asContentValues(){
        ContentValues cv = new ContentValues();
        cv.put(ConfigValues.ID, id.toString());
        cv.put(ConfigValues.DATE, date.toString());
        cv.put(ConfigValues.AMOUNT, amount.toString());
        cv.put(ConfigValues.DESCRIPTION, description);
        cv.put(ConfigValues.ACCOUNT_ID, accountId.toString());
        cv.put(ConfigValues.ENTRY_TYPE, entryType.toString());
        return cv;
    }

    public UUID getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public FinanceEntryType getEntryType() {
        return entryType;
    }

    public void setEntryType(FinanceEntryType entryType) {
        this.entryType = entryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FinanceEntry)) return false;

        FinanceEntry that = (FinanceEntry) o;
        return id.equals(that.id) && date.equals(that.date)
                && amount.equals(that.amount)
                && accountId.equals(that.accountId)
                && entryType == that.entryType;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + accountId.hashCode();
        result = 31 * result + entryType.hashCode();
        return result;
    }
}
