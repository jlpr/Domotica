package com.uds.domotica.charts;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import com.uds.domotica.utils.RandomColor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

public class PieChartActivity implements ICharts{


	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Intent crearGrafica(Context context) {
		// TODO Auto-generated method stub
		// this is my data of performance; data is collected in array.
	       int []Performance = {22, 15, 13,20,30};  // [0] for Call, [1] for Meeting, [2] for Email
	        CategorySeries series = new CategorySeries("pie"); // adding series to charts. //collect 3 value in array. therefore add three series.
	            series.add("Call",Performance[0]);            
	            series.add("Meeting",Performance[1]);
	            series.add("Email",Performance[2]);
	            series.add("Chat",Performance[3]);
	            series.add("Twitter", Performance[4]);
	// add three colors for three series respectively           
	          //  int []colors = new int[]{Color.MAGENTA, Color.WHITE, Color.GREEN};
	
	        	int []colors= new int[series.getItemCount()];
	            for (int i=0;i<series.getItemCount();i++){
	            	colors[i]=RandomColor.getInstance().crearColor();
	            }
	            // set style for series
	            DefaultRenderer renderer = new DefaultRenderer();
	            for(int color : colors){
	                SimpleSeriesRenderer r = new SimpleSeriesRenderer();
	                r.setColor(color);
	                r.setDisplayBoundingPoints(true);
	                r.setShowLegendItem(true);
	                renderer.addSeriesRenderer(r);
		           
	            }
	          
	            renderer.isInScroll();
	            renderer.setZoomButtonsVisible(true);   //set zoom button in Graph
	            renderer.setApplyBackgroundColor(true);
	            renderer.setBackgroundColor(Color.BLACK); //set background color
	            renderer.setChartTitle("Efforts");
	            renderer.setChartTitleTextSize((float) 30);
	            renderer.setShowLabels(true);  
	            renderer.setLabelsTextSize(20);
	            renderer.setLegendTextSize(25);
	            renderer.setDisplayValues(true);
	            return ChartFactory.getPieChartIntent(context, series, renderer, "PieChart");
	}
}
