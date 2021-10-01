package com.example.rihanapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class RecuperarContrasena extends AppCompatActivity {

    private EditText emailrecuperacion;
    private Button   resetearcontraseña;
    private ProgressBar progressBar;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contrasena);

        emailrecuperacion =(EditText)findViewById(R.id.eTEmailRecuperarC);
        resetearcontraseña=(Button) findViewById(R.id.recuperarcontraseña);
        progressBar=(ProgressBar)findViewById(R.id.progressBar3);
        auth=FirebaseAuth.getInstance();

        resetearcontraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recuperarcontraseña();
            }
        });


    }

    private void recuperarcontraseña() {
        String email=emailrecuperacion.getText().toString().trim();
        //validadciones
        if(email.isEmpty()){
            emailrecuperacion.setError("Email es requerido");
            emailrecuperacion.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailrecuperacion.setError("Ingrese un mail valido");
            emailrecuperacion.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull  Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RecuperarContrasena.this,"Revisa tu Email para recuperar la contraseña",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(RecuperarContrasena.this,"Prueba de nuevo, algo salio mal",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}