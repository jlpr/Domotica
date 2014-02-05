package com.uds.domotica.charts;

import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import com.uds.domotica.utils.RandomColor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;




public class BarChartActivity implements ICharts  {


		@Override
		public String getNombre() {
			// TODO Auto-generated method stub
			return "Grafica de Barras";
		}

		@Override
		public String getDescripcion() {
			// TODO Auto-generated method stub
			return "Muestra todos los datos de tal dia";
		}

		@Override
		public Intent crearGrafica(Context context) {
			// TODO Auto-generated method stub
			int y[] = {25,10,15,20};
	        
	        CategorySeries series = new CategorySeries("Bar1");
	        CategorySeries series2= new CategorySeries("Bar2");
	        for(int i=0; i < y.length; i++){
	            series.add("Bar"+(i+1),y[i]);
	            series2.add("Bar2"+i, y[i]+10);
	        }
	        //Se asigna la coleccion de series
	        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
	        dataset.addSeries(series.toXYSeries());
	        dataset.addSeries(series2.toXYSeries());
	        XYMultipleSeriesRenderer mRenderer= new XYMultipleSeriesRenderer();
	        for (int i=0 ; i<dataset.getSeriesCount();i++){
		        mRenderer.addSeriesRenderer(crearRendererSeries());
	        }

	        mRenderer.setChartTitle("Demo Graph");
//	        mRenderer.setXTitle("xValues");
	        mRenderer.setYTitle("Rupee");
	        mRenderer.setZoomButtonsVisible(true);    mRenderer.setShowLegend(true);
	        mRenderer.setShowGridX(true);      // this will show the grid in  graph
	        mRenderer.setShowGridY(true);              
//	        mRenderer.setAntialiasing(true);
	        mRenderer.setBarSpacing(.5);   // adding spacing between the line or stacks
	        mRenderer.setApplyBackgroundColor(true);
	        mRenderer.setBackgroundColor(Color.BLACK);
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
	        Intent intent = ChartFactory.getBarChartIntent(context, dataset,mRenderer,Type.DEFAULT);
			return intent;
		}
		public XYSeriesRenderer crearRendererSeries(){
		
			XYSeriesRenderer renderer= new XYSeriesRenderer();
	        renderer.setAnnotationsTextSize((float) 0.3d);
	        renderer.setColor(RandomColor.getInstance().crearColor());
	        renderer.setDisplayChartValues(true);
	        renderer.setChartValuesSpacing((float) 5.5d);
	        renderer.setLineWidth((float) 10.5d);
			return renderer;
		}

}
