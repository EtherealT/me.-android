package com.nectarmicrosystems.me.android.utilities;

import android.content.Context;

/**
 * Created by Tobi Adeyinka on 2017. 08. 15..
 *
 * This class manages the local app security
 */

public class SecurityManager {

    private Context context;
    private PreferencesManager preferencesManager;

    /*
     * This is used to hold the stored hashed password in memory
     * to avoid accessing database for each character when verifying
     * the entered password on text change
     */
    private final String hashedPassword;

    public SecurityManager(Context context) {
        this.context = context;
        preferencesManager = new PreferencesManager(context);
        hashedPassword = preferencesManager.getPasswordHash();
    }

    public SecurityManager setPassword(String password){
        /*
         * TODO look for an encryption method
         */
        String hashedPassword = password;
        preferencesManager.setPasswordHash(hashedPassword);
        return this;
    }

    public boolean verifyPassword(String password){
        return password.equals(hashedPassword);
    }

    public SecurityManager enablePasswordProtection(){
        preferencesManager.setPasswordProtected(true);
        return this;
    }

    public SecurityManager disablePasswordProtection(){
        preferencesManager.setPasswordProtected(false);
        return this;
    }

    public boolean checkPasswordProtection(){
        return preferencesManager.isPasswordProtected();
    }

}
