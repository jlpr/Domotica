package com.uds.domotica.charts;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import com.uds.domotica.R;
import com.uds.domotica.utils.RandomColor;
import com.uds.domotica.utils.Utils;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;




public class BarChartActivity extends Activity {

	 GraphicalView mchart;
	String nameChart;
	 String [][] datoSerie;
	 Bitmap bitmap;
	 XYMultipleSeriesDataset datasetLista;
     XYMultipleSeriesRenderer mRenderer;
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

			createSerie();	
	        XYMultipleSeriesDataset datasetLista = addSeriesDataset( datoSerie);
	        XYMultipleSeriesRenderer mRenderer= new XYMultipleSeriesRenderer();
	        for (int i=0 ; i<datasetLista.getSeriesCount();i++){
		        mRenderer.addSeriesRenderer(crearRendererSeries());
	        }
	        mRenderer.setChartTitle(nameChart);
//	        mRenderer.setXTitle("xValues");
	        mRenderer.setYTitle("Rupee");
	        mRenderer.setZoomButtonsVisible(true);    mRenderer.setShowLegend(true);
	        mRenderer.setShowGridX(true);      // this will show the grid in  graph
	        mRenderer.setShowGridY(true);              
//	        mRenderer.setAntialiasing(true);
	        mRenderer.setBarSpacing(.5);   // adding spacing between the line or stacks
	      
	        mRenderer.setBackgroundColor(Color.BLACK);
	        mRenderer.setApplyBackgroundColor(true);
	        mRenderer.setXAxisMin(0);
//	        mRenderer.setYAxisMin(.5);
	        mRenderer.setXAxisMax(5);
	        mRenderer.setYAxisMax(50);    
	        mRenderer.setXLabels(0);
	        mRenderer.addXTextLabel(1,"Income");
	        mRenderer.addXTextLabel(2,"Saving");
	        mRenderer.addXTextLabel(3,"Expenditure");
	        mRenderer.addXTextLabel(4,"NetIncome");
	        mRenderer.setPanEnabled(true, true);    // will fix the chart position
	        mRenderer.setClickEnabled(false);
	        mchart= ChartFactory.getBarChartView(getApplicationContext(), datasetLista,mRenderer,Type.DEFAULT);
	        return mchart;
		}
		public static XYSeriesRenderer crearRendererSeries(){
			XYSeriesRenderer renderer= new XYSeriesRenderer();
	        renderer.setAnnotationsTextSize((float) 0.3d);
	        renderer.setColor(RandomColor.getInstance().createColor());
	        renderer.setDisplayChartValues(true);
	        renderer.setChartValuesSpacing((float) 5.5d);
	        renderer.setLineWidth((float) 10.5d);
			return renderer;
		}
		public static XYMultipleSeriesDataset addSeriesDataset(String [][] nombre ){
	
			XYMultipleSeriesDataset seriesMu= new XYMultipleSeriesDataset();
			CategorySeries serie;
			
			int lengthx= nombre.length;
			int lengthy= nombre[0].length;
			for(int i=0; i<lengthx;i++){
				serie= new CategorySeries(String.valueOf(nombre[i][0]));
				for(int z= 1;z<lengthy;z++){
					serie.add(nombre[i][0],Integer.parseInt(nombre[i][z]));
				}
				seriesMu.addSeries(serie.toXYSeries());
			}
			return seriesMu;
		}

		public void createSerie(){
			try{
			datoSerie= new String[3][4];
			datoSerie[0][0]="Bar1";
			datoSerie[0][1]="30";
			datoSerie[0][2]="40";
			datoSerie[0][3]="50";
			datoSerie[1][0]="Bar2";
			datoSerie[1][1]="20";
			datoSerie[1][2]="40";
			datoSerie[1][3]="50";
			datoSerie[2][0]="Bar3";
			datoSerie[2][1]="10";
			datoSerie[2][2]="20";
			datoSerie[2][3]="30";
			}
			catch(Exception ex){
				Utils.getInstance().MakeToastLong(getApplicationContext(), "Error:"+ex);
			}
		}


}
