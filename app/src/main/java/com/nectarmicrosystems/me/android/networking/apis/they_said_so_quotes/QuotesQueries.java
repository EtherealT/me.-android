package com.nectarmicrosystems.me.android.networking.apis.they_said_so_quotes;

import android.util.Log;

import java.net.URL;
import java.io.IOException;

import static com.nectarmicrosystems.me.android.networking.NetworkUtils.query;

/**
 * Created by Tobi Adeyinka on 2017. 08. 19..
 */

public abstract class QuotesQueries {

    private static final String BASE_URL = " http://quotes.rest/";

    public static String getTodaysInspiringQuote(){
        try {
            URL url = new URL(BASE_URL + "qod.json?category=inspire");
            String response = query(url);
            Log.i(QuotesQueries.class.getCanonicalName(), response);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
