package com.example.projcar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {
    ImageButton Compra,Venda,Favorito,Perfil;
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;
    int whip = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        Compra=findViewById(R.id.btnCompra);
        Venda=findViewById(R.id.btnVenda);
        Favorito=findViewById(R.id.btnFavoritos);
        Perfil=findViewById(R.id.btnPerfil);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if(sensor == null)
            finish();

        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float x = sensorEvent.values[0];
                float y = sensorEvent.values[1];
                float z = sensorEvent.values[2];
                System.out.println("Valor X =" + x);
                if ( x <- 5 && whip == 0) {
                    getWindow().getDecorView().setBackgroundColor(Color. BLUE);
                    whip++;

                } else if (x > 5 && whip == 1 ) {
                    whip++;
                    getWindow().getDecorView().setBackgroundColor(Color.RED);

                }

                if(whip == 2) {
                    sound();
                    whip = 0;
                }


            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy ) {

            }
        };
        Start();
        Compra.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent telaCompra=new Intent(getApplicationContext(),Comprar.class);
                startActivity(telaCompra);
            }
        });

        Venda.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent telaVenda=new Intent(getApplicationContext(),Vender.class);
                startActivity(telaVenda);
            }
        });

        Favorito.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent telaFavorito=new Intent(getApplicationContext(),Favoritos.class);
                startActivity(telaFavorito);
            }
        });

        Perfil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent telaPerfil=new Intent(getApplicationContext(),Cadastro.class);
                startActivity(telaPerfil);
            }
        });
    }
    private void sound() {
        MediaPlayer mediaPlayer = MediaPlayer.create(  this, R.raw.latigo);
        mediaPlayer.start();
    }

    private void Start(){
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void Stop(){
        sensorManager.unregisterListener(sensorEventListener);
    }


    @Override
    protected void onPause() {
        super.onPause();
        Stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Start();

    }
}










