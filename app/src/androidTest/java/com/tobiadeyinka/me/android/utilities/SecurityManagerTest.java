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

package com.tobiadeyinka.me.android.utilities;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.tobiadeyinka.me.android.AndroidTest;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by Tobi Adeyinka on 2017. 08. 15..
 */

public class SecurityManagerTest extends AndroidTest {

    private SecurityManager securityManager;
    private PreferencesManager preferencesManager;

    private final String PASSWORD = "password";

    @Before
    public void setup() {
        Context context = InstrumentationRegistry.getTargetContext();
        securityManager = new SecurityManager(context);
        preferencesManager = new PreferencesManager(context);
    }

    @Test
    public void testPasswordCreation() {
        securityManager.setPassword(PASSWORD);
        assertNotEquals(preferencesManager.getPasswordHash(), "");
    }

    @Test
    public void testCorrectPasswordVerification() {
        assertTrue(securityManager.verifyPassword(PASSWORD));
    }

    @Test
    public void testWrongPasswordVerification() {
        assertFalse(securityManager.verifyPassword("wrong password"));
    }
    
}
