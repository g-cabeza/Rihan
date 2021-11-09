package com.example.rihanapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PerfilDatosUsuario extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_datos_usuario);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Usuarios");
        userID = user.getUid();


        final TextView nombreusuario = (TextView) findViewById(R.id.textView59);
        final TextView emailusuario  = (TextView) findViewById(R.id.textView62);
        final TextView contraseñausuario= (TextView)findViewById(R.id.textView65);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Usuario userProfile = snapshot.getValue(Usuario.class);
                if (userProfile != null){
                    String NombreUsuario = userProfile.NombreUsuario;
                    String Email  = user.getEmail();
                    String Contraseña = userProfile.ContraseñaUsuario;

                    nombreusuario.setText(NombreUsuario);
                    emailusuario.setText(Email);
                    contraseñausuario.setText(Contraseña);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(PerfilDatosUsuario.this, "Sucedio un error",Toast.LENGTH_SHORT).show();
            }
        });



    }
    public void PerfilDatosUsuario (View view){
        switch(view.getId()){
            case R.id.imageView115://boton Atras, te lleva a PerfilUsuario
                startActivity(new Intent(this, Ajustes_PerfilUsuario.class));
                break;

        }

    }
}