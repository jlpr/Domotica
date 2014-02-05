package com.uds.domotica.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapChange {

	 public static int calculateInSampleSize(
	            BitmapFactory.Options options, int reqWidth, int reqHeight) {
	    // original size image
	    final int height = options.outHeight;
	    final int width = options.outWidth;
	    int inSampleSize = 1;

	    if (height > reqHeight || width > reqWidth) {

	        final int halfHeight = height / 2;
	        final int halfWidth = width / 2;

	        // Calculate the largest inSampleSize value that is a power of 2 and keeps both
	        // height and width larger than the requested height and width.
	        while ((halfHeight / inSampleSize) > reqHeight
	                && (halfWidth / inSampleSize) > reqWidth) {
	            inSampleSize *= 2;
	        }
	    }
	    return inSampleSize;
	}

		public static Bitmap decodeSampledBitmapFromResource(
				Resources resources, int resId, int reqWidth, int reqHeight) {
			// TODO Auto-generated method stub
			   final BitmapFactory.Options options = new BitmapFactory.Options();
		        options.inJustDecodeBounds = true;
		        BitmapFactory.decodeResource(resources, resId, options);

		        // Calculate inSampleSize
		        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

		        // Decode bitmap with inSampleSize set
		        options.inJustDecodeBounds = false;
		        return BitmapFactory.decodeResource(resources, resId, options);
		}

}
