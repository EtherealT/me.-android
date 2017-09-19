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

package com.tobiadeyinka.me.android.ui_tests.modules.main;

import android.view.Gravity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.matcher.ViewMatchers;

import com.tobiadeyinka.me.R;
import com.tobiadeyinka.me.android.AndroidTest;
import com.tobiadeyinka.me.android.modules.main.activities.*;
import com.tobiadeyinka.me.android.modules.password_manager.activities.NewSitePasswordActivity;

import org.junit.Rule;
import org.junit.Test;

import static com.tobiadeyinka.me.android.TestUtils.clickButton;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;

/**
 * Created by Tobi Adeyinka on 2017. 08. 24..
 */

public class MainActivityUITest extends AndroidTest{

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    /*
     * swipe to the last fragment & verify that the dashboard button returns to the first fragment
     */
    @Test
    public void testDashboardButton(){
        Intents.init();
        swipeViewPagerLeft(4);
        openDrawer();
        clickButton(R.id.dashboard_button);
        onView(withId(R.id.dash_fragment_root)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        Intents.release();
    }

    /*
     * verify that the tasks fragment is displayed when the tasks button is clicked
     */
    @Test
    public void testTasksButtonClick(){
        Intents.init();
        openDrawer();
        clickButton(R.id.tasks_button);
        onView(withId(R.id.tasks_fragment_root)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        Intents.release();
    }

    /*
     * verify that the finances fragment is displayed when the finances button is clicked
     */
    @Test
    public void testFinancesButtonClick(){
        Intents.init();
        openDrawer();
        clickButton(R.id.finances_button);
        onView(withId(R.id.finances_fragment_root)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        Intents.release();
    }

    /*
     * verify that the passwords fragment is displayed when the passwords button is clicked
     */
    @Test
    public void testPasswordsButtonClick(){
        Intents.init();
        openDrawer();
        clickButton(R.id.passwords_button);
        onView(withId(R.id.passwords_fragment_root)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        Intents.release();
    }

    /*
     * verify that the journal fragment is displayed when the journal button is clicked
     */
    @Test
    public void testJournalButtonClick(){
        Intents.init();
        openDrawer();
        clickButton(R.id.journal_button);
        onView(withId(R.id.journal_fragment_root)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        Intents.release();
    }

    /*
     * verify that the settings activity is launched when the settings button is clicked
     */
    @Test
    public void testSettingsButtonClick(){
        Intents.init();
        openDrawer();
        clickButton(R.id.settings_button);
        intended(hasComponent(SettingsActivity.class.getName()));
        Intents.release();
    }

    /*
     * verify that the app info activity is launched when the about button is clicked
     */
    @Test
    public void testAboutButtonClick(){
        Intents.init();
        openDrawer();
        clickButton(R.id.about_button);
        intended(hasComponent(AppInfoActivity.class.getName()));
        Intents.release();
    }

    /*
     * verify that the tasks fragment is displayed after a single swipe
     */
    @Test
    public void testSingleLeftSwipe(){
        Intents.init();
        swipeViewPagerLeft(1);
        onView(withId(R.id.tasks_fragment_root)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        Intents.release();
    }

    /*
     * verify that the finance fragment is displayed after two swipes
     */
    @Test
    public void testTwoLeftSwipes(){
        Intents.init();
        swipeViewPagerLeft(2);
        onView(withId(R.id.finances_fragment_root)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        Intents.release();
    }

    /*
     * verify that the passwords fragment is displayed after three swipes
     */
    @Test
    public void testThreeLeftSwipes(){
        Intents.init();
        swipeViewPagerLeft(3);
        onView(withId(R.id.passwords_fragment_root)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        Intents.release();
    }

    /*
     * verify that the journal fragment is displayed after four swipes
     */
    @Test
    public void testFourLeftSwipes(){
        Intents.init();
        swipeViewPagerLeft(4);
        onView(withId(R.id.journal_fragment_root)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        Intents.release();
    }

    @Test
    public void testNewSitePasswordActivityLaunch(){
        Intents.init();
        swipeViewPagerLeft(3);
        sleep(3);
        clickButton(R.id.fab_new_password);
        intended(hasComponent(NewSitePasswordActivity.class.getName()));
        Intents.release();
    }

    private void openDrawer(){
        onView(withId(R.id.main_activity_drawer))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(open());
    }

    private void swipeViewPagerLeft(int numberOfSwipes){
        for (int i = 0; i < numberOfSwipes; i++)
            onView(withId(R.id.main_activity_view_pager)).perform(swipeLeft());
    }

}
