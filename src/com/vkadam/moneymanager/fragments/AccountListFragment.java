package com.vkadam.moneymanager.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;

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
public class AccountListFragment extends ListFragment {
    
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_account_list, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    
}