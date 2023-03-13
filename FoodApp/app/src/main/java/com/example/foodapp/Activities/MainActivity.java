package com.example.foodapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.foodapp.R;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout btnInicial;
    EditText edUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edUsuario = findViewById( R.id.edtUsuario );
        btnInicial = findViewById( R.id.btnInicio );
        btnInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                Intent i = new Intent( getApplicationContext(), Principal.class );
                i.putExtra("Usuario", edUsuario.getText().toString());
                startActivity( i );
            }
        });
    }
}