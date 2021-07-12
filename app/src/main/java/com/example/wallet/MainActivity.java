package com.example.wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText  ed_numertarj ,ed_fechaexpi,ed_codSeguridad,ed_nombreTarj;
    private Button btn_agregar;
    private CheckBox cb_terminos_condiciones;
    private TextView tv_terminos_condiciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_numertarj = findViewById(R.id.ed_numertarj);
        ed_fechaexpi = findViewById(R.id.ed_fechexpi);
        ed_codSeguridad = findViewById(R.id.ed_codSeguridad);
        ed_nombreTarj = findViewById(R.id.ed_nombreTarjeta);
        btn_agregar= findViewById(R.id.btnAgregar);
        cb_terminos_condiciones= findViewById(R.id.cb_terminos_condiciones);
        tv_terminos_condiciones = findViewById(R.id.tv_terminos_condiciones);
        cb_terminos_condiciones.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                btn_agregar.setEnabled(isChecked);
            }
        });
        tv_terminos_condiciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                terminosCondiciones();
            }
        });
        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    login();
                    finish();
            }
        });
    }
     private void terminosCondiciones(){
         Intent intent = new Intent(this,Terminos_Condiciones.class);
         startActivity(intent);
     }
    private void login(){
        String numertarj = ed_numertarj.getText().toString();
        String fechaexpi = ed_fechaexpi.getText().toString();
        String codSeguridad = ed_codSeguridad.getText().toString();
        String nombreTarj = ed_nombreTarj.getText().toString();

        if(numeroTrajeta() && fecha_expiracion()&& codigoDeSeguridad()&& nombreTrajeta() ){

            Intent intent = new Intent(this,HomeActivity.class);
            intent.putExtra("NumeroTarjeta",numertarj);
            intent.putExtra("FechaExpiacion",fechaexpi);
            intent.putExtra("CodigoSeguridad",codSeguridad);
            intent.putExtra("NombreTarjeta",nombreTarj);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Los campos ingresadsos no son validos",Toast.LENGTH_LONG).show();
        }
    }

    private boolean numeroTrajeta(){

        return ed_numertarj.getText().toString().length()==12;
    }
    private boolean fecha_expiracion(){

        return ed_fechaexpi.getText().toString().length()==5;
    }
    private boolean codigoDeSeguridad(){

        return ed_codSeguridad.getText().toString().length()==3;
    }
    private boolean nombreTrajeta(){

        return ed_nombreTarj.getText().toString().length()>5;
    }
}