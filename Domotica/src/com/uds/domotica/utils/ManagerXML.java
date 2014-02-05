package com.uds.domotica.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;
import android.content.Context;
import android.util.Xml;
import android.widget.Toast;

public class ManagerXML {

	public 	String TAG="Error";
	public static void escribirXML(Context context,String dato) {

		   FileOutputStream fout = null;
		   try {
		
				  fout = context.openFileOutput("test.xml", Context.MODE_PRIVATE);
			
			 
		   } catch (FileNotFoundException e) {

		      Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();  
		   }
		   XmlSerializer serializer = Xml.newSerializer();
			try {
				serializer.setOutput(fout, "UTF-8");
				serializer.startDocument(null, true);
				serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);

				serializer.startTag(null, "BackgroundImage");
				serializer.attribute(null, "numeroimagenes", "2");
				serializer.startTag(null, "Imagenes");
				serializer.attribute(null, "image", dato);
				serializer.endTag(null, "Imagenes");
				serializer.endTag(null,"BackgroundImage");
				serializer.endDocument();
				serializer.flush();
				fout.close();

		
			} catch (Exception e) {
				//Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
			}

		}
	public static int leerXML(Context context) {
		FileInputStream fin = null;
		int dato=0;

		try {
			fin = context.openFileInput("test.xml");
			//Utils.getInstance().MakeToastLong(context, context.getCacheDir()+"");
		} catch (Exception e) {
			//Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
		}

		XmlPullParser parser = Xml.newPullParser();
		try {
			parser.setInput(fin, "UTF-8");
			int event = parser.next();
			while(event != XmlPullParser.END_DOCUMENT) {
				if(event == XmlPullParser.START_TAG) {
					for(int i = 0; i < parser.getAttributeCount(); i++) {
					//	Log.d("Error","\t" + parser.getAttributeName(i) + " = " + parser.getAttributeValue(i) +" "+ i);
						if(i==0){
							parser.getAttributeValue(i);
						dato= Integer.parseInt(parser.getAttributeValue(i).toString());
						}
					}
				}


				event = parser.next();
			}
			fin.close();

		
		} catch (Exception e) {
			//Toast.makeText(context, "error: "+ e, Toast.LENGTH_LONG).show();
			dato=10;
		}
		return dato;
	}

}
