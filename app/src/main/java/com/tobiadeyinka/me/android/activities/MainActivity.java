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

package com.tobiadeyinka.me.android.activities;

import android.support.v4.content.ContextCompat;
import android.view.*;
import android.os.Bundle;
import android.content.Intent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import com.tobiadeyinka.me.R;
import com.tobiadeyinka.me.android.entities.CustomViewPager;
import com.tobiadeyinka.me.android.fragments.main_activity.MainActivityPagerAdapter;

/**
 * Created by tobi on 2017. 06. 06..
 */

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private CustomViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeWindowLimits();
        setContentView(R.layout.activity_main);
        setupViewPager();
        drawer = (DrawerLayout)findViewById(R.id.main_activity_drawer);
        setupButtonListeners();
    }

    public void removeWindowLimits(){
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public void restoreWindowLimits(){
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
    }

    private void setupViewPager(){
        viewPager = (CustomViewPager)findViewById(R.id.main_activity_view_pager);
        PagerAdapter pagerAdapter = new MainActivityPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }

    private void setupButtonListeners(){
        setupDashboardButtonListener();
        setupTasksButtonListener();
        setupFinancesButtonLister();
        setupPasswordsButtonListener();
        setupJournalButtonLister();
        setupSettingsButtonListener();
    }

    private void setupDashboardButtonListener(){
        LinearLayout dashboardButton = (LinearLayout)findViewById(R.id.dashboard_button);
        dashboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * set the dash fragment as the active fragment then close the drawer
                 */
                viewPager.setCurrentItem(MainActivityPagerAdapter.DASH_FRAGMENT);
                drawer.closeDrawer(Gravity.LEFT);
                removeWindowLimits();
            }
        });
    }

    private void setupTasksButtonListener(){
        LinearLayout tasksButton = (LinearLayout)findViewById(R.id.tasks_button);
        tasksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * set the tasks fragment as the active fragment then close the drawer
                 */
                viewPager.setCurrentItem(MainActivityPagerAdapter.TASKS_FRAGMENT);
                drawer.closeDrawer(Gravity.LEFT);
                restoreWindowLimits();
            }
        });
    }

    private void setupFinancesButtonLister(){
        LinearLayout financesButton = (LinearLayout)findViewById(R.id.finances_button);
        financesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * set the finances fragment as the active fragment then close the drawer
                 */
                viewPager.setCurrentItem(MainActivityPagerAdapter.FINANCES_FRAGMENT);
                drawer.closeDrawer(Gravity.LEFT);
                restoreWindowLimits();
            }
        });
    }

    private void setupPasswordsButtonListener(){
        LinearLayout passwordsButton = (LinearLayout)findViewById(R.id.passwords_button);
        passwordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * set the passwords fragment as the active fragment then close the drawer
                 */
                viewPager.setCurrentItem(MainActivityPagerAdapter.PASSWORDS_FRAGMENT);
                drawer.closeDrawer(Gravity.LEFT);
                restoreWindowLimits();
            }
        });
    }

    private void setupJournalButtonLister(){
        LinearLayout journalButton = (LinearLayout)findViewById(R.id.journal_button);
        journalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * set the journal fragment as the active fragment then close the drawer
                 */
                viewPager.setCurrentItem(MainActivityPagerAdapter.JOURNAL_FRAGMENT);
                drawer.closeDrawer(Gravity.LEFT);
                restoreWindowLimits();
            }
        });
    }

    private void setupSettingsButtonListener(){
        LinearLayout settingsButton = (LinearLayout)findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * launch the settings activity
                 */
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

}
