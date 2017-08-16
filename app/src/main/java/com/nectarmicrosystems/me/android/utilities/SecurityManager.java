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

    public void setPassword(String password){
        /*
         * TODO look for an encryption method
         */
        String hashedPassword = password;
        preferencesManager.setPasswordHash(hashedPassword);
    }

    public boolean verifyPassword(String password){
        return password.equals(hashedPassword);
    }

    public void enablePasswordProtection(){
        preferencesManager.setPasswordProtected(true);
    }

    public void disablePasswordProtection(){
        preferencesManager.setPasswordProtected(false);
    }

    public boolean checkPasswordProtection(){
        return preferencesManager.isPasswordProtected();
    }

}
