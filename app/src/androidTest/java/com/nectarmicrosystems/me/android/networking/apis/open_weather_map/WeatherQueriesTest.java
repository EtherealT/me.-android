package com.nectarmicrosystems.me.android.networking.apis.open_weather_map;

import android.util.Log;
import android.support.test.runner.AndroidJUnit4;

import org.junit.*;
import org.junit.runner.RunWith;

/**
 * Created by Tobi Adeyinka on 2017. 08. 15..
 */

@RunWith(AndroidJUnit4.class)
public class WeatherQueriesTest {

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
