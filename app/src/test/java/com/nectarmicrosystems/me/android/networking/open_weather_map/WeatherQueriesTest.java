package com.nectarmicrosystems.me.android.networking.open_weather_map;

import com.nectarmicrosystems.me.android.TestUtils;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Tobi Adeyinka on 2017. 06. 07..
 */

public class WeatherQueriesTest {

    private static final Logger LOGGER = Logger.getLogger(WeatherQueriesTest.class.getCanonicalName());

    private final String TEST_CITY = "Budapest";
    private final String TEST_COUNTRY_ISO = "HU";

    @BeforeClass
    public void setup(){
        TestUtils.setupLogger(LOGGER);
    }

    @Test
    public void getCurrentWeatherByCityTest() throws IOException {
        String response = WeatherQueries.getCurrentWeather(TEST_CITY);
        Assert.assertFalse(response.isEmpty());
        Assert.assertTrue(response.contains(TEST_CITY));
        LOGGER.info("weather by city response: " + response);
    }

    @Test
    public void getCurrentWeatherByCityAndCountryISO() throws IOException {
        String response = WeatherQueries.getCurrentWeather(TEST_CITY, TEST_COUNTRY_ISO);
        Assert.assertFalse(response.isEmpty());
        Assert.assertTrue(response.contains(TEST_CITY));
        LOGGER.info("weather by city and ISO response: " + response);
    }

}
