package com.nectarmicrosystems.me.android.fragments.main_activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by tobi on 2017. 06. 06..
 */

public class MainActivityPagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_FRAGMENTS = 1;
    public static final int DASH_FRAGMENT = 0;


    public MainActivityPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == DASH_FRAGMENT) return new DashFragment();
        return null;
    }

    @Override
    public int getCount() {
        return NUM_FRAGMENTS;
    }

}
