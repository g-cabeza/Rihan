package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class ValidarMonedas extends AppCompatActivity implements View.OnClickListener {

    private  ImageView volverim,continuar;
    private  ImageView Mon10,Mon5,Mon2,Mon1,Mon50,Mon25;
    private EditText Moneda10,Moneda5,Moneda2,Moneda1,Moneda50,Moneda25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validar_monedas);

        volverim=(ImageView) findViewById(R.id.imageView70);
        volverim.setOnClickListener(this);

        continuar=(ImageView) findViewById(R.id.imageView71);
        continuar.setOnClickListener(this);


        Mon10 = (ImageView) findViewById(R.id.imageView16);
        Mon5 = (ImageView) findViewById(R.id.imageView17);
        Mon2 = (ImageView) findViewById(R.id.imageView18);
        Mon1 = (ImageView) findViewById(R.id.imageView19);
        Mon50 = (ImageView) findViewById(R.id.imageView20);
        Mon25 = (ImageView) findViewById(R.id.imageView21);

        Moneda10=(EditText) findViewById(R.id.editTextTextPersonName16);
        Moneda10.setText(String.valueOf(Singleton.getInstance().moneda10));

        Moneda5=(EditText) findViewById(R.id.editTextTextPersonName18);
        Moneda5.setText(String.valueOf(Singleton.getInstance().moneda5));

        Moneda2=(EditText) findViewById(R.id.editTextTextPersonName8);
        Moneda2.setText(String.valueOf(Singleton.getInstance().moneda2));

        Moneda1=(EditText) findViewById(R.id.editTextTextPersonName10);
        Moneda1.setText(String.valueOf(Singleton.getInstance().moneda1));

        Moneda50=(EditText) findViewById(R.id.editTextTextPersonName11);
        Moneda50.setText(String.valueOf(Singleton.getInstance().moneda50));

        Moneda25=(EditText) findViewById(R.id.editTextTextPersonName13);
        Moneda25.setText(String.valueOf(Singleton.getInstance().moneda25));

        BDSQLiteOpenHelper TipoBM = new BDSQLiteOpenHelper(this,"UsuarioMB",null,1);
        SQLiteDatabase UsuarioMonBill = TipoBM.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("ID", String.valueOf(Mon10));
        values.put("Cantidad", String.valueOf(Moneda10));

        values.put("ID", String.valueOf(Mon5));
        values.put("Cantidad", String.valueOf(Moneda5));

        values.put("ID", String.valueOf(Mon2));
        values.put("Cantidad", String.valueOf(Moneda2));

        values.put("ID", String.valueOf(Mon1));
        values.put("Cantidad", String.valueOf(Moneda1));

        values.put("ID", String.valueOf(Mon50));
        values.put("Cantidad", String.valueOf(Moneda50));

        values.put("ID", String.valueOf(Mon25));
        values.put("Cantidad", String.valueOf(Moneda25));



        // Insert los datos en la tabla
        UsuarioMonBill.insert("BilletesyMonedas", null, values);
        UsuarioMonBill.close();






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