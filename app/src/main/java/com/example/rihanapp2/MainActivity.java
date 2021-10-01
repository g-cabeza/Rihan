package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView usuario,tutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario= (ImageView) findViewById(R.id.imageView);
        usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IngresaUsuario();
            }
        });

        tutor= (ImageView) findViewById(R.id.imageView2);
        tutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {IngresaTutor();}
        });

    }

    private void IngresaTutor() {
    }

    //cuando toca la imagen,va a la otra activity
    private void IngresaUsuario() {
        startActivity(new Intent(this,ConfiguracionInicial.class));
    }


}