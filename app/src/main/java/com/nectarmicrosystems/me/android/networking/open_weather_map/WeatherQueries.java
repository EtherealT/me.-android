package com.nectarmicrosystems.me.android.networking.open_weather_map;

import com.nectarmicrosystems.me.android.config.Sensitive;

import java.net.URL;
import java.io.IOException;
import java.net.MalformedURLException;

import static com.nectarmicrosystems.me.android.networking.NetworkUtils.query;

/**
 * Created by tobi on 2017. 06. 07..
 */

class WeatherQueries {

    private static final String BASE_URL = "api.openweathermap.org/data/2.5/weather?q=";
    private static final String API_KEY = Sensitive.OPEN_WEATHER_MAP_API_KEY;

    public static String getCurrentWeather(String city, String countryISO3166) throws IOException {
        return getCurrentWeather(city + "," + countryISO3166);
    }

    public static String getCurrentWeather(String city) throws IOException {
        try {
            URL url = new URL(BASE_URL + city);
            return query(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
