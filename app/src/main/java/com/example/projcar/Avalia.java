package com.example.projcar;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Avalia extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avalia);
    }

    public void fGravarInterna(View view) {
        Intent it = new Intent(this, Gravar.class);
        it.putExtra(Constantes.STORAGE_TYPE, Constantes.Type.INTERNAL);
        startActivity(it);
    }


    public void fLerInterna(View view) {
        Intent it = new Intent(this, Ler.class);
        it.putExtra(Constantes.STORAGE_TYPE, Constantes.Type.INTERNAL);
        startActivity(it);

    }


    public void fGravarExterna(View view) {
        Intent it = new Intent(this, Gravar.class);
        it.putExtra(Constantes.STORAGE_TYPE, Constantes.Type.EXTERNAL);
        startActivity(it);

    }


    public void fLerExterna(View view) {
        Intent it = new Intent(this, Ler.class);
        it.putExtra(Constantes.STORAGE_TYPE, Constantes.Type.EXTERNAL);
        startActivity(it);

    }

}