package com.example.recicleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Elementos> {

    Context contexto;
    ArrayList<Modelo> modelos;



    public Adaptador(Context contexto, ArrayList<Modelo> modelos) {
        this.contexto = contexto;
        this.modelos = modelos;
    }

    @NonNull
    @Override
    public Elementos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contexto.getApplicationContext()).inflate( R.layout.peliculas_listado, null );
        return new Elementos( view );
    }

    @Override
    public void onBindViewHolder(@NonNull Elementos holder, int position) {
        Elementos.tvNombrePel.setText( modelos.get( position ).getNombrePelicula() );
        Elementos.tvGeneroPel.setText( modelos.get( position ).getGeneroPelicula() );
        Elementos.imgvPel.setImageResource( modelos.get( position ).getImagenPelicula() );


    }

    @Override
    public int getItemCount() {
        return modelos.size();
    }
}
