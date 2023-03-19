package com.example.recicleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mrecycleview;
    Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mrecycleview = findViewById( R.id.rvPeliculas );
        mrecycleview.setLayoutManager( new LinearLayoutManager(this));
        adaptador = new Adaptador(this, getListado());
        mrecycleview.setAdapter(adaptador);

        /*
        mrecycleview.setOnClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText( getApplicationContext(), "Seleccionar " + adapterView.getItemAtPosition( i ).toString(), Toast.LENGTH_LONG ).show();)
            }
        });


        mrecycleview.setOnClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText( adapterView.getContext(), "Seleccionar " + adapterView.getItemAtPosition( i ).toString(), Toast.LENGTH_LONG).show();

            }
        });
        */
    }



    private ArrayList<Modelo> getListado(){
        ArrayList<Modelo> modelos = new ArrayList<>();
        Modelo modeLista = new Modelo();
        modeLista.setNombrePelicula("Interestelar");
        modeLista.setNombreDirectorPelicula("Iván Landaverde");
        modeLista.setGeneroPelicula("Ciencia Ficción");
        modeLista.setImagenPelicula(R.drawable.interestelar);
        modeLista.setClasificacionPelicula(3.45);
        modeLista.setDuracionPelicula("1 hora 50 minutos");
        modeLista.setAnioPelicula("2014");
        modelos.add(modeLista);

        modeLista = new Modelo();
        modeLista.setNombrePelicula("Ex-Maquina");
        modeLista.setNombreDirectorPelicula("Iván Landaverde");
        modeLista.setGeneroPelicula("Ciencia Ficción");
        modeLista.setImagenPelicula(R.drawable.ex_maquina);
        modeLista.setClasificacionPelicula(3.45);
        modeLista.setDuracionPelicula("1 hora 50 minutos");
        modeLista.setAnioPelicula("2014");
        modelos.add(modeLista);

        modeLista = new Modelo();
        modeLista.setNombrePelicula("Jumanji");
        modeLista.setNombreDirectorPelicula("Iván Landaverde");
        modeLista.setGeneroPelicula("Ciencia Ficción");
        modeLista.setImagenPelicula(R.drawable.jumanji);
        modeLista.setClasificacionPelicula(3.45);
        modeLista.setDuracionPelicula("1 hora 50 minutos");
        modeLista.setAnioPelicula("2014");
        modelos.add(modeLista);

        modeLista = new Modelo();
        modeLista.setNombrePelicula("La llegada");
        modeLista.setNombreDirectorPelicula("Iván Landaverde");
        modeLista.setGeneroPelicula("Ciencia Ficción");
        modeLista.setImagenPelicula(R.drawable.la_llegada);
        modeLista.setClasificacionPelicula(3.45);
        modeLista.setDuracionPelicula("1 hora 50 minutos");
        modeLista.setAnioPelicula("2014");
        modelos.add(modeLista);

        modeLista = new Modelo();
        modeLista.setNombrePelicula("Forma Agua");
        modeLista.setNombreDirectorPelicula("Iván Landaverde");
        modeLista.setGeneroPelicula("Ciencia Ficción");
        modeLista.setImagenPelicula(R.drawable.forma_agua);
        modeLista.setClasificacionPelicula(3.45);
        modeLista.setDuracionPelicula("1 hora 50 minutos");
        modeLista.setAnioPelicula("2014");
        modelos.add(modeLista);

        modeLista = new Modelo();
        modeLista.setNombrePelicula("Extraordinario");
        modeLista.setNombreDirectorPelicula("Iván Landaverde");
        modeLista.setGeneroPelicula("Ciencia Ficción");
        modeLista.setImagenPelicula(R.drawable.extraordinario);
        modeLista.setClasificacionPelicula(3.45);
        modeLista.setDuracionPelicula("1 hora 50 minutos");
        modeLista.setAnioPelicula("2014");
        modelos.add(modeLista);

        modeLista = new Modelo();
        modeLista.setNombrePelicula("Interestelar");
        modeLista.setNombreDirectorPelicula("Iván Landaverde");
        modeLista.setGeneroPelicula("Ciencia Ficción");
        modeLista.setImagenPelicula(R.drawable.interestelar);
        modeLista.setClasificacionPelicula(3.45);
        modeLista.setDuracionPelicula("1 hora 50 minutos");
        modeLista.setAnioPelicula("2014");
        modelos.add(modeLista);

        modeLista = new Modelo();
        modeLista.setNombrePelicula("Interestelar");
        modeLista.setNombreDirectorPelicula("Iván Landaverde");
        modeLista.setGeneroPelicula("Ciencia Ficción");
        modeLista.setImagenPelicula(R.drawable.ex_maquina);
        modeLista.setClasificacionPelicula(3.45);
        modeLista.setDuracionPelicula("1 hora 50 minutos");
        modeLista.setAnioPelicula("2014");
        modelos.add(modeLista);
        return modelos;
    }
}