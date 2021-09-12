package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IngresarMonedas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_monedas);
    }

    //Boton BienMonedas
    public void ValidarMonedas (View v){
        Intent PantallaValidarMonedasBF = new Intent(this,ValidarMonedas.class);
        startActivity(PantallaValidarMonedasBF);
    }

    //Boton AtrasMonedas
    public void IngresarMonedasAtras (View v){
        Intent PantallaIngresarMonedasAtras = new Intent(this,IngresarDinero1.class);
        startActivity(PantallaIngresarMonedasAtras);
    }







}