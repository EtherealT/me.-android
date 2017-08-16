package com.nectarmicrosystems.me.android.utilities;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.InstrumentationRegistry;

import com.nectarmicrosystems.me.android.TestUtils;

import org.junit.*;
import org.junit.runner.RunWith;

import java.util.logging.Logger;

import static org.junit.Assert.*;

/**
 * Created by Tobi Adeyinka on 2017. 08. 15..
 */

@RunWith(AndroidJUnit4.class)
public class SecurityManagerTest {

    private static final Logger LOGGER = Logger.getLogger(SecurityManagerTest.class.getCanonicalName());

    private Context context;
    private SecurityManager securityManager;
    private PreferencesManager preferencesManager;

    private final String PASSWORD = "password";

    @Before
    public void setup() {
        TestUtils.setupLogger(LOGGER);
        context = InstrumentationRegistry.getTargetContext();
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
