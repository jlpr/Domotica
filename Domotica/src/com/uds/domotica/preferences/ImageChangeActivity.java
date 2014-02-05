package com.uds.domotica.preferences;

import org.taptwo.android.widget.CircleFlowIndicator;
import org.taptwo.android.widget.ViewFlow;
import org.taptwo.android.widget.ViewFlow.ViewSwitchListener;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.uds.domotica.MainActivity;
import com.uds.domotica.R;
import com.uds.domotica.utils.ManagerXML;
import com.uds.domotica.utils.Utils;


public class ImageChangeActivity extends Activity {
	private ViewFlow viewFlow;
	public int[]util;
	public TextView tvinombre;
	public int dato=0;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setTitle("Imagen");
		setContentView(R.layout.imagechange);
		tvinombre=(TextView)findViewById(R.id.txvchage);
		util=new int[] {R.drawable.bg_sky,R.drawable.red_orage,R.drawable.blue_green};
		viewFlow = (ViewFlow) findViewById(R.id.viewflow2);
		viewFlow.setAdapter(new ChangeAdapter(this,util), 0);

		CircleFlowIndicator indic = (CircleFlowIndicator) findViewById(R.id.viewflowindic2);
		viewFlow.setFlowIndicator(indic);
		viewFlow.setOnViewSwitchListener(new ViewSwitchListener() {
		    public void onSwitched(View v, int position) {
		        dato=util[position];
		    }
		});
		tvinombre.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(dato==0)
					ManagerXML.escribirXML(getApplicationContext(),""+R.drawable.bg_sky);
				else
					ManagerXML.escribirXML(getApplicationContext(),""+dato);
		
				Utils.getInstance().MakeToastLong(getApplicationContext(), "Se ha cambiado el fondo");
					}
	
		});
	}
	/* If your min SDK version is < 8 you need to trigger the onConfigurationChanged in ViewFlow manually, like this */	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		viewFlow.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		 
		switch(keyCode){
		case KeyEvent.KEYCODE_BACK:
			 Intent intent= new Intent(this,MainActivity.class);
			startActivity(intent);
			finish();
			
		}
		return super.onKeyDown(keyCode, event);
	};

}
