package com.example.dpl.locationprovider;

import android.content.Context;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView mProviders;
    LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProviders= (ListView) findViewById(R.id.provider);
        //首先获取LocationManager对象
        locationManager= (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //然后获取所有的LocationProvider名称
        List<String> providerNames=locationManager.getAllProviders();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,providerNames);
        mProviders.setAdapter(adapter);
    }
}
