package com.example.parcial3_ivanmendoza_electiva1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parcial3_ivanmendoza_electiva1.Helpers.AdminSQLiteHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Fragmento_Eliminar extends AppCompatActivity {

    EditText edCodigo, edNombres, edApellidos, edTelefono, edCorreo;
    Button btEliminar, btLimpiar, btBuscar;
    BottomNavigationView btnNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmento_eliminar);
        btnNavigator = findViewById( R.id.btnNav );
        btnNavigator.setOnNavigationItemSelectedListener( ( BottomNavigationView.OnNavigationItemSelectedListener ) navListener );

        edCodigo = findViewById( R.id.edtCodigo );
        edNombres = findViewById(  R.id.edtNombre );
        edApellidos = findViewById( R.id.edtApellido );
        edTelefono = findViewById( R.id.edtTelefono );
        edCorreo = findViewById( R.id.edtCorreo );
        btBuscar = findViewById( R.id.btnBuscar );
        btEliminar = findViewById( R.id.btnEliminar);
        btLimpiar = findViewById( R.id.btnLimpiar );

        btEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteHelper admin = new AdminSQLiteHelper( getApplicationContext(), "Parcial", null, 1 );
                SQLiteDatabase db =admin.getWritableDatabase();
                String cod_contacto = edCodigo.getText().toString();

                int cat = db.delete( "contactos", "cod_contacto = " + cod_contacto, null );

                if ( cat == 1 ){
                    Toast.makeText( getApplicationContext(), "Se elimino el registro", Toast.LENGTH_LONG ).show();
                    edCodigo.setText( "" );
                    edNombres.setText( "" );
                    edApellidos.setText( "" );
                    edTelefono.setText( "" );
                    edCorreo.setText( "" );
                }else{
                    Toast.makeText( getApplicationContext(), "No se pudo realizar la eliminación del registro", Toast.LENGTH_LONG ).show();
                }

                db.close();
            }
        });

        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteHelper admin = new AdminSQLiteHelper( getApplicationContext(), "Parcial", null, 1 );
                SQLiteDatabase db =admin.getWritableDatabase();
                String cod_contacto = edCodigo.getText().toString();

                Cursor fila = db.rawQuery( "select nombres, apellidos, telefono, correo_electronico from contactos WHERE cod_contacto = " + cod_contacto,
                        null );

                if ( fila.moveToFirst() ){
                    edNombres.setText( fila.getString( 0 ) );
                    edApellidos.setText( fila.getString( 1 ) );
                    edTelefono.setText( fila.getString( 2 ) );
                    edCorreo.setText( fila.getString( 3 ) );
                    Toast.makeText( getApplicationContext(), "El registro fue encontrado", Toast.LENGTH_LONG ).show();

                }else {
                    Toast.makeText( getApplicationContext(), "Registro no encontrado", Toast.LENGTH_LONG ).show();
                }
                db.close();
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectFragment = null;

            switch ( item.getItemId() ){
                case R.id.nav_update:
                    Intent intento = new Intent( getApplicationContext(), Fragmento_Actualizar.class );
                    startActivity( intento );
                    break;

                case R.id.nav_delete:
                    Intent intento2 = new Intent( getApplicationContext(), Fragmento_Eliminar.class );
                    startActivity( intento2 );
                    break;

                case R.id.nav_Edit:
                    Intent intento3 = new Intent( getApplicationContext(), Fragmento_Insertar.class );
                    startActivity( intento3 );
                    break;

                case R.id.nav_Show:
                    Intent intento4 = new Intent( getApplicationContext(), Fragmento_Mostrar.class );
                    startActivity( intento4 );
                    break;
            }
            // getSupportFragmentManager().beginTransaction().replace( R.id.FragmentContent, selectFragment ).commit();
            return true;
        }
    };

    public boolean onCreateOptionsMenu(Menu menu ){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu_superior, menu );
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem items){
        switch ( items.getItemId() ){
            case R.id.opcion1:
                Toast.makeText( this, "Selecciono la opción 1", Toast.LENGTH_LONG ).show();
                return true;

            case R.id.opcion2:
                Toast.makeText( this, "Selecciono la opción 2", Toast.LENGTH_LONG ).show();
                return true;

            case R.id.opcion3:
                Toast.makeText( this, "Selecciono la opción 3", Toast.LENGTH_LONG ).show();
                return true;

            case R.id.opcion4:
                Toast.makeText( this, "Selecciono la opción 4", Toast.LENGTH_LONG ).show();
                return true;
        }
        return super.onOptionsItemSelected( items );
    }
}