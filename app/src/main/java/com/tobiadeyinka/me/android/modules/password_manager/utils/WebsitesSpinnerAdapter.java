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

import android.view.*;
import android.widget.*;
import android.content.Context;

import com.tobiadeyinka.me.R;
import com.tobiadeyinka.me.android.modules.password_manager.entities.Website;

/**
 * Created by Tobi Adeyinka on 2017. 08. 30..
 */

public class WebsitesSpinnerAdapter extends BaseAdapter{

    private Context context;
    private static final Website[] WEBSITES;

    static {
        WEBSITES = WebsitesManager.getWEBSITES();
    }

    public WebsitesSpinnerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return WEBSITES.length;
    }

    @Override
    public Object getItem(int position) {
        return WEBSITES[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.website_spinner_item, parent, false);

            viewHolder.logoImageView = (ImageView)convertView.findViewById(R.id.website_logo);
            viewHolder.websiteNameTextView = (TextView)convertView.findViewById(R.id.website_name);

            convertView.setTag(viewHolder);
        }
        else viewHolder = (ViewHolder)convertView.getTag();

        viewHolder.logoImageView.setImageResource(WEBSITES[position].getLogoResourceId());
        viewHolder.websiteNameTextView.setText(WEBSITES[position].getName());

        return convertView;
    }

    private static class ViewHolder {
        private ImageView logoImageView;
        private TextView websiteNameTextView;
    }

}
