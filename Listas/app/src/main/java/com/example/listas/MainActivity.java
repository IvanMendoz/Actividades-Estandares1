package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listaDias;
    TextView tvTitulo;
    ArrayAdapter<CharSequence> adapter;
    ArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDias = findViewById( R.id.lvListaDias );
        tvTitulo = findViewById( R.id.tvTitulo );

        /*
        adapter = ArrayAdapter.createFromResource(this, R.array.arregloDias, android.R.layout.simple_list_item_1 );
        listaDias.setAdapter( adapter );
        Llenado desde un archivo String
         */

        // Llenado desde un Array List
        ArrayList<String> listaEmpleados = new ArrayList<>();
        listaEmpleados.add("Iván Mendoza");
        listaEmpleados.add("Carolina Mata");
        listaEmpleados.add("Marco Leiva");
        listaEmpleados.add("Gabriela Mendoza");
        listaEmpleados.add("Jeannete Peraza");
        listaEmpleados.add("Diana Serrano");

        adaptador = new ArrayAdapter( this, android.R.layout.simple_list_item_1, listaEmpleados );
        listaDias.setAdapter( adaptador );

        listaDias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText( adapterView.getContext(), "Selecciono " + adapterView.getItemAtPosition( i ).toString(), Toast.LENGTH_LONG ).show();
            }
        });
    }
}