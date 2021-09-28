package com.example.projcar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import com.example.projcar.Constantes.Type;

public class Ler extends Activity {

    private TextView txtTexto;
    private Type type;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ler);

        txtTexto = (TextView) findViewById(R.id.itext);
        type = (Type) getIntent().getSerializableExtra(Constantes.STORAGE_TYPE);

        try {

            if (type == Type.INTERNAL){
                LerInterno();
            }else{
                LerExterno();
            }

        } catch (IOException e) {
            Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT);
            e.printStackTrace();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void LerInterno() throws IOException {
        FileInputStream infl = openFileInput(Constantes.FILE_NAME);

        Scanner scanner = new Scanner(infl);
        try{
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                sb.append(line).append(System.lineSeparator());
            }
            txtTexto.setText(sb.toString());
        }finally{
            scanner.close();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void LerExterno() throws IOException{
        String status = Environment.getExternalStorageState();

        if (!status.equals(Environment.MEDIA_MOUNTED)){
            throw new IOException("O SD Card n�o montado ou encontrado");
        }

        File dir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        Scanner scanner = new Scanner( new File(dir, Constantes.FILE_NAME));

        try{
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                sb.append(line).append(System.lineSeparator());
            }
            txtTexto.setText(sb.toString());
        }finally{
            scanner.close();
        }
    }


}