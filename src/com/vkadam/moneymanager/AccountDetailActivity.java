package com.vkadam.moneymanager;

import roboguice.inject.ContentView;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.actionbarsherlock.app.ActionBar;
import com.vkadam.moneymanager.content.DummyAccountContent;
import com.vkadam.moneymanager.content.DummyAccountContent.DummyItem;
import com.vkadam.moneymanager.fragments.AccountListFragment;

@ContentView(R.layout.activity_account_detail)
public class AccountDetailActivity extends BaseActivity {
    
    private static final String LOG_TAG_NAME = AccountDetailActivity.class.getCanonicalName();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        
        /*final LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View view = inflater.inflate(R.layout.activity_account_detail_actionbar, null);
        actionBar.setCustomView(view, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                                 ViewGroup.LayoutParams.MATCH_PARENT));
        actionBar.setDisplayShowCustomEnabled(true);*/
        
        int accountRecordPosition = getIntent().getIntExtra(AccountListFragment.ACCOUNT_ID_KEY, -1);
        if (accountRecordPosition != -1) {
            DummyItem dummyAccount = DummyAccountContent.ITEMS.get(accountRecordPosition);
            
            EditText accountNameLabel = (EditText) findViewById(R.id.input_account_name);
            accountNameLabel.setText(dummyAccount.name);
        }
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        
        getSupportMenuInflater().inflate(R.menu.activity_account_detail, menu);
        return true;
    }
    
    @Override
    public boolean onMenuItemSelected(int featureId, com.actionbarsherlock.view.MenuItem item) {
        switch (item.getItemId()) {
        case R.id.menu_account_save_cancel:
            Log.d(LOG_TAG_NAME, "Closing activity and going back");
            this.finish();
            return super.onMenuItemSelected(featureId, item);
        default:
            return super.onMenuItemSelected(featureId, item);
        }
    }
    
}
