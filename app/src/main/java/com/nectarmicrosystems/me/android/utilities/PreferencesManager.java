package com.nectarmicrosystems.me.android.utilities;

import android.util.Log;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Calendar;

/**
 * Created by Tobi Adeyinka on 2017. 08. 15..
 *
 * This class manages the app users local preferences/settings
 */

public class PreferencesManager {

    private static final String PREFERENCES_ID = "com.nectarmicrosystems.me";
    private static final String PASSWORD_HASH_KEY = ".passwordhash";
    private static final String PASSWORD_PROTECTED_KEY = ".passwordprotected";
    private static final String TODAYS_QUOTE_KEY = ".todaysquote";
    private static final String TODAYS_QUOTE_AUTHOR_KEY = ".todaysquoteauthor";
    private static final String TODAYS_QUOTE_IMG_KEY = ".todaysquoteimg";
    private static final String LAST_RUN_DATE_PREFERENCE_KEY = ".lastrundate";
    private static final String FIRST_RUN_PREFERENCE_KEY = ".firstrun";

    private Context context;
    private SharedPreferences preferences;

    public PreferencesManager(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(PREFERENCES_ID, Context.MODE_PRIVATE);
    }

    public void setTodaysQuote(String todaysQuote){
        Log.i(PreferencesManager.class.getCanonicalName(), "setting new quote of the day");
        preferences.edit().putString(TODAYS_QUOTE_KEY, todaysQuote).apply();
    }

    public String getTodaysQuote(){
        return preferences.getString(TODAYS_QUOTE_KEY, "");
    }

    public void setTodaysQuoteAuthor(String todaysQuoteAuthor){
        Log.i(PreferencesManager.class.getCanonicalName(), "setting new quote of the day author");
        preferences.edit().putString(TODAYS_QUOTE_AUTHOR_KEY, todaysQuoteAuthor).apply();
    }

    public String getTodaysQuoteAuthor(){
        return preferences.getString(TODAYS_QUOTE_AUTHOR_KEY, "");
    }

    public void setTodaysQuoteImage(String todaysQuoteImage){
        Log.i(PreferencesManager.class.getCanonicalName(), "setting new quote of the day image");
        preferences.edit().putString(TODAYS_QUOTE_IMG_KEY, todaysQuoteImage).apply();
    }

    public String getTodaysQuoteImage(){
        return preferences.getString(TODAYS_QUOTE_IMG_KEY, "");
    }

    public void setPasswordProtected(boolean passwordProtected) {
        Log.i(PreferencesManager.class.getCanonicalName(),
                "setting password protection: " + (passwordProtected ? "on" : "off"));
        preferences.edit().putBoolean(PASSWORD_PROTECTED_KEY, passwordProtected).apply();
    }

    public boolean isPasswordProtected() {
        return preferences.getBoolean(PASSWORD_PROTECTED_KEY, false);
    }

    public void setPasswordHash(String passwordHash) {
        Log.i(PreferencesManager.class.getCanonicalName(), "saving password hash");
        preferences.edit().putString(PASSWORD_HASH_KEY, passwordHash).apply();
    }

    public String getPasswordHash() {
        /*
         * the default must not be a blank string to avoid an exception
         * during password verification tests for cases where a password hasn't been set,
         * hence the single space
         */
        return preferences.getString(PASSWORD_HASH_KEY, " ");
    }

    /*
     * check if this the apps first run
     */
    public boolean isFirstRun(){
        boolean firstRun = preferences.getBoolean(FIRST_RUN_PREFERENCE_KEY, true);
        preferences.edit().putBoolean(FIRST_RUN_PREFERENCE_KEY, false).apply();
        return firstRun;
    }

    public void setLastRunDate(long timeMillis){
        Log.i(PreferencesManager.class.getCanonicalName(), "saving last run date");
        preferences.edit().putLong(LAST_RUN_DATE_PREFERENCE_KEY, timeMillis).apply();
    }

    public Calendar getLastRunDate(){
        long timeMillis = preferences.getLong(LAST_RUN_DATE_PREFERENCE_KEY, System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMillis);
        return calendar;
    }

}
