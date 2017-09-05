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

import android.view.*;
import android.widget.*;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.tobiadeyinka.me.R;
import com.tobiadeyinka.me.android.modules.password_manager.entities.Website;
import com.tobiadeyinka.me.android.modules.password_manager.entities.SitePassword;
import com.tobiadeyinka.me.android.database.repositories.SitePasswordsRepository;
import com.tobiadeyinka.me.android.modules.password_manager.utils.WebsitesManager;
import com.tobiadeyinka.me.android.modules.password_manager.utils.WebsitesSpinnerAdapter;

/**
 * Created by Tobi Adeyinka on 2017. 08. 26..
 */

public class NewSitePasswordActivity extends AppCompatActivity {

    /*
     * spinner for selecting password app/website
     */
    private Spinner siteSelector;

    /*
     * account identifier input field
     */
    private EditText accountIdentifierInput;

    /*
     * password input field
     */
    private EditText passwordInput;

    /*
     * repository for database access
     */
    private SitePasswordsRepository sitePasswordsRepository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_site_password);

        colorStatusBar();
        setUpSiteSelector();
        setUpAccountIdentifierInputField();
        setUpPasswordInputField();
        setUpSaveButton();

        /*
         * stop the keyboard from popping up on activity start
         */
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        sitePasswordsRepository = new SitePasswordsRepository(this);
    }

    private void setUpSiteSelector(){
        siteSelector = (Spinner)findViewById(R.id.app_website_selector);
        WebsitesSpinnerAdapter siteSelectorAdapter = new WebsitesSpinnerAdapter(this);
        siteSelector.setAdapter(siteSelectorAdapter);
    }

    private void setUpAccountIdentifierInputField(){
        accountIdentifierInput = (EditText)findViewById(R.id.account_identifier_input);
    }

    private void setUpPasswordInputField(){
        passwordInput = (EditText)findViewById(R.id.password_input);
    }

    private void setUpSaveButton(){
        Button saveButton = (Button)findViewById(R.id.save_password_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accountIdentifier = accountIdentifierInput.getText().toString();
                String password = passwordInput.getText().toString();
                if(validateInput(accountIdentifier, password)){
                    Website website = WebsitesManager.getWEBSITES()[siteSelector.getSelectedItemPosition()];
                    SitePassword sitePassword = new SitePassword(
                            website.getName(),
                            accountIdentifier,
                            password,
                            website.getLogoResourceId()
                    );

                    sitePasswordsRepository.insert(sitePassword);
                    finish();
                };
            }
        });
    }

    private boolean validateInput(String accountIdentifier, String password){
        if (accountIdentifier.isEmpty()) {
            Toast.makeText(this, getString(R.string.error_1), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.isEmpty()) {
            Toast.makeText(this, getString(R.string.error_2), Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void colorStatusBar(){
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
    }

}
