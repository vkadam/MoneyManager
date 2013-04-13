package com.vkadam.moneymanager;

import android.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.vkadam.moneymanager.content.DummyAccountContent;
import com.vkadam.moneymanager.content.DummyAccountContent.DummyItem;
import com.vkadam.moneymanager.fragments.AccountListFragment;

public class AccountDetailActivity extends BaseActivity {
    
    private static final String LOG_TAG_NAME = AccountDetailActivity.class.getCanonicalName();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_detail);
        
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        
        int accountRecordPosition = getIntent().getIntExtra(AccountListFragment.ACCOUNT_ID_KEY, -1);
        if (accountRecordPosition != -1) {
            DummyItem dummyAccount = DummyAccountContent.ITEMS.get(accountRecordPosition);
            
            EditText accountNameLabel = (EditText) findViewById(R.id.input_account_name);
            accountNameLabel.setText(dummyAccount.name);
        }
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_account_detail, menu);
        return true;
    }
    
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            Log.d(LOG_TAG_NAME, "Closing activity and going back");
            this.finish();
            return super.onMenuItemSelected(featureId, item);
        default:
            return super.onMenuItemSelected(featureId, item);
        }
    }
    
}
