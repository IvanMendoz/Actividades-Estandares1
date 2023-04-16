package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sharedpreferences.Helpers.AdminSQliteOpenHelper;

import java.sql.SQLData;

public class MainActivity extends AppCompatActivity {

    EditText edCodProducto, edDescripcionProducto, edPrecioProducto;
    Button btnInsert, btnDelete, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edCodProducto = findViewById( R.id.edtCodProducto );
        edDescripcionProducto = findViewById( R.id.edtDescripcionProducto );
        edPrecioProducto = findViewById( R.id.edtPrecioProducto );
        btnInsert = findViewById( R.id.btnInsertar );
        btnDelete = findViewById( R.id.btnBorrar );
        btnUpdate = findViewById( R.id.btnActualizar );

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQliteOpenHelper admin = new AdminSQliteOpenHelper( getApplicationContext(), "Bodega", null, 1);
                SQLiteDatabase db = admin.getWritableDatabase();
                String codProd = edCodProducto.getText().toString(),
                        descripProd = edDescripcionProducto.getText().toString(),
                        precioProd = edPrecioProducto.getText().toString();

                ContentValues info = new ContentValues();
                info.put("cod_producto", codProd);
                info.put("descripcion_producto", descripProd);
                info.put("precio_producto", precioProd);

                db.insert("productos", null, info);
                db.close();
            }
        });
    }
}