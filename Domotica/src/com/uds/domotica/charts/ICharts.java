package com.uds.domotica.charts;

import android.content.Context;
import android.content.Intent;

public interface ICharts {

	String nombre="Nombre";
	String Descripcion="Descripcion";
	
	public String getNombre();
	public String getDescripcion();
	Intent crearGrafica(Context context);
}
