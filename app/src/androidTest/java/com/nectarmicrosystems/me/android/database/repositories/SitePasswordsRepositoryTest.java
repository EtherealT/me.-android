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

package com.nectarmicrosystems.me.android.database.repositories;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.InstrumentationRegistry;

import com.nectarmicrosystems.me.android.modules.password_manager.entities.SitePassword;

import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tobi Adeyinka on 2017. 08. 25..
 */

@RunWith(AndroidJUnit4.class)
public class SitePasswordsRepositoryTest {

    private SitePasswordsRepository sitePasswordsRepository;

    @Before
    public void setup() {
        Context context = InstrumentationRegistry.getTargetContext();
        sitePasswordsRepository = new SitePasswordsRepository(context);
        emptyDatabase();
    }

    @Test
    public void testInsertNewSitePassword(){
        SitePassword sitePassword = createSitePasswordForTest();
        sitePasswordsRepository.insert(sitePassword);
        assertEquals(sitePasswordsRepository.getAll().size(), 1);
    }

    /*
     * empty the database after each test
     */
    @After
    public void emptyDatabase(){
        sitePasswordsRepository.deleteAll();
    }

    private SitePassword createSitePasswordForTest(){
        return new SitePassword("yahoo", "password");
    }

}
