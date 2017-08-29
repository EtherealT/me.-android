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

package com.tobiadeyinka.me.android.modules.quotes.entities;

import org.json.JSONObject;
import org.json.JSONException;

/**
 * Created by Tobi Adeyinka on 2017. 08. 20..
 */

public class Quote {

    private String quote;
    private String author;
    private String imageUrl;

    public Quote(String quote, String author, String imageUrl) {
        this.quote = quote;
        this.author = author;
        this.imageUrl = imageUrl;
    }

    public static Quote fromTheySaidSoQOD(JSONObject jsonQuote){
        try {
            String quote = jsonQuote.getString("quoteText");
            String author = jsonQuote.getString("quoteAuthor");
            String imageUrl = "https://unsplash.it/1000/?random&blur";
            
            return new Quote(quote, author, imageUrl);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getQuote() {
        return quote;
    }

    public String getAuthor() {
        return author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
