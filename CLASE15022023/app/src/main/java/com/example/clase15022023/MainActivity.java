package com.example.clase15022023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnprincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnprincipal = findViewById( R.id.btnLsnt );
        btnprincipal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent( getApplicationContext(), Principal.class);
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