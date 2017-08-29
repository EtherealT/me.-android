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

package com.tobiadeyinka.me.android.fragments.main_activity;

import android.view.*;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;

import com.tobiadeyinka.me.R;
import com.tobiadeyinka.me.android.activities.MainActivity;
import com.tobiadeyinka.me.android.utilities.PreferencesManager;

import com.squareup.picasso.Picasso;

import java.util.Random;

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
        TextView authorTextView = (TextView) rootView.findViewById(R.id.todays_quote_author);

        int randomQuoteIndex = new Random().nextInt(4);
        PreferencesManager preferencesManager = new PreferencesManager(getContext());
        quoteTextView.setText(preferencesManager.getTodaysQuote(randomQuoteIndex));
        authorTextView.setText(preferencesManager.getTodaysQuoteAuthor(randomQuoteIndex));

        if (!preferencesManager.getTodaysQuoteImage().isEmpty())
            Picasso.with(getActivity()).load(preferencesManager.getTodaysQuoteImage()).into(quoteBackground);

        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (this.isVisible()) ((MainActivity)getActivity()).removeWindowLimits();
    }

}
