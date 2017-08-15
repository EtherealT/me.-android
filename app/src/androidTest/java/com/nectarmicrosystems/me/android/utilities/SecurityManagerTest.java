package com.nectarmicrosystems.me.android.utilities;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.InstrumentationRegistry;

import com.nectarmicrosystems.me.android.TestUtils;

import org.junit.*;
import org.junit.runner.RunWith;

import java.util.logging.Logger;

/**
 * Created by Tobi Adeyinka on 2017. 08. 15..
 */

@RunWith(AndroidJUnit4.class)
public class SecurityManagerTest {

    private static final Logger LOGGER = Logger.getLogger(SecurityManagerTest.class.getCanonicalName());

    private Context context;

    @Before
    public void setup() {
        context = InstrumentationRegistry.getContext();
        TestUtils.setupLogger(LOGGER);
    }

    @Test
    public void testPasswordCreationAndVerification(){
    }

}
