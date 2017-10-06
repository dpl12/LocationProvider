package com.example.dpl.locationprovider;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.widget.TextView;

public class LocationActivity extends Activity {
    private LocationManager locationManager;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        textView = (TextView) findViewById(R.id.show);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //从GPS获取最近的定位信息
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        updateView(location);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 8, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                //当GPS定位信息发生改变时，更新位置
                updateView(location);
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {
                //当GPS LocationProvider可用时，更新位置
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                updateView(locationManager.getLastKnownLocation(s));
            }

            @Override
            public void onProviderDisabled(String s) {

            }
        });//两秒或8米都会更新位置信息
    }
    //用来更新EditText信息
    public void updateView(Location location){
        if (location!=null){
            StringBuilder stringBuilder=new StringBuilder();
            stringBuilder.append("实时的位置信息：\n");
            stringBuilder.append("经度：");
            stringBuilder.append(location.getLongitude());
            stringBuilder.append("\n纬度：");
            stringBuilder.append(location.getLatitude());
            stringBuilder.append("\n海拔：");
            stringBuilder.append(location.getAltitude());
            stringBuilder.append("\n速度：");
            stringBuilder.append(location.getSpeed());
            stringBuilder.append("\n方向：");
            stringBuilder.append(location.getBearing());
            textView.setText(stringBuilder.toString());
        }
    }
}
