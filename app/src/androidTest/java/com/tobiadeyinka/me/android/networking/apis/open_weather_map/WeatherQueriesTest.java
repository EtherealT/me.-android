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

package com.tobiadeyinka.me.android.networking.apis.open_weather_map;

import android.util.Log;

import com.tobiadeyinka.me.android.AndroidTest;

import org.junit.*;

/**
 * Created by Tobi Adeyinka on 2017. 08. 15..
 */

public class WeatherQueriesTest extends AndroidTest{

    private final String TEST_CITY = "Budapest";
    private final String TEST_COUNTRY_ISO = "HU";

    @Test
    public void testGetCurrentWeatherByCity(){
        String response = WeatherQueries.getCurrentWeather(TEST_CITY);
        Assert.assertFalse(response.isEmpty());
        Assert.assertTrue(response.contains(TEST_CITY));
        Log.i(WeatherQueriesTest.class.getCanonicalName(), "current weather by city response: " + response);
    }

    @Test
    public void testGetCurrentWeatherByCityAndCountryISO(){
        String response = WeatherQueries.getCurrentWeather(TEST_CITY, TEST_COUNTRY_ISO);
        Assert.assertFalse(response.isEmpty());
        Assert.assertTrue(response.contains(TEST_CITY));
        Log.i(WeatherQueriesTest.class.getCanonicalName(), "current weather by city and ISO response: " + response);
    }

    @Test
    public void testGetWeatherForecastByCity(){
        String response = WeatherQueries.getWeatherForecast(TEST_CITY);
        Assert.assertFalse(response.isEmpty());
        Assert.assertTrue(response.contains(TEST_CITY));
        Log.i(WeatherQueriesTest.class.getCanonicalName(), "weather forecast by city response: " + response);
    }

    @Test
    public void testGetWeatherForecastByCityAndCountryISO(){
        String response = WeatherQueries.getWeatherForecast(TEST_CITY, TEST_COUNTRY_ISO);
        Assert.assertFalse(response.isEmpty());
        Assert.assertTrue(response.contains(TEST_CITY));
        Log.i(WeatherQueriesTest.class.getCanonicalName(), "weather forecast by city and ISO response: " + response);
    }

}
