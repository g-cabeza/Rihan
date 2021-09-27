package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ValidarBilletes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validar_billetes);
    }

    //Boton Bien  Hecho
    public void FinalizarCargaBilletes (View v){
        Intent PantallaFinalMenuPrincipal = new Intent(this, MenuPrincipal.class);
        startActivity(PantallaFinalMenuPrincipal );
    }

    //Boton Mal  Hecho vuelve a la pantalla de ingresar dinero
    public void ModificarCargaBilletes (View v){
        Intent PantallaIngresarDinero2 = new Intent(this, IngresarBilletes.class);
        startActivity(PantallaIngresarDinero2);
    }

}