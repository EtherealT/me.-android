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

package com.nectarmicrosystems.me.android.ui_tests;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;
import android.support.test.espresso.intent.Intents;
import android.support.test.InstrumentationRegistry;

import com.nectarmicrosystems.me.android.activities.*;
import com.nectarmicrosystems.me.android.utilities.SecurityManager;

import org.junit.*;
import org.junit.runner.RunWith;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;

/**
 * Created by Tobi Adeyinka on 2017. 08. 24..
 */

@RunWith(AndroidJUnit4.class)
public class SplashActivityUITest {

    @Rule
    public ActivityTestRule<SplashActivity> activityTestRule = new ActivityTestRule<>(SplashActivity.class);

    private SecurityManager securityManager;

    @Before
    public void setup() {
        Context context = InstrumentationRegistry.getTargetContext();
        securityManager = new SecurityManager(context);
    }

    /*
     * verify password activity is launched when password check is enabled
     */
    @Test
    public void testPasswordActivityLaunch(){
        securityManager.enablePasswordProtection();
        Intents.init();
        //TODO wait for splash to load before verifying displayed activity
        //intended(hasComponent(PasswordActivity.class.getName()));
        Intents.release();
    }

    /*
     * verify main activity is launched when password check is disabled
     */
    @Test
    public void testMainActivityLaunch(){
        securityManager.disablePasswordProtection();
        Intents.init();
        //TODO wait for splash to load before verifying displayed activity
        //intended(hasComponent(MainActivity.class.getName()));
        Intents.release();
    }

}