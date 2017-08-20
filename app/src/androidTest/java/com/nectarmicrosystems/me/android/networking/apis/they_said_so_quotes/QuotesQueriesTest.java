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
        String response = QuotesQueries.getTodaysInspiringQuote();
        Assert.assertFalse(response.isEmpty());
        Log.i(WeatherQueriesTest.class.getCanonicalName(), "todays quote response: " + response);
    }

}
