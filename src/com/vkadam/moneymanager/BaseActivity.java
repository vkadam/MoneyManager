// **********************************************************
// Copyright (c) Vishal Kadam 2013 - All rights reserved
// **********************************************************
package com.vkadam.moneymanager;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.MenuItem;

public abstract class BaseActivity extends FragmentActivity {
    
    private static final String LOG_TAG_NAME = BaseActivity.class.getCanonicalName();
    
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
        case R.id.menu_app_settings:
            Log.d(LOG_TAG_NAME, "Accessing application setting menu");
            break;
        }
        return super.onMenuItemSelected(featureId, item);
    }
    
}
