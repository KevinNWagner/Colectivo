package com.example.kevin.colectivo;

import android.content.Intent;
import android.content.res.Resources;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    int prog=0;
    public static Resources resources;

    double data[][] ={{-58.50479664982050	,-31.6239727448884}
    ,{-58.50462852065230	,-31.6241376722635
    },{-58.50434248123210	,-31.6243955164478
    },{-58.50412343700280	,-31.6245604888225
    },{-58.50390214736420	,-31.6247451787814
    },{-58.50372754639970	,-31.6249238349924
    },{-58.50349602131020	,-31.6250886704507
    },{-58.50326141277520	,-31.6252828997511
    },{-58.50307778410290	,-31.6254317788914
    },{-58.50283462340640	,-31.6256502894842
    },{-58.50255983625010	,-31.6258913973770
    },{-58.50235170146850	,-31.6261032531949
    },{-58.50216214700420	,-31.6262473815949
    },{-58.50191201817350	,-31.6260255995429
    },{-58.50162705270740	,-31.6258010380980
    },{-58.50142704292510	,-31.6255976386731
    },{-58.50129859853560	,-31.6254887799054
    },{-58.50140970394030	,-31.6253188995735
    },{-58.50166688121990	,-31.6250910499539
    },{-58.50191024559970	,-31.6248822986035
    },{-58.50212414244340	,-31.6247310890239
    },{-58.50207156079920	,-31.6245690522935
    },{-58.50187963193630	,-31.6244061204051
    },{-58.50164468488520	,-31.6242102247089
    },{-58.50143697914020	,-31.6240854745369
    },{-58.50132050755530	,-31.6239776960437
    },{-58.50137553391380	,-31.6238381904947
    },{-58.50164921931680	,-31.6236061728786
    },{-58.50191290139890	,-31.6233644088183
    },{-58.50225613339400	,-31.6230850713454
    },{-58.50251748300420	,-31.6228628292073
    },{-58.50278933080400	,-31.6226507788517
    },{-58.50303599923040	,-31.6224576184250
    },{-58.50313331517480	,-31.6224703951015
    },{-58.50330096166360	,-31.6226420086759
    },{-58.50358779489040	,-31.6228922395408
    },{-58.50387655762230	,-31.6231770021724
    },{-58.50412215926890	,-31.6233742313669
    },{-58.50431294722980	,-31.6235378926455
    },{-58.50455090596070	,-31.6237403216390}};


    private LocationManager locationManager;
    private LocationListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this,LoginMainActivity.class);
        startActivity(intent);
        /*
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);


        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                //t.append("\n " + location.getLongitude() + " " + location.getLatitude());
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);
            }
        };
            */
        //callAsynchronousTask();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 10:
                //configure_button();
                break;
            default:
                break;
        }
    }



    public void callAsynchronousTask() {
        final Handler handler = new Handler();
        Timer timer = new Timer();
        TimerTask doAsynchronousTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        if(prog<40)
                            prog++;
                        else
                            prog=0;

                        try {
                            final sendPosition send = new sendPosition();
                            try {
                                send.execute(Double.toString(data[prog][0]),Double.toString(data[prog][1])).get();
                                Log.d("Probando",Double.toString(data[prog][0])+Double.toString(data[prog][1]));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                        }
                    }
                });
            }
        };
        timer.schedule(doAsynchronousTask, 0, 5000); //execute in every 50000 ms
    }





}
