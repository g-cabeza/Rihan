package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ValidarBilletes extends AppCompatActivity implements View.OnClickListener {

    private ImageView volverib,continuar;
    private ImageView Bill1000,Bill500,Bill200,Bill100,Bill50,Bill20,Bill10;
    private EditText Billete1000,Billete500,Billete200,Billete100,Billete50,Billete20,Billete10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validar_billetes);

        volverib=(ImageView) findViewById(R.id.imageView72);
        volverib.setOnClickListener(this);

        continuar =(ImageView) findViewById(R.id.imageView73);
        continuar.setOnClickListener(this);

        Bill1000 = (ImageView) findViewById(R.id.imageView22);
        Bill500 = (ImageView) findViewById(R.id.imageView23);
        Bill200 = (ImageView) findViewById(R.id.imageView24);
        Bill100 = (ImageView) findViewById(R.id.imageView25);
        Bill50 = (ImageView) findViewById(R.id.imageView26);
        Bill20 = (ImageView) findViewById(R.id.imageView27);
        Bill10 = (ImageView) findViewById(R.id.imageView28);

        Billete1000=(EditText) findViewById(R.id.editTextTextPersonName7);
        Billete1000.setText(String.valueOf(Singleton2.getInstance().billete1000));
        Billete500=(EditText) findViewById(R.id.editTextTextPersonName9);
        Billete500.setText(String.valueOf(Singleton2.getInstance().billete500));
        Billete200=(EditText) findViewById(R.id.editTextTextPersonName12);
        Billete200.setText(String.valueOf(Singleton2.getInstance().billete200));
        Billete100=(EditText) findViewById(R.id.editTextTextPersonName14);
        Billete100.setText(String.valueOf(Singleton2.getInstance().billete100));
        Billete50=(EditText) findViewById(R.id.editTextTextPersonName15);
        Billete50.setText(String.valueOf(Singleton2.getInstance().billete50));
        Billete20=(EditText) findViewById(R.id.editTextTextPersonName17);
        Billete20.setText(String.valueOf(Singleton2.getInstance().billete20));
        Billete10=(EditText) findViewById(R.id.editTextTextPersonName);
        Billete10.setText(String.valueOf(Singleton2.getInstance().billete10));


        BDSQLiteOpenHelper TipoBM = new BDSQLiteOpenHelper(this,"UsuarioMB",null,1);
        SQLiteDatabase UsuarioMonBill = TipoBM.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("ID", String.valueOf(Bill1000));
        values.put("Cantidad", String.valueOf(Billete1000));

        values.put("ID", String.valueOf(Bill500));
        values.put("Cantidad", String.valueOf(Billete500));

        values.put("ID", String.valueOf(Bill200));
        values.put("Cantidad", String.valueOf(Billete200));

        values.put("ID", String.valueOf(Bill100));
        values.put("Cantidad", String.valueOf(Billete100));

        values.put("ID", String.valueOf(Bill50));
        values.put("Cantidad", String.valueOf(Billete50));

        values.put("ID", String.valueOf(Bill20));
        values.put("Cantidad", String.valueOf(Billete20));

        values.put("ID", String.valueOf(Bill10));
        values.put("Cantidad", String.valueOf(Billete10));

       // Insert los datos en la tabla
        UsuarioMonBill.insert("BilletesyMonedas", null, values);
        UsuarioMonBill.close();

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