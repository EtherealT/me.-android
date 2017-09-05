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
import android.content.Intent;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v4.view.MotionEventCompat;

import com.tobiadeyinka.me.R;
import com.tobiadeyinka.me.android.config.ConfigValues;
import com.tobiadeyinka.me.android.utilities.list_adapter_utils.helpers.*;
import com.tobiadeyinka.me.android.database.repositories.SitePasswordsRepository;
import com.tobiadeyinka.me.android.modules.password_manager.entities.SitePassword;
import com.tobiadeyinka.me.android.modules.password_manager.activities.ViewSitePasswordActivity;

import java.util.*;

/**
 * Created by Tobi Adeyinka on 2017. 09. 05..
 */

public class PasswordsAdapter extends RecyclerView.Adapter<PasswordsAdapter.PasswordViewHolder>
        implements ItemTouchHelperAdapter {

    private Context context;

    /*
     * passwords to be rendered
     */
    private ArrayList<SitePassword> data;

    /*
     * for drag/swipe support
     */
    private OnStartDragListener onStartDragListener;

    /*
     * for querying db
     */
    private SitePasswordsRepository sitePasswordsRepository;

    public PasswordsAdapter(Context context, ArrayList<SitePassword> data, OnStartDragListener onStartDragListener) {
        this.context = context;
        this.data = data;
        this.onStartDragListener = onStartDragListener;
        sitePasswordsRepository = new SitePasswordsRepository(context);
    }

    @Override
    public PasswordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutIdForListItem = R.layout.site_passwords_list_item;
        final LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);
        final PasswordViewHolder viewHolder = new PasswordViewHolder(view);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                UUID passwordId = data.get(position).getId();

                Intent intent = new Intent(context, ViewSitePasswordActivity.class);
                intent.putExtra(ConfigValues.ID, passwordId.toString());
                context.startActivity(intent);
            }
        });

        viewHolder.siteLogoImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    onStartDragListener.onStartDrag(viewHolder);
                }
                return false;
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PasswordViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        int total = getItemCount();
        int lowerPosition = (fromPosition < toPosition) ? fromPosition : toPosition;

        Collections.swap(data, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);

        for (int i = lowerPosition; i < total; i++){
            SitePassword password = data.get(i);
            password.setRanking(i);
            sitePasswordsRepository.update(password);
        }

        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        SitePassword password = data.get(position);
        data.remove(position);
        sitePasswordsRepository.delete(password.getId());
        notifyDataSetChanged();
    }

    class PasswordViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {

        ImageView siteLogoImage;
        TextView siteNameTextView;
        TextView accountIdentifierTextView;
        LinearLayout itemWrap;

        PasswordViewHolder(View itemView) {
            super(itemView);
            itemWrap = (LinearLayout)itemView.findViewById(R.id.site_passwords_item_wrap);
            siteLogoImage = (ImageView)itemView.findViewById(R.id.site_logo_image);
            siteNameTextView = (TextView)itemView.findViewById(R.id.site_name_text_view);
            accountIdentifierTextView = (TextView)itemView.findViewById(R.id.account_identifier_text_view);
        }

        void bind(int position){
            SitePassword password = data.get(position);
            siteLogoImage.setImageResource(password.getLogoResourceId());
            siteNameTextView.setText(password.getSiteName());
            accountIdentifierTextView.setText(password.getAccountIdentifier());
        }

        @Override
        public void onItemSelected() {
            itemWrap.setBackground(context.getDrawable(R.drawable.list_item_grey_back));
        }

        @Override
        public void onItemClear() {
            itemWrap.setBackground(context.getDrawable(R.drawable.list_item_white_back));
        }
    }

}
