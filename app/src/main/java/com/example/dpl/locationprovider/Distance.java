package com.example.dpl.locationprovider;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Distance extends AppCompatActivity {
    private EditText startLatitude,startLongitude,endLatitude,endLongitude,etDistance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);
        startLatitude= (EditText) findViewById(R.id.startLatitude);
        startLongitude= (EditText) findViewById(R.id.startLongitude);
        endLatitude= (EditText) findViewById(R.id.endLatitude);
        endLongitude= (EditText) findViewById(R.id.endLongitude);
        etDistance= (EditText) findViewById(R.id.etDistance);
    }
    public void click(View V){
        Double startLatitude1=Double.parseDouble(startLatitude.getText().toString().trim());
        Double startLongitude1=Double.parseDouble(startLongitude.getText().toString().trim());
        Double endLatitude1=Double.parseDouble(endLatitude.getText().toString().trim());
        Double endLongitude1=Double.parseDouble(endLongitude.getText().toString().trim());
        final float[] result=new float[3];
        Location.distanceBetween(startLatitude1,startLongitude1,endLatitude1,endLongitude1,result);
        etDistance.setText(result[0]+"米");
    }
}
