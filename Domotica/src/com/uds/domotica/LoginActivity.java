package com.uds.domotica;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import com.uds.domotica.introduction.CircleViewFlowExample;
import com.uds.domotica.utils.BitmapChange;
import com.uds.domotica.utils.ClickOpenClass;
import com.uds.domotica.utils.ManagerXML;
import com.uds.domotica.utils.Utils;

public class LoginActivity extends Activity{
	EditText EDTUSUARIO;
	EditText EDTCONTRASEÑA;
	Button BTNLOGIN,BTNINTRO;
	CheckBox ckrRecordar;
	RelativeLayout rlLogin;
	TabHost tabWi;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		rlLogin=(RelativeLayout)findViewById(R.id.RelativeLayout1);
	BTNLOGIN = (Button)findViewById(R.id.btnStart);
	EDTUSUARIO=(EditText)findViewById(R.id.edtUser);
	EDTCONTRASEÑA=(EditText)findViewById(R.id.edtPassword);
	ckrRecordar= (CheckBox)findViewById(R.id.checkBox1);
	BTNINTRO=(Button)findViewById(R.id.btnIntro);
	tabWi=(TabHost)findViewById(R.id.tbhost);
	tabWi.setup();
	TabHost.TabSpec tabs= tabWi.newTabSpec("Inicio");
	tabs.setContent(R.id.tab1);
	tabs.setIndicator("Inicio");
	tabWi.addTab(tabs);
	TabHost.TabSpec tabs2= tabWi.newTabSpec("Introduccion");
	tabs2.setContent(R.id.tab2);
	tabs2.setIndicator("Introduccion");
	tabWi.addTab(tabs2);
	if(checkFile()){
	}
	else{
		ManagerXML.escribirXML(this, "2130837513");
	}
	int idimagen=ManagerXML.leerXML(this);
	//Utils.getInstance().MakeToastLong(getApplicationContext(), "error: "+idimagen );
	rlLogin.setBackground(new BitmapDrawable(BitmapChange.decodeSampledBitmapFromResource(getResources(),idimagen, 300, 300)));
	//rlLogin.setBackgroundResource(idimagen);
	 loadSavedPreferences();
	BTNLOGIN.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		    savePreferences("CheckBox_Value", ckrRecordar.isChecked());
		    if (ckrRecordar.isChecked()) {
		                savePreferences("Usuario", EDTUSUARIO.getText().toString());
		     }
		           //UsersAsyncTask user= new UsersAsyncTask(edtUsuario, edtcontraseña, getApplicationContext(), MainActivity.class);
		            //user.execute();    
				Intent intenta= new Intent(getApplicationContext(),MainActivity.class);
					startActivity(intenta);	
				//	Utils.getInstance().MakeProgressDialog(LoginActivity.this, "Entrando", "Cargando...");
		            finish();
		}
	});
	
	BTNINTRO.setOnClickListener(ClickOpenClass.openClass(this,CircleViewFlowExample.class));
		
	}
	private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean checkBoxValue = sharedPreferences.getBoolean("CheckBox_Value", false);
        String name = sharedPreferences.getString("Usuario", "");
        if (checkBoxValue) {
           ckrRecordar.setChecked(true);
        } else {
        	 ckrRecordar.setChecked(false);
        }
        EDTUSUARIO.setText(name);
    }
	private void savePreferences(String key, boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    private void savePreferences(String key, String value) {	
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }
    private boolean checkFile(){
    	boolean checar=false;
    	File file = new File(getFilesDir()+"/test.xml");
    		if (file.exists())
    		{
    			checar =true;
    		}
    	return checar;
    }
    /*
    private String toMd5(String pass){
        try{
            //Creando Hash MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(pass.getBytes());
            byte messageDigest[] = digest.digest();
 
            //Creando Hex String
            StringBuffer hexString = new StringBuffer();
            for(int i=0; i<messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            Log.w("Pass en MD5: ", hexString.toString());
            return hexString.toString();
        }catch(NoSuchAlgorithmException ex){
            Log.w("NoSuchAlgorithmException", ex.toString());
            return null;
        }
    }
    
    
    public InputStream retrieveStream(String url){ 	
    	DefaultHttpClient dhc= new DefaultHttpClient();
    	HttpGet htg= new HttpGet(url);
    	try{
    		HttpResponse htr= dhc.execute(htg);
    		final int statusCode=htr.getStatusLine().getStatusCode();
    		if(statusCode!=HttpStatus.SC_OK){
    			Log.w(getClass().getSimpleName(), "Error: "+statusCode+"for URL: "+url);
    		}
    		HttpEntity htpe= htr.getEntity();
    		return htpe.getContent();  		
    	}
    	catch(IOException ie){
    		htg.abort();
    		Log.w(getClass().getSimpleName(),"Error: "+ url,ie);
    	}
    	return null;
    }
    */
    


}
