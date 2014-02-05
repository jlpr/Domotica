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
					LineChartActivity lnca= new LineChartActivity();
					 inten= lnca.crearGrafica(activity);
					activity.startActivity(inten);
					break;
				case 1:
					BarChartActivity baac= new BarChartActivity();
					inten= baac.crearGrafica(activity);
					activity.startActivity(inten);
					break;
				case 2:
					PieChartActivity pcn= new PieChartActivity();
					 inten= pcn.crearGrafica(activity);
					activity.startActivity(inten);
					break;
				case 3:
					BubleChartsActivity bbca=new BubleChartsActivity();
					inten= bbca.crearGrafica(activity);
					activity.startActivity(inten);
					break;
				case 4:
					TemperatureChartsActivity tmca=new TemperatureChartsActivity();
					inten= tmca.crearGrafica(activity);
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
