package com.uds.domotica.charts;

import java.util.ArrayList;
import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;


public class LineChartActivity extends AbstractCharts implements ICharts{

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
		String[] titles = new String[] { "Sales for 2008", "Sales for 2007",
        "Difference between 2008 and 2007 sales" };
    List<double[]> values = new ArrayList<double[]>();
    values.add(new double[] { 14230, 12300, 14240, 15244, 14900, 12200, 11030, 12000, 12500, 15500,
        14600, 15000 });
    values.add(new double[] { 10230, 10900, 11240, 12540, 13500, 14200, 12530, 11200, 10500, 12500,
        11600, 13500 });
    int length = values.get(0).length;
    double[] diff = new double[length];
    for (int i = 0; i < length; i++) {
      diff[i] = values.get(0)[i] - values.get(1)[i];
    }
    values.add(diff);
    int[] colors = new int[] { Color.BLUE, Color.CYAN, Color.GREEN };
    PointStyle[] styles = new PointStyle[] { PointStyle.POINT, PointStyle.POINT, PointStyle.POINT };
    XYMultipleSeriesRenderer renderer = buildRenderer(colors, styles);
    setChartSettings(renderer, "Monthly sales in the last 2 years", "Month", "Units sold", 0.75,
        12.25, -5000, 19000, Color.GRAY, Color.LTGRAY);
    renderer.setXLabels(12);
    renderer.setYLabels(10);
    renderer.setChartTitleTextSize(20);
    renderer.setTextTypeface("sans_serif", Typeface.BOLD);
    renderer.setLabelsTextSize(14f);
    renderer.setAxisTitleTextSize(15);
    renderer.setLegendTextSize(15);
    length = renderer.getSeriesRendererCount();

    for (int i = 0; i < length; i++) {
      XYSeriesRenderer seriesRenderer = (XYSeriesRenderer) renderer.getSeriesRendererAt(i);
      if (i == length - 1) {
        FillOutsideLine fill = new FillOutsideLine(FillOutsideLine.Type.BOUNDS_ALL);
        fill.setColor(Color.GREEN);
        seriesRenderer.addFillOutsideLine(fill);
      }
      seriesRenderer.setLineWidth(2.5f);
      seriesRenderer.setDisplayChartValues(true);
      seriesRenderer.setChartValuesTextSize(10f);
    }
    return ChartFactory.getCubicLineChartIntent(context, buildBarDataset(titles, values), renderer,
        0.5f);
	}
	
}
