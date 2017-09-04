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

package com.tobiadeyinka.me.android.modules.password_manager.activities;

import android.os.Bundle;
import android.view.Window;
import android.widget.Spinner;
import android.view.WindowManager;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.tobiadeyinka.me.R;
import com.tobiadeyinka.me.android.modules.password_manager.utils.WebsitesSpinnerAdapter;

/**
 * Created by Tobi Adeyinka on 2017. 08. 26..
 */

public class NewSitePasswordActivity extends AppCompatActivity {

    /*
     * spinner for selecting password app/website
     */
    private Spinner siteSelector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_site_password);
        colorStatusBar();
        setUpSiteSelector();

        /*
         * stop the keyboard from popping up on activity start
         */
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    private void setUpSiteSelector(){
        siteSelector = (Spinner)findViewById(R.id.app_website_selector);
        WebsitesSpinnerAdapter siteSelectorAdapter = new WebsitesSpinnerAdapter(this);
        siteSelector.setAdapter(siteSelectorAdapter);
    }

    private void colorStatusBar(){
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
    }

}
