package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rihanapp2.BD.DbBilletesyMonedas;

public class CargaGlobalBM extends AppCompatActivity {

    EditText txtTipo,txtValor;
    Button btn_Guardar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_global_bm);

        txtTipo=findViewById(R.id.et_tipo);
        txtValor = findViewById(R.id.tv_valor);
        btn_Guardar =findViewById(R.id.buttonguardar);

        btn_Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbBilletesyMonedas billetesyMonedas = new DbBilletesyMonedas(CargaGlobalBM.this);
              long id = billetesyMonedas.insertarDatos(txtTipo.getText().toString(),txtValor.getText().toString());

                if (id > 0){
                        Toast.makeText(CargaGlobalBM.this,"Registro Guardado",Toast.LENGTH_SHORT).show();
                        Limpiar();
                    }else{
                        Toast.makeText(CargaGlobalBM.this,"Error al Guardar el registro ",Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }

    private void Limpiar(){
        txtTipo.setText("");
        txtValor.setText("");
    }
}