
package com.example.mitkari.ms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

/**
 * Created by mitkari on 11/2/2015.
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        /*
        // TODO Auto-generated method stub
        String phoneNumberReciver="9989397740";
        String message="Hi I will be there later, See You Soon";
        SmsManager sms= SmsManager.getDefault();
        sms.sendTextMessage(phoneNumberReciver, null, message, null, null);
        Toast.makeText(context, "Alarm Triggered and SMS Sent", Toast.LENGTH_LONG).show();
    */
        Intent service1 = new Intent(context, MyAlarmService.class);
        context.startService(service1);
    }



  //  Read more: http://www.javaexperience.com/how-to-set-alarm-in-android-application-with-code-example/#ixzz3qLIauoq5
}
