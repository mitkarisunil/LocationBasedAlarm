package com.example.mitkari.ms;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by mitkari on 11/4/2015.
 */
public class MyAlarmService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public void onCreate()
    {
        // TODO Auto-generated method stub
        super.onCreate();
    }

    //@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @SuppressWarnings("static-access")
    @Override
    public void onStart(Intent intent, int startId)
    {
        super.onStart(intent, startId);

        NotificationManager mManager = (NotificationManager) this.getApplicationContext().getSystemService(this.getApplicationContext().NOTIFICATION_SERVICE);
        Intent intent1 = new Intent(this.getApplicationContext(),MapsActivity.class);

        Notification notification = new Notification(R.drawable.location,"This is a test message!", System.currentTimeMillis());
        intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP| Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingNotificationIntent = PendingIntent.getActivity( this.getApplicationContext(),0, intent1,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
/*        notification.setLatestEventInfo(this.getApplicationContext(), "AlarmManagerDemo", "Your place came", pendingNotificationIntent);
*/
        Context context = getApplicationContext();
        Notification.Builder builder = new Notification.Builder(context);

        builder.setAutoCancel(false);
        builder.setTicker("You have Reached the Destination");
        builder.setContentTitle("Destination Came");
        builder.setContentText("You have Reached the Destination");
        builder.setSmallIcon(R.drawable.location);
        builder.setContentIntent(pendingNotificationIntent);
        builder.setOngoing(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            builder.setSubText("You Reached");   //API level 16
        }
        builder.setNumber(100);
        builder.build();






        mManager.notify(0, notification);

    }

    @Override
    public void onDestroy()
    {
        // TODO Auto-generated method stub
        super.onDestroy();
    }
}
