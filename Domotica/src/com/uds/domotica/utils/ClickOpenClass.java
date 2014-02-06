package com.uds.domotica.utils;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class ClickOpenClass {
    public static OnClickListener openClass(final Activity activity,final Class<?> clase){
    	OnClickListener clickOpen= new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intenta= new Intent(activity.getApplicationContext(),clase);
				activity.startActivity(intenta);
			}
		};
		return clickOpen;
    }
}
