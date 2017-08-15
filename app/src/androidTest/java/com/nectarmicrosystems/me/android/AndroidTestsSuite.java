package com.nectarmicrosystems.me.android;

import com.nectarmicrosystems.me.android.utilities.SecurityManagerTest;
import com.nectarmicrosystems.me.android.networking.open_weather_map.WeatherQueriesTest;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

/**
 * Created by Tobi Adeyinka on 2017. 08. 15..
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        WeatherQueriesTest.class,
        SecurityManagerTest.class
})
public class AndroidTestsSuite {}
