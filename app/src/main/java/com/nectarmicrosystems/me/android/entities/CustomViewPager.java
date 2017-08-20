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

package com.nectarmicrosystems.me.android.entities;

import android.widget.Scroller;
import android.content.Context;
import android.util.AttributeSet;
import android.support.v4.view.ViewPager;
import android.view.animation.DecelerateInterpolator;

import java.lang.reflect.Field;

/**
 * Created by tobi on 2017. 06. 06..
 */

public class CustomViewPager extends ViewPager {

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager( Context context, AttributeSet attrs) {
        super( context, attrs );
        setScroller();
    }

    private void setScroller() {
        try {
            Class<?> viewpager = ViewPager.class;
            Field scroller = viewpager.getDeclaredField("mScroller");
            scroller.setAccessible(true);
            scroller.set(this, new CustomScroller(getContext()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class CustomScroller extends Scroller {
        public CustomScroller(Context context) {
            super(context, new DecelerateInterpolator());
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            //600ms scroll time
            super.startScroll(startX, startY, dx, dy, 600);
        }
    }

}
