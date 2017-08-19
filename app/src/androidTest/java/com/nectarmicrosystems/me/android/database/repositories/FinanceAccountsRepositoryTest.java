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
