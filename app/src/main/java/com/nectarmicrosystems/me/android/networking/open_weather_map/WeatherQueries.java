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

    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = Sensitive.OPEN_WEATHER_MAP_API_KEY;

    /**
     * get the current weather data for a city using the city name and country ISO code
     *
     * @param city Name of the city
     * @param countryISO3166 ISO3166 Country code
     * @return String JSON representation of current weather data
     * @throws IOException
     */
    public static String getCurrentWeather(String city, String countryISO3166) throws IOException {
        return getCurrentWeather(city + "," + countryISO3166);
    }

    /**
     * get the current weather data for a city using the city name
     *
     * @param city Name of the city
     * @return String JSON representation of current weather data
     * @throws IOException
     */
    public static String getCurrentWeather(String city) throws IOException {
        try {
            URL url = new URL(BASE_URL + "weather?q=" + city + "&appid=" + API_KEY);
            return query(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
