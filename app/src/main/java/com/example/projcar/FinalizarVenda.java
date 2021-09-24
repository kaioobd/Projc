package com.example.projcar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class FinalizarVenda extends AppCompatActivity {

    ImageButton voltaMain;
    Button voltaVenda;
    TextView txtMarca,txtModelo,txtAnoMod,txtAnoFab,txtCor,txtKm,txtPreco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_finalizar_venda);

        voltaVenda=findViewById(R.id.btnVoltaVenda);
        voltaMain=findViewById(R.id.btnVoltaMain);

        txtMarca=findViewById(R.id.marcaFinalV);
        txtModelo=findViewById(R.id.modeloFinalV);
        txtAnoMod=findViewById(R.id.anoModeloFinalV);
        txtAnoFab=findViewById(R.id.anoFabFinalV);
        txtCor=findViewById(R.id.corFinalV);
        txtKm=findViewById(R.id.kmFinalV);
        txtPreco=findViewById(R.id.precoFinalV);

        Intent fn=getIntent();

        String marca=fn.getStringExtra("key_marca");
        String modelo=fn.getStringExtra("key_modelo");
        String anoMod=fn.getStringExtra("key_anoMod");
        String anoFab=fn.getStringExtra("key_anoFab");
        String cor=fn.getStringExtra("key_cor");
        String km=fn.getStringExtra("key_km");
        String preco=fn.getStringExtra("key_preco");

        txtMarca.setText(marca);
        txtModelo.setText(modelo);
        txtAnoMod.setText(anoMod);
        txtAnoFab.setText(anoFab);
        txtCor.setText(cor);
        txtKm.setText(km);
        txtPreco.setText(preco);

        voltaMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent voltaMn=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(voltaMn);
            }
        });
        voltaVenda.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent voltaMn=new Intent(getApplicationContext(),Vender.class);
                startActivity(voltaMn);
            }
        });
    }




}