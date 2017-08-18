package com.nectarmicrosystems.me.android.networking.open_weather_map;

import android.support.test.runner.AndroidJUnit4;

import com.nectarmicrosystems.me.android.TestUtils;

import org.junit.*;
import org.junit.runner.RunWith;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Tobi Adeyinka on 2017. 08. 15..
 */

@RunWith(AndroidJUnit4.class)
public class WeatherQueriesTest {

    private static final Logger LOGGER = Logger.getLogger(WeatherQueriesTest.class.getCanonicalName());

    private final String TEST_CITY = "Budapest";
    private final String TEST_COUNTRY_ISO = "HU";

    @Before
    public void setup(){
        TestUtils.setupLogger(LOGGER);
    }

    @Test
    public void testGetCurrentWeatherByCity(){
        String response = WeatherQueries.getCurrentWeather(TEST_CITY);
        Assert.assertFalse(response.isEmpty());
        Assert.assertTrue(response.contains(TEST_CITY));
        LOGGER.log(Level.INFO, "current weather by city response: " + response);
    }

    @Test
    public void testGetCurrentWeatherByCityAndCountryISO(){
        String response = WeatherQueries.getCurrentWeather(TEST_CITY, TEST_COUNTRY_ISO);
        Assert.assertFalse(response.isEmpty());
        Assert.assertTrue(response.contains(TEST_CITY));
        LOGGER.log(Level.INFO, "current weather by city and ISO response: " + response);
    }

    @Test
    public void testGetWeatherForecastByCity(){
        String response = WeatherQueries.getWeatherForecast(TEST_CITY);
        Assert.assertFalse(response.isEmpty());
        Assert.assertTrue(response.contains(TEST_CITY));
        LOGGER.log(Level.INFO, "weather forecast by city response: " + response);
    }

    @Test
    public void testGetWeatherForecastByCityAndCountryISO(){
        String response = WeatherQueries.getWeatherForecast(TEST_CITY, TEST_COUNTRY_ISO);
        Assert.assertFalse(response.isEmpty());
        Assert.assertTrue(response.contains(TEST_CITY));
        LOGGER.log(Level.INFO, "weather forecast by city and ISO response: " + response);
    }

}
