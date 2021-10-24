package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AjustesMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes_menu);
    }

    public void AjustesMenu (View view){
        switch(view.getId()){
            case R.id.tv_PerfilUsuario: //Perfil
                startActivity(new Intent(this, Ajustes_PerfilUsuario.class));
                break;
            case R.id.imageButton2://boton Atras, lleva a Menu Principal
                startActivity(new Intent(this, MenuPrincipal.class));
                break;

        }

    }
}