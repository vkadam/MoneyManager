package com.vkadam.moneymanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

/**
 * An activity representing a list of Accounts. On handsets, the activity presents a list of items, which when touched,
 * lead to a {@link AccountDetailActivity} representing item details.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a {@link AccountListFragment} and the item details
 * (if present) is a {@link AccountDetailFragment}.
 * <p>
 * This activity also implements the required {@link AccountListFragment.Callbacks} interface to listen for item
 * selections.
 */
public class AccountListActivity extends FragmentActivity implements AccountListFragment.Callbacks {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_list);
        
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_account_list, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    /**
     * Callback method from {@link AccountListFragment.Callbacks} indicating that the item with the given ID was
     * selected.
     */
    @Override
    public void onItemSelected(String id) {
        // In single-pane mode, simply start the detail activity
        // for the selected item ID.
        Intent detailIntent = new Intent(this, AccountDetailActivity.class);
        detailIntent.putExtra(AccountDetailFragment.ARG_ITEM_ID, id);
        startActivity(detailIntent);
    }
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            // This ID represents the Home or Up button. In the case of this
            // activity list, the Up button is shown. Use NavUtils to allow
            // users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
            return true;
        case R.id.add_account:
            Intent detailIntent = new Intent(this, AccountDetailActivity.class);
            startActivity(detailIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
