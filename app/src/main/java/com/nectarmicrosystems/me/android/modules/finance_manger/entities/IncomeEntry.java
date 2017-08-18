package com.nectarmicrosystems.me.android.modules.finance_manger.entities;

import java.util.Date;
import java.util.UUID;
import java.math.BigDecimal;

/**
 * Created by Tobi Adeyinka on 2017. 08. 18..
 */

public class IncomeEntry extends FinanceEntry {

    public IncomeEntry(Date date, BigDecimal amount, String description, UUID accountId) {
        super(date, amount, description, accountId, FinanceEntryType.INCOME);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
