package com.nectarmicrosystems.me.android.modules.quotes;

import android.os.AsyncTask;
import android.content.Context;

import com.nectarmicrosystems.me.android.utilities.PreferencesManager;
import com.nectarmicrosystems.me.android.modules.quotes.entities.Quote;
import com.nectarmicrosystems.me.android.networking.apis.they_said_so_quotes.QuotesQueries;

import org.json.JSONObject;
import org.json.JSONException;

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
            JSONObject responseObject = new JSONObject(QuotesQueries.getTodaysQuote());
            return Quote.fromTheySaidSoQOD(responseObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Quote quote) {
        super.onPostExecute(quote);
        PreferencesManager preferencesManager = new PreferencesManager(context);
        preferencesManager.setTodaysQuote(quote.getQuote());
        preferencesManager.setTodaysQuoteAuthor(quote.getAuthor());
        preferencesManager.setTodaysQuoteImage(quote.getImageUrl());
    }
}
