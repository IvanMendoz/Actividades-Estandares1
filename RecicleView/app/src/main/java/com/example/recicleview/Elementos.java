package com.example.recicleview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Elementos extends RecyclerView.ViewHolder {

    static ImageView imgvPel;
    static TextView tvNombrePel, tvGeneroPel;

    public Elementos(@NonNull View itemView) {
        super(itemView);
        imgvPel = itemView.findViewById( R.id.imgPelicula );
        tvNombrePel = itemView.findViewById( R.id.tvTitulo );
        tvGeneroPel = itemView.findViewById( R.id.tvGenero );
    }
}
