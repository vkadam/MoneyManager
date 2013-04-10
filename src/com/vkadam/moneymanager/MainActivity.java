package com.vkadam.moneymanager;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.slidingmenu.lib.SlidingMenu;

public class MainActivity extends FragmentActivity implements MainNavigationFragment.Callbacks {
    
    private SlidingMenu menu;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        
        //configure the SlidingMenu
        menu = new SlidingMenu(this);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        
        menu.setShadowWidthRes(R.dimen.sliding_shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        
        menu.setBehindWidthRes(R.dimen.sliding_menu_width);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.main_left_navigation_fragment);
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public void onNavigationItemSelected(Fragment contentFragment) {
        
        if (null != contentFragment) {
            getSupportFragmentManager().beginTransaction()
                                       .replace(R.id.fragment_main_content, contentFragment)
                                       .commit();
        }
        menu.toggle();
    }
    
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            menu.toggle();
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
