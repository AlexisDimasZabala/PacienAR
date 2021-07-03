package com.alexdim.pacienar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private EditText plRegistroCorreo;
    private EditText plRegistroNombreCompleto;
    private EditText plRegistroNombreUsuario;
    private EditText plRegistroContra;
    private EditText plRegistroRepeContra;

    private Button btnRegistroLogin;
    private Button btnRegistroCompletar;

    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        plRegistroCorreo = findViewById(R.id.plRegistroCorreo);
        plRegistroNombreCompleto = findViewById(R.id.plRegistroNombreCompleto);
        plRegistroNombreUsuario = findViewById(R.id.plRegistroNombreUsuario);
        plRegistroContra = findViewById(R.id.plRegistroContra);
        plRegistroRepeContra = findViewById(R.id.plRegistroRepeContra);

        btnRegistroLogin = findViewById(R.id.btnRegistroLogin);
        btnRegistroCompletar = findViewById(R.id.btnRegistroCompletar);

        pref = getSharedPreferences("mis_pref", Context.MODE_PRIVATE);

        btnRegistroLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        btnRegistroCompletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();
            }
        });
    }

    private void registrar() {


        String usuario = plRegistroCorreo.getText().toString();
        String nombreCompleto = plRegistroNombreCompleto.getText().toString();
        String nombreUsuario = plRegistroNombreUsuario.getText().toString();
        String contra = plRegistroContra.getText().toString();
        String repeContra = plRegistroRepeContra.getText().toString();

        if (!usuario.equals("") && !nombreCompleto.equals("") && !nombreUsuario.equals("") && !contra.equals("") && !repeContra.equals("")){
            SharedPreferences.Editor editor = pref.edit();

            editor.putString("emailUsuario",usuario);
            editor.putString("nombreCompleto",nombreCompleto);
            editor.putString("nombreUsuario",nombreUsuario);
            editor.putString("contraseña",contra);

            editor.commit();


            Intent intent = new Intent(Registro.this,Main.class);

            intent.putExtra("Extra_USUARIO",nombreUsuario);
            intent.putExtra("Extra_CONTRA",contra);
            //intent.putExtra("EXTRA_IDREGISTRO",21);

            startActivity(intent);
        }
        else {
            Toast.makeText(this,"Datos Incorrectos",Toast.LENGTH_LONG).show();
        }

    }

    private void login() {
        Intent intent = new Intent(Registro.this,Main.class);

        startActivity(intent);
    }


}