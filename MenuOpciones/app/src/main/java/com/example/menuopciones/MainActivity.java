package com.example.menuopciones;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.menuopciones.clases.CameraFragment;
import com.example.menuopciones.clases.FavoriteFragment;
import com.example.menuopciones.clases.PrincialFragment;
import com.example.menuopciones.clases.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btnNavi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNavi = findViewById( R.id.btnNav );
        btnNavi.setOnNavigationItemSelectedListener( ( BottomNavigationView.OnNavigationItemSelectedListener ) navaListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navaListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment seleccionFrag = null;

            switch ( item.getItemId() ){
                case R.id.nav_home:
                    seleccionFrag = new PrincialFragment();
                    break;

                case R.id.nav_favorites:
                    seleccionFrag = new FavoriteFragment();
                    break;

                case R.id.nav_camera:
                    seleccionFrag = new CameraFragment();
                    break;

                case R.id.nav_search:
                    seleccionFrag = new SearchFragment();
                    break;


            }

            getSupportFragmentManager().beginTransaction().replace( R.id.fragmentCont, seleccionFrag).commit();
            return true;
        }
    };
    public boolean onCreateOptionsMenu(Menu menu ){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu_configuraciones, menu );
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem items){
        Intent intent = new Intent( this, Sumar.class);
        switch ( items.getItemId() ){
            case R.id.opcion1:
                Toast.makeText( this, "Selecciono la opción 1", Toast.LENGTH_LONG ).show();
                startActivity( intent );
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