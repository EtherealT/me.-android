/*
 *  Copyright 2017 Oluwatobi Adeyinka
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package com.tobiadeyinka.me.android.utilities;

import android.content.Context;

/**
 * Created by Tobi Adeyinka on 2017. 08. 15..
 *
 * This class manages the local app security
 */

public class SecurityManager {

    private PreferencesManager preferencesManager;

    /*
     * This is used to hold the stored hashed password in memory
     * to avoid accessing database for each character when verifying
     * the entered password on text change
     */
    private final String hashedPassword;

    public SecurityManager(Context context) {
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
