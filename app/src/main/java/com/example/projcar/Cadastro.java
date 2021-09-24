package com.example.projcar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Cadastro extends AppCompatActivity {

    Button volta,cad;
    EditText nome,email,senha,sexo,dataNasc,cpf,tel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cadastro);

        volta=findViewById(R.id.btnVoltaC);
        cad=findViewById(R.id.btnCadC);

        nome=findViewById(R.id.edtTxtNomeC);
        email=findViewById(R.id.edtTxtEmailC);
        senha=findViewById(R.id.edtTxtSenhaC);
        sexo=findViewById(R.id.edtTxtSexoC);
        dataNasc=findViewById(R.id.edtTxtDataNascC);
        cpf=findViewById(R.id.edtTxtCPFC);
        tel=findViewById(R.id.edtTxtTelC);

        volta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent voltaMn=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(voltaMn);
            }
        });

        cad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent cd=new Intent(getApplicationContext(),Perfil.class);

                cd.putExtra("nome",nome.getText().toString());
                cd.putExtra("email",email.getText().toString());
                cd.putExtra("senha",senha.getText().toString());
                cd.putExtra("sexo",sexo.getText().toString());
                cd.putExtra("dataNasc",dataNasc.getText().toString());
                cd.putExtra("cpf",cpf.getText().toString());
                cd.putExtra("tel",tel.getText().toString());

                startActivity(cd);
            }
        });
    }


}