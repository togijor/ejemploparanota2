package com.example.testappexamen2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class mostrardatos extends AppCompatActivity {

    private TextInputLayout tilBuscar;
    private ListView ltvnombres;
    private Button btnFiltrar;

    private ArrayAdapter<Tarea> adaptadorTareaLista;

    private ArrayList<Tarea> ListaTareas, agregarlista;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrardatos);

        referencia();
        obteneDatos();
        eventos();


        adaptadorTareaLista = new ArrayAdapter<Tarea>(this, android.R.layout.simple_list_item_1, ListaTareas);
        ltvnombres.setAdapter(adaptadorTareaLista);
    }

    private void eventos() {
        btnFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dato = tilBuscar.getEditText().getText().toString();

            }
        });
        ltvnombres.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long l) {
                ListaTareas.remove(pos);
                adaptadorTareaLista.notifyDataSetChanged();
                return false;
            }
        });

    }

    private void obteneDatos() {
        ListaTareas = new ArrayList<Tarea>();



       /* for(int x = 1; x <= 25; ++x){
            Tarea i = new Tarea();
            i.setTitulo("Titulo " + x);
            i.setDescripcion("Descripcion " + x);
            ListaTareas.add(i);
        }

        */
        //agregar esto para prueba de datos

            String titulo = getIntent().getExtras().getString("datoTitulo");
            String descripcion = getIntent().getExtras().getString("datoDescripcion");
            Tarea t = new Tarea();
            t.setTitulo(titulo);
            t.setDescripcion(descripcion);
            ListaTareas.add(t);





    }

    private void referencia() {

        ltvnombres = findViewById(R.id.ltvnombres);
        tilBuscar = findViewById(R.id.tilBuscar);
        btnFiltrar = findViewById(R.id.btnFiltrar);

        ListaTareas = new ArrayList<Tarea>();

    }
}