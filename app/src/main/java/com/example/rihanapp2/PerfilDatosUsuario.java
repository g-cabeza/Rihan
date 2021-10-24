package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PerfilDatosUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_datos_usuario);
    }
    public void PerfilDatosUsuario (View view){
        switch(view.getId()){
            case R.id.imageButton://boton Atras, te lleva a PerfilUsuario
                startActivity(new Intent(this, Ajustes_PerfilUsuario.class));
                break;

        }

    }
}