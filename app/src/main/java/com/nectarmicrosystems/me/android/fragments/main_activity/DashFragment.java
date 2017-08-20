package com.nectarmicrosystems.me.android.fragments.main_activity;

import android.view.*;
import android.os.Bundle;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.ImageView;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;

import com.nectarmicrosystems.me.R;
import com.nectarmicrosystems.me.android.utilities.PreferencesManager;

import com.squareup.picasso.Picasso;

/**
 * Created by tobi on 2017. 06. 06..
 */

public class DashFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_dash_main_activity, container, false);

        ImageView quoteBackground = (ImageView) rootView.findViewById(R.id.quote_background);
        TextView quoteTextView = (TextView) rootView.findViewById(R.id.todays_quote);

        PreferencesManager preferencesManager = new PreferencesManager(getContext());
        quoteTextView.setText(preferencesManager.getTodaysQuote());

        if (!preferencesManager.getTodaysQuoteImage().isEmpty())
            Picasso.with(getActivity()).load(preferencesManager.getTodaysQuoteImage()).into(quoteBackground);

        return rootView;
    }

}
