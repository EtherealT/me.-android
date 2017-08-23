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

import android.Manifest;
import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;
import android.support.test.espresso.intent.Intents;
import android.support.test.InstrumentationRegistry;

import com.nectarmicrosystems.me.R;
import com.nectarmicrosystems.me.android.activities.MainActivity;
import com.nectarmicrosystems.me.android.utilities.SecurityManager;
import com.nectarmicrosystems.me.android.activities.PasswordActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;

/**
 * Created by Tobi Adeyinka on 2017. 08. 24..
 */

@RunWith(AndroidJUnit4.class)
public class PasswordActivityUITest {

    @Rule
    public ActivityTestRule<PasswordActivity> activityTestRule = new ActivityTestRule<>(PasswordActivity.class);

    /*
     * verify that main activity is launched when the correct password is entered
     */
    @Test
    public void testPasswordValidation(){
        final String password = "password";

        Context context = InstrumentationRegistry.getTargetContext();
        SecurityManager securityManager = new SecurityManager(context);
        securityManager.setPassword(password);

        Intents.init();
        onView(withId(R.id.password_activity_password_field)).perform(typeText(password));
        intended(hasComponent(MainActivity.class.getName()));
        Intents.release();
    }

}
