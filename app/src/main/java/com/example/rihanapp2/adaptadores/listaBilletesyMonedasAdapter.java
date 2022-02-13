package com.example.rihanapp2.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rihanapp2.R;
import com.example.rihanapp2.entidades.BilletesyMonedas;

import java.util.ArrayList;

public class listaBilletesyMonedasAdapter extends RecyclerView.Adapter<listaBilletesyMonedasAdapter.billetemonedaViewHolder> {

    ArrayList<BilletesyMonedas> listaBilletesyMonedas;

    public listaBilletesyMonedasAdapter(ArrayList<BilletesyMonedas> listaBilletesMonedas){
        this.listaBilletesyMonedas = listaBilletesyMonedas;
    }



    @NonNull
    @Override //asignar el diseño de cada elemento de la lista
    public billetemonedaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_billetesmonedas,null,false);

        return new billetemonedaViewHolder(view);
    }

    @Override //asignar los elementos que corresponden a cada opcion
    public void onBindViewHolder(@NonNull billetemonedaViewHolder holder, int position) {

        holder.view_id.setText(listaBilletesyMonedas.get(position).getID());
        holder.view_tipo.setText(listaBilletesyMonedas.get(position).getTIPO());
        holder.view_valor.setText(listaBilletesyMonedas.get(position).getVALOR());


    }

    @Override  //devuelve el tamaño de la lista
    public int getItemCount() {
        return listaBilletesyMonedas.size();

    }

    public class billetemonedaViewHolder extends RecyclerView.ViewHolder {

        TextView view_id,view_tipo,view_valor;

        public billetemonedaViewHolder(@NonNull View itemView) {
            super(itemView);
            view_id   = itemView.findViewById(R.id.view_id);
            view_tipo = itemView.findViewById(R.id.view_tipo);
            view_valor= itemView.findViewById(R.id.view_valor);
        }
    }
}
