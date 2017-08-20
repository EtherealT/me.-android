package com.nectarmicrosystems.me.android.fragments.main_activity;

import android.view.*;
import android.os.Bundle;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.BitmapDrawable;

import com.nectarmicrosystems.me.R;
import com.nectarmicrosystems.me.android.modules.quotes.entities.Quote;

import com.squareup.picasso.Target;
import com.squareup.picasso.Picasso;
import com.nectarmicrosystems.me.android.networking.apis.they_said_so_quotes.QuotesQueries;

import org.json.JSONObject;
import org.json.JSONException;

/**
 * Created by tobi on 2017. 06. 06..
 */

public class DashFragment extends Fragment {

    private ImageView quoteBackground;
    private TextView quoteTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_dash_main_activity, container, false);

        quoteBackground = (ImageView) rootView.findViewById(R.id.quote_background);
        quoteTextView = (TextView) rootView.findViewById(R.id.todays_quote);
        new QuotesQueryTask().execute();

        return rootView;
    }

    private class QuotesQueryTask extends AsyncTask<Void, Void, Quote> {

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
            quoteTextView.setText(quote.getQuote());
            Picasso.with(getActivity()).load(quote.getImageUrl()).into(quoteBackground);
        }
    }

}
