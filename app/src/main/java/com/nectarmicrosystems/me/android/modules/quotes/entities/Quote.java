package com.nectarmicrosystems.me.android.modules.quotes.entities;

import org.json.JSONException;
import org.json.JSONObject;

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

    public static Quote fromTheySaidSoQOD(JSONObject object){
        try {
            JSONObject jsonQuote = object.getJSONObject("contents")
                    .getJSONArray("quotes")
                    .getJSONObject(0);

            String quote = jsonQuote.getString("quote");
            String author = jsonQuote.getString("author");
            String imageUrl = jsonQuote.getString("background");

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
