package com.example.crudapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.crudapp.Adaptador.lstProveedorAdaptador;
import com.example.crudapp.datos.Proveedores;
import com.example.crudapp.entidades.EntidadProveedores;

import java.util.ArrayList;

public class ExplorerFragment extends Fragment {

    RecyclerView listaProveedores;
    ArrayList<EntidadProveedores> aListProveedores;
    Context context;
    public ExplorerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_explorer, container, false);

        listaProveedores = root.findViewById( R.id.listaProveedores );
        listaProveedores.setLayoutManager( new LinearLayoutManager( getContext() ));

        Proveedores proveedores = new Proveedores( getContext() );
        aListProveedores = new ArrayList<>();

        lstProveedorAdaptador adapter = new lstProveedorAdaptador( proveedores.mostrarProveedores() );
        listaProveedores.setAdapter( adapter );

        return root;
    }
}