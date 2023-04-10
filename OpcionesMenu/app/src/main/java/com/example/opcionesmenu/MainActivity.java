package com.example.opcionesmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu ){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu_configuraciones, menu );
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem items){
        Intent intent = new Intent( this, Suma.class);
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