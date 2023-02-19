package com.example.clase15022023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    Button btnAlerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnAlerta = findViewById( R.id.btnToast );
        btnAlerta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toastp = new Toast( getApplicationContext() );
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate( R.layout.toast_layout, (ViewGroup) findViewById( R.id.lyMensaje ) );

                TextView txtMensaje = ( TextView ) layout.findViewById( R.id.textView2 );

                toastp.setDuration( Toast.LENGTH_LONG );
                toastp.setView( layout );
                toastp.show();

            }
        });
    }
}