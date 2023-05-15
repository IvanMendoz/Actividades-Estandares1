package com.example.crudapp.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.crudapp.entidades.EntidadProveedores;

import java.util.ArrayList;

public class BaseHelper extends SQLiteOpenHelper {

    private static final int VERSION_BASEDATOS = 1;
    private static final String NOMBER_BASEDATOS = "BDTIENDA.db";
    public static final String NOMBER_TABLAPROVEEDORES = "proveedores";
    private static final String NOMBER_TABLACLIENTES = "clientes";
    private static final String NOMBER_TABLA_PRODUCTOS = "productos";

    public BaseHelper(@Nullable Context context ) {
        super(context, NOMBER_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL( "CREATE TABLE " + NOMBER_TABLAPROVEEDORES + "" +
                "( id_proveedor INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre_proveedor TEXT NOT NULL, " +
                "telefono TEXT NOT NULL, " +
                    "correo text NOT NULL)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL( "DROP TABLE " + NOMBER_TABLAPROVEEDORES );
        onCreate( sqLiteDatabase );
    }
}
