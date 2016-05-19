package com.example.mitkari.ms;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.support.annotation.RequiresPermission;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.GregorianCalendar;

/**
 * Created by mitkari on 10/31/2015.
 */
public class SecActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        //   Bundle extras = getIntent().getExtras();
        String lat;
        String lang;

    //    Button stop;

        // if (extras != null) {
        //Intent intent=getIntent();
        Bundle bundle = getIntent().getExtras();
        lat = bundle.getString("lat");
        lang = bundle.getString("long");

        TextView t;
        TextView t1;
        t = (TextView) findViewById(R.id.textView);
        t.setText("Latitude : " + lat);
        t1 = (TextView) findViewById(R.id.textView2);
        t1.setText("Longittude :" + lang);
   //stop = (Button) findViewById(R.id.button2);
      /*       ringtone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.setAction(Intent.ACTION_GET_CONTENT);
                intent1.setType("audio/*");
                startActivityForResult(Intent.createChooser(intent1, "Choose Sound File"), 6);


            }
        });
*/

        //}


    }

    //@Override
   /* protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode ==RESULT_OK&&requestCode==6){
            Uri i = data.getData(); //getDATA
            String s = i.getPath(); //getPath
            File k = new File(s); //set File from path

            if(s!=null){  //(file.exists

                ContentValues values = new ContentValues();
                values.put(MediaStore.MediaColumns.DATA, k.getAbsolutePath());
                values.put(MediaStore.MediaColumns.TITLE, "ring");
                values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/mp3");
                values.put(MediaStore.MediaColumns.SIZE, k.length());
                values.put(MediaStore.Audio.Media.ARTIST, R.string.app_name);
                values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
                values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
                values.put(MediaStore.Audio.Media.IS_ALARM, true);
                values.put(MediaStore.Audio.Media.IS_MUSIC, false);

                Uri uri = MediaStore.Audio.Media.getContentUriForPath(k.getAbsolutePath());
                getContentResolver().delete(uri, MediaStore.MediaColumns.DATA + "=\"" + k.getAbsolutePath() + "\"", null);
                Uri newUri = getContentResolver().insert(uri, values);


                try {
                 //   RingtoneManager.setActualDefaultRingtoneUri(this, RingtoneManager.TYPE_RINGTONE, newUri);
                } catch (Throwable t) {

                }
            }


        }
        */
     /*   Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
        r.play();
        /*

        Uri alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        MediaPlayer mp;
        mp= MediaPlayer.create(getBaseContext(), alert);
        mp.setVolume(100, 100);
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp){
                mp.release();

               // RingtoneManager.setActualDefaultRingtoneUri(this, RingtoneManager.TYPE_RINGTONE, newUri);
            }
        });
        */

       // Context context;


 //   }
   // Button alarm;
   // Button alarm= (Button) findViewById(R.id.button);
    public void scheduleAlarm(View V){
      /*  Long time= new GregorianCalendar().getTimeInMillis()+1000;
        Intent intentAlarm= new Intent(this, AlarmReceiver.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, time, PendingIntent.getBroadcast(this, 1, intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT));
        Toast.makeText(this, "Alarm Scheduled", Toast.LENGTH_LONG).show();

        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
        r.play();
        Vibrator vibrator;

        vibrator = (Vibrator) getSystemService (VIBRATOR_SERVICE);
        vibrator.vibrate(400);
    */
        startService(new Intent(getApplicationContext(),Repeat.class));
        Toast.makeText(this, "Alarm Scheduled....", Toast.LENGTH_SHORT).show();
        //
    }


    public void stopAlarm(View view){
        stopService(new Intent(getApplicationContext(),Repeat.class));


    }




  // alarm.setOnClickListener(scheduleAlarm());
   // RequiresPermission.Read more: http://www.javaexperience.com/how-to-set-alarm-in-android-application-with-code-example/#ixzz3qLHx7ca8


}