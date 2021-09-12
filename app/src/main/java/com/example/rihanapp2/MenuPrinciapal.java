package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuPrinciapal extends AppCompatActivity {

    private TextView nombre2_usuario;  //declaro el textview de menu principal
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_princiapal);

        //creo relacion L-G
        nombre2_usuario = (TextView) findViewById(R.id.nombre2_usuario);
        //creo una variable temporal
        String DatoNombre =getIntent().getStringExtra("DatoNombre");
        //coloco el brazo en
        nombre2_usuario.setText("       Hola    " + DatoNombre);

    }
    //metodos de botones

    //boton BILLETERA FISICA

    public void BilleteraFisica1 (View v){
        Intent PrimeraPantallaBF = new Intent(this,BilleteraFisica1.class);
        startActivity(PrimeraPantallaBF);
    }
}