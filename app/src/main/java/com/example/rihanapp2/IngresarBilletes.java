package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class IngresarBilletes extends AppCompatActivity implements View.OnClickListener {

    private ImageView volverid1,continuar,sumar1000,sumar500,sumar200,sumar100,sumar50,sumar20,sumar10,restar1000,restar500,restar200,restar100,restar50,restar20,restar10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_billetes);


        volverid1 = (ImageView) findViewById(R.id.imageView68);
        volverid1.setOnClickListener(this);

        continuar = (ImageView) findViewById(R.id.imageView69);
        continuar.setOnClickListener(this);

        //inicializo los de sumar
        sumar1000 =  (ImageView) findViewById(R.id.imageView47);
        sumar1000.setOnClickListener(this);

        sumar500 =  (ImageView) findViewById(R.id.imageView54);
        sumar500.setOnClickListener(this);

        sumar200 =  (ImageView) findViewById(R.id.imageView58);
        sumar200.setOnClickListener(this);

        sumar100 =  (ImageView) findViewById(R.id.imageView60);
        sumar100.setOnClickListener(this);

        sumar50 =  (ImageView) findViewById(R.id.imageView62);
        sumar50.setOnClickListener(this);

        sumar20 =  (ImageView) findViewById(R.id.imageView64);
        sumar20.setOnClickListener(this);

        sumar10 =  (ImageView) findViewById(R.id.imageView66);
        sumar10.setOnClickListener(this);

        //Inicializo los de restar

        restar1000 =  (ImageView) findViewById(R.id.imageView53);
        restar1000.setOnClickListener(this);

        restar500 =  (ImageView) findViewById(R.id.imageView57);
        restar500.setOnClickListener(this);

        restar200 =  (ImageView) findViewById(R.id.imageView59);
        restar200.setOnClickListener(this);

        restar100 =  (ImageView) findViewById(R.id.imageView61);
        restar100.setOnClickListener(this);

        restar50 =  (ImageView) findViewById(R.id.imageView63);
        restar50.setOnClickListener(this);

        restar20 =  (ImageView) findViewById(R.id.imageView65);
        restar20.setOnClickListener(this);

        restar10 =  (ImageView) findViewById(R.id.imageView67);
        restar10.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView68: //toca Atras
                startActivity(new Intent(this, IngresarDinero1.class));
                break;
            case R.id.imageView69:  //toca Pulgar Arriba
                startActivity(new Intent(this, ValidarBilletes.class));
                break;
            case R.id.imageView47:

                break;
                case R.id.imageView54:

                break;
            case R.id.imageView58:

                break;
            case R.id.imageView60:

                break;
            case R.id.imageView62:

                break;
            case R.id.imageView64:

                break;
            case R.id.imageView66:

                break;
            case R.id.imageView53:

                break;
            case R.id.imageView57:

                break;
            case R.id.imageView59:

                break;
            case R.id.imageView61:

                break;
            case R.id.imageView63:

                break;
            case R.id.imageView65:

                break;
            case R.id.imageView67:

                break;


        }
    }



}