package com.example.rihanapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

public class ConfiguracionInicial extends AppCompatActivity implements View.OnClickListener {

    private EditText nombre_usuario, eTEmailIniSes, eTContraseñaIniSes;
    private TextView registrar, recuperarContraseña, banner;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    private TextView acceder;  //antes enbutton


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion_inicial);

        //relacion de la parte logica con la grafica
        nombre_usuario = (EditText) findViewById(R.id.nombre_usuario);
        eTEmailIniSes = (EditText) findViewById(R.id.eTEmailAddress);
        eTContraseñaIniSes = (EditText) findViewById(R.id.eTPassword);

        registrar = (TextView) findViewById(R.id.tVRegistrar);
        registrar.setOnClickListener(this);

        acceder = (TextView) findViewById(R.id.tVAcceder);
        acceder.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();


        recuperarContraseña = (TextView) findViewById(R.id.tVRestaurarContraseña);
        recuperarContraseña.setOnClickListener(this);

        banner = (TextView) findViewById(R.id.tVTitulo);
        banner.setOnClickListener(this);


    }


    //metodo que va a ejecutar el boton Bien (La mano)
       /*public void Bien (View view){
          //      +nombre del objeto = new intent ( desde que activity , hasta que otra va.class).
           Intent  Bbien = new Intent(this, MenuPrincipal.class);
           //paso el valor nombre
           Bbien.putExtra("DatoNombre",nombre_usuario.getText().toString());
           startActivity(Bbien);

    }*/


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tVRegistrar: //si toca el text view REGISTRAR
                startActivity(new Intent(this, NuevoUsuario.class));
                break;
            case R.id.tVAcceder:
                UsuarioInicioSesion();
                break;
            case R.id.tVRestaurarContraseña://loagrege yp
                startActivity(new Intent(this, RecuperarContrasena.class));
                break;
            case R.id.tVTitulo:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }


    private void UsuarioInicioSesion() {
        String email = eTEmailIniSes.getText().toString().trim();
        String Contraseña = eTContraseñaIniSes.getText().toString().trim();
        String Nombre = nombre_usuario.getText().toString().trim();

        //validacion del Nombre
        if (Nombre.isEmpty()) {
            nombre_usuario.setError("Nombre es requerido");
            nombre_usuario.requestFocus();
            return;
        }
        //validacion mail - no este vacio
        if (email.isEmpty()) {
            eTEmailIniSes.setError("Email es requerido");
            eTEmailIniSes.requestFocus();
            return;
        }
        //validacion email - que sea @gmail.com o algo
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            eTEmailIniSes.setError("Por favor ingrese un mail valido");
            eTEmailIniSes.requestFocus();
            return;
        }
        //validacion de Contraseña
        if (Contraseña.isEmpty()) {
            eTContraseñaIniSes.setError("Contraseña es requerida");
            eTContraseñaIniSes.requestFocus();
            return;
        }
        //validacion Contraseña tamaño
        if (Contraseña.length() < 6) {
            eTContraseñaIniSes.setError("Minimo requerido 6 caracteres");
            eTContraseñaIniSes.requestFocus();
            return;
        }


        //llamamos al objeto de la autentificacion
        mAuth.signInWithEmailAndPassword(email, Contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //verificamos el mail
                    FirebaseUser usuario = FirebaseAuth.getInstance().getCurrentUser();

                    if (usuario.isEmailVerified()) {
                        //si se inicio correctamente va a la activity MenuPrincipal
                        startActivity(new Intent(ConfiguracionInicial.this, MenuPrincipal.class));
                    } else {//si no esta el mail,envia al correo un mensaje para que lo verifique
                        usuario.sendEmailVerification();
                        Toast.makeText(ConfiguracionInicial.this, "Ingresa a tu Email para verificar tu cuenta", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(ConfiguracionInicial.this, "Inicio sesion fallido, por favor verifica los datos si ya esta registrado, o pulse Registrar", Toast.LENGTH_LONG).show();
                }

            }
        });


    }

}