package com.example.darren.weather;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Calendar;

public class MyService extends IntentService {

    public MyService() {
        super("MyService");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.e("TEST","I GOT TO THE SERVICE");
        setAlarm();

    }


    public void setAlarm(){
        //Long alertTime = new GregorianCalendar().getTimeInMillis()+5*1000;
        Calendar calendar = Calendar.getInstance();

        //calendar.set(Calendar.HOUR_OF_DAY, 13); // For 1 PM
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 20);

        Intent alarmIntent = new Intent (this,AlertReceiver.class);
        AlarmManager alarmManager = (AlarmManager)
                getSystemService(Context.ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                PendingIntent.getBroadcast(this,1,alarmIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT));
    }
}
