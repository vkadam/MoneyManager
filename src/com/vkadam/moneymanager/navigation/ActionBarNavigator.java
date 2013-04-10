package com.vkadam.moneymanager.navigation;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;

import com.vkadam.moneymanager.AccountListActivity;
import com.vkadam.moneymanager.R;

public class ActionBarNavigator extends FragmentActivity {
    
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        
        switch (item.getItemId()) {
        case R.id.accounts:
            Intent detailIntent = new Intent(this, AccountListActivity.class);
            startActivity(detailIntent);
            return true;
        }
        return super.onMenuItemSelected(featureId, item);
    }
    
}
