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

package com.tobiadeyinka.me.android.modules.main.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tobiadeyinka.me.android.modules.main.fragments.DashFragment;
import com.tobiadeyinka.me.android.modules.journal.fragments.JournalFragment;
import com.tobiadeyinka.me.android.modules.task_manager.fragments.TasksFragment;
import com.tobiadeyinka.me.android.modules.finance_manager.fragments.FinancesFragment;
import com.tobiadeyinka.me.android.modules.password_manager.fragments.PasswordsFragment;

/**
 * Created by tobi on 2017. 06. 06..
 */

public class MainActivityPagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_FRAGMENTS = 5;
    public static final int DASH_FRAGMENT = 0;
    public static final int TASKS_FRAGMENT = 1;
    public static final int FINANCES_FRAGMENT = 2;
    public static final int PASSWORDS_FRAGMENT = 3;
    public static final int JOURNAL_FRAGMENT = 4;

    public MainActivityPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == DASH_FRAGMENT) return new DashFragment();
        if (position == TASKS_FRAGMENT) return new TasksFragment();
        if (position == FINANCES_FRAGMENT) return new FinancesFragment();
        if (position == PASSWORDS_FRAGMENT) return new PasswordsFragment();
        if (position == JOURNAL_FRAGMENT) return new JournalFragment();
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == DASH_FRAGMENT) return "Dashboard";
        if (position == TASKS_FRAGMENT) return "Tasks";
        if (position == FINANCES_FRAGMENT) return "Finances";
        if (position == PASSWORDS_FRAGMENT) return "Passwords";
        if (position == JOURNAL_FRAGMENT) return "Journal";
        return null;
    }

    @Override
    public int getCount() {
        return NUM_FRAGMENTS;
    }

}
