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

package com.nectarmicrosystems.me.android.fragments.main_activity;

import android.view.*;
import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;

import com.nectarmicrosystems.me.R;
import com.nectarmicrosystems.me.android.activities.MainActivity;
import com.nectarmicrosystems.me.android.activities.NewSitePasswordActivity;

/**
 * Created by Tobi Adeyinka on 2017. 08. 24..
 */

public class PasswordsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_passwords_main_activity, container, false);
        setupFloatingActionButton(rootView);
        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (this.isVisible()) ((MainActivity)getActivity()).restoreWindowLimits();
    }

    private void setupFloatingActionButton(ViewGroup rootView){
        FloatingActionButton button = (FloatingActionButton)rootView.findViewById(R.id.fab_new_password);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * Launch new site password activity
                 */
                Intent intent = new Intent(getContext(), NewSitePasswordActivity.class);
                startActivity(intent);
            }
        });
    }

}
