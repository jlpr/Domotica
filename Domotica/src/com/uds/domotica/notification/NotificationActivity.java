package com.uds.domotica.notification;




public class NotificationActivity {

	/*
	private int notificationID=1;
	public void displayNotification(Context context){
        Intent i = new Intent(context, LineChartActivity.class);
        i.putExtra("notificationID", notificationID);
         
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, i, 0);
 
        NotificationManager nm = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
         
        CharSequence ticker ="Sea rebasado el Limite Permitido";
        CharSequence contentTitle = "Domo";
        CharSequence contentText = "EL Limite para el dispositivo ha sido rebasado";
        Notification noti = new Notification.Builder(context)
                                .setContentIntent(pendingIntent)
                                .setTicker(ticker)
                                .setContentTitle(contentTitle)
                                .setContentText(contentText)
                                .setSmallIcon(R.drawable.ic_launcher)
                                .addAction(R.drawable.ic_launcher, ticker, pendingIntent)
                                .setVibrate(new long[] {100, 250, 100, 500})
                                .build();
        nm.notify(notificationID, noti);
    }*/
}
