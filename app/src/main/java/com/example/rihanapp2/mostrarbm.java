package com.example.rihanapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.rihanapp2.BD.DbBilletesyMonedas;
import com.example.rihanapp2.adaptadores.listaBilletesyMonedasAdapter;
import com.example.rihanapp2.entidades.BilletesyMonedas;

import java.util.ArrayList;

public class mostrarbm extends AppCompatActivity {

RecyclerView listabilletesmonedas;
ArrayList<BilletesyMonedas>listaBilletesyMonedas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrarbm);

        listabilletesmonedas = findViewById(R.id.listabilletesmodedas);
        listabilletesmonedas.setLayoutManager(new LinearLayoutManager(mostrarbm.this));

        DbBilletesyMonedas dbBilletesyMonedas = new DbBilletesyMonedas(mostrarbm.this);
        listaBilletesyMonedas = new ArrayList<>();
       //para ver bien cada elementode la lista y se reclicle neesitamosuna clase Adaptadores.

        listaBilletesyMonedasAdapter adapter = new listaBilletesyMonedasAdapter(dbBilletesyMonedas.mostrarBilletesyMonedas());
        listabilletesmonedas.setAdapter(adapter);

    }
}