package com.example.projcar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import com.example.projcar.Constantes.Type;

public class Gravar extends AppCompatActivity {

    private Type type;
    private EditText edTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravar);

        edTexto = (EditText) findViewById(R.id.terraria);
        type = (Type) getIntent().getSerializableExtra(Constantes.STORAGE_TYPE);

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void fSalvarTexto(View view) {

        String text = edTexto.getText().toString();
        String path;

        try {
            if (type == Type.INTERNAL) {
                path = salvarInterno(text);
            } else {
                path = salvarExterno(text);
            }

            Toast.makeText(this, "Arquivo gravado em" + path,Toast.LENGTH_SHORT).show();
            finish();
        } catch (IOException e) {
            Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }

    private String salvarInterno(String text) throws IOException {


        FileOutputStream out = openFileOutput(Constantes.FILE_NAME,    MODE_PRIVATE);
        PrintWriter pw = new PrintWriter(out);

        try {
            pw.print(text);
            return getFilesDir().getPath() + File.separator
                    + Constantes.FILE_NAME;
        } finally {
            pw.close();
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private String salvarExterno(String text) throws IOException {

        String status = Environment.getExternalStorageState();


        if( !status.equals(Environment.MEDIA_MOUNTED)){
            throw new IOException("O SD Card n�o montado ou n�o dispon�vel!!!");
        }

        File dir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(dir, Constantes.FILE_NAME);
        PrintWriter pw = new PrintWriter(file);

        try{
            pw.print(text);
            return file.getPath();
        }finally {
            pw.close();
        }


    }

}