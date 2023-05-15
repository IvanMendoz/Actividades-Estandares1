package com.example.crudapp.Adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudapp.R;
import com.example.crudapp.entidades.EntidadProveedores;

import java.util.ArrayList;

public class lstProveedorAdaptador extends RecyclerView.Adapter<lstProveedorAdaptador.ProveedoresViewHolder> {

    ArrayList<EntidadProveedores> listaProv = null;

    public lstProveedorAdaptador() {
    }

    public lstProveedorAdaptador( ArrayList<EntidadProveedores> listaProv ) {
        this.listaProv = listaProv;
    }

    @NonNull
    @Override
    public lstProveedorAdaptador.ProveedoresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // return null;
        View view = LayoutInflater.from(parent.getContext() ).inflate(R.layout.lista_proveedores, null, false );
        return new ProveedoresViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull lstProveedorAdaptador.ProveedoresViewHolder holder, int position) {
        holder.viewNombre.setText( listaProv.get( position ).getNombre_proveedor() );
        holder.viewTelefono.setText( listaProv.get( position ).getTelefono() );
        holder.viewCorreo.setText( listaProv.get( position ).getCorreo() );
    }

    @Override
    public int getItemCount() {
        return listaProv.size();
    }

    public class ProveedoresViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewTelefono, viewCorreo;
        public ProveedoresViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNombre = itemView.findViewById( R.id.edtNombreProveedor );
            viewTelefono = itemView.findViewById( R.id.edtTelefonoProveedor );
            viewCorreo = itemView.findViewById( R.id.edtCorreoProveedor );
        }
    }
}
