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

    private List<Produto> produtos;
    private EditText editProduto;
    private EditText editCategoria;
    private EditText editQuant;
    private EditText editValor;
    private ListView listProdutos;
    private ArrayAdapter<Produto> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        produtos = new ArrayList<>();
        editProduto = findViewById(R.id.editProduto);
        editCategoria = findViewById(R.id.editCategoria);
        editQuant = findViewById(R.id.editQuant);
        editValor = findViewById(R.id.editValor);
        listProdutos = findViewById(R.id.listFilme);
        atualizarProdutos();
    }

    private void atualizarProdutos(){
        if(adapter == null) {
            adapter = new ProdutoAdapter(getApplicationContext(), R.layout.produto_item, produtos);
            listProdutos.setAdapter(adapter);
        }else{
            adapter.notifyDataSetChanged();
        }
    }

    public void salvarProduto(View v){
        String nome = editProduto.getText().toString();
        String categoria = editCategoria.getText().toString();
        int quant = Integer.parseInt(editQuant.getText().toString());
        Double valor = Double.parseDouble(editValor.getText().toString());

        Produto a = new Produto();
        a.setNome(nome);
        a.setCategoria(categoria);
        a.setQuantidade(quant);
        a.setValor(valor);

        produtos.add(a);
        atualizarProdutos();
    }
}
