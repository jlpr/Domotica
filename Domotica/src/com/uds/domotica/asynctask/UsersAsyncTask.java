package com.uds.domotica.asynctask;

import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import com.uds.domotica.BO.UserBO;
import com.uds.domotica.utils.Utils;
import android.content.Context;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;
import android.widget.EditText;

public class UsersAsyncTask extends AsyncTask<String ,Void, Boolean> {
	private EditText edtpass,edtuser;
	private Context context;
	@SuppressWarnings("unused")
	private Class<?> clasep;
    InputStream inputStream = null;

	//private static String METHOD = "POST";
	String url= "http://dyson.jit.su/user";

	public UsersAsyncTask(EditText edtuser ,EditText edtpass,Context context,Class<?>clasep){
		this.edtuser=edtuser;
		this.edtpass=edtpass;
		this.context=context;
		this.clasep=clasep;
	}

	@Override
	protected Boolean doInBackground(String... params) {
		// TODO Auto-generated method stub
		try{
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); 
			StrictMode.setThreadPolicy(policy);
			
			HttpClient httpClient = new DefaultHttpClient();
			  
			HttpGet del =
			    new HttpGet(url);
			 
			del.setHeader("content-type", "application/json");
			 
			try
			{
			        HttpResponse resp = httpClient.execute(del);
			        String respStr = EntityUtils.toString(resp.getEntity());
			        UserBO ubo= new UserBO();
			        JSONObject respJSON = new JSONObject(respStr);
			 
			         ubo.setUser(respJSON.toString(1));
			         ubo.setCity(respJSON.toString(2));
			        
			         if(ubo.getUser().equals(edtuser.getText().toString())&&ubo.getCity().equals(edtpass.getText().toString())){
			        	 Utils.getInstance().MakeToastLong(context, "Bienvenido");
			         }
			         else{
			        	 Utils.getInstance().MakeToastLong(context, ""+ubo.getUser()+" "+ubo.getCity());
			         }
			}
			catch(Exception ex)
			{
			        Log.e("ServicioRest","Error!"+ex , ex);
			}
		
	
            } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				  Log.e("ServicioRest","Error!"+e , e);
			}
        
        return null;
    }


	

	@Override
	protected void onPostExecute(Boolean result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		/*try{
		if(result)
		{
			Intent intent= new Intent(context,clasep);
			context.startActivity(intent);
		}
		else {
			Utils.getInstance().MakeToastLong(context, "Contraseña incorrecta");
		}
		}
		catch (Exception e){
			
		}*/
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
	}

	
}
	