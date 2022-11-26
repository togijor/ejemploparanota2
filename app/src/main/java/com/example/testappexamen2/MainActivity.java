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
    private ImageButton btnBuscar;
    private ArrayList<Tarea> ListaTareas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refecrencia();
        poblararray();
        eventoBotones();
    }
    //  Llenna el array con datos aleatorios
    private void poblararray() {
        for(int x = 1; x <= 10; ++x){
            Tarea i = new Tarea();
            i.setId((int) (Math.random()*100));
            i.setTitulo("Tareas " + x);
            i.setDescripcion("Descripcion " + x);
            ListaTareas.add(i);
        }


    }

    private void eventoBotones(){
        // Funcion para Button Buscar
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //entra a la segunda pantalla
                actividadMostrardatos();
            }
        });

        //  Funcion para Botton Ingresar
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener Datos en Textlayoutinput
                String titulo = tilTitulo.getEditText().getText().toString();
                String descripcion = tilDescripcion.getEditText().getText().toString();

                // valida usuario debe ingresar titulo y descripcion
                validacion();



                // Agregar un nuevo objeto de clase Tarea
                Tarea i = new Tarea();
                i.setTitulo(titulo);
                i.setDescripcion(descripcion);
                ListaTareas.add(i);


            }
        });

        // Funcion para Botton Modificar
        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener datos en Textlayoutinput
                String titulo = tilTitulo.getEditText().getText().toString();
                String descripcion = tilDescripcion.getEditText().getText().toString();

                // valida si hay datos en titulo y descripcion
                validacion();


                boolean encontrado = false;
                // Leer todos Arraylist de Tarea
                for (int x = 0; x < ListaTareas.size(); x++ ){
                    Tarea i = ListaTareas.get(x);
                    // si encuentra titulo que usario ingresa
                    if (i.getTitulo().equals(titulo)){
                        encontrado = true;

                        // Modificar descripcion
                        i.setDescripcion(descripcion);

                        // salir leer Arraylist
                        break;
                    }
                }
                // Si no encuentra el mismo Titulo manda Toast mensaje "Tarea no existe"
                if (!encontrado){
                    Toast.makeText(MainActivity.this, "Tarea no existe", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    // valida usuario debe ingresar titulo y descripcion
    private void validacion() {
        // Obtener datos en textlayout
        String titulo = tilTitulo.getEditText().getText().toString();
        String descripcion = tilDescripcion.getEditText().getText().toString();

        // si hay un campo vacio envia un error
        if (titulo.isEmpty() || descripcion.isEmpty()){
            if(titulo.isEmpty())
                tilTitulo.setError("Debes completar este campo");
            if(descripcion.isEmpty())
                tilDescripcion.setError("Debes completar este campo");
        }
    }
    // Funcion para entra a la segunda actividad
    private void actividadMostrardatos() {
        // Obtener datos
        String titulo = tilTitulo.getEditText().getText().toString();
        String descripcion = tilDescripcion.getEditText().getText().toString();

        //Crear nuevo Intent para desde mainActividad  al segundo actividad
        Intent segundoPantalla = new Intent(getBaseContext(), mostrardatos.class);

        // envia Arraylist a la segunda actividad
        segundoPantalla.putExtra("Listatareas", ListaTareas);

        // abrir segunda actividad
        startActivity(segundoPantalla);
    }

    // refencia los widget
    private void refecrencia() {
        tilTitulo = findViewById(R.id.tilTitulo);
        tilDescripcion = findViewById(R.id.tilDescripcion);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnModificar = findViewById(R.id.btnModificar);
        btnBuscar = findViewById(R.id.ibbotton);

        ListaTareas = new ArrayList<Tarea>();

    }

}