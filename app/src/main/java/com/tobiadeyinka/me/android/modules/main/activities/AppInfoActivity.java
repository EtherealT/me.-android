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

package com.tobiadeyinka.me.android.modules.main.activities;

import android.os.Bundle;
import android.view.Window;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.tobiadeyinka.me.R;

/**
 * Created by Tobi Adeyinka on 2017. 09. 19..
 */

public class AppInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        colorStatusBar();
    }

    private void colorStatusBar(){
        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
    }

}
