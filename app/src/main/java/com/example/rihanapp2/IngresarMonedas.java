package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class IngresarMonedas extends AppCompatActivity implements View.OnClickListener {
    private ImageView volverid,continuar,sumarm10,sumarm5,sumarm2,sumarm1,sumarm50,sumarm25,restarm10,restarm5,restarm2,restarm1,restarm50,restarm25;
    private TextView cantidad,cantidad5,cantidad2,cantidad1,cantidad50,cantidad25;
    private int Sumar10, Sumar5,Sumar2,Sumar1,Sumar50,Sumar25 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_monedas);

        //Singleton.getInstance().init();

        //Inicializo Cantidad

        Sumar10 = 0;
        Sumar5 = 0;
        Sumar2 = 0;
        Sumar1 = 0;
        Sumar50 = 0;
        Sumar25 = 0;


        cantidad = (TextView) findViewById(R.id.textView26);
        cantidad5 =(TextView) findViewById(R.id.textView27);
        cantidad2 = (TextView) findViewById(R.id.textView28);
        cantidad1 = (TextView) findViewById(R.id.textView30);
        cantidad50 = (TextView) findViewById(R.id.textView31);
        cantidad25 = (TextView) findViewById(R.id.textView37);

        //Inicializo atras/continuar

        volverid=(ImageView) findViewById(R.id.imageView55);
        volverid.setOnClickListener(this);

        continuar=(ImageView) findViewById(R.id.imageView56);
        continuar.setOnClickListener(this);

        //inicializo Suma de Monedas

        sumarm10=(ImageView) findViewById(R.id.imageView40);
        sumarm10.setOnClickListener(this);

        sumarm5=(ImageView) findViewById(R.id.imageView42);
        sumarm5.setOnClickListener(this);

        sumarm2=(ImageView) findViewById(R.id.imageView44);
        sumarm2.setOnClickListener(this);

        sumarm1=(ImageView) findViewById(R.id.imageView46);
        sumarm1.setOnClickListener(this);

        sumarm50=(ImageView) findViewById(R.id.imageView49);
        sumarm50.setOnClickListener(this);

        sumarm25=(ImageView) findViewById(R.id.imageView51);
        sumarm25.setOnClickListener(this);

        //inicializo Resta de Monedas
        restarm10=(ImageView) findViewById(R.id.imageView41);
        restarm10.setOnClickListener(this);

        restarm5=(ImageView) findViewById(R.id.imageView43);
        restarm5.setOnClickListener(this);

        restarm2=(ImageView) findViewById(R.id.imageView45);
        restarm2.setOnClickListener(this);

        restarm1=(ImageView) findViewById(R.id.imageView48);
        restarm1.setOnClickListener(this);

        restarm50=(ImageView) findViewById(R.id.imageView50);
        restarm50.setOnClickListener(this);

        restarm25=(ImageView) findViewById(R.id.imageView52);
        restarm25.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.imageView55: //toca Atras
                startActivity(new Intent(this, IngresarDinero1.class));
                break;
            case R.id.imageView56:  //toca PulgarArriba
                Singleton.getInstance().moneda10=Integer.parseInt(cantidad.getText().toString());
                Singleton.getInstance().moneda5=Integer.parseInt(cantidad5.getText().toString());
                Singleton.getInstance().moneda2=Integer.parseInt(cantidad2.getText().toString());
                Singleton.getInstance().moneda1=Integer.parseInt(cantidad1.getText().toString());
                Singleton.getInstance().moneda50=Integer.parseInt(cantidad50.getText().toString());
                Singleton.getInstance().moneda25=Integer.parseInt(cantidad25.getText().toString());
                startActivity(new Intent(this, ValidarMonedas.class));
                break;
            case R.id.imageView40://SUMAR 10

                cantidad.setText(String.valueOf(++Sumar10 ));
                break;
            case R.id.imageView42://SUMAR 5

                cantidad5.setText(String.valueOf(++Sumar5 ));
                break;
            case R.id.imageView44://SUMAR 2

                cantidad2.setText(String.valueOf(++Sumar2 ));
                break;
            case R.id.imageView46://SUMAR 1
                cantidad1.setText(String.valueOf(++Sumar1 ));
                break;
            case R.id.imageView49://SUMAR 50

                cantidad50.setText(String.valueOf(++Sumar50 ));
                break;
            case R.id.imageView51://SUMAR 25

                cantidad25.setText(String.valueOf(++Sumar25 ));
                break;


            case R.id.imageView41://RESTAR 10


                cantidad.setText(String.valueOf(--Sumar10 ));

                break;
            case R.id.imageView43://RESTAR 5
                cantidad5.setText(String.valueOf(--Sumar5 ));
                break;
            case R.id.imageView45://RESTAR 2
                cantidad2.setText(String.valueOf(--Sumar2 ));
                break;
            case R.id.imageView48://RESTAR 1

                cantidad1.setText(String.valueOf(--Sumar1 ));

                break;
            case R.id.imageView50://RESTAR 50
                cantidad50.setText(String.valueOf(--Sumar50 ));
                break;
            case R.id.imageView52://RESTAR 25
                cantidad25.setText(String.valueOf(--Sumar25 ));
                break;
        }
    }

    /*//Boton BienMonedas
    public void ValidarMonedas (View v){
        Intent PantallaValidarMonedasBF = new Intent(this,ValidarMonedas.class);
        startActivity(PantallaValidarMonedasBF);
    }

    //Boton AtrasMonedas
    public void IngresarMonedasAtras (View v){
        Intent PantallaIngresarMonedasAtras = new Intent(this,IngresarDinero1.class);
        startActivity(PantallaIngresarMonedasAtras);


TextView cantidad=view.findViewById(R.id.txtcantidad);
    Button aumentar=view.findViewById(R.id.btnaumntar);
    Button disminuir=view.findViewById(R.id.btndisminuir)

    aumentar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            cantidad.setText(String.valueOf(++valor));

        }
    });
    disminuir.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            cantidad.setText(String.valueOf(--valor));
        }
    });


    }*/







}