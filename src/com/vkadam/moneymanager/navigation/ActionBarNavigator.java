package com.vkadam.moneymanager.navigation;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;

import com.vkadam.moneymanager.AccountListActivity;
import com.vkadam.moneymanager.R;

public class ActionBarNavigator extends Activity {
    
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
