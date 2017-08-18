package com.nectarmicrosystems.me.android.modules.finance_manger.entities;

import java.util.Date;
import java.util.UUID;
import java.math.BigDecimal;

/**
 * Created by Tobi Adeyinka on 2017. 08. 18..
 */

public class FinanceEntry {

    /*
     * unique auto generated id of an account
     */
    private final UUID id;
    private Date date;
    private BigDecimal amount;
    private String description;
    private UUID accountId;

    public FinanceEntry(Date date, BigDecimal amount, String description, UUID accountId) {
        id = UUID.randomUUID();
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.accountId = accountId;
    }
}
