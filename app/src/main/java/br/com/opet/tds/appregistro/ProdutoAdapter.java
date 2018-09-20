package br.com.opet.tds.appregistro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Diego on 19/09/2018.
 */

public class ProdutoAdapter extends ArrayAdapter<Produto> {
    private int rId;

    public ProdutoAdapter(Context context, int resource, List<Produto> objects) {
        super(context, resource, objects);
        this.rId = resource;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent){
        View mView = currentView;

        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rId,null);
        }

        Produto produto = getItem(position);

        if(produto.getQuantidade() < 10){
            TextView textNome = mView.findViewById(R.id.textNome);
            TextView textQuant = mView.findViewById(R.id.textQuant);
            TextView textCategoria = mView.findViewById(R.id.textCategoria);
            TextView textValor = mView.findViewById(R.id.textValor);
            TextView textTotal = mView.findViewById(R.id.textTotal);

            textNome.setText(produto.getNome());
            textCategoria.setText(produto.getCategoria());
            textQuant.setText(produto.getQuantidade()+"");
            textValor.setText(produto.getValor()+"");
            textTotal.setText("Valor Total: "+ produto.getQuantidade() * produto.getValor() );
        }

        return mView;
    }
}
