package com.example.recicleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Listas extends AppCompatActivity {

    ListView listaDias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);

        listaDias = findViewById( R.id.lvEjemplo );

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this, R.array.arregloDias, android.R.layout.simple_list_item_1 );
        listaDias.setAdapter( adapter );

        listaDias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}