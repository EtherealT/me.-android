package com.nectarmicrosystems.me.android.modules.finance_manger.entities;

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

    public FinanceAccount(String name, FinanceAccountType accountType, BigDecimal balance) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
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
