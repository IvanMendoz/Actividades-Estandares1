package com.example.parcial3_ivanmendoza_electiva1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Fragmento_Mostrar extends AppCompatActivity {

    BottomNavigationView btnNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmento_mostrar);

        btnNavigator = findViewById( R.id.btnNav );
        btnNavigator.setOnNavigationItemSelectedListener( ( BottomNavigationView.OnNavigationItemSelectedListener ) navListener );
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