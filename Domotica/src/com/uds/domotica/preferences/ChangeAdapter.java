
package com.uds.domotica.preferences;

import com.uds.domotica.R;
import com.uds.domotica.utils.BitmapChange;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ChangeAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	Context context;
	public int[] uil;
	//private static final int[] ids = { R.drawable.bg_sky,R.drawable.blue_orage,R.drawable.blue_green};

	public ChangeAdapter(Context context,int []uil) {
		//TODO 
		this.uil=uil;
		this.context=context;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return uil.length;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.changeimage_item, null);
			
		}
		((ImageView) convertView.findViewById(R.id.imgView)).setImageBitmap(BitmapChange.decodeSampledBitmapFromResource(context.getResources(),uil[position],100,100));
		
		
		return convertView;
	}

}
