package com.uds.domotica.utils;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Environment;
import android.widget.Toast;

public class Utils {

	ProgressDialog pd = null;
	
	private static Utils instance = null;

	protected Utils() {
	}

	public static Utils getInstance() {
		if (instance == null) {
			if (instance == null) {
				instance = new Utils();
			}
		}
		return instance;
	}

	public void MakeToastLong(Context context, String text) {
		Toast.makeText(context, text, Toast.LENGTH_LONG).show();
	}

	public void MakeToastShort(Context context, String text) {
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}

	public void MakeProgressDialog(Context context, String titulo,
			String mensaje) {
		if (pd == null) {
			pd = new ProgressDialog(context);
			pd.setTitle(titulo);
			pd.setMessage(mensaje);
			pd.setCancelable(false);
			pd.setIndeterminate(true);
			pd.show();
		}else{
			pd.setTitle(titulo);
			pd.setMessage(mensaje);
			pd.setCancelable(false);
			pd.setIndeterminate(true);
			pd.show();
		}
	}

	public void KillProgressDialgo() {
		if (pd != null) {
			pd.cancel();
			pd = null;
		}
	}

	public void MakeAlerDialogCloseActivity(final Context context,
			String titulo, String texto, Integer icon) {
		try {
			AlertDialog.Builder al = new AlertDialog.Builder(context);
			al.setTitle(titulo);
			al.setCancelable(false);
			al.setIcon(icon);
			al.setNeutralButton("Aceptar",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							((Activity) context).finish();
						}
					});
			al.setMessage(texto);
			AlertDialog ald = al.create();
			ald.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	public boolean isExternalStorageAvailable() {

        String state = Environment.getExternalStorageState();
        boolean mExternalStorageAvailable = false;
        boolean mExternalStorageWriteable = false;

        if (Environment.MEDIA_MOUNTED.equals(state)) {
            // Podemos leer y escribir en la memoria
            mExternalStorageAvailable = mExternalStorageWriteable = true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            // We can only read the media
            mExternalStorageAvailable = true;
            mExternalStorageWriteable = false;
        } else {
            // Something else is wrong. It may be one of many other states, but
            // all we need
            // to know is we can neither read nor write
            mExternalStorageAvailable = mExternalStorageWriteable = false;
        }

        if (mExternalStorageAvailable == true
                && mExternalStorageWriteable == true) {
            return true;
        } else {
            return false;
        }
    }
}
