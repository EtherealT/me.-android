package com.nectarmicrosystems.me.android.networking.apis.they_said_so_quotes;

import java.io.IOException;
import java.net.URL;

import static com.nectarmicrosystems.me.android.networking.NetworkUtils.query;

/**
 * Created by Tobi Adeyinka on 2017. 08. 19..
 */

public abstract class QuotesQueries {

    private static final String BASE_URL = " http://quotes.rest/";

    public static String getTodaysQuote(){
        try {
            URL url = new URL(BASE_URL + "qod.json");
            return query(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
