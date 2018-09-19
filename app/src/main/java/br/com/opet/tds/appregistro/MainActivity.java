package br.com.opet.tds.appregistro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private List<Artista> artistas;
    private EditText editNome;
    private Spinner spinnerGenero;
    private ListView listArtista;
    private ArrayAdapter<Artista> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        artistas = new ArrayList<>();
        editNome = findViewById(R.id.editNome);
        spinnerGenero = findViewById(R.id.spinnerGenero);
        listArtista = findViewById(R.id.listArtista);

        adapter = new ArtistaAdapter (getApplicationContext(),R.layout.artista_item,artistas);
        listArtista.setAdapter(adapter);
    }

    public void salvarArtista(View v){
        String nome = editNome.getText().toString();
        String genero = spinnerGenero.getSelectedItem().toString();
        Artista a = new Artista();
        a.setNome(nome);
        a.setGenero(genero);

        artistas.add(a);
        adapter.notifyDataSetChanged();
    }
}
