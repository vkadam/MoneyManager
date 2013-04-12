package com.vkadam.moneymanager.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.vkadam.moneymanager.R;
import com.vkadam.moneymanager.content.DummyPayeesContent;
import com.vkadam.moneymanager.fragments.MainNavigationFragment.Callbacks;

/**
 * A list fragment representing a list of Accounts. This fragment also supports tablet devices by allowing list items to
 * be given an 'activated' state upon selection. This helps indicate which item is currently being viewed in a
 * {@link AccountDetailFragment}.
 * <p>
 * Activities containing this fragment MUST implement the {@link Callbacks} interface.
 */
public class PayeeListFragment extends ListFragment {
    
    private static final String LOG_TAG_NAME = PayeeListFragment.class.getCanonicalName();
    
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the fragment (e.g. upon screen orientation
     * changes).
     */
    public PayeeListFragment() {
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<DummyPayeesContent.DummyItem>(getActivity(),
                                                                      android.R.layout.simple_list_item_activated_1,
                                                                      android.R.id.text1, DummyPayeesContent.ITEMS));
        setHasOptionsMenu(true);
    }
    
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_payee_list, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.menu_add_payee:
            
            return super.onOptionsItemSelected(item);
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
}
