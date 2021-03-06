package com.example.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class AccelActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager msensorManager;
    private Sensor mSensorAccel;
    private long lastUpdate = 0;
    float highestZ = 0;

    TextView mtxtView_Accel,
             mtxt_highestZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accel);

        mtxtView_Accel = findViewById(R.id.txt_accel);
        mtxt_highestZ = findViewById(R.id.txt_highest_Z);

        msensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //linear acceleration = acceleration - acceleration due to gravity
        mSensorAccel = msensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        msensorManager.registerListener(this, mSensorAccel, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        //Sensor mySensor = sensorEvent.sensor;

        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];

        if(z>highestZ){
            highestZ = z;
        }

        mtxt_highestZ.setText("Highest z: " + highestZ);
        mtxtView_Accel.setText("x: " + (int) x + " y: " + (int) y + " z: " + (int) z);
        /*if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            long curTime = System.currentTimeMillis();

            if ((curTime - lastUpdate) > 100) {
                long diffTime = (curTime - lastUpdate);
                lastUpdate = curTime;
                mtxtView_Accel.setText((int) x);
            }
        }*/


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
