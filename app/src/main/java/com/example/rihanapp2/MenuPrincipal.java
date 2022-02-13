package com.example.rihanapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MenuPrincipal extends AppCompatActivity implements View.OnClickListener {

    private ImageView logout,billefisica,billevirtual,trasnporte,agenda,ajuste;

    private GoogleSignInClient mGoogleSignInClient;

    //Recuperar datos firebase
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

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

        //recuperar Nombre de la Base de DATOS FIREBASE

       /*user = FirebaseAuth.getInstance().getCurrentUser();
       reference = FirebaseDatabase.getInstance().getReference("Usuarios");
        //  NULLPOINTEREXCEPTION  REVISAR
        userID = user.getUid();

        final TextView nombreusuario = (TextView) findViewById(R.id.textView54);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Usuario userProfile = snapshot.getValue(Usuario.class);
                if (user != null){
                    String NombreUsuario = userProfile.NombreUsuario;

                    nombreusuario.setText("Hola "+NombreUsuario);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MenuPrincipal.this, "Sucedio un error",Toast.LENGTH_SHORT).show();
            }
        });*/





        logout = (ImageView) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {   //Habria que hacer un condicional para ver con que entro. y cerrar sesion
            @Override
            public void onClick(View v) {
                if (FirebaseAuth.getInstance().getCurrentUser() != null){
                    FirebaseAuth.getInstance().signOut();   //esto estaba solo antes
                    startActivity(new Intent(MenuPrincipal.this, ConfiguracionInicial.class));
                }else{
                    mGoogleSignInClient.signOut();
                    startActivity(new Intent(MenuPrincipal.this, ConfiguracionInicial.class).putExtra("logout",true));
                 }
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
                startActivity(new Intent(this, AjustesMenu.class));
                break;
        }
    }
  }