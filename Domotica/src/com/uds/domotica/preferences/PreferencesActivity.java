package com.uds.domotica.preferences;


import com.uds.domotica.R;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PreferencesActivity extends PreferenceActivity {

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//setContentView(R.xml.settings);
		addPreferencesFromResource(R.xml.settings);
		
	}

}
