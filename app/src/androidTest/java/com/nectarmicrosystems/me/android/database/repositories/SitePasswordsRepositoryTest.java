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
import android.support.test.InstrumentationRegistry;

import com.nectarmicrosystems.me.android.AndroidTest;
import com.nectarmicrosystems.me.android.modules.password_manager.entities.SitePassword;

import org.junit.*;

import java.util.UUID;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by Tobi Adeyinka on 2017. 08. 25..
 */

public class SitePasswordsRepositoryTest extends AndroidTest {

    private SitePasswordsRepository sitePasswordsRepository;

    private static final String TEST_SITE_NAME = "yahoo";

    @Before
    public void setup() {
        Context context = InstrumentationRegistry.getTargetContext();
        sitePasswordsRepository = new SitePasswordsRepository(context);
        emptyDatabase();
    }

    @Test
    public void testInsertNewSitePassword(){
        createAndSaveSitePasswordForTest();
        assertEquals(sitePasswordsRepository.getAll().size(), 1);
    }

    @Test
    public void testGetSitePasswordById(){
        SitePassword sitePassword = createAndSaveSitePasswordForTest();
        assertEquals(sitePasswordsRepository.getById(sitePassword.getId()).getSiteName(), TEST_SITE_NAME);
    }

    @Test
    public void testGetSitePasswordWithNonExistingId(){
        SitePassword password = sitePasswordsRepository.getById(UUID.randomUUID());
        assertNull(password);
    }

    @Test
    public void testUpdateSitePassword(){
        SitePassword sitePassword = createAndSaveSitePasswordForTest();
        String newSiteName = "facebook";
        sitePassword.setSiteName(newSiteName);
        sitePasswordsRepository.update(sitePassword);
        assertEquals(sitePasswordsRepository.getById(sitePassword.getId()).getSiteName(), newSiteName);
    }

    @Test
    public void testDeleteSitePasswordById(){
        SitePassword sitePassword = createAndSaveSitePasswordForTest();
        sitePasswordsRepository.delete(sitePassword.getId());
        assertEquals(sitePasswordsRepository.getAll().size(), 0);
    }

    @Test
    public void testDeleteAll(){
        createAndSaveSitePasswordForTest();
        sitePasswordsRepository.deleteAll();
        assertEquals(sitePasswordsRepository.getAll().size(), 0);
    }

    /*
     * empty the database after each test
     */
    @After
    public void emptyDatabase(){
        sitePasswordsRepository.deleteAll();
    }

    private SitePassword createAndSaveSitePasswordForTest(){
        SitePassword sitePassword = new SitePassword(TEST_SITE_NAME, "password");
        sitePasswordsRepository.insert(sitePassword);
        return sitePassword;
    }

}
