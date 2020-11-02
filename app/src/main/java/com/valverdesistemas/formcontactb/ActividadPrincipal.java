package com.valverdesistemas.formcontactb;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

public class ActividadPrincipal extends AppCompatActivity {

    EditText strNombre;
    TextView etiNombre;
    //DatePicker dateFecha;
    DatePickerDialog picker;
    EditText edtFecha;
    Button btnGet;
    TextView tvw;
    EditText edtTelefono;
    EditText edtEmail;
    EditText edtDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);

        strNombre       = (EditText) findViewById(R.id.edtTxtNombre);
        etiNombre       = (TextView) findViewById(R.id.etiNombre);

        tvw             = (TextView) findViewById(R.id.textView1);
        edtFecha        = (EditText) findViewById(R.id.edtFecha);
        edtFecha.setInputType(InputType.TYPE_NULL);
        edtFecha.setText("");
        edtTelefono     = (EditText) findViewById(R.id.telefono);
        edtEmail        = (EditText) findViewById(R.id.email);
        edtDescripcion  = (EditText) findViewById(R.id.descripcion);

        edtFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(ActividadPrincipal.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                edtFecha.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        btnGet=(Button)findViewById(R.id.button1);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvw.setText("Selected Date: "+ edtFecha.getText());
            }
        });
      //  dateFecha = (DatePicker) findViewById(R.id.fecha);
       // Intent intent = new Intent(ActividadPrincipal.this, ActividadDetalle.class);
        // startActivity(intent);
    }


    public void funcNext(View v){
        EditText nombre = (EditText) findViewById(R.id.nombre);
        Log.d("Nombre: ", nombre.getText().toString());
    }

    //public void onClick(View view){
    //    Intent miIntent = new Intent(ActividadPrincipal.this, ActividadDetalle.class);
    //   startActivity(miIntent);
    //}
    public void evento(View view){
        switch (view.getId()){
            case R.id.btnProbar:
                String txtNombre = strNombre.getText().toString();
                etiNombre.setText("Bienvenido : " + txtNombre);
                break;
            case R.id.btnSiguiente:
                String sNombre          = strNombre.getText().toString();
                String dateFecha        = edtFecha.getText().toString();
                String strTelefono      = edtTelefono.getText().toString();
                String strEmail         = edtTelefono.getText().toString();
                String strDescripcion   = edtDescripcion.getText().toString();

                Intent miIntent = new Intent(ActividadPrincipal.this, ActividadDetalle.class);

                Bundle myBundle = new Bundle();
                myBundle.putString("nombre", strNombre.getText().toString());

                //myBundle.putString("fecha", dateFecha.getDayOfMonth()+"/"+ (dateFecha.getMonth() + 1)+"/"+dateFecha.getYear());
                myBundle.putString("fecha", dateFecha.toString());
                myBundle.putString("telefono", strTelefono);
                myBundle.putString("email", strEmail);
                myBundle.putString("descripcion", strDescripcion);
                miIntent.putExtras(myBundle);
                etiNombre.setText("Bienvenido : " + sNombre + ", en fecha: " + dateFecha.toString());

                startActivity(miIntent);
                break;
            case R.id.btnFin:
                finish();
                break;
        }
    }
}