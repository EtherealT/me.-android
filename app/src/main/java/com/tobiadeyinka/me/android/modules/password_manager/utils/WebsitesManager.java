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

package com.tobiadeyinka.me.android.modules.password_manager.utils;

import com.tobiadeyinka.me.R;
import com.tobiadeyinka.me.android.modules.password_manager.entities.Website;

/**
 * Created by Tobi Adeyinka on 2017. 08. 30..
 */

abstract class WebsitesManager {

    private static final Website[] WEBSITES = {
            new Website("Facebook", R.mipmap.ic_facebook_logo),
            new Website("Google", R.mipmap.ic_google_logo),
            new Website("Instagram", R.mipmap.ic_instagram_logo),
            new Website("Netflix", R.mipmap.ic_netflix_logo),
            new Website("Twitter", R.mipmap.ic_twitter_logo),
            new Website("Yahoo", R.mipmap.ic_yahoo_logo)
    };

    static Website[] getWEBSITES() {
        return WEBSITES;
    }

}
