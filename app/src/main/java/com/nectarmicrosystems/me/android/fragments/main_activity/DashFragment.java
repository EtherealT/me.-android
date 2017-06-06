package com.nectarmicrosystems.me.android.fragments.main_activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;

import com.nectarmicrosystems.me.R;

/**
 * Created by tobi on 2017. 06. 06..
 */

public class DashFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_dash_main_activity, container, false);
        return rootView;
    }

}
