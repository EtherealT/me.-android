package com.nectarmicrosystems.me.android.activities;

import android.util.Log;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.nectarmicrosystems.me.R;
import com.nectarmicrosystems.me.android.entities.CustomViewPager;
import com.nectarmicrosystems.me.android.fragments.main_activity.MainActivityPagerAdapter;

/**
 * Created by tobi on 2017. 06. 06..
 */

public class MainActivity extends AppCompatActivity {

    private CustomViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViewComponents();
    }

    private void setupViewComponents(){
        Log.i(getClass().getCanonicalName(), "setting up fragments");
        viewPager = (CustomViewPager)findViewById(R.id.view_pager);
        PagerAdapter pagerAdapter = new MainActivityPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }

}
