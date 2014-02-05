package com.uds.domotica;

import org.taptwo.android.widget.TitleProvider;

import com.uds.domotica.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class DiffAdapter extends BaseAdapter implements TitleProvider {

        private static final int VIEW1 = 0;
        private static final int VIEW2 = 1;

        private static final int VIEW_MAX_COUNT = VIEW1 + 1;
        Context context;
        ImageView ivda;
    	private final String[] names = {"Grafica","Dispositivos"};

    private LayoutInflater mInflater;

    public DiffAdapter(Context context) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context=context;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_MAX_COUNT;
    }

    @Override
    public int getCount() {
        return names.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        int view = getItemViewType(position);
        if (convertView == null) {
            switch (view) {
                case VIEW1:
                    convertView = mInflater.inflate(R.layout.activity_sesion, null);
                    break;
                case VIEW2:
                    convertView = mInflater.inflate(R.layout.diff_view2, null);
                    break;
        
       
            }
        }
        return convertView;
    }

    

    /* (non-Javadoc)
	 * @see org.taptwo.android.widget.TitleProvider#getTitle(int)
	 */
	public String getTitle(int position) {
		return names[position];
	}

}
