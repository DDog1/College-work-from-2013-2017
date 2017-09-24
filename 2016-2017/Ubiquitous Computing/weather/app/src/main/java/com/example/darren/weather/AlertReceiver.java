package com.example.darren.weather;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
/**
 * Created by darren on 11/12/2016.
 */

public class AlertReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean rainFound=false;

        //new display.DownloadJSONTask().execute().get();

        creatNotification(context,"Rain Alert","Please cheek forecast","Alert",true);

    }

    public void creatNotification(Context context, String msg, String msgText, String msgAlert,boolean rainFound){
        if (rainFound) {
            Log.e("TEST","I GOT TO THE ALARM");
            PendingIntent notification = PendingIntent.getActivity(context, 0,
                    new Intent(context, display.class), 0);

            NotificationCompat.Builder mBulider = new NotificationCompat.Builder(context)
                    .setSmallIcon(R.mipmap.rain)
                    .setContentTitle(msg)
                    .setTicker(msgAlert)
                    .setContentText(msgText);

            mBulider.setContentIntent(notification);
            mBulider.setDefaults(NotificationCompat.DEFAULT_SOUND);
            mBulider.setAutoCancel(true);

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(1, mBulider.build());
        }
    }
}
