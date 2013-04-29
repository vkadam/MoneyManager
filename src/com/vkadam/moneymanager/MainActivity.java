package com.vkadam.moneymanager;

import roboguice.inject.ContentView;
import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockListFragment;
import com.slidingmenu.lib.SlidingMenu;
import com.vkadam.moneymanager.fragments.MainNavigationFragment;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity implements MainNavigationFragment.Callbacks {
    
    private SlidingMenu slidingMenu;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        
        //configure the SlidingMenu
        slidingMenu = new SlidingMenu(this);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        
        slidingMenu.setShadowWidthRes(R.dimen.sliding_shadow_width);
        slidingMenu.setShadowDrawable(R.drawable.shadow);
        
        slidingMenu.setBehindWidthRes(R.dimen.sliding_menu_width);
        slidingMenu.setFadeDegree(0.35f);
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        slidingMenu.setMenu(R.layout.fragment_main_navigation);
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        
        getSupportMenuInflater().inflate(R.menu.activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    public void onNavigationItemSelected(SherlockListFragment contentFragment) {
        
        if (null != contentFragment) {
            getSupportFragmentManager().beginTransaction().replace(R.id.layout_activity_main, contentFragment).commit();
        }
        slidingMenu.toggle();
    }
    
    @Override
    public boolean onMenuItemSelected(int featureId, com.actionbarsherlock.view.MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            slidingMenu.toggle();
            break;
        }
        return super.onMenuItemSelected(featureId, item);
    }
    
}

/*public void showDatePickerDialog(View v) {
DialogFragment newFragment = new DatePickerFragment();
newFragment.show(getSupportFragmentManager(), "datePicker");
}

public static class DatePickerFragment extends DialogFragment implements
	DatePickerDialog.OnDateSetListener {

@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
	// Use the current date as the default date in the picker
	final Calendar c = Calendar.getInstance();
	int year = c.get(Calendar.YEAR);
	int month = c.get(Calendar.MONTH);
	int day = c.get(Calendar.DAY_OF_MONTH);

	// Create a new instance of DatePickerDialog and return it
	return new DatePickerDialog(getActivity(), this, year, month, day);
}

public void onDateSet(DatePicker view, int year, int month, int day) {
	// Do something with the date chosen by the user
}
}*/
