package com.vkadam.moneymanager.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.vkadam.moneymanager.AccountDetailActivity;
import com.vkadam.moneymanager.R;
import com.vkadam.moneymanager.content.DummyAccountContent;
import com.vkadam.moneymanager.fragments.MainNavigationFragment.Callbacks;

/**
 * A list fragment representing a list of Accounts. This fragment also supports tablet devices by allowing list items to
 * be given an 'activated' state upon selection. This helps indicate which item is currently being viewed in a
 * {@link AccountDetailFragment}.
 * <p>
 * Activities containing this fragment MUST implement the {@link Callbacks} interface.
 */
public class AccountListFragment extends SherlockListFragment {
    
    private static final String LOG_TAG_NAME = AccountListFragment.class.getCanonicalName();
    
    public static final String ACCOUNT_ID_KEY = "ACCOUNT_ID_KEY";
    
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the fragment (e.g. upon screen orientation
     * changes).
     */
    public AccountListFragment() {
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<DummyAccountContent.DummyItem>(getActivity(),
                                                                       android.R.layout.simple_list_item_activated_1,
                                                                       android.R.id.text1, DummyAccountContent.ITEMS));
        setHasOptionsMenu(true);
    }
    
    @Override
    public void onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu,
                                    com.actionbarsherlock.view.MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_account_list, menu);
        
        super.onCreateOptionsMenu(menu, inflater);
    }
    
    @Override
    public boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem item) {
        switch (item.getItemId()) {
        case R.id.menu_add_account:
            Intent intent = new Intent(getActivity(), AccountDetailActivity.class);
            Log.d(LOG_TAG_NAME, "Starting Account Details Activity for new account...");
            startActivity(intent);
            return super.onOptionsItemSelected(item);
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        
        Intent intent = new Intent(getActivity(), AccountDetailActivity.class);
        intent.putExtra(ACCOUNT_ID_KEY, position);
        Log.d(LOG_TAG_NAME, "Starting Account Details Activity for " + position + "...");
        startActivity(intent);
        
    }
}
