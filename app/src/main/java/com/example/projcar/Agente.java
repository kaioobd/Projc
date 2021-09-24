package com.example.projcar;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Agente extends AppCompatActivity {
    private ImageView btnYtb;
    private ImageView btnCall;
    private ImageView btnSite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_agente);

        btnYtb= (ImageView) findViewById(R.id.btnYtb);
        btnCall= (ImageView) findViewById(R.id.btnNum);
        btnSite= (ImageView) findViewById(R.id.btnSite);


        btnYtb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com.br/")));
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel.123456789");
                Intent it = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(it);
            }
        });

        btnSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                String query = "Webmotors";
                intent.putExtra(SearchManager.QUERY, query);
                startActivity(intent);
            }
        });


    }
}