package com.nectarmicrosystems.me.android.networking.apis.they_said_so_quotes;

import android.util.Log;
import android.support.test.runner.AndroidJUnit4;

import com.nectarmicrosystems.me.android.networking.apis.open_weather_map.WeatherQueriesTest;

import org.junit.*;
import org.junit.runner.RunWith;

/**
 * Created by Tobi Adeyinka on 2017. 08. 20..
 */

@RunWith(AndroidJUnit4.class)
public class QuotesQueriesTest {

    @Test
    public void testGetTodaysQuote(){
        String response = QuotesQueries.getTodaysQuote();
        Assert.assertFalse(response.isEmpty());
        Log.i(WeatherQueriesTest.class.getCanonicalName(), "todays quote response: " + response);
    }

}
