package com.uds.domotica.charts;

import java.util.ArrayList;
import java.util.List;
import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import com.uds.domotica.R;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class TemperatureChartsActivity extends Activity {

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
			  String[] titles = new String[] { "Crete", "Corfu", "Thassos", "Skiathos" };
			    List<double[]> x = new ArrayList<double[]>();
			    for (int i = 0; i < titles.length; i++) {
			      x.add(new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 });
			    }
			    List<double[]> values = new ArrayList<double[]>();
			    values.add(new double[] { 12.3, 12.5, 13.8, 16.8, 20.4, 24.4, 26.4, 26.1, 23.6, 20.3, 17.2,
			        13.9 });
			    values.add(new double[] { 10, 10, 12, 15, 20, 24, 26, 26, 23, 18, 14, 11 });
			    values.add(new double[] { 5, 5.3, 8, 12, 17, 22, 24.2, 24, 19, 15, 9, 6 });
			    values.add(new double[] { 9, 10, 11, 15, 19, 23, 26, 25, 22, 18, 13, 10 });
			    int[] colors = new int[] { Color.BLUE, Color.GREEN, Color.CYAN, Color.YELLOW };
			    PointStyle[] styles = new PointStyle[] { PointStyle.CIRCLE, PointStyle.DIAMOND,
			        PointStyle.TRIANGLE, PointStyle.SQUARE };
			    XYMultipleSeriesRenderer renderer = AbstractCharts.buildRenderer(colors, styles);
			    int length = renderer.getSeriesRendererCount();
			    for (int i = 0; i < length; i++) {
			      ((XYSeriesRenderer) renderer.getSeriesRendererAt(i)).setFillPoints(true);
			    }
			    AbstractCharts.setChartSettings(renderer, "Average temperature", "Month", "Temperature", 0.5, 12.5, -10, 40,
			        Color.LTGRAY, Color.LTGRAY);
			    renderer.setXLabels(12);
			    renderer.setYLabels(10);
			    renderer.setShowGrid(true);
			    renderer.setXLabelsAlign(Align.RIGHT);
			    renderer.setYLabelsAlign(Align.RIGHT);
			    renderer.setZoomButtonsVisible(true);
			    renderer.setPanLimits(new double[] { -10, 20, -10, 40 });
			    renderer.setZoomLimits(new double[] { -10, 20, -10, 40 });

			    XYMultipleSeriesDataset dataset = AbstractCharts.buildDataset(titles, x, values);
			    XYSeries series = dataset.getSeriesAt(0);
			    series.addAnnotation("Vacation", 6, 28);

			    XYSeriesRenderer r = (XYSeriesRenderer) renderer.getSeriesRendererAt(0);
			    r.setAnnotationsColor(Color.GREEN);
			    r.setAnnotationsTextSize(15);
			    r.setAnnotationsTextAlign(Align.CENTER);
			    mchart=ChartFactory.getLineChartView(this, dataset, renderer);
			    return  mchart;
		}
	
}
