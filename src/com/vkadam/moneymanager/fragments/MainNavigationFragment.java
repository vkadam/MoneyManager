package com.vkadam.moneymanager.fragments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vkadam.moneymanager.R;

/**
 * A list fragment representing a Main Navigation.
 * <p>
 * Activities containing this fragment MUST implement the {@link Callbacks} interface.
 */

public class MainNavigationFragment extends ListFragment {
    
    /**
     * A callback interface that all activities containing this fragment must implement. This mechanism allows
     * activities to be notified of item selections.
     */
    public interface Callbacks {
        /**
         * Callback for when an item has been selected.
         */
        public void onNavigationItemSelected(Fragment contentFragment);
    }
    
    /**
     * A dummy implementation of the {@link Callbacks} interface that does nothing. Used only when this fragment is not
     * attached to an activity.
     */
    private static Callbacks sDummyCallbacks = new Callbacks() {
        @Override
        public void onNavigationItemSelected(Fragment contentFragment) {
        }
    };
    
    /**
     * The fragment's current callback object, which is notified of list item clicks.
     */
    private Callbacks mCallbacks = sDummyCallbacks;
    
    /**
     * An array of sample (dummy) items.
     */
    public List<NavigationItem> NAVIGATION_ITEMS = new ArrayList<NavigationItem>();
    
    /**
     * A map of sample (NavigationItem) items, by ID.
     */
    
    @SuppressLint("UseSparseArrays")
    public Map<Integer, NavigationItem> NAVIGATION_MENU_MAP = new HashMap<Integer, NavigationItem>();
    
    private void addItem(NavigationItem item) {
        NAVIGATION_ITEMS.add(item);
        NAVIGATION_MENU_MAP.put(item.id, item);
    }
    
    /**
     * A dummy item representing a piece of content.
     */
    public static class NavigationItem {
        private int id;
        private String name;
        private Fragment contentFragment;
        
        public NavigationItem(int resourceId, String content) {
            this.id = resourceId;
            this.name = content;
        }
        
        @Override
        public String toString() {
            return name;
        }
        
    }
    
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the fragment (e.g. upon screen orientation
     * changes).
     */
    public MainNavigationFragment() {
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        
        setListAdapter(new ArrayAdapter<NavigationItem>(getActivity(), android.R.layout.simple_list_item_activated_1,
                                                        android.R.id.text1, this.NAVIGATION_ITEMS));
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getListView().setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
    }
    
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        addItem(new NavigationItem(1, getString(R.string.navigation_accounts)));
        addItem(new NavigationItem(2, getString(R.string.navigation_payees)));
        addItem(new NavigationItem(3, getString(R.string.navigation_categories)));
        
        // Activities containing this fragment must implement its callbacks.
        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }
        
        mCallbacks = (Callbacks) activity;
    }
    
    @Override
    public void onDetach() {
        super.onDetach();
        // Reset the active callbacks interface to the dummy implementation.
        mCallbacks = sDummyCallbacks;
    }
    
    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);
        
        NavigationItem navigationItem = this.NAVIGATION_ITEMS.get(position);
        
        if (null == navigationItem.contentFragment) {
            switch (navigationItem.id) {
            case 1:
                navigationItem.contentFragment = new AccountListFragment();
                break;
            case 2:
                navigationItem.contentFragment = new PayeeListFragment();
                break;
            }
        }
        
        if (null != navigationItem.contentFragment) {
            // Notify the active callbacks interface (the activity, if the
            // fragment is attached to one) that an item has been selected.
            mCallbacks.onNavigationItemSelected(navigationItem.contentFragment);
        }
    }
    
}
