package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ajustes_PerfilUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes_perfil_usuario);
    }

    public void Ajustes_PerfilUsuario (View view){
        switch(view.getId()){
            case R.id.textView56: //Tus Datos
                startActivity(new Intent(this, PerfilDatosUsuario.class));
                break;
            case R.id.imageView112://boton Atras, lleva a Menu Principal
                startActivity(new Intent(this, AjustesMenu.class));
                break;

        }

    }
}