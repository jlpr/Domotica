package com.uds.domotica;
import java.util.ArrayList;
import java.util.List;
import org.taptwo.android.widget.TitleFlowIndicator;
import org.taptwo.android.widget.ViewFlow;
import org.taptwo.android.widget.ViewFlow.ViewSwitchListener;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.uds.domotica.adapters.ItemGrid;
import com.uds.domotica.adapters.gridViewAdapter;
import com.uds.domotica.menusatellite.SatelliteMenu;
import com.uds.domotica.menusatellite.SatelliteMenu.SateliteClickedListener;
import com.uds.domotica.menusatellite.SatelliteMenuItem;
import com.uds.domotica.preferences.ImageChangeActivity;
import com.uds.domotica.preferences.PreferencesActivity;
import com.uds.domotica.quickaction.ActionItem;
import com.uds.domotica.quickaction.QuickAction;
import com.uds.domotica.utils.BitmapChange;
import com.uds.domotica.utils.Dialogcharts;
import com.uds.domotica.utils.ManagerXML;
import com.uds.domotica.utils.Utils;
/**
 * 
 * @author jl
 *
 */
public class MainActivity extends Activity {

	private ViewFlow VIEWFLOW;
	private GridView GVDEVICES;
	public String NAMEDEVICES;
	int IDIMAGEN=0;
	FrameLayout FRAMELAYOUTMAIN;
	Dialogcharts DIALOGCHART= new Dialogcharts();
	LinearLayout LBAR,LPIE,LBUBLE,LLINE,LTEMPERATURE,LCHARTONLINE;


