package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IngresarBilletes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_billetes);
    }

    //Boton Bien
    public void ValidarBilletes (View v){
        Intent PantallaValidarBilletesBF = new Intent(this,ValidarBilletes.class);
        startActivity(PantallaValidarBilletesBF);
    }

    //Boton Atras
    public void IngresarDineroAtras (View v){
        Intent PantallaIngresarDineroAtras = new Intent(this,IngresarDinero1.class);
        startActivity(PantallaIngresarDineroAtras);
    }

}