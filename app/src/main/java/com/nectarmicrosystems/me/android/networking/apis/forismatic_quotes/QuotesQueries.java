/*
 *  Copyright 2017 Oluwatobi Adeyinka
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package com.nectarmicrosystems.me.android.networking.apis.forismatic_quotes;

import android.util.Log;

import java.net.URL;
import java.io.IOException;

import static com.nectarmicrosystems.me.android.networking.NetworkUtils.query;

/**
 * Created by Tobi Adeyinka on 2017. 08. 19..
 */

public abstract class QuotesQueries {

    public static String getTodaysInspiringQuote(){
        try {
            URL url = new URL("https://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
            String response = query(url);
            Log.i(QuotesQueries.class.getCanonicalName(), response);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
