package com.uds.domotica.asynctask;


import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;


public class JSONParser {
	private String _url;
	private String _method;
	//private HttpRequestBase _method;
	private ArrayList<NameValuePair> _params;
	
	public JSONParser(String url, String method) {
		this._url = url;
		this._method=method.toLowerCase();
		this._params = new ArrayList<NameValuePair>();
	}

	public void addParam(String name, String value) {
		this._params.add(new BasicNameValuePair(name, value));
	}

	public void clearParams() {
		_params.clear();
	}
	
	public JSONObject call(String function) throws Exception {
		JSONObject ret = null;
		HttpClient client = new DefaultHttpClient();
		String fullURL = this._url + "/" + function;
		HttpRequestBase request = null;
		
		if (_method.equals("get")) {
			request = new HttpGet(fullURL);
		} else if (_method.equals("post")) {
			request = new HttpPost(fullURL);
			((HttpPost)request).setEntity(new UrlEncodedFormEntity(this._params, HTTP.UTF_8));
		} else if (_method.equals("put")) {
			request = new HttpPut(fullURL);
			((HttpPut)request).setEntity(new UrlEncodedFormEntity(this._params, HTTP.UTF_8));
		} else if (_method.equals("delete")) {
			request = new HttpDelete(fullURL);
		} else {
			throw new Exception("Metodo no soportado: " + _method);
		}
    	
		//request.setHeader("Content-Type", "application/json; charset=utf-8");
		HttpResponse oRespuesta = client.execute(request);
		String sResponse = EntityUtils.toString(oRespuesta.getEntity());
		
		if (sResponse != null) {
			ret = new JSONObject(sResponse);
		}
		
	    return ret;
	}
	
	public JSONObject call() throws Exception {
		JSONObject ret = null;
		HttpClient client = new DefaultHttpClient();
		String fullURL = this._url;
		HttpRequestBase request = null;
		
		if (_method.equals("get")) {
			request = new HttpGet(fullURL);
		} else if (_method.equals("post")) {
			request = new HttpPost(fullURL);
			((HttpPost)request).setEntity(new UrlEncodedFormEntity(this._params, HTTP.UTF_8));
		} else if (_method.equals("put")) {
			request = new HttpPut(fullURL);
			((HttpPut)request).setEntity(new UrlEncodedFormEntity(this._params, HTTP.UTF_8));
		} else if (_method.equals("delete")) {
			request = new HttpDelete(fullURL);
		} else {
			throw new Exception("Metodo no soportado: " + _method);
		}
    	
		//request.setHeader("Content-Type", "application/json; charset=utf-8");
		HttpResponse oRespuesta = client.execute(request);
		String sResponse = EntityUtils.toString(oRespuesta.getEntity());
		
		if (sResponse != null) {
			ret = new JSONObject(sResponse);
		}
		
	    return ret;
	}
}
