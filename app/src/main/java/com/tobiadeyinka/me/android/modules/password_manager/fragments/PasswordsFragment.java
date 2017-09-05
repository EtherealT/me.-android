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

package com.tobiadeyinka.me.android.modules.password_manager.fragments;

import android.view.*;
import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.design.widget.FloatingActionButton;

import com.tobiadeyinka.me.R;
import com.tobiadeyinka.me.android.modules.main.activities.MainActivity;
import com.tobiadeyinka.me.android.database.repositories.SitePasswordsRepository;
import com.tobiadeyinka.me.android.modules.password_manager.entities.SitePassword;
import com.tobiadeyinka.me.android.modules.password_manager.utils.PasswordsAdapter;
import com.tobiadeyinka.me.android.utilities.list_adapter_utils.helpers.OnStartDragListener;
import com.tobiadeyinka.me.android.modules.password_manager.activities.NewSitePasswordActivity;
import com.tobiadeyinka.me.android.utilities.list_adapter_utils.helpers.SimpleItemTouchHelperCallback;

import java.util.ArrayList;

/**
 * Created by Tobi Adeyinka on 2017. 08. 24..
 */

public class PasswordsFragment extends Fragment implements OnStartDragListener {

    /*
     * touch helper for swipe/drag/drop support
     */
    private ItemTouchHelper itemTouchHelper;

    /*
     * recycler view adapter
     */
    private PasswordsAdapter passwordsAdapter;

    /*
     * all site passwords in db
     */
    private ArrayList<SitePassword> sitePasswords;

    /*
     * for querying db
     */
    private SitePasswordsRepository sitePasswordsRepository;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_passwords_main_activity, container, false);

        sitePasswordsRepository = new SitePasswordsRepository(getContext());
        sitePasswords = sitePasswordsRepository.getAll();
        passwordsAdapter = new PasswordsAdapter(getContext(), sitePasswords, this);

        setUpPasswordsList(rootView);
        setupFloatingActionButton(rootView);
        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (this.isVisible()) ((MainActivity)getActivity()).restoreWindowLimits();
    }

    @Override
    public void onResume() {
        sitePasswords.clear();
        sitePasswords.addAll(sitePasswordsRepository.getAll());
        passwordsAdapter.notifyDataSetChanged();
        super.onResume();
    }

    private void setUpPasswordsList(ViewGroup rootView){
        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.site_passwords_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(passwordsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(passwordsAdapter);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
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

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        itemTouchHelper.startDrag(viewHolder);
    }
}
