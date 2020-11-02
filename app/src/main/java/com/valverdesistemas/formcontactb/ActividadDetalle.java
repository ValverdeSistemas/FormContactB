package com.valverdesistemas.formcontactb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Date;


public class ActividadDetalle extends AppCompatActivity {
    private static String EXTRA_MESSAGE;

    TextView lblnombre;
    TextView lblFecha;
    TextView lblTelefono;
    TextView lblEmail;
    TextView lblDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_detalle);

        lblnombre       = (TextView) findViewById(R.id.lblNombre);
        lblFecha        = (TextView) findViewById(R.id.lblFecha);
        lblTelefono     = (TextView) findViewById(R.id.telefono);
        lblEmail        = (TextView) findViewById(R.id.email);
        lblDescripcion  = (TextView) findViewById(R.id.descripcion);

        Bundle miBundle = this.getIntent().getExtras();

        if(miBundle != null){
            String nombre = miBundle.getString("nombre");
            lblnombre.setText("Nombre: " + nombre);
            String strFecha = miBundle.getString("fecha");
            lblFecha.setText(strFecha);
            String strTelefono = miBundle.getString("telefono");
            lblTelefono.setText(strTelefono);
            String strEmail = miBundle.getString("email");
            lblEmail.setText(strEmail);
            String strDescripcion = miBundle.getString("descripcion");
            lblDescripcion.setText(strDescripcion);

        }

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(ActividadDetalle.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
       // TextView textView = findViewById(R.id.lblNombre);
        //textView.setText(message);
    }

    public void evento(View view){
      // Intent intent = new Intent(this, ActividadPrincipal.class);
       // startActivity(intent);
        finish();
    }
}
