package com.nectarmicrosystems.me.android.database.repositories;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.InstrumentationRegistry;

import com.nectarmicrosystems.me.android.modules.finance_manger.entities.*;

import org.junit.*;
import org.junit.runner.RunWith;

import java.util.Date;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tobi Adeyinka on 2017. 08. 25..
 */

@RunWith(AndroidJUnit4.class)
public class FinanceEntriesRepositoryTest {

    private FinanceAccountsRepository financeAccountsRepository;
    private FinanceEntriesRepository financeEntriesRepository;

    @Before
    public void setup() {
        Context context = InstrumentationRegistry.getTargetContext();
        financeAccountsRepository = new FinanceAccountsRepository(context);
        financeEntriesRepository = new FinanceEntriesRepository(context);
        emptyDatabase();
    }

    @Test
    public void testInsertNewFinanceEntry(){
        FinanceEntry entry = createFinanceEntryForTest();
        financeEntriesRepository.insert(entry);
        assertEquals(financeEntriesRepository.getAll().size(), 1);
    }

    /*
     * empty the database after each test
     */
    @After
    public void emptyDatabase(){
        financeEntriesRepository.deleteAll();
        financeAccountsRepository.deleteAll();
    }

    private FinanceEntry createFinanceEntryForTest(){
        FinanceAccount account = createFinanceAccountForTest();
        financeAccountsRepository.insert(account);
        return new FinanceEntry(new Date(), new BigDecimal(20.0), "test entry", account.getId(), FinanceEntryType.INCOME);
    }

    private FinanceAccount createFinanceAccountForTest(){
        return new FinanceAccount("Test Account", new BigDecimal(2000), FinanceAccountType.SAVINGS, Currency.USD);
    }
}
