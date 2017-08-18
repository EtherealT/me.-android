package com.nectarmicrosystems.me.android.database.repositories;

import android.content.Context;
import android.content.ContentValues;

import com.nectarmicrosystems.me.android.modules.finance_manger.entities.FinanceAccount;
import com.nectarmicrosystems.me.android.database.content_providers.FinanceAccountsProvider;

import java.util.UUID;
import java.util.ArrayList;

/**
 * Created by Tobi Adeyinka on 2017. 08. 18..
 */

public class FinanceAccountsRepository implements DatabaseRepository<FinanceAccount> {

    private Context context;

    public FinanceAccountsRepository(Context context) {
        this.context = context;
    }

    @Override
    public void insert(FinanceAccount data) {
        ContentValues values = data.asContentValues();
        context.getApplicationContext()
                .getContentResolver()
                .insert(FinanceAccountsProvider.CONTENT_URI, values);
    }

    @Override
    public void update(FinanceAccount data) {

    }

    @Override
    public void delete(UUID dataId) {

    }

    @Override
    public ArrayList<FinanceAccount> getAll() {
        return null;
    }

    @Override
    public FinanceAccount getById(UUID dataId) {
        return null;
    }

}
