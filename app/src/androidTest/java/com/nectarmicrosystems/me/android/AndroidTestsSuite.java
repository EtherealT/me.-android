package com.nectarmicrosystems.me.android;

import com.nectarmicrosystems.me.android.utilities.SecurityManagerTest;
import com.nectarmicrosystems.me.android.networking.apis.open_weather_map.WeatherQueriesTest;
import com.nectarmicrosystems.me.android.database.repositories.FinanceAccountsRepositoryTest;
import com.nectarmicrosystems.me.android.networking.apis.they_said_so_quotes.QuotesQueriesTest;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

/**
 * Created by Tobi Adeyinka on 2017. 08. 15..
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        QuotesQueriesTest.class,
        WeatherQueriesTest.class,
        SecurityManagerTest.class,
        FinanceAccountsRepositoryTest.class
})
public class AndroidTestsSuite {}
