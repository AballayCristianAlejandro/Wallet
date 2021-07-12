package com.example.wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Detalle_tarjeta extends AppCompatActivity {

    private TextView txtNumero;
    private TextView txtNombre;
    private TextView txtFechaExpiracion ;
    private String NumeroTarjeta,FechaExpiracion,NombreTrajeta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_tarjeta);
        setupInicializacion();
        asignarDatos();
    }

    private void setupInicializacion(){



        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
             NumeroTarjeta = bundle.getString("NumeroTarjerta","");
             FechaExpiracion = bundle.getString("FechaExpiacion","");
             NombreTrajeta = bundle.getString("NombreTarjeta","");
        }
        txtNumero = findViewById(R.id.txtNumero);
        txtNombre= findViewById(R.id.txtNombre);
        txtFechaExpiracion= findViewById(R.id.txtFechaExpiracion);

    }

    public void asignarDatos(){
        txtNumero.setText(NumeroTarjeta);
        txtNombre.setText(NombreTrajeta);
        txtFechaExpiracion.setText(FechaExpiracion);
    }
}