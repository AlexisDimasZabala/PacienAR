package com.alexdim.pacienar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Inicio extends AppCompatActivity {

    private Button btnInicioCorreo;
    private Button btnInicioLlamada;
    private Button btnInicioGithub;
    private Button btnInicioCerrarSesion;

    private String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btnInicioCorreo = findViewById(R.id.btnInicioIrCorreo);
        btnInicioLlamada = findViewById(R.id.btnInicioIrLlamada);
        btnInicioGithub = findViewById(R.id.btnInicioIrGithub);
        btnInicioCerrarSesion = findViewById(R.id.btnInicioCerrarSesion);

        Intent intent = getIntent();
        usuario = intent.getStringExtra("EXTRA_USUARIO");

        btnInicioCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Inicio.this,Main.class);
                startActivity(intent);
            }
        });

        btnInicioGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://github.com/AlexisDimasZabala";

                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btnInicioCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destinatarios = {"angry@hotmail.com","angry2_dimas@hotmail.com","angry3_dimas@hotmail.com"};
                enviarEmail(destinatarios,"Consultas de programa");
            }
        });

        btnInicioLlamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "2954555555";

                Intent intent = new Intent(Intent.ACTION_DIAL);

                intent.setData(Uri.parse("tel:" + phoneNumber));

                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
            }
        });
    }

    public void enviarEmail(String[] correo, String asunto){
        SharedPreferences sharedPref = getSharedPreferences("nombreCompleto", Context.MODE_PRIVATE);
        String nombreCompleto = sharedPref.getString("nombreCompleto","");

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, correo);
        intent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        intent.putExtra(Intent.EXTRA_TEXT, "Hola buen dia, soy "+ usuario +" .Estimado programador, me comunico..." + nombreCompleto);

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
}