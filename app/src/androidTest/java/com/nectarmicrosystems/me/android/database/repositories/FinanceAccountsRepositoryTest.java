package com.nectarmicrosystems.me.android.database.repositories;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.nectarmicrosystems.me.android.TestUtils;
import com.nectarmicrosystems.me.android.modules.finance_manger.entities.FinanceAccount;
import com.nectarmicrosystems.me.android.modules.finance_manger.entities.FinanceAccountType;

import org.junit.*;
import java.math.BigDecimal;
import java.util.logging.Logger;

/**
 * Created by Tobi Adeyinka on 2017. 08. 18..
 */

public class FinanceAccountsRepositoryTest {

    private static final Logger LOGGER = Logger.getLogger(FinanceAccountsRepositoryTest.class.getCanonicalName());

    private FinanceAccountsRepository financeAccountsRepository;

    @Before
    public void setup() {
        TestUtils.setupLogger(LOGGER);
        Context context = InstrumentationRegistry.getTargetContext();
        financeAccountsRepository = new FinanceAccountsRepository(context);
    }

    @Test
    public void testInsertNewFinanceAccount(){
        FinanceAccount account = createFinanceAccountForTest();
        financeAccountsRepository.insert(account);
        // TODO verify insertion
    }

    private FinanceAccount createFinanceAccountForTest(){
        return new FinanceAccount("Test Account", new BigDecimal(2000), FinanceAccountType.SAVINGS);
    }

}
