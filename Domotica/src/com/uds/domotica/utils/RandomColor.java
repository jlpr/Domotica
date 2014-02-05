package com.uds.domotica.utils;

import java.util.Random;

import android.graphics.Color;

public class RandomColor {

	private static RandomColor instance;
	
	Random rcolor= new Random();
	public RandomColor(){
		
	}
	
	public static RandomColor getInstance(){
		if (instance == null) {
			if (instance == null) {
				instance = new RandomColor();
			}
		}
		return instance;
	}
	
	public int crearColor(){
		
		
		int r= rcolor.nextInt();
		int g= rcolor.nextInt();
		int b= rcolor.nextInt();

		return Color.argb(10, r, g, b);
		
	}
	
}
