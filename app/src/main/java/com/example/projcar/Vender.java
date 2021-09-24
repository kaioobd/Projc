 package com.example.projcar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Vender extends AppCompatActivity {

    Button voltar,finalizar;
    EditText marca,modelo,anoMod,anoFab,cor,km,preco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_vender);

        voltar=findViewById(R.id.btnVoltaV);
        finalizar=findViewById(R.id.btnFinalV);

        marca=findViewById(R.id.edtTxtMarcaV);
        modelo=findViewById(R.id.edtTxtModeloV);
        anoMod=findViewById(R.id.edtTxtAnoModV);
        anoFab=findViewById(R.id.edtTxtAnoFabV);
        cor=findViewById(R.id.edtTxtCorV);
        km=findViewById(R.id.edtTxtKmV);
        preco=findViewById(R.id.edtTxtPreçoV);


        voltar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent voltaMn=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(voltaMn);
            }
        });

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent fn=new Intent(getApplicationContext(),FinalizarVenda.class);

                fn.putExtra("key_marca",marca.getText().toString());
                fn.putExtra("key_modelo",modelo.getText().toString());
                fn.putExtra("key_anoMod",anoMod.getText().toString());
                fn.putExtra("key_anoFab",anoFab.getText().toString());
                fn.putExtra("key_cor",cor.getText().toString());
                fn.putExtra("key_km",km.getText().toString());
                fn.putExtra("key_preco",preco.getText().toString());

                startActivity(fn);
            }
        });

    }
}