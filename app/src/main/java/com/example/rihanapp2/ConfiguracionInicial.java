package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ConfiguracionInicial extends AppCompatActivity {

    private EditText  nombre_usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion_inicial);

        //relacion de la parte logica con la grafica
        nombre_usuario = (EditText)findViewById(R.id.nombre_usuario);


    }
       //metodo que va a ejecutar el boton Bien (La mano)
       public void Bien (View view){
          //      +nombre del objeto = new intent ( desde que activity , hasta que otra va.class).
           Intent  Bbien = new Intent(this,MenuPrinciapal.class);
           //paso el valor nombre
           Bbien.putExtra("DatoNombre",nombre_usuario.getText().toString());
           startActivity(Bbien);

    }
}