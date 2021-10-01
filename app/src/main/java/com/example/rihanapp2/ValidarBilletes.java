package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ValidarBilletes extends AppCompatActivity implements View.OnClickListener {
    private ImageView volverib,continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validar_billetes);

        volverib=(ImageView) findViewById(R.id.imageView72);
        volverib.setOnClickListener(this);

        continuar =(ImageView) findViewById(R.id.imageView73);
        continuar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView72: //toca Atras
                startActivity(new Intent(this, IngresarBilletes.class));
                break;
            case R.id.imageView73:  //toca PulgarArriba
                startActivity(new Intent(this, MenuPrincipal.class));
                break;


        }
    }


}