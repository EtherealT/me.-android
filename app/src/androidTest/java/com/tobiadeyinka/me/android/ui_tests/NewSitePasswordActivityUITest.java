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

package com.tobiadeyinka.me.android.ui_tests;

import android.support.test.rule.ActivityTestRule;

import com.tobiadeyinka.me.android.AndroidTest;
import com.tobiadeyinka.me.android.activities.NewSitePasswordActivity;

import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Tobi Adeyinka on 2017. 08. 26..
 */

public class NewSitePasswordActivityUITest extends AndroidTest{

    @Rule
    public ActivityTestRule<NewSitePasswordActivity> activityTestRule = new ActivityTestRule<>(NewSitePasswordActivity.class);

    @Test
    public void emptyTest(){

    }

}