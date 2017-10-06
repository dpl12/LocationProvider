package com.example.dpl.locationprovider;

import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class CriteriaLocationProvider extends AppCompatActivity {
    ListView mProviders;
    LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criteria_location_provider);
        mProviders= (ListView) findViewById(R.id.providers);
        //首先获取LocationManager对象
        locationManager= (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //创建一个LocationProvider的过滤条件
        Criteria criteria=new Criteria();
        //设置LocationProvider要求是免费的
        criteria.setCostAllowed(false);
        //设置要求LocationProvider提供海拔信息
        criteria.setAltitudeRequired(true);
        //设置要求LocationProvider提供方向信息
        criteria.setBearingRequired(true);
        List<String> providers=locationManager.getProviders(criteria,true);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,providers);
        mProviders.setAdapter(adapter1);
    }
}
