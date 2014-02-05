package com.uds.domotica.adapters;

import java.util.ArrayList;

import com.uds.domotica.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class gridViewAdapter extends ArrayAdapter<ItemGrid> {
	
	 Context context;
	 int layoutResourceId;
	 ArrayList<ItemGrid> data= new ArrayList<ItemGrid>();

	 public gridViewAdapter(Context context,int layoutResourceId, ArrayList<ItemGrid> data) {
		super(context, layoutResourceId,data);
		// TODO Auto-generated constructor stub
		this.context=context;
		this.layoutResourceId=layoutResourceId;
		this.data=data;
	}
	 @Override
	  public View getView(int position, View convertView, ViewGroup parent) {

	   View row = convertView;
	   RecordHolder holder = null;
	   if (row == null) {
		    LayoutInflater inflater = ((Activity) context).getLayoutInflater();
		    row = inflater.inflate(layoutResourceId, parent, false);
		    holder = new RecordHolder();
		    holder.tvNombre= (TextView) row.findViewById(R.id.tvNameD);
		    holder.tvUbica=(TextView)row.findViewById(R.id.tvUbic);
		    holder.imageItem = (ImageView) row.findViewById(R.id.imgdevices);
		    row.setTag(holder);
	   } else {
		   holder = (RecordHolder) row.getTag();
	   }
	   ItemGrid item = data.get(position);
	   row.setBackgroundResource(R.color.green_transparente);
	   holder.tvNombre.setText(item.getNombre());
	   holder.tvUbica.setText(item.getUbicacion());
	   holder.imageItem.setImageResource(item.getImagen());

	   return row;
	  }


	 static class RecordHolder {
		   TextView tvNombre,tvUbica;
		   ImageView imageItem;

		  }

}
