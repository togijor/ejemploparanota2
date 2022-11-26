package com.example.testappexamen2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private TextInputLayout tilTitulo,tilDescripcion;
    private Button btnIngresar,btnModificar;
    private ImageButton btnbuscar;
    private ArrayList<Tarea> ListaTareas;
    public int c = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refecrencia();
        evento();
    }

    private void evento() {
        btnbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrardatos();
            }
        });
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ingreso = (int) (Math.random()*100);
                String titulo = tilTitulo.getEditText().getText().toString();
                String descripcion = tilDescripcion.getEditText().getText().toString();
                validacion();
                Tarea t = new Tarea();
                t.setId((int) (Math.random()*100));
                t.setTitulo(titulo);
                t.setDescripcion(descripcion);
                ListaTareas.add(t);



            }
        });
        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = tilTitulo.getEditText().getText().toString();
                String descripcion = tilDescripcion.getEditText().getText().toString();
                validacion();
                Toast.makeText(MainActivity.this, "Tarea no existe", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void validacion() {
        String titulo = tilTitulo.getEditText().getText().toString();
        String descripcion = tilDescripcion.getEditText().getText().toString();

        if (titulo.isEmpty() || descripcion.isEmpty()){
            if(titulo.isEmpty())
                tilTitulo.setError("Debes completar este campo");
            if(descripcion.isEmpty())
                tilDescripcion.setError("Debes completar este campo");
        }
    }

    private void mostrardatos() {
        String titulo = tilTitulo.getEditText().getText().toString();
        String descripcion = tilDescripcion.getEditText().getText().toString();

        Intent pantallaMostrar = new Intent(this, mostrardatos.class);

        pantallaMostrar.putExtra("datoTitulo", titulo);
        pantallaMostrar.putExtra("datoDescripcion", descripcion);

        startActivity(pantallaMostrar);
    }

    private void refecrencia() {
        tilTitulo = findViewById(R.id.tilTitulo);
        tilDescripcion = findViewById(R.id.tilDescripcion);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnModificar = findViewById(R.id.btnModificar);
        btnbuscar = findViewById(R.id.ibbotton);

        ListaTareas = new ArrayList<Tarea>();

    }

}