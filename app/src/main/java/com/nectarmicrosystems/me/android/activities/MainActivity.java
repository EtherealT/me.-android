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

package com.nectarmicrosystems.me.android.activities;

import android.util.Log;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.nectarmicrosystems.me.R;
import com.nectarmicrosystems.me.android.entities.CustomViewPager;
import com.nectarmicrosystems.me.android.fragments.main_activity.MainActivityPagerAdapter;

/**
 * Created by tobi on 2017. 06. 06..
 */

public class MainActivity extends AppCompatActivity {

    private CustomViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_main);
        setupViewComponents();
    }

    private void setupViewComponents(){
        Log.i(getClass().getCanonicalName(), "setting up fragments");
        viewPager = (CustomViewPager)findViewById(R.id.view_pager);
        PagerAdapter pagerAdapter = new MainActivityPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }

}
