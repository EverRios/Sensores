package com.example.everardo.sensores;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends ActionBarActivity implements SensorEventListener {
// DECLARACION DE LAS VARIABLES...
    private TextView lista, val1, val2, val3, val4, val5, val6, val7, val8, val9, val10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/// SE LANZAN LOS TEXTVIEW

        lista = (TextView) findViewById(R.id.lista);
        val1 = (TextView) findViewById(R.id.val1);
        val2 = (TextView) findViewById(R.id.val2);
        val3 = (TextView) findViewById(R.id.val3);
        val4 = (TextView) findViewById(R.id.val4);
        val5 = (TextView) findViewById(R.id.val5);
        val6 = (TextView) findViewById(R.id.val6);
        val7 = (TextView) findViewById(R.id.val7);
        val8 = (TextView) findViewById(R.id.val8);
        val9 = (TextView) findViewById(R.id.val9);
        val10 = (TextView) findViewById(R.id.val10);



        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (Sensor sensor : listaSensores) {
            log(sensor.getName());
        }
    }
/// Metodo para iniciar unicamente el Sensor de TYPE_MAGNETIC_FIELD
    public void iniciar_manegtic() {

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);
        listaSensores = sensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);

        if (!listaSensores.isEmpty()) {
            Sensor magneticSensor = listaSensores.get(0);
            sensorManager.registerListener(this, magneticSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    /// Metodo para iniciar unicamente el Sensor de TYPE_ACCELEROMETER
    public void iniciar_ACCELEROMETER() {

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);
        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        if (!listaSensores.isEmpty()) {
            Sensor acelerometerSensor = listaSensores.get(0);
            sensorManager.registerListener(this, acelerometerSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    /// Metodo para iniciar uncamente el Sensor de TYPE_GYRODCOPE
    public void iniciar_GIROSCOPIO (){
        SensorManager sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        List<Sensor>listaSensores=sensorManager.getSensorList(Sensor.TYPE_ALL);
        listaSensores=sensorManager.getSensorList(Sensor.TYPE_GYROSCOPE);

        if(!listaSensores.isEmpty()){
        Sensor giroscopioSensor=listaSensores.get(0);
        sensorManager.registerListener(this,giroscopioSensor,
        SensorManager.SENSOR_DELAY_UI);
        }
        }
    /// Metodo para iniciar uncamente el Sensor de TYPE_PROXIMITY
public  void  iniciar_proximidad() {
    SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

    List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);
    listaSensores = sensorManager.getSensorList(Sensor.TYPE_PROXIMITY);
    if (!listaSensores.isEmpty()) {
        Sensor proximitySensor = listaSensores.get(0);
        sensorManager.registerListener(this, proximitySensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }
}
/// METODO PARA INICIAR LOS EVENTOS DE TODOS LOS SENSORES
    public void iniciar(View v) {
        lista.setText("");
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (Sensor sensor : listaSensores) {
            log(sensor.getName());
        }
        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        if (!listaSensores.isEmpty()) {
            Sensor acelerometerSensor = listaSensores.get(0);
            sensorManager.registerListener(this, acelerometerSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_PROXIMITY);

        if (!listaSensores.isEmpty()) {
            Sensor proximitySensor = listaSensores.get(0);
            sensorManager.registerListener(this, proximitySensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        listaSensores = sensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);

        if (!listaSensores.isEmpty()) {
            Sensor magneticSensor = listaSensores.get(0);
            sensorManager.registerListener(this, magneticSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_GYROSCOPE);

        if (!listaSensores.isEmpty()) {
            Sensor giroscopioSensor = listaSensores.get(0);
            sensorManager.registerListener(this, giroscopioSensor,
                    SensorManager.SENSOR_DELAY_UI);
        }


        listaSensores = sensorManager.getSensorList(Sensor.TYPE_GRAVITY);

        if (!listaSensores.isEmpty()) {
            Sensor gravedadSensor = listaSensores.get(0);
            sensorManager.registerListener(this, gravedadSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_TEMPERATURE);

        if (!listaSensores.isEmpty()) {
            Sensor temperatureSensor = listaSensores.get(0);
            sensorManager.registerListener(this, temperatureSensor,
                   SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    // METODO PARA OBTENER LOS VALORES DE CADA UNO DE LOS SENSORES
    public void onSensorChanged(SensorEvent event) {
        synchronized (this) {
            switch (event.sensor.getType()) {
                case Sensor.TYPE_ORIENTATION:
                    break;
                case Sensor.TYPE_ACCELEROMETER:
                    val1.setText("Aceler\u00f3metro X: " + event.values[0]);
                    val2.setText("Aceler\u00f3metro Y: " + event.values[1]);
                    val3.setText("Aceler\u00f3metro Z: " + event.values[2]);
                    break;
                case Sensor.TYPE_GYROSCOPE:
                    val4.setText("Eje X: " + event.values[0]);
                    val5.setText("Eje Y: " + event.values[1]);
                    val6.setText("Eje Z: " + event.values[2]);
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    val7.setText("Eje X: " + event.values[0]);
                    val8.setText("Eje Y: " + event.values[1]);
                    val9.setText("Eje Z: " + event.values[2]);
                    break;
                case Sensor.TYPE_PROXIMITY:
                    val10.setText("Proximidad: " + event.values[0]);
                    break;
                case Sensor.TYPE_LIGHT:
                    break;
                case Sensor.TYPE_GRAVITY:
                    break;
                default:


            }
        }
    }

    private void log(String string) {
        lista.append(string + "\n");
    }

    //METODO PARA PAUSAR EL PROCESO
    @Override
    protected void onPause() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.unregisterListener(this);
        super.onPause();
    }
    /////METODO PARA REINICIRA EL PROCESOS DE TODOS LOS SENSORES.
    @Override
    protected void onRestart() {
        super.onRestart();
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ORIENTATION);

        if (!listaSensores.isEmpty()) {
            Sensor orientationSensor = listaSensores.get(0);
            sensorManager.registerListener(this, orientationSensor,
                    SensorManager.SENSOR_DELAY_UI);
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        if (!listaSensores.isEmpty()) {
            Sensor acelerometerSensor = listaSensores.get(0);
            sensorManager.registerListener(this, acelerometerSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_PROXIMITY);

        if (!listaSensores.isEmpty()) {
            Sensor proximitySensor = listaSensores.get(0);
            sensorManager.registerListener(this, proximitySensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }


        listaSensores = sensorManager.getSensorList(Sensor.TYPE_GYROSCOPE);

        if (!listaSensores.isEmpty()) {
            Sensor giroscopioSensor = listaSensores.get(0);
            sensorManager.registerListener(this, giroscopioSensor,
                    SensorManager.SENSOR_DELAY_UI);
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);

        if (!listaSensores.isEmpty()) {
            Sensor magneticSensor = listaSensores.get(0);
            sensorManager.registerListener(this, magneticSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_LIGHT);

        if (!listaSensores.isEmpty()) {
            Sensor luzSensor = listaSensores.get(0);
            sensorManager.registerListener(this, luzSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_GRAVITY);

        if (!listaSensores.isEmpty()) {
            Sensor gravedadSensor = listaSensores.get(0);
            sensorManager.registerListener(this, gravedadSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_TEMPERATURE);

        if (!listaSensores.isEmpty()) {
            Sensor temperatureSensor = listaSensores.get(0);
            sensorManager.registerListener(this, temperatureSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    ///// METODO PARA TERMINAR EL PROCESO.
    public void detener(View v) {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.unregisterListener(this);
        super.onStop();
    }
    ///// METODO PARA DESTRUIR EL PROCESOS.
    @Override
    protected void onDestroy() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.unregisterListener(this);
        super.onDestroy();
    }
/// METODO PARA SALIR DE LA APLICACION
    public void salir(View v) {
        finish();
    }
    // METODO PARA LIMPIAR LOS VALORES DE LOS SENSORES
    public void limpiar(View v) {
        val1.setText("");
        val2.setText("");
        val3.setText("");
        val4.setText("");
        val5.setText("");
        val6.setText("");
        val7.setText("");
        val8.setText("");
        val9.setText("");
        val10.setText("");


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //METODO PARA LA FUNCIONALIDAD DE LOS MENUS.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {

            case R.id.Sensor_magnetic:
                iniciar_manegtic();
                return true;
            case R.id.ACELEROMETER:
                iniciar_ACCELEROMETER();
                return true;
            case R.id.Giroscope:
                iniciar_GIROSCOPIO();
                return true;
            case R.id.PROXIMITY:
                iniciar_proximidad();
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }
    }
}