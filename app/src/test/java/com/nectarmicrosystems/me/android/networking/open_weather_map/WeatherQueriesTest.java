package com.nectarmicrosystems.me.android.networking.open_weather_map;

import com.nectarmicrosystems.me.android.TestUtils;

import org.junit.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Tobi Adeyinka on 2017. 06. 07..
 */

public class WeatherQueriesTest {

    private static final Logger LOGGER = Logger.getLogger(WeatherQueriesTest.class.getCanonicalName());

    private final String TEST_CITY = "Budapest";
    private final String TEST_COUNTRY_ISO = "HU";

    @BeforeClass
    public static void setup(){
        TestUtils.setupLogger(LOGGER);
    }

    @Test
    public void getCurrentWeatherByCity(){
        String response = WeatherQueries.getCurrentWeather(TEST_CITY);
        Assert.assertFalse(response.isEmpty());
        Assert.assertTrue(response.contains(TEST_CITY));
        LOGGER.log(Level.FINE, "current weather by city response: " + response);
    }

    @Test
    public void getCurrentWeatherByCityAndCountryISO(){
        String response = WeatherQueries.getCurrentWeather(TEST_CITY, TEST_COUNTRY_ISO);
        Assert.assertFalse(response.isEmpty());
        Assert.assertTrue(response.contains(TEST_CITY));
        LOGGER.log(Level.FINE, "current weather by city and ISO response: " + response);
    }

    @Test
    public void getWeatherForecastByCity(){
        String response = WeatherQueries.getWeatherForecast(TEST_CITY);
        Assert.assertFalse(response.isEmpty());
        Assert.assertTrue(response.contains(TEST_CITY));
        LOGGER.log(Level.FINE, "weather forecast by city response: " + response);
    }

    @Test
    public void getWeatherForecastByCityAndCountryISO(){
        String response = WeatherQueries.getWeatherForecast(TEST_CITY, TEST_COUNTRY_ISO);
        Assert.assertFalse(response.isEmpty());
        Assert.assertTrue(response.contains(TEST_CITY));
        LOGGER.log(Level.INFO, "weather forecast by city and ISO response: " + response);
    }

}
