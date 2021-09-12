package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BilleteraFisica1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billetera_fisica1);
    }

    //boton pagar



    //Boton ingresar dinero
    public void IngresarDinero (View v){
        Intent SegundaPantallaBF = new Intent(this,IngresarDinero1.class);
        startActivity(SegundaPantallaBF);
    }
}