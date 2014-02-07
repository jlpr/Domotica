package com.uds.domotica.charts;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYValueSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import com.uds.domotica.R;
import com.uds.domotica.utils.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class BubleChartsActivity extends Activity{

	 GraphicalView mchart;
	String nameChart;
	 String [][] datoSerie;
	 Bitmap bitmap;
    LinearLayout lChart;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showchart);
		 lChart= (LinearLayout)findViewById(R.id.charts);
		lChart.addView(crearGrafica());

	
		Button btnSave= (Button)findViewById(R.id.btnSaveImage);
		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		
                mchart.setDrawingCacheEnabled(true); 
                mchart.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH); 
                //Build the cache, get the bitmap and close the cache 
                mchart.buildDrawingCache(true); 
                mchart.setSaveEnabled(true);
                Bitmap b = Bitmap.createBitmap(mchart.getDrawingCache()); 
                mchart.setDrawingCacheEnabled(false); 

                try { 
                	AbstractCharts.saveImageToInternalStorage(b,getApplicationContext());
            Utils.getInstance().MakeToastLong(getApplicationContext(), "Guardado en: " + getPackageCodePath() );
                } catch (Exception e) { 
                        e.printStackTrace(); 
                } 
			
			}
		});

	}
	public GraphicalView crearGrafica() {
		// TODO Auto-generated method stub
		XYMultipleSeriesDataset series = new XYMultipleSeriesDataset();
	    XYValueSeries newTicketSeries = new XYValueSeries("New Tickets");
	    newTicketSeries.add(1f, 2, 14);
	    newTicketSeries.add(2f, 2, 12);
	    newTicketSeries.add(3f, 2, 18);
	    newTicketSeries.add(4f, 2, 5);
	    newTicketSeries.add(5f, 2, 1);
	    series.addSeries(newTicketSeries);
	    XYValueSeries fixedTicketSeries = new XYValueSeries("Fixed Tickets");
	    fixedTicketSeries.add(1f, 1, 7);
	    fixedTicketSeries.add(2f, 1, 4);
	    fixedTicketSeries.add(3f, 1, 18);
	    fixedTicketSeries.add(4f, 1, 3);
	    fixedTicketSeries.add(5f, 1, 1);
	    series.addSeries(fixedTicketSeries);

	    XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
	    renderer.setAxisTitleTextSize(16);
	    renderer.setChartTitleTextSize(20);
	    renderer.setLabelsTextSize(15);
	    renderer.setLegendTextSize(15);
	    renderer.setMargins(new int[] { 20, 30, 15, 0 });
	    XYSeriesRenderer newTicketRenderer = new XYSeriesRenderer();
	    newTicketRenderer.setColor(Color.BLUE);
	    renderer.addSeriesRenderer(newTicketRenderer);
	    XYSeriesRenderer fixedTicketRenderer = new XYSeriesRenderer();
	    fixedTicketRenderer.setColor(Color.GREEN);
	    renderer.addSeriesRenderer(fixedTicketRenderer);

	    AbstractCharts.setChartSettings(renderer, "Project work status", "Priority", "", 0.5, 5.5, 0, 5, Color.GRAY,
	        Color.LTGRAY);
	    renderer.setXLabels(7);
	    renderer.setYLabels(0);
	    renderer.setShowGrid(false);
	    mchart=ChartFactory.getBubbleChartView(this, series, renderer );
	    return  mchart;
	}
	

}
