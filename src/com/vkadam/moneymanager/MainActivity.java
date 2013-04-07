package com.vkadam.moneymanager;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;

import com.vkadam.moneymanager.R;
import com.vkadam.moneymanager.navigation.ActionBarNavigator;

public class MainActivity extends ActionBarNavigator {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return super.onCreateOptionsMenu(menu);
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
