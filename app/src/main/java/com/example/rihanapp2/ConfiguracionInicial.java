package com.example.rihanapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.regex.Pattern;

public class ConfiguracionInicial extends AppCompatActivity implements View.OnClickListener {

    private static final int RC_SIGN_IN =171 ; //constantes
    private static final String TAG = "tag";
    private EditText nombre_usuario, eTEmailIniSes, eTContraseñaIniSes;
    private TextView registrar, recuperarContraseña, banner;
    private FirebaseAuth mAuth;
    private TextView acceder;

    private GoogleSignInClient mGoogleSignInClient;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion_inicial);

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Check for existing Google Sign In account, if the user is already signed in
       // the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (!getIntent().getBooleanExtra("logout",false)){
            updateUI(account,true);
        }


        // Set the dimensions of the sign-in button.
        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        findViewById(R.id.sign_in_button).setOnClickListener(this);



        //relacion de la parte logica con la grafica
        nombre_usuario = (EditText) findViewById(R.id.nombre_usuario);
        eTEmailIniSes = (EditText) findViewById(R.id.eTEmailAddress);
        eTContraseñaIniSes = (EditText) findViewById(R.id.eTPassword);

        registrar = (TextView) findViewById(R.id.tVRegistrar);
        registrar.setOnClickListener(this);

        acceder = (TextView) findViewById(R.id.tVAcceder);
        acceder.setOnClickListener(this);

        recuperarContraseña = (TextView) findViewById(R.id.tVRestaurarContraseña);
        recuperarContraseña.setOnClickListener(this);

        banner = (TextView) findViewById(R.id.tVTitulo);
        banner.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();



    }

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
            case R.id.sign_in_button:// icono de Google.
                signIn();
                break;
        }
    }




    private void UsuarioInicioSesion() {
        final String[] email = {eTEmailIniSes.getText().toString().trim()};
        String Contraseña = eTContraseñaIniSes.getText().toString().trim();
        String Nombre = nombre_usuario.getText().toString().trim();

        //validacion del Nombre
        if (Nombre.isEmpty()) {
            nombre_usuario.setError("Nombre es requerido");
            nombre_usuario.requestFocus();
            return;
        }
        //validacion mail - no este vacio
        if (email[0].isEmpty()) {
            eTEmailIniSes.setError("Email es requerido");
            eTEmailIniSes.requestFocus();
            return;
        }
        //validacion email - que sea @gmail.com o algo
        if (!Patterns.EMAIL_ADDRESS.matcher(email[0]).matches()) {
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
        mAuth.signInWithEmailAndPassword(email[0], Contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //verificamos el mail
                    FirebaseUser usuario = FirebaseAuth.getInstance().getCurrentUser();

                    if (usuario.isEmailVerified()) {
                        email[0] = mAuth.getCurrentUser().getUid();
                        Toast.makeText(ConfiguracionInicial.this, email[0], Toast.LENGTH_LONG).show();
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



    }//usuarioiniciosesion

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            // Signed in successfully, show authenticated UI.
            updateUI(account,false);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            updateUI(null,false);
        }
    }

    private void updateUI(GoogleSignInAccount account, boolean prisesion ) {
        //Change UI according to user data.

            if(account != null){
                //Toast.makeText(this,"You Signed In successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(this,MenuPrincipal.class));
            }else {
                if (!prisesion){
                    Toast.makeText(this,"Inicio de Sesion Fallida",Toast.LENGTH_LONG).show();
                }

            }
    }

}

