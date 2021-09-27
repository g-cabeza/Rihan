package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ValidarMonedas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validar_monedas);
    }

    //Boton Bien termina y va al Menu  Principal
    public void FinalizarCargaMonedas (View v){
        Intent PantallaFinalMenuPrincipal = new Intent(this, MenuPrincipal.class);
        startActivity(PantallaFinalMenuPrincipal );
    }

    //Boton Mal  Hecho vuelve a la pantalla de ingresar Monedas
    public void ModificarCargaMonedas (View v){
        Intent PantallaIngresarDinero2 = new Intent(this, IngresarMonedas.class);
        startActivity(PantallaIngresarDinero2);
    }






}