package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class BilleteraFisica1 extends AppCompatActivity implements View.OnClickListener {

    private ImageView pagar, ingresardinero,volvermp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billetera_fisica1);

        pagar = (ImageView) findViewById(R.id.imageView34);
        pagar.setOnClickListener(this);

        ingresardinero = (ImageView) findViewById(R.id.imageView35);
        ingresardinero.setOnClickListener(this);

        volvermp =(ImageView) findViewById(R.id.imageView36);
        volvermp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView34: //toca Pagar

                break;
            case R.id.imageView35:  //toca Ingresar Dinero
                startActivity(new Intent(this, IngresarDinero1.class));
                break;
            case R.id.imageView36:
                startActivity(new Intent(this,MenuPrincipal.class));

        }
    }

    //boton pagar

    //prueba de si github funciona o no
    //mas comentarios de prubea
    //muchos mas comentarios

    //Boton ingresar dinero
    //public void IngresarDinero(View v) {
    //    Intent SegundaPantallaBF = new Intent(this, IngresarDinero1.class);
    //    startActivity(SegundaPantallaBF);
    //}
}


