package com.nectarmicrosystems.me.android.modules.finance_manger.entities;

/**
 * Created by Tobi Adeyinka on 2017. 08. 18..
 */

public enum FinanceAccountType {
    CURRENT,
    SAVINGS;

    @Override
    public String toString() {
        return this == CURRENT ? "CURRENT" : "SAVINGS";
    }
}
