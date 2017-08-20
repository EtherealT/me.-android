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

package com.nectarmicrosystems.me.android.database.repositories;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.nectarmicrosystems.me.android.modules.finance_manger.entities.Currency;
import com.nectarmicrosystems.me.android.modules.finance_manger.entities.FinanceAccount;
import com.nectarmicrosystems.me.android.modules.finance_manger.entities.FinanceAccountType;

import org.junit.*;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tobi Adeyinka on 2017. 08. 18..
 */

public class FinanceAccountsRepositoryTest {

    private FinanceAccountsRepository financeAccountsRepository;

    @Before
    public void setup() {
        Context context = InstrumentationRegistry.getTargetContext();
        financeAccountsRepository = new FinanceAccountsRepository(context);
        emptyDatabase();
    }

    @Test
    public void testInsertNewFinanceAccount(){
        FinanceAccount account = createFinanceAccountForTest();
        financeAccountsRepository.insert(account);
        assertEquals(financeAccountsRepository.getAll().size(), 1);
    }

    /*
     * empty the database after each test
     */
    @After
    public void emptyDatabase(){
        financeAccountsRepository.deleteAll();
    }

    private FinanceAccount createFinanceAccountForTest(){
        return new FinanceAccount("Test Account", new BigDecimal(2000), FinanceAccountType.SAVINGS, Currency.USD);
    }

}
