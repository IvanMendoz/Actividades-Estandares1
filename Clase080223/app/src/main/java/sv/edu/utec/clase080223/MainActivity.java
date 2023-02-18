package sv.edu.utec.clase080223;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

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
        spPais = findViewById( R.id.spnPais );
        etNombres = findViewById( R.id.edtNombres );
        etApellidos = findViewById( R.id.edtApellidos );
        etInfo = findViewById( R.id.edtMDatos );
        rbMascu = findViewById( R.id.rbMasculino );
        rbFemeni = findViewById( R.id.rbFemenino );
        rbOtro = findViewById( R.id.rbOtros );

        String[] opciones = { "Seleccione un pais...", "Guatemala", "El Salvador", "Honduras", "Nicaragua", "Costa Rica", "Panama" };
        ArrayAdapter< String > adapter = new ArrayAdapter< String >( this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, opciones );

        spPais.setAdapter( adapter );
    }

    public void Almacenar( View v ){

        etInfo.setText( "" );
        String datos = "";
        String seleccion = spPais.getSelectedItem().toString();
        if ( seleccion.equals( "Seleccione un pais..." ) ){
            datos  = "No selecciono nigún país";
        }else if( seleccion.equals( "Guatemala" ) ){
            datos = "Guatemala";
        }else if( seleccion.equals( "El Salvador" ) ){
            datos = "El Salvador";
        }

        etInfo.append( String.valueOf( datos ) );
    }
}