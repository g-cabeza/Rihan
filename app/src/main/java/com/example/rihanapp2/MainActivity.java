package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //METODO BOTON USUARIO
    public void PrimerConfInicial(View v){
        Intent PrimerConfInicial = new Intent(this,ConfiguracionInicial.class);
        startActivity(PrimerConfInicial);
    }
}