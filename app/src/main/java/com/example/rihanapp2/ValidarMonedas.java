package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ValidarMonedas extends AppCompatActivity implements View.OnClickListener {

    private  ImageView volverim,continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validar_monedas);

        volverim=(ImageView) findViewById(R.id.imageView70);
        volverim.setOnClickListener(this);

        continuar=(ImageView) findViewById(R.id.imageView71);
        continuar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView70: //toca Atras
                startActivity(new Intent(this, IngresarMonedas.class));
                break;
            case R.id.imageView71:  //toca Continuar
                startActivity(new Intent(this, MenuPrincipal.class));
                break;


        }
    }

    /*//Boton Bien termina y va al Menu  Principal
    public void FinalizarCargaMonedas (View v){
        Intent PantallaFinalMenuPrincipal = new Intent(this, MenuPrincipal.class);
        startActivity(PantallaFinalMenuPrincipal );
    }

    //Boton Mal  Hecho vuelve a la pantalla de ingresar Monedas
    public void ModificarCargaMonedas (View v){
        Intent PantallaIngresarDinero2 = new Intent(this, IngresarMonedas.class);
        startActivity(PantallaIngresarDinero2);
    }*/






}