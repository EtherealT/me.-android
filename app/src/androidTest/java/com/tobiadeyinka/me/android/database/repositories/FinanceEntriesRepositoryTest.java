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

import java.util.Date;
import java.util.UUID;
import java.math.BigDecimal;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by Tobi Adeyinka on 2017. 08. 25..
 */

public class FinanceEntriesRepositoryTest extends AndroidTest{

    private FinanceAccountsRepository financeAccountsRepository;
    private FinanceEntriesRepository financeEntriesRepository;

    private static final String TEST_ENTRY_DESCRIPTION = "Test Entry";

    @Before
    public void setUp() {
        Context context = InstrumentationRegistry.getTargetContext();
        financeAccountsRepository = new FinanceAccountsRepository(context);
        financeEntriesRepository = new FinanceEntriesRepository(context);
        emptyDatabase();
    }

    @Test
    public void testInsertNewFinanceEntry(){
        createAndSaveFinanceEntryForTest();
        assertEquals(financeEntriesRepository.getAll().size(), 1);
    }

    @Test
    public void testGetFinanceEntryById(){
        FinanceEntry entry = createAndSaveFinanceEntryForTest();
        assertEquals(financeEntriesRepository.getById(entry.getId()).getDescription(), TEST_ENTRY_DESCRIPTION);
    }

    @Test
    public void testGetFinanceEntryWithNonExistingId(){
        FinanceEntry entry = financeEntriesRepository.getById(UUID.randomUUID());
        assertNull(entry);
    }

    @Test
    public void testUpdateFinanceEntry(){
        FinanceEntry entry = createAndSaveFinanceEntryForTest();
        String newDescription = "New Description";
        entry.setDescription(newDescription);
        financeEntriesRepository.update(entry);
        assertEquals(financeEntriesRepository.getById(entry.getId()).getDescription(), newDescription);
    }

    @Test
    public void testDeleteEntryById(){
        FinanceEntry entry = createAndSaveFinanceEntryForTest();
        financeEntriesRepository.delete(entry.getId());
        assertEquals(financeEntriesRepository.getAll().size(), 0);
    }

    @Test
    public void testDeleteAll(){
        createAndSaveFinanceEntryForTest();
        financeEntriesRepository.deleteAll();
        assertEquals(financeEntriesRepository.getAll().size(), 0);
    }

    /*
     * empty the database after each test
     */
    @After
    public void emptyDatabase(){
        financeEntriesRepository.deleteAll();
        financeAccountsRepository.deleteAll();
    }

    private FinanceEntry createAndSaveFinanceEntryForTest(){
        FinanceAccount account = createAndSaveFinanceAccountForTest();
        FinanceEntry entry = new FinanceEntry(new Date(), new BigDecimal("20.0"), TEST_ENTRY_DESCRIPTION, account.getId(), FinanceEntryType.INCOME);
        financeEntriesRepository.insert(entry);
        return entry;
    }

    private FinanceAccount createAndSaveFinanceAccountForTest(){
        FinanceAccount account = new FinanceAccount("Test Account", new BigDecimal(2000), FinanceAccountType.SAVINGS, Currency.USD);
        financeAccountsRepository.insert(account);
        return account;
    }
}
