package org.persistency.dagumar;

import android.os.Bundle;
import android.preference.PreferenceActivity;


public class AndroidPreferencesScreenActivity extends PreferenceActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.layout.preferences_screen);
	}
}
