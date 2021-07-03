package com.alexdim.pacienar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ContentInfoCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    private View txtError;
    private EditText plCorreo;
    private EditText plContra;
    private Button btnIngresar;
    private Button btnRegistrar;

    //private int id;
    private String usuario;
    private String contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        //id = intent.getIntExtra("EXTRA_IDREGISTRO",0);
        usuario = intent.getStringExtra("EXTRA_USUARIO");
        contra = intent.getStringExtra("EXTRA_CONTRA");
/*
        //asigno datos recibidos de registro
        if(usuario!="" && contra != ""){
            plCorreo.setText(usuario);
            plContra.setText(contra.);
        }*/

        txtError = findViewById(R.id.txtLoginError);

        plCorreo = findViewById(R.id.plLoginCorreo);
        plContra = findViewById(R.id.plLoginContra);

        btnIngresar = findViewById(R.id.btnLoginIngresar);
        btnRegistrar = findViewById(R.id.btnLoginRegistrarse);


        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registro();
            }
        });
    }

    private void registro() {
        Intent intent = new Intent(Main.this,Registro.class);

        startActivity(intent);
    }

    private void login() {
        //verificar usuario y contraseña

        String usuario=plCorreo.getText().toString();
        String contra=plContra.getText().toString();

        if (!(usuario.equals("") && !contra.equals("")))
        {
            if (usuario.equals("alumno") && contra.equals("123456")){
                Intent intent = new Intent(Main.this,Inicio.class);

                intent.putExtra("EXTRA_USUARIO",usuario);

                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Datos Incorrectos",Toast.LENGTH_LONG).show();
                txtError.setVisibility(View.VISIBLE);
            }
        }

    }
}