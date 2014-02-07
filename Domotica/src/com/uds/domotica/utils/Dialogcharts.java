package com.uds.domotica.utils;
import com.uds.domotica.R;
import com.uds.domotica.WebActivity;
import com.uds.domotica.charts.BarChartActivity;
import com.uds.domotica.charts.BubleChartsActivity;
import com.uds.domotica.charts.LineChartActivity;
import com.uds.domotica.charts.PieChartActivity;
import com.uds.domotica.charts.TemperatureChartsActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class Dialogcharts {
	private static Dialogcharts instance=null;
	
	public Dialogcharts(){
		
	}
	public static synchronized Dialogcharts getInstance(){
		if (instance == null) {
			if (instance == null) {
				instance = new Dialogcharts();
			}
		}
		return instance;
	}
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
		
	}
	public void graficaDialogo(final Activity activity,final int tipo){

		
		AlertDialog.Builder dialog= new AlertDialog.Builder(activity,android.R.style.Theme_DeviceDefault_Dialog);
      

        dialog.setTitle("Elija por Periodo");
        dialog.setSingleChoiceItems(R.array.periodo, 0,new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				final Intent inten;
				switch(tipo){
				case 0:
					 inten= new Intent(activity,LineChartActivity.class);
					activity.startActivity(inten);
					break;
				case 1:
					inten= new Intent(activity,BarChartActivity.class);
					activity.startActivity(inten);
					break;
				case 2:
					 inten= new Intent(activity,PieChartActivity.class);
					activity.startActivity(inten);
					break;
				case 3:
					 inten= new Intent(activity,BubleChartsActivity.class);
					activity.startActivity(inten);
					break;
				case 4:
					 inten= new Intent(activity,TemperatureChartsActivity.class);
					activity.startActivity(inten);
					break;
				case 5:
					inten = new Intent(activity,WebActivity.class);
					activity.startActivity(inten);
	
				}
										
				}
			
		}) ;
     
        dialog.show();;
  
	}
	
}
