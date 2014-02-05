package com.uds.domotica.utils;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

public class ProgressBar {
	ProgressDialog pd;
	public void showDialog(Context context,String titulo,String mensaje){
		 pd= new ProgressDialog(context);
		pd.setMax(100);
		pd.setMessage(mensaje);
		pd.setTitle(titulo);
		pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		pd.show();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
				while (pd.getProgress()<=pd.getMax()){
					Thread.sleep(200);
					handler.sendMessage(handler.obtainMessage());
					if(pd.getProgress()==pd.getMax()){
						pd.dismiss();
					}
				}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		} ).start();
	}
	@SuppressLint("HandlerLeak")
	Handler handler= new Handler(){
		@Override
		public void handleMessage(Message mss){
			super.handleMessage(mss);
			pd.incrementProgressBy(10);
		}
	};

		
	
}
