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

package com.nectarmicrosystems.me.android.modules.finance_manger.entities;

import java.util.Date;
import java.util.UUID;
import java.math.BigDecimal;

/**
 * Created by Tobi Adeyinka on 2017. 08. 18..
 */

public class ExpenseEntry extends FinanceEntry {

    public ExpenseEntry(Date date, BigDecimal amount, String description, UUID accountId) {
        super(date, amount, description, accountId, FinanceEntryType.EXPENSE);
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
