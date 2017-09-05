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
import android.content.Intent;
import android.widget.TextView;
import android.widget.ImageView;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tobiadeyinka.me.R;
import com.tobiadeyinka.me.android.config.ConfigValues;
import com.tobiadeyinka.me.android.database.repositories.SitePasswordsRepository;
import com.tobiadeyinka.me.android.modules.password_manager.entities.SitePassword;

import java.util.UUID;

/**
 * Created by Tobi Adeyinka on 2017. 09. 05..
 */

public class ViewSitePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_site_password);

        Intent intent = getIntent();
        String passwordId = intent.getStringExtra(ConfigValues.ID);
        SitePassword password = new SitePasswordsRepository(this).getById(UUID.fromString(passwordId));

        ((ImageView)findViewById(R.id.site_logo_image)).setImageResource(password.getLogoResourceId());
        ((TextView)findViewById(R.id.account_identifier)).setText(password.getAccountIdentifier());
        ((TextView)findViewById(R.id.password)).setText(password.getPassword());
    }

}
