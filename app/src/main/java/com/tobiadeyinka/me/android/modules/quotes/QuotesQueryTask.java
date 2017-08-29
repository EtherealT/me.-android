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

package com.tobiadeyinka.me.android.modules.quotes;

import android.os.AsyncTask;
import android.content.Context;

import com.tobiadeyinka.me.android.utilities.PreferencesManager;
import com.tobiadeyinka.me.android.modules.quotes.entities.Quote;
import com.tobiadeyinka.me.android.networking.apis.forismatic_quotes.QuotesQueries;

import org.json.JSONObject;
import org.json.JSONException;

import java.net.InetAddress;

/**
 * Created by Tobi Adeyinka on 2017. 08. 20..
 */

public class QuotesQueryTask extends AsyncTask<Void, Void, Quote> {

    private Context context;

    public QuotesQueryTask(Context context) {
        this.context = context;
    }

    @Override
    protected Quote doInBackground(Void... params) {
        try {
            if (internetAvailable()){
                JSONObject responseObject = new JSONObject(QuotesQueries.getTodaysInspiringQuote());
                return Quote.fromTheySaidSoQOD(responseObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Quote quote) {
        super.onPostExecute(quote);
        if (quote != null){
            PreferencesManager preferencesManager = new PreferencesManager(context);
            preferencesManager.setTodaysQuote(quote.getQuote());
            preferencesManager.setTodaysQuoteAuthor(quote.getAuthor());
            preferencesManager.setTodaysQuoteImage(quote.getImageUrl());
        }
    }

    private boolean internetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            return !ipAddr.equals("");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
