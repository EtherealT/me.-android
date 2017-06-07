package com.nectarmicrosystems.me.android.networking.open_weather_map;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Tobi Adeyinka on 2017. 06. 07..
 */

public class WeatherQueriesTest {

    private final String TEST_CITY = "Budapest";

    @Test
    public void getCurrentWeatherByCityTest() throws IOException {
        Assert.assertFalse(WeatherQueries.getCurrentWeather(TEST_CITY).isEmpty());
    }

}
