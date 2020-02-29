package com.example.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout mlinearLayout_list;

    Button mBtnAccelerometer;
    Button mBtnLight;
    /*TextView mTxtAccel;
    TextView mThermometer;
    TextView mCompass;
    TextView mLight;
    TextView mBarometer;
    TextView mProximity; */

    SensorManager mSensorManager;

    Sensor mSensAccel;
    /*Sensor mSensTherm;
    Sensor mSensCompass;
    Sensor mSensLight;
    Sensor mSensBarom;
    Sensor mSensProx; */

    //List<Sensor> mdeviceSensors = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnAccelerometer = findViewById(R.id.btn_accelerometer);
        mBtnAccelerometer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent accelIntent = new Intent(MainActivity.this,
                        AccelActivity.class);
                startActivity(accelIntent);
            }
        });

        mBtnLight = findViewById(R.id.btn_light);
        mBtnLight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent accelIntent = new Intent(MainActivity.this,
                        LightActivity.class);
                startActivity(accelIntent);
            }
        });

        /*mlinearLayout_list = findViewById(R.id.lin_lay_txt);

        mAccelerator = findViewById(R.id.btn_accelerometer);
        mThermometer = findViewById(R.id.txt_thermometer);
        mCompass = findViewById(R.id.txt_compass);
        mLight = findViewById(R.id.txt_light);
        mBarometer = findViewById(R.id.txt_barometer);
        mProximity = findViewById(R.id.txt_proximity);

        mdeviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        initSensors(); */

    }

}
