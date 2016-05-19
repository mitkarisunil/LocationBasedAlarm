package com.example.mitkari.ms;

import android.app.Service;
import android.content.Intent;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import static java.lang.Long.valueOf;

/**
 * Created by mitkari on 11/4/2015.
 */
public class Repeat extends Service {
   // private boolean isRunning  = false;
    private static final String TAG = "HelloService";

public  void onCreate() {
    super.onCreate();
    // startService();
    // isRunning=true;
    Toast.makeText(getApplicationContext(), "OnCreate", Toast.LENGTH_SHORT).show();
    Log.i(TAG, "Service onCreate");
//onStartCommand(getApplicationContext(),Toast.makeText(getApplicationContext(),"start..",Toast.LENGTH_SHORT).show(),)
//    t.scheduleAtFixedRate(new Repeat.mainTask(), 0, 1000);


    Timer t;


//    public int onStartCommand (Intent intent, int flags, int startId){
    String dlat = new Bundle().getString("lat");
    String dlang = new Bundle().getString("lang");
    try {
        // final double clat = Double.parseDouble(dlat);
        //final double clang = Double.parseDouble(dlang);
        final double clat = valueOf(dlat);
        final double clang = valueOf(dlang);


        //{
        t = new Timer();
        class mainTask extends TimerTask {

            public void run() {
                Toast.makeText(getApplicationContext(), "Run............", Toast.LENGTH_SHORT).show();
                LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
                Criteria criteria = new Criteria();
                criteria.setAccuracy(Criteria.ACCURACY_FINE);


                LocationListener locationListener = new LocationListener() {

                    @Override
                    public void onLocationChanged(Location location) {
                        // showCurrentLocation(location);
                        double latitude = location.getLatitude();
                        double langitude = location.getLongitude();

                        float[] dist = new float[1];

                        Location.distanceBetween(latitude, langitude, clat, clang, dist);
                        System.out.print(latitude + "  " + langitude + " " + clat + " " + clang + " ");
                        Toast.makeText(getApplicationContext(), Float.toString(dist[0]), Toast.LENGTH_LONG).show();
                        if (dist[0] < 5000) {
                            //  SecActivity.
                            Toast.makeText(getApplicationContext(), Float.toString(dist[0]), Toast.LENGTH_LONG).show();
                            Repeat.this.playAudio();


                            Vibrator vibrator;
//t.cancel();
                            vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                            vibrator.vibrate(400);
                            new Timer().cancel();
                        }


                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {

                    }

                    @Override
                    public void onProviderEnabled(String provider) {

                    }

                    @Override
                    public void onProviderDisabled(String provider) {

                    }






      /*  mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).snippet("Hello World!")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_media_play))
                .flat(true)
                .title("I'm here!"));
                */

                };
            }
        }
        // super.onCreate(savedInstanceState);

        // class repeated {

        // repeated() {
        //           t.schedule(new mainTask(), 1000);
        // }
        //  }

        //  }
//        mainTask m = new mainTask();
//        t.scheduleAtFixedRate(m, 0, 10 * 1000);
//        //m.start();
       TimerTask timerTask = new mainTask();
        //running timer task as daemon thread
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    } catch (NumberFormatException e) {
        e.printStackTrace();

    }

}

     //   return START_STICKY;
   // }

    public void playAudio() {
        Intent objIntent = new Intent(getApplicationContext(), PlayAudio.class);
        startService(objIntent);
    }

    public void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this, "Service Stopped ...", Toast.LENGTH_SHORT).show();
    }
   // @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;

    }




}
