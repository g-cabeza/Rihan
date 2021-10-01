package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MenuPrincipal extends AppCompatActivity implements View.OnClickListener {

    private ImageView logout,billefisica,billevirtual,trasnporte,agenda,ajuste;

        /*//creo relacion L-G
        nombre2_usuario = (TextView) findViewById(R.id.nombre2_usuario);
        //creo una variable temporal
        String DatoNombre =getIntent().getStringExtra("DatoNombre");
        //coloco el brazo en
        nombre2_usuario.setText("Hola " + DatoNombre);*/



    private TextView nombre2_usuario;  //declaro el textview de menu principal
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);



        billefisica=(ImageView)findViewById(R.id.imageView11);
        billefisica.setOnClickListener(this);

        billevirtual=(ImageView) findViewById(R.id.imageView14) ;
        billefisica.setOnClickListener(this);

        trasnporte=(ImageView)findViewById(R.id.imageView12);
        trasnporte.setOnClickListener(this);

        agenda=(ImageView)findViewById(R.id.imageView13);
        agenda.setOnClickListener(this);

        ajuste=(ImageView)findViewById(R.id.imageView15);
        ajuste.setOnClickListener(this);


        logout = (ImageView) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MenuPrincipal.this, ConfiguracionInicial.class));
            }
        });



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView4://toca el RIHAN
                startActivity(new Intent(this, MainActivity.class));
            case R.id.imageView11: //toca BilleteraFisica
                 startActivity(new Intent(this, BilleteraFisica1.class));
                break;
            case R.id.imageView12:  //toca Transporte

                break;
            case R.id.imageView13: //toca Agenda

                break;
            case R.id.imageView14://toca billeteraVirtual

                break;
            case R.id.imageView15://toca Ajuste

                break;


        }
    }

    /*//metodos de botones

    //boton BILLETERA FISICA

    public void BilleteraFisica1 (View v){
        Intent PrimeraPantallaBF = new Intent(this,BilleteraFisica1.class);
        startActivity(PrimeraPantallaBF);
    }*/
}