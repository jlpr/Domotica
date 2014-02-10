package com.uds.domotica.charts;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import com.uds.domotica.R;
import com.uds.domotica.utils.RandomColor;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class PieChartActivity extends Activity {

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
			btnSave.setOnClickListener(AbstractCharts.clickSaveChart(getApplicationContext(), mchart));
	}

	public GraphicalView crearGrafica() {
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
	            	colors[i]=RandomColor.getInstance().createColor();
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
	            mchart=ChartFactory.getPieChartView(getApplicationContext(), series, renderer);
	            return mchart;
	          
	}
}
