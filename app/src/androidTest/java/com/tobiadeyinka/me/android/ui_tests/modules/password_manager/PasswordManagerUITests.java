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

package com.tobiadeyinka.me.android.ui_tests.modules.password_manager;

import android.view.Gravity;
import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.Intents;

import com.tobiadeyinka.me.R;
import com.tobiadeyinka.me.android.AndroidTest;
import com.tobiadeyinka.me.android.modules.main.activities.MainActivity;
import com.tobiadeyinka.me.android.database.repositories.SitePasswordsRepository;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

/**
 * Created by Tobi Adeyinka on 2017. 09. 04..
 */

public class PasswordManagerUITests extends AndroidTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testSaveNewSitePassword(){
        String username = "testUser";
        String password = "password";

        Intents.init();

        /*
         * go to passwords fragment
         */
        openDrawer();
        clickButton(R.id.passwords_button);
        sleep(1);

        /*
         * click new button
         */
        clickButton(R.id.fab_new_password);
        sleep(1);

        /*
         * fill in account identifier and password and save,
         * then verify the database has one entry
         */
        onView(withId(R.id.account_identifier_input)).perform(typeText(username));
        onView(withId(R.id.password_input)).perform(typeText(password));
        onView(withId(R.id.save_password_button))
                .perform(scrollTo())
                .perform(click());

        Context context = InstrumentationRegistry.getTargetContext();
        SitePasswordsRepository repository = new SitePasswordsRepository(context);
        assertEquals(repository.getAll().size(), 1);

        repository.deleteAll();
        Intents.release();
    }

    private void clickButton(int buttonId){
        onView(withId(buttonId)).perform(click());
    }

    private void openDrawer(){
        onView(withId(R.id.main_activity_drawer))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(open());
    }

}
