package com.example.crudapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.crudapp.datos.Proveedores;

public class MensajesFragment extends Fragment {

    EditText edNombreProveedor, edTelefonoProveedor, edCorreoProveedor;
    Button btnGuardarProveedor, btnActualizarProveedor, btnEliminarProveedor;
    TextView txMensajeCreacion;

    public MensajesFragment() {
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
        View root = inflater.inflate(R.layout.fragment_mensajes, container, false);

        edNombreProveedor = root.findViewById( R.id.edtNombreProveedor );
        edTelefonoProveedor = root.findViewById( R.id.edtTelefonoProveedor );
        edCorreoProveedor = root.findViewById( R.id.edtCorreoProveedor );
        btnGuardarProveedor = root.findViewById( R.id.btnGuardarProveedor );
        btnActualizarProveedor = root.findViewById( R.id.btnActualizarProveedor);
        btnEliminarProveedor = root.findViewById( R.id.btnBorrarProveedor);
        txMensajeCreacion = root.findViewById( R.id.txvMensajeCreacion );

        btnGuardarProveedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Proveedores proveedores = new Proveedores( getContext() );
                long idSave = proveedores.insesrtarProveedor( edNombreProveedor.getText().toString(), edTelefonoProveedor.getText().toString(), edCorreoProveedor.getText().toString() );
                if ( idSave > 0 ){
                    txMensajeCreacion.setText( "El registro se inserto correctamente" );
                }else {
                    txMensajeCreacion.setText( "El registro no se pudo insertar" );
                }
            }
        });

        return root;
    }
}