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

package com.tobiadeyinka.me.android.database.repositories;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.tobiadeyinka.me.android.AndroidTest;
import com.tobiadeyinka.me.android.modules.finance_manager.entities.*;

import org.junit.*;

import java.util.UUID;
import java.math.BigDecimal;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by Tobi Adeyinka on 2017. 08. 18..
 */

public class FinanceAccountsRepositoryTest extends AndroidTest{

    private FinanceAccountsRepository financeAccountsRepository;

    private static final String TEST_ACCOUNT_NAME = "Test Account";

    @Before
    public void setUp() {
        Context context = InstrumentationRegistry.getTargetContext();
        financeAccountsRepository = new FinanceAccountsRepository(context);
        emptyDatabase();
    }

    @Test
    public void testInsertNewFinanceAccount(){
        createAndSaveFinanceAccountForTest();
        assertEquals(financeAccountsRepository.getAll().size(), 1);
    }

    @Test
    public void testGetFinanceAccountById(){
        FinanceAccount account = createAndSaveFinanceAccountForTest();
        assertEquals(financeAccountsRepository.getById(account.getId()).getName(), TEST_ACCOUNT_NAME);
    }

    @Test
    public void testGetFinanceAccountWithNonExistingId(){
        FinanceAccount account = financeAccountsRepository.getById(UUID.randomUUID());
        assertNull(account);
    }

    @Test
    public void testUpdateFinanceAccount(){
        FinanceAccount account = createAndSaveFinanceAccountForTest();
        String newName = "New Name";
        account.setName(newName);
        financeAccountsRepository.update(account);
        assertEquals(financeAccountsRepository.getById(account.getId()).getName(), newName);
    }

    @Test
    public void testDeleteAccountById(){
        FinanceAccount account = createAndSaveFinanceAccountForTest();
        financeAccountsRepository.delete(account.getId());
        assertEquals(financeAccountsRepository.getAll().size(), 0);
    }

    @Test
    public void testDeleteAll(){
        createAndSaveFinanceAccountForTest();
        financeAccountsRepository.deleteAll();
        assertEquals(financeAccountsRepository.getAll().size(), 0);
    }

    /*
     * empty the database after each test
     */
    @After
    public void emptyDatabase(){
        financeAccountsRepository.deleteAll();
    }

    private FinanceAccount createAndSaveFinanceAccountForTest(){
        FinanceAccount account = new FinanceAccount(TEST_ACCOUNT_NAME, new BigDecimal(2000), FinanceAccountType.SAVINGS, Currency.USD);
        financeAccountsRepository.insert(account);
        return account;
    }

}
