package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IngresarDinero1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_dinero1);
    }

    //Boton Billetes  Hecho
    public void IngresarBilletes (View v){
        Intent PantallaCargarBilletesBF = new Intent(this,IngresarBilletes.class);
        startActivity(PantallaCargarBilletesBF);
    }

    //Boton Atras
    public void AtrasBF (View v){
        Intent PantallaBilleteraFisica1Atras = new Intent(this,BilleteraFisica1.class);
        startActivity(PantallaBilleteraFisica1Atras);
    }

    //Boton Monedas  Hecho
    public void IngresarMonedas (View v){
        Intent PantallaCargarMonedasBF = new Intent(this,IngresarMonedas.class);
        startActivity(PantallaCargarMonedasBF);
    }
}