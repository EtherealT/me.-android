package com.nectarmicrosystems.me.android.networking.apis.open_weather_map;

import com.nectarmicrosystems.me.android.config.Sensitive;

import java.net.URL;
import java.io.IOException;

import static com.nectarmicrosystems.me.android.networking.NetworkUtils.query;

/**
 * Created by tobi on 2017. 06. 07..
 */

public abstract class WeatherQueries {

    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = Sensitive.OPEN_WEATHER_MAP_API_KEY;

    /*
     * get the current weather for a city using
     * the city name and country ISO code
     */
    public static String getCurrentWeather(String city, String countryISO3166){
        return getCurrentWeather(city + "," + countryISO3166);
    }

    /*
     * get the current weather data for a city using the city name
     */
    public static String getCurrentWeather(String city){
        try {
            URL url = new URL(BASE_URL + "weather?q=" + city + "&appid=" + API_KEY);
            return query(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * get the weather forecast for a city using
     * the city name and country ISO code
     */
    public static String getWeatherForecast(String city, String countryISO3166){
        return getWeatherForecast(city + "," + countryISO3166);
    }

    /*
     * get the weather forecast for a city using the city name
     */
    public static String getWeatherForecast(String city){
        try {
            URL url = new URL(BASE_URL + "forecast?q=" + city + "&appid=" + API_KEY);
            return query(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
