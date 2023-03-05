package com.example.clase15022023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnprincipal;
    EditText ejemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnprincipal = findViewById( R.id.btnLsnt );
        ejemp = findViewById( R.id.edtEjemplo);
        btnprincipal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent( getApplicationContext(), Pantalla3.class);
                startActivity( intento );
            }
        });
    }

    public void pantalla( View view ) {
        Intent intento = new Intent( this, Principal.class);
        startActivity( intento );

    }

    public void Salir( View view ) {
        finish();
    }
}