	@SuppressWarnings("deprecation")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.activity_main);
		FRAMELAYOUTMAIN= (FrameLayout)findViewById(R.id.frmain);
	 IDIMAGEN=ManagerXML.leerXML(this);
	 
		Utils.getInstance().MakeToastLong(getApplicationContext(), ""+IDIMAGEN);
	
		FRAMELAYOUTMAIN.setBackground(new BitmapDrawable(BitmapChange.decodeSampledBitmapFromResource(getResources(), IDIMAGEN, 100, 100)));
	
     /**
      * variables
      */
		  SatelliteMenu MENUSATELLITE = (SatelliteMenu) findViewById(R.id.menu);
	     
	     try{
	    	
	    	 /**
	    	  *   View Flow (interface)
	    	  */
			VIEWFLOW = (ViewFlow) findViewById(R.id.viewflow);
	        DiffAdapter ADAPTER= new DiffAdapter(this);
	        VIEWFLOW.setAdapter(ADAPTER);
	        VIEWFLOW.setOnViewSwitchListener(new ViewSwitchListener() {
				
	        	
				@Override
				public void onSwitched(View view, int POSITION) {
					// TODO Auto-generated method stub
					if(POSITION==2){
						
					}
				}
			});
	        
	        
	        /**
	         *  select type view flow 
	         */
			TitleFlowIndicator INDICATOR= (TitleFlowIndicator) findViewById(R.id.viewflowindic);
			
			INDICATOR.setTitleProvider(ADAPTER);
			VIEWFLOW.setFlowIndicator(INDICATOR);

			/**
			 *  Quick Action create items
			 */
	        //Add action item
	        ActionItem addAction = new ActionItem();       
	        addAction.setTitle("On");
	        addAction.setIcon(getResources().getDrawable(R.drawable.on_actionquick)); 
	        //Accept action item
	        ActionItem accAction = new ActionItem();         
	        accAction.setTitle("Off");
	        accAction.setIcon(getResources().getDrawable(R.drawable.off_actionquick));         
	        //Upload action item
	        ActionItem upAction = new ActionItem();         
	        upAction.setTitle("Info");
	        upAction.setIcon(getResources().getDrawable(R.drawable.info_actionquick));      
	        final QuickAction mQuickAction  = new QuickAction(this);
	       mQuickAction.addActionItem(addAction);
	        mQuickAction.addActionItem(accAction);
	        mQuickAction.addActionItem(upAction);
	         mQuickAction.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
	        //setup the action item click listener
	        mQuickAction.setOnActionItemClickListener(new QuickAction.OnActionItemClickListener() {         
	            @Override
	            public void onItemClick(int pos) {
	                 
	                if (pos == 0) { //Add item selected
	                    Toast.makeText(MainActivity.this, "Encendido: " + NAMEDEVICES, Toast.LENGTH_SHORT).show();
	                } else if (pos == 1) { //Accept item selected
	                    Toast.makeText(MainActivity.this, "Apagado: "+NAMEDEVICES, Toast.LENGTH_SHORT).show();
	                } else if (pos == 2) { //Upload item selected
	                    Toast.makeText(MainActivity.this, "Informacion", Toast.LENGTH_SHORT).show();
	                }   
	            }
	        });
			
	     /**
	      *  Grid View
	      */
	        GVDEVICES= (GridView)findViewById(R.id.gridView1);
		      final ArrayList<ItemGrid> Lista_grid= new ArrayList<ItemGrid>();
		      Lista_grid.add(new ItemGrid(R.drawable.zwave,"Termometro","Pared"));
		      Lista_grid.add(new ItemGrid(R.drawable.zwave2,"apagador","Centro"));
		      Lista_grid.add(new ItemGrid(R.drawable.z_wavelogo,"Logo","Login"));
		      gridViewAdapter gva= new gridViewAdapter(this, R.layout.gridview_item,Lista_grid);
		       GVDEVICES.setAdapter(gva);
		       Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fly_in_from_top_corner);
               GVDEVICES.setAnimation(anim);
               anim.start();
		       GVDEVICES.setOnItemClickListener(new OnItemClickListener() {
		    	   public void onItemClick(AdapterView<?> parent, View v,
		    			   int position, long id) {
		    		   // TODO Auto-generated method stub
		    		   mQuickAction.show(v);
		    		   NAMEDEVICES=Lista_grid.get(position).getNombre();
		    		   mQuickAction.setAnimStyle(QuickAction.ANIM_GROW_FROM_CENTER);
		    	   }
		       });
		      
		       
		       LBAR= (LinearLayout)findViewById(R.id.layoutBar);
		  	 LBAR.setOnClickListener(clickSelection(MainActivity.this, 1));
		       LCHARTONLINE=(LinearLayout)findViewById(R.id.layoutOnline);
		       LCHARTONLINE.setOnClickListener(clickSelection(MainActivity.this, 5));
		  			 
		  			 
     /**
      * Menu satellite
      */
        List<SatelliteMenuItem> items = new ArrayList<SatelliteMenuItem>();
        items.add(new SatelliteMenuItem(5, R.drawable.close));
        items.add(new SatelliteMenuItem(4, R.drawable.datade));
        items.add(new SatelliteMenuItem(3, R.drawable.change_image));
        items.add(new SatelliteMenuItem(2, R.drawable.ic_action_email));
        items.add(new SatelliteMenuItem(1, R.drawable.notify));
        MENUSATELLITE.addItems(items);        
        MENUSATELLITE.setOnItemClickedListener(new SateliteClickedListener() {
			public void eventOccured(int id) {
				Intent intent;
				switch(id){
				case 1:
					break;
				case 3:
					 intent= new Intent(MainActivity.this,ImageChangeActivity.class);
					startActivity(intent);
					finish();
					break;
				case 4:
					intent= new Intent(MainActivity.this,PreferencesActivity.class );
					startActivity(intent);
					break;
				case 5:
					 intent= new Intent(MainActivity.this,LoginActivity.class);
					startActivity(intent);
					finish();
				}	
			}
		});
        
	     }catch(IndexOutOfBoundsException iO)
	     {
	    	Utils util=Utils.getInstance();
	    	util.MakeToastLong(getApplicationContext(), "Error");
	     }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public OnClickListener clickSelection(final Activity activity, final int tipo){
		OnClickListener openChart= new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DIALOGCHART.graficaDialogo(activity, tipo);
			}
		};
		return openChart;
	}
	
	

}
