package sv.edu.utec.clase080223;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declaración de componentes a utilizar
    Spinner spPais;
    EditText etNombres, etApellidos, etInfo;
    RadioButton rbMascu, rbFemeni, rbOtro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Haciendo referencia a los componentes que se ocuparon dentro de la vista
        // Spinner
        spPais = findViewById( R.id.spnPais );

        // EditText
        etNombres = findViewById( R.id.edtNombres );
        etApellidos = findViewById( R.id.edtApellidos );
        etInfo = findViewById( R.id.edtMDatos );

        // RadioButtons
        rbMascu = findViewById( R.id.rbMasculino );
        rbFemeni = findViewById( R.id.rbFemenino );
        rbOtro = findViewById( R.id.rbOtros );

        // Forma 1
        /*
        spPais.setSelection( 0, false );
        String[] opciones = { "Seleccione un pais...", "Guatemala", "El Salvador", "Honduras", "Nicaragua", "Costa Rica", "Panama" };
        ArrayAdapter< String > adapter = new ArrayAdapter< String >( this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, opciones );

        spPais.setAdapter( adapter );
         */

        // Forma 2
        ArrayAdapter< String > adapter = new ArrayAdapter< String >( this, android.R.layout.simple_spinner_dropdown_item){
            public View getView(int posicion, View contenido, ViewGroup parent){

                View vista = super.getView( posicion, contenido, parent );
                if ( posicion == getCount() ){
                    ( (TextView)vista.findViewById( android.R.id.text1 ) ).setText("");
                    ( (TextView)vista.findViewById( android.R.id.text1 ) ).setHint( getItem( getCount() ) );
                }
                return vista;
            }

            public int getCount(){
                return super.getCount() - 1;
            }
        };

        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        adapter.add( "Guatemala" );
        adapter.add( "El Salvador" );
        adapter.add( "Honduras" );
        adapter.add( "Nicaragua" );
        adapter.add( "Costa Rica" );
        adapter.add( "Panama" );
        adapter.add( "Seleccione un pais" );        // Este es el elemento a quitar del Spinner
        spPais.setAdapter( adapter );
        spPais.setSelection( adapter.getCount() );
    }

    public void Almacenar( View v ){

        String datos = "", genero = "";
        String nombres = etNombres.getText().toString(),
                apellidos = etApellidos.getText().toString();

        /* Para setear por defecto un checkbox, se realiza con la propiedad checkedButton
        * desde la interfaz gráfica */
        if ( rbFemeni.isChecked() == false && rbMascu.isChecked() == false && rbOtro.isChecked() == false ){
            genero = "Por favor, Seleccione un genero";
        } else if ( rbFemeni.isChecked() == true ) {
            genero = "Femenino";
        } else if ( rbMascu.isChecked() == true ) {
            genero = "Masculino";
        }else if ( rbOtro.isChecked() == true ) {
            genero = "Otros";
        }
        String seleccion = spPais.getSelectedItem().toString();
        if ( seleccion.equals( "Seleccione un pais..." ) ){
            datos  = "No selecciono nigún país";
        }else if( seleccion.equals( "Guatemala" ) ){
            datos = "Guatemala";
        }else if( seleccion.equals( "El Salvador" ) ){
            datos = "El Salvador";
        } else if ( seleccion.equals( "Honduras" ) ) {
            datos = "Honduras";
        } else if ( seleccion.equals( "Nicaragua" ) ) {
            datos = "Nicaragua";
        } else if ( seleccion.equals( "Costa Rica" ) ) {
            datos = "Costa Rica";
        } else if ( seleccion.equals( "Panama" ) ) {
            datos = "Panama";
        }

        // etInfo.setText( "" );
        if ( genero.equals("Por favor, Seleccione un genero") ){
            etInfo.setText( "" );
            Toast mensajeGeneroError = Toast.makeText( this, "Seleccione un genero 👌", Toast.LENGTH_LONG );
            mensajeGeneroError.show();
        }else{
            etInfo.setText( "" );
            etInfo.append( "Nombres: " + nombres + "\n" +
                    "Apellidos: " + apellidos + "\n" +
                    "Sexo seleccionado:" + genero + "\n" +
                    "Pais seleccionado: " + String.valueOf( datos ) );
        }
    }
}