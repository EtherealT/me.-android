package com.nectarmicrosystems.me.android;

import java.util.logging.*;

/**
 * Created by Tobi Adeyinka on 2017. 06. 07..
 */

public class TestUtils {

    public static void setupLogger(Logger logger){
        Handler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        logger.addHandler(ch);
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);
    }

}
