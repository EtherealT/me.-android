package com.nectarmicrosystems.me.android;

import java.util.logging.*;

/**
 * Created by Tobi Adeyinka on 2017. 08. 15..
 */

public abstract class TestUtils {

    public static void setupLogger(Logger logger){
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);
    }

}
