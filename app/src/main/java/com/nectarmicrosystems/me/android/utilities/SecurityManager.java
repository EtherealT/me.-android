package com.nectarmicrosystems.me.android.utilities;

import android.content.Context;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Created by Tobi Adeyinka on 2017. 08. 15..
 *
 * This class manages the local app security
 */

public class SecurityManager {

    private Context context;
    private PreferencesManager preferencesManager;

    public SecurityManager(Context context) {
        this.context = context;
        preferencesManager = new PreferencesManager(context);
    }

    public void setPassword(String password){
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        preferencesManager.setPasswordHash(hashedPassword);
    }

    public boolean verifyPassword(String password){
        String hashedPassword = preferencesManager.getPasswordHash();
        return BCrypt.checkpw(password, hashedPassword);
    }

}
