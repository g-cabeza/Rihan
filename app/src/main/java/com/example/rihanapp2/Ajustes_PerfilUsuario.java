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

public class Ajustes_PerfilUsuario extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes_perfil_usuario);


        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Usuarios");
        userID = user.getUid();


        final TextView nombreusuario = (TextView) findViewById(R.id.tv_nombreperfil);
        final TextView emailusuario  = (TextView) findViewById(R.id.tv_emailUsuario);




        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Usuario userProfile = snapshot.getValue(Usuario.class);
                if ( userProfile != null){
                    String NombreUsuario = userProfile.NombreUsuario;
                    String Email  = user.getEmail();

                    nombreusuario.setText(NombreUsuario);
                    emailusuario.setText(Email);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Ajustes_PerfilUsuario.this, "Sucedio un error",Toast.LENGTH_SHORT).show();
            }
        });
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