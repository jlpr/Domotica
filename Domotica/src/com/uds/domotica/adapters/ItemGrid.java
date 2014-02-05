package com.uds.domotica.adapters;

public class ItemGrid {
	private int imagen;
	private String nombre;
	private String ubicacion;

	
	public ItemGrid(int imagen, String nombre, String ubicacion){
		this.imagen=imagen;
		this.nombre=nombre;
		this.ubicacion=ubicacion;
	}
	public int getImagen() {
		return imagen;
	}
	public void setImagen(int imagen) {
		this.imagen = imagen;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

}
