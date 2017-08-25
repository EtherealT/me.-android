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

package com.nectarmicrosystems.me.android;

import com.nectarmicrosystems.me.android.ui_tests.*;
import com.nectarmicrosystems.me.android.database.repositories.*;
import com.nectarmicrosystems.me.android.utilities.SecurityManagerTest;

import com.nectarmicrosystems.me.android.networking.apis.open_weather_map.WeatherQueriesTest;
import com.nectarmicrosystems.me.android.networking.apis.forismatic_quotes.QuotesQueriesTest;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

/**
 * Created by Tobi Adeyinka on 2017. 08. 15..
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        QuotesQueriesTest.class,
        WeatherQueriesTest.class,
        MainActivityUITest.class,
        SecurityManagerTest.class,
        SplashActivityUITest.class,
        PasswordActivityUITest.class,
        SitePasswordsRepositoryTest.class,
        FinanceEntriesRepositoryTest.class,
        FinanceAccountsRepositoryTest.class
})
public class AndroidTestsSuite {}
