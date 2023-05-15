package com.example.crudapp.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.crudapp.entidades.EntidadProveedores;

import java.util.ArrayList;

public class Proveedores extends BaseHelper{

    Context context;

    public Proveedores( @Nullable Context context ) {
        super( context );
        this.context = context;
    }

    public long insesrtarProveedor( String nombre_proveedor, String telefono, String correo ) {

        long id = 0;

        try{
            BaseHelper baseHelper = new BaseHelper(context);
            SQLiteDatabase db = getWritableDatabase();

            ContentValues valoresProveedor = new ContentValues();
            valoresProveedor.put("nombre_proveedor", nombre_proveedor);
            valoresProveedor.put("telefono", telefono);
            valoresProveedor.put("correo", correo);

            db.insert(NOMBER_TABLAPROVEEDORES, null, valoresProveedor);
            return id;
        }catch (Exception e){
            e.toString();
            return id = 0;
        }
    };

    public ArrayList<EntidadProveedores> mostrarProveedores(){
        BaseHelper baseHelper = new BaseHelper(context);
        SQLiteDatabase db = getWritableDatabase();

        ArrayList<EntidadProveedores> listaProveedores = new ArrayList<EntidadProveedores>();
        EntidadProveedores entidadProveedores = null;
        Cursor cursorProveedores = null;

        cursorProveedores = db.rawQuery( "SELECT * FROM " + NOMBER_TABLAPROVEEDORES, null );
        if ( cursorProveedores.moveToFirst() ){
            do {
                entidadProveedores = new EntidadProveedores();
                entidadProveedores.getId_proveedor( cursorProveedores.getInt( 0 ) );
                entidadProveedores.getNombre_proveedor( cursorProveedores.getString( 1 ) );
                entidadProveedores.getTelefono( cursorProveedores.getString( 2 ) );
                entidadProveedores.getCorreo( cursorProveedores.getString( 3 ) );
                listaProveedores.add( entidadProveedores );

            } while ( cursorProveedores.moveToNext() );
        }

        cursorProveedores.close();
        return listaProveedores;
    }
}
