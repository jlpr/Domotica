package com.uds.domotica.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class AvailableInternet {
	
	private static AvailableInternet instance= null;
	protected  AvailableInternet(){
		
	}
	public static AvailableInternet getInstance(){
		if(instance==null){
			if (instance==null){
				instance= new AvailableInternet();
			}
		}
		return instance;
	}
	
	public boolean isNetworkAvailable(Context context) {
	    ConnectivityManager connectivityManager 
	          = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
}
