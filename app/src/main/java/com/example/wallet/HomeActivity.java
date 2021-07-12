package com.example.wallet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

     private RecyclerView rvCard;
     private CardAdapter adapter;
     private Toolbar toolbar;
     private String txtNumero,txtNombre,txtFechaExpiracion ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        rvCard = findViewById(R.id.rvCard);
        rvCard.setLayoutManager(new LinearLayoutManager(this));
        adapter= new CardAdapter(obtenerTrajeta(), new CardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Card cards) {
                 accederDetalle();

            }
        });
        rvCard.setAdapter(adapter);
        setupToolBar();

      /*  Bundle bundle = getIntent().getExtras();
        if (bundle != null){
           String NumeroTarjeta = bundle.getString("NumeroTarjerta","");
            String FechaExpiacion = bundle.getString("FechaExpiacion","");
            String CodigoSeguridad = bundle.getString("CodigoSeguridad","");
            String NombreTrajeta = bundle.getString("NombreTarjeta","");
        }*/
        obtenerTrajeta();
    }
    private void setupToolBar(){
        toolbar = findViewById(R.id.toolBarHome);
          setSupportActionBar(toolbar);
           getSupportActionBar().setTitle("Mis Trajetas");
    }

    private List<Card> obtenerTrajeta(){
        List<Card> cards= new ArrayList<>();
        cards.add(new Card("123456789012","10/24","123","Nicolas Diaz"));
        cards.add(new Card("412391230121","02/22","351","Juan Perez"));
        cards.add(new Card("946383412490","06/23","912","Esteban Garcia"));
        return  cards;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()== R.id.nmenuAgragar){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
     public void accederDetalle(){

        Intent intent = new Intent(this,Detalle_tarjeta.class);

         intent.putExtra("NumeroTarjeta",txtNumero);//Como obtengo una los datos de una sola tarjeta ?
         intent.putExtra("FechaExpiacion",txtFechaExpiracion);
         intent.putExtra("NombreTarjeta",txtNombre);
        startActivity(intent);

     }

}