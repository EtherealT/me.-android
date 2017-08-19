package com.nectarmicrosystems.me.android.networking.apis.they_said_so_quotes;

import android.support.test.runner.AndroidJUnit4;

import com.nectarmicrosystems.me.android.TestUtils;

import org.junit.*;
import org.junit.runner.RunWith;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Tobi Adeyinka on 2017. 08. 20..
 */

@RunWith(AndroidJUnit4.class)
public class QuotesQueriesTest {

    private static final Logger LOGGER = Logger.getLogger(QuotesQueriesTest.class.getCanonicalName());

    @Before
    public void setup(){
        TestUtils.setupLogger(LOGGER);
    }

    @Test
    public void testGetTodaysQuote(){
        String response = QuotesQueries.getTodaysQuote();
        Assert.assertFalse(response.isEmpty());
        LOGGER.log(Level.INFO, "todays quote response: " + response);
    }

}
