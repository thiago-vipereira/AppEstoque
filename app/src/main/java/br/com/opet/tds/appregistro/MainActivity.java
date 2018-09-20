package br.com.opet.tds.appregistro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends Activity {

    private List<Filme> filmes;
    private EditText editFilme;
    private EditText editGenero;
    private EditText editNota;
    private ListView listFilmes;
    private ArrayAdapter<Filme> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filmes = new ArrayList<>();
        editFilme = findViewById(R.id.editFilme);
        editGenero = findViewById(R.id.editGenero);
        editNota = findViewById(R.id.editNota);
        listFilmes = findViewById(R.id.listFilme);
        atualizarFilmes();
    }

    private void atualizarFilmes(){
        if(adapter == null) {
            adapter = new FilmeAdapter(getApplicationContext(), R.layout.filme_item, filmes);
            listFilmes.setAdapter(adapter);
        }else{
            adapter.notifyDataSetChanged();
        }
    }

    public void salvarFilme(View v){
        String nome = editFilme.getText().toString();
        String genero = editGenero.getText().toString();
        int nota = Integer.parseInt(editNota.getText().toString());

        if(nota > 0 && nota <= 5){

            Filme a = new Filme();
            a.setNome(nome);
            a.setGenero(genero);
            a.setNota(nota);


            filmes.add(a);

            Collections.sort(filmes, new Comparator<Filme>() {
                @Override
                public int compare(Filme f1, Filme f2) {
                    if (f1.getNota() < f2.getNota())
                        return 1;
                    if (f1.getNota() > f2.getNota())
                        return -1;
                    return 0;
                }
            });

            while(filmes.size() > 10){
                filmes.remove(filmes.size() - 1);
            }
            atualizarFilmes();
        }
    }
}
