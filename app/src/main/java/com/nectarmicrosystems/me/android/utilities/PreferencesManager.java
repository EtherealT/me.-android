package com.nectarmicrosystems.me.android.utilities;

import android.util.Log;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Tobi Adeyinka on 2017. 08. 15..
 *
 * This class manages the app users local preferences/settings
 */

public class PreferencesManager {

    private static final String PREFERENCES_ID = "com.nectarmicrosystems.me";
    private static final String PASSWORD_HASH_KEY = ".passwordhash";
    private static final String PASSWORD_PROTECTED_KEY = ".passwordprotected";

    private Context context;
    private SharedPreferences preferences;

    public PreferencesManager(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(PREFERENCES_ID, Context.MODE_PRIVATE);
    }

    public void setPasswordProtected(boolean passwordProtected){
        Log.i(PreferencesManager.class.getCanonicalName(),
                "setting password protection: " + (passwordProtected ? "on" : "off"));
        preferences.edit().putBoolean(PASSWORD_PROTECTED_KEY, passwordProtected).apply();
    }

    public boolean isPasswordProtected() {
        return preferences.getBoolean(PASSWORD_PROTECTED_KEY, false);
    }

    public void setPasswordHash(String passwordHash){
        Log.i(PreferencesManager.class.getCanonicalName(), "saving password hash");
        preferences.edit().putString(PASSWORD_HASH_KEY, passwordHash);
    }

    public String getPasswordHash(){
        return preferences.getString(PASSWORD_HASH_KEY, "");
    }

}
