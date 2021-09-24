package com.example.projcar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Favoritos extends AppCompatActivity {

    ImageButton volta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_favoritos);

        volta=findViewById(R.id.btnVoltaFav);

        volta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent voltar=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(voltar);

            }

        });
    }
}