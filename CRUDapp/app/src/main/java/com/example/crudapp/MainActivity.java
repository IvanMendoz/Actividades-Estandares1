package com.example.crudapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.crudapp.datos.BaseHelper;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar tlbar;
    DrawerLayout drwLayout;
    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tlbar = findViewById( R.id.toolBar );
        drwLayout = findViewById( R.id.drawerLayout );
        navView = findViewById( R.id.navigator );

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drwLayout, tlbar, R.string.open, R.string.close );
        drwLayout.addDrawerListener( toggle );
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor( getResources().getColor( R.color.purple_500, null ) );

        BaseHelper basHelper = new BaseHelper( this );
        SQLiteDatabase db = basHelper.getWritableDatabase();
        if ( db != null ){
            Toast.makeText( this, "Base de datos generada", Toast.LENGTH_LONG ).show();
        }else {

            Toast.makeText( this, "ERROR: Base de datos no generada", Toast.LENGTH_LONG ).show();
        }

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch ( item.getItemId() ){
                    case R.id.Mensajes:
                        drwLayout.closeDrawer( GravityCompat.START );
                        Toast.makeText( getApplicationContext(), "Selecciono Mensajes", Toast.LENGTH_LONG ).show();
                        createFragment( new MensajesFragment() );
                        break;

                    case R.id.Explorer:
                        drwLayout.closeDrawer( GravityCompat.START );
                        Toast.makeText( getApplicationContext(), "Selecciono Explorar", Toast.LENGTH_LONG ).show();
                        createFragment( new ExplorerFragment() );
                        break;

                    case R.id.Comentarios:
                        drwLayout.closeDrawer( GravityCompat.START );
                        Toast.makeText( getApplicationContext(), "Selecciono Comentarios", Toast.LENGTH_LONG ).show();
                        createFragment( new ComentariosFragment() );
                        break;


                    case R.id.Enviar:
                        drwLayout.closeDrawer( GravityCompat.START );
                        Toast.makeText( getApplicationContext(), "Selecciono Enviar", Toast.LENGTH_LONG ).show();
                        createFragment( new EnviarFragment() );
                        break;

                    case R.id.Compartir:
                        drwLayout.closeDrawer( GravityCompat.START );
                        Toast.makeText( getApplicationContext(), "Selecciono Compartir", Toast.LENGTH_LONG ).show();
                        createFragment( new CompartirFragment() );
                        break;
                }

                return true;
            }
        });
    }

    private void createFragment(Fragment fragment ){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frmLayoutContenedor, fragment);
        fragmentTransaction.commit();
    }
}