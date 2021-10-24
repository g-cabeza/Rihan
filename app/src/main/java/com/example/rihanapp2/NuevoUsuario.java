package com.example.rihanapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.net.PasswordAuthentication;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Pattern;

public class NuevoUsuario extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth; //declaro para autentificar

    private TextView tvbanner,tvregistar; //banner y registrar
    private EditText nombre_usuario_registrar,eTEmailRegistrarUsuario,eTContraseñaRegistrarUsuario;  //datos
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_usuario);

        mAuth = FirebaseAuth.getInstance(); //inicializo

        tvbanner = (TextView)findViewById(R.id.textView14);//para que cuando toque vaya al menu principal
        tvbanner.setOnClickListener(this);

        tvregistar = (TextView)findViewById(R.id.textView16);
        tvregistar.setOnClickListener(this);

        nombre_usuario_registrar = (EditText)findViewById(R.id.nombre_usuario_registrar);
        eTEmailRegistrarUsuario = (EditText)findViewById(R.id.eTEmailRegistrar);
        eTContraseñaRegistrarUsuario = (EditText)findViewById(R.id.eTContraseñaRegistrar);

        progressBar = (ProgressBar) findViewById(R.id.progressBar2);




    }

    @Override //banner
    public void onClick(View v) {
      switch (v.getId()){  //si tocan el banner vuelven a configuracion Inicial
        case R.id.textView14:
            startActivity(new Intent(this,ConfiguracionInicial.class));
            break;
          case R.id.textView16:  //si toca Registrar
              RegistroNuevoUsuario();
              break;


      }

    }

    private void RegistroNuevoUsuario() {  //conviertoastring
        String Email =  eTEmailRegistrarUsuario.getText().toString().trim();
        String NombreUsuario = nombre_usuario_registrar.getText().toString().trim();
        String ContraseñaUsuario = eTContraseñaRegistrarUsuario.getText().toString().trim();

        //valido las entradas
        if(NombreUsuario.isEmpty()){
            nombre_usuario_registrar.setError("Se requiere Nombre");
            nombre_usuario_registrar.requestFocus();
            return;
        }

        if(Email.isEmpty()){
            eTEmailRegistrarUsuario.setError("Se requiere Email");
            eTEmailRegistrarUsuario.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            eTEmailRegistrarUsuario.setError("Por Favor ingrese un Email Valido");
            eTEmailRegistrarUsuario.requestFocus();
            return;
        }

        if(ContraseñaUsuario.isEmpty()){
            eTContraseñaRegistrarUsuario.setError("Se requiere Contraseña");
            eTContraseñaRegistrarUsuario.requestFocus();
            return;
        }
        if(ContraseñaUsuario.length() < 6){
            eTContraseñaRegistrarUsuario.setError("La contraseña debe tener minimo 6 caracteres");
            eTContraseñaRegistrarUsuario.requestFocus();
            return;
        }

        progressBar.setVisibility(View.GONE);

        mAuth.createUserWithEmailAndPassword(Email,ContraseñaUsuario)
                .addOnCompleteListener(new OnCompleteListener <AuthResult>() {
                    @Override
                    public void onComplete(@NonNull  Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Usuario Usuar = new Usuario(NombreUsuario,Email,ContraseñaUsuario);
                            FirebaseDatabase.getInstance().getReference("Usuarios")
                             .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                                    .setValue(Usuar).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(NuevoUsuario.this, "Registro Exitoso", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }else{
                                        Toast.makeText(NuevoUsuario.this, "Registro Fallido, pruebe de nuevo", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                        //direcciona al logout
                                }
                            }
                                    });
                            }else{
                                 Toast.makeText(NuevoUsuario.this, "Registro Fallido, pruebe de nuevo", Toast.LENGTH_LONG).show();
                                 progressBar.setVisibility(View.GONE);
                                }
                    }
                });

    }
}