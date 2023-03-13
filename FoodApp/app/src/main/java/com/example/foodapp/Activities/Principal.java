package com.example.foodapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.foodapp.R;

public class Principal extends AppCompatActivity {

    TextView tvUserActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Referencia a Front
        tvUserActive = findViewById( R.id.txvUserActive );

        Bundle bundle = getIntent().getExtras();
        String infor = "Hola, " + bundle.getString("Usuario");
        tvUserActive.setText( infor );
    }
}