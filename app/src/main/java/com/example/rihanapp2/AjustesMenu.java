package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.rihanapp2.BD.BDSQLiteOpenHelper;

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
            case R.id.imageView114://boton Atras, lleva a Menu Principal
                Intent intent =new Intent(this,MenuPrincipal.class);
                startActivity(intent);
                break;
            case R.id.crearbasededatos:
                 BDSQLiteOpenHelper basededatos = new BDSQLiteOpenHelper(AjustesMenu.this);
                 SQLiteDatabase db = basededatos.getWritableDatabase();
                 if (db != null){
                     Toast.makeText(AjustesMenu.this,"Base de datos creada",Toast.LENGTH_SHORT).show();
                 }else{
                     Toast.makeText(AjustesMenu.this,"Error al crearla base de datos ",Toast.LENGTH_SHORT).show();
                 }
                 break;
            case R.id.cargarbasededatos:
                nuevoRegistro();
                break;

            case R.id.textView69:
                this.deleteDatabase("BDSQLiteOpenHelper");
                Toast.makeText(this,"Base de datos eliminada",Toast.LENGTH_SHORT).show();
                break;


        }

    }

    /*public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.registronuevo:
                nuevoRegistro();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }*/

    private void nuevoRegistro(){
        Intent intent=new Intent(this,CargaGlobalBM.class);
        startActivity(intent);}

}