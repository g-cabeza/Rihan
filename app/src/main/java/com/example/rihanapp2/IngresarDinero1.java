package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class IngresarDinero1 extends AppCompatActivity implements View.OnClickListener {

    private ImageView monedas,billetes,volverbf1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_dinero1);

        monedas = (ImageView) findViewById(R.id.imageView37);
        monedas.setOnClickListener(this);

        billetes =(ImageView)  findViewById(R.id.imageView38);
        billetes.setOnClickListener(this);

        volverbf1 =(ImageView) findViewById(R.id.imageView39);
        volverbf1.setOnClickListener(this);

    }

    /*//Boton Billetes  Hecho
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
    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView37: //toca Monedas
                startActivity(new Intent(this, IngresarMonedas.class));
                break;
            case R.id.imageView38:  //toca Billetes
                startActivity(new Intent(this, IngresarBilletes.class));
                break;
            case R.id.imageView39:
                startActivity(new Intent(this, BilleteraFisica1.class));
                break;

        }
    }
}