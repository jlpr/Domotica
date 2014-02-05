package com.uds.domotica;

import com.uds.domotica.utils.AvailableInternet;
import com.uds.domotica.utils.Utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends Activity{

	private WebView BROWSER;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.diff_view3);
	
		  final show_Web SHOWWEB= new show_Web();
		  if(AvailableInternet.getInstance().isNetworkAvailable(getApplicationContext())){
				BROWSER = (WebView)findViewById(R.id.webView1);
		        	runOnUiThread(new Runnable() {
		        		@SuppressLint("SetJavaScriptEnabled")
						@Override
			            public void run() {
			        		getWindow().setFeatureInt(Window.FEATURE_PROGRESS,Window.PROGRESS_VISIBILITY_ON);
			            	 WebSettings webSettings = BROWSER.getSettings();
			 		        webSettings.setJavaScriptEnabled(true);
			 		        webSettings.setSupportZoom(true);
			 		        webSettings.setBuiltInZoomControls(true);
			 		        BROWSER.setWebViewClient(SHOWWEB);
			            	BROWSER.loadUrl("http://google.com");
			            	final Activity WebActivity= WebActivity.this;
			            	BROWSER.setWebChromeClient(new WebChromeClient(){
			            		   public void onProgressChanged(WebView view, int progress)  {
			            			   WebActivity.setTitle("Abriendo Página...");
			            			   WebActivity.setProgress(progress * 100); 
			            	            if(progress == 100)
			            	               WebActivity.setTitle(R.string.app_name);
			            		   		}
			            	   
			            	});
			            }
		        	});
			}
			else{
				Utils.getInstance().MakeToastLong(getApplicationContext(), " No tiene Internet!!");
			}
	}
	/**
	 * 
	 * @category WebView
	 *
	 */
	private class show_Web extends WebViewClient {

	    @Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
	        view.loadUrl(url);
	        return true;
	    }
	}
	
}
