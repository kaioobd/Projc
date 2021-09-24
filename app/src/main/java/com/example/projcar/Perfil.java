package com.example.projcar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Perfil extends AppCompatActivity {

    TextView txtNome,txtEmail,txtSenha,txtSexo,txtDataNasc,txtCPF,txtTel;

    Button volta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_perfil);

        volta=findViewById(R.id.btnVolta);

        txtNome=findViewById(R.id.txtNomeUso);
        txtEmail=findViewById(R.id.txtEmailUso);
        txtSenha=findViewById(R.id.txtSenhaUso);
        txtSexo=findViewById(R.id.txtSexoUso);
        txtDataNasc=findViewById(R.id.txtDataNascUso);
        txtCPF=findViewById(R.id.txtCPFUso);
        txtTel=findViewById(R.id.txtTelUso);

        Intent cd = getIntent();

        String nome = cd.getStringExtra("nome");
        String email = cd.getStringExtra("email");
        String senha = cd.getStringExtra("senha");
        String sexo = cd.getStringExtra("sexo");
        String dataNasc = cd.getStringExtra("dataNasc");
        String cpf = cd.getStringExtra("cpf");
        String tel = cd.getStringExtra("tel");

        txtNome.setText(nome);
        txtEmail.setText(email);
        txtSenha.setText(senha);
        txtSexo.setText(sexo);
        txtDataNasc.setText(dataNasc);
        txtCPF.setText(cpf);
        txtTel.setText(tel);


        volta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent voltaMn=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(voltaMn);
            }
        });
    }
}