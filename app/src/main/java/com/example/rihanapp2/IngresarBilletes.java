package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class IngresarBilletes extends AppCompatActivity implements View.OnClickListener {

    private ImageView volverid1, continuar, sumar1000, sumar500, sumar200, sumar100, sumar50, sumar20, sumar10, restar1000, restar500, restar200, restar100, restar50, restar20, restar10;
    private TextView cantidad1000, cantidad500, cantidad200, cantidad100, cantidad50, cantidad20, cantidad10;
    private int Sumar1000, Sumar500, Sumar200, Sumar100, Sumar50, Sumar20, Sumar10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_billetes);

        Singleton.getInstance().init();

        //Inicializo Cantidad
        Sumar1000 = 0;
        Sumar500 = 0;
        Sumar200 = 0;
        Sumar100 = 0;
        Sumar50 = 0;
        Sumar20 = 0;
        Sumar10 = 0;

        cantidad1000 = (TextView) findViewById(R.id.textView);
        cantidad500 = (TextView) findViewById(R.id.textView11);
        cantidad200 = (TextView) findViewById(R.id.textView21);
        cantidad100 = (TextView) findViewById(R.id.textView22);
        cantidad50 = (TextView) findViewById(R.id.textView23);
        cantidad20 = (TextView) findViewById(R.id.textView24);
        cantidad10 = (TextView) findViewById(R.id.textView25);


        volverid1 = (ImageView) findViewById(R.id.imageView68);
        volverid1.setOnClickListener(this);

        continuar = (ImageView) findViewById(R.id.imageView69);
        continuar.setOnClickListener(this);

        //inicializo los de sumar
        sumar1000 = (ImageView) findViewById(R.id.imageView47);
        sumar1000.setOnClickListener(this);

        sumar500 = (ImageView) findViewById(R.id.imageView54);
        sumar500.setOnClickListener(this);

        sumar200 = (ImageView) findViewById(R.id.imageView58);
        sumar200.setOnClickListener(this);

        sumar100 = (ImageView) findViewById(R.id.imageView60);
        sumar100.setOnClickListener(this);

        sumar50 = (ImageView) findViewById(R.id.imageView62);
        sumar50.setOnClickListener(this);

        sumar20 = (ImageView) findViewById(R.id.imageView64);
        sumar20.setOnClickListener(this);

        sumar10 = (ImageView) findViewById(R.id.imageView66);
        sumar10.setOnClickListener(this);

        //Inicializo los de restar

        restar1000 = (ImageView) findViewById(R.id.imageView53);
        restar1000.setOnClickListener(this);

        restar500 = (ImageView) findViewById(R.id.imageView57);
        restar500.setOnClickListener(this);

        restar200 = (ImageView) findViewById(R.id.imageView59);
        restar200.setOnClickListener(this);

        restar100 = (ImageView) findViewById(R.id.imageView61);
        restar100.setOnClickListener(this);

        restar50 = (ImageView) findViewById(R.id.imageView63);
        restar50.setOnClickListener(this);

        restar20 = (ImageView) findViewById(R.id.imageView65);
        restar20.setOnClickListener(this);

        restar10 = (ImageView) findViewById(R.id.imageView67);
        restar10.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView68: //toca Atras
                startActivity(new Intent(this, IngresarDinero1.class));
                break;
            case R.id.imageView69:  //toca Pulgar Arriba

                Singleton.getInstance().billete1000 = Integer.parseInt(cantidad1000.getText().toString());
                Singleton.getInstance().billete500 = Integer.parseInt(cantidad500.getText().toString());
                Singleton.getInstance().billete200 = Integer.parseInt(cantidad200.getText().toString());
                Singleton.getInstance().billete100 = Integer.parseInt(cantidad100.getText().toString());
                Singleton.getInstance().billete50 = Integer.parseInt(cantidad50.getText().toString());
                Singleton.getInstance().billete20 = Integer.parseInt(cantidad20.getText().toString());
                Singleton.getInstance().billete10 = Integer.parseInt(cantidad10.getText().toString());

                startActivity(new Intent(this, ValidarBilletes.class));
                break;
            case R.id.imageView47: //Sumar 1000
                cantidad1000.setText(String.valueOf(++Sumar1000));
                break;
            case R.id.imageView54://Sumar 500
                cantidad500.setText(String.valueOf(++Sumar500));
                break;
            case R.id.imageView58://Sumar 200
                cantidad200.setText(String.valueOf(++Sumar200));
                break;
            case R.id.imageView60://Sumar 100
                cantidad100.setText(String.valueOf(++Sumar100));
                break;
            case R.id.imageView62://Sumar 50
                cantidad50.setText(String.valueOf(++Sumar50));
                break;
            case R.id.imageView64://Sumar 20
                cantidad20.setText(String.valueOf(++Sumar20));
                break;
            case R.id.imageView66://Sumar 10
                cantidad10.setText(String.valueOf(++Sumar10));
                break;

            //Restas

            case R.id.imageView53://Restar 1000
                if (Sumar1000 > 0) {
                    cantidad1000.setText(String.valueOf(--Sumar1000));
                }

                break;
            case R.id.imageView57://Restar 500

                if (Sumar500 > 0) {
                    cantidad500.setText(String.valueOf(--Sumar500));
                }

                break;
            case R.id.imageView59://Restar 200

                if (Sumar200 > 0) {
                    cantidad200.setText(String.valueOf(--Sumar200));
                }

                break;
            case R.id.imageView61://Restar 100

                if (Sumar100 > 0) {
                    cantidad100.setText(String.valueOf(--Sumar100));
                }

                break;
            case R.id.imageView63://Restar 50

                if (Sumar50 > 0) {
                    cantidad50.setText(String.valueOf(--Sumar50));
                }

                break;
            case R.id.imageView65://Restar 20

                if (Sumar20 > 0) {
                    cantidad20.setText(String.valueOf(--Sumar20));
                }

                break;
            case R.id.imageView67://Restar 10

                if (Sumar10 > 0) {
                    cantidad10.setText(String.valueOf(--Sumar10));
                }

                break;


        }
    }
}

