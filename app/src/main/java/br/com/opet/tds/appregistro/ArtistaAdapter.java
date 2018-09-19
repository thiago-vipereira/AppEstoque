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

public class ArtistaAdapter extends ArrayAdapter<Artista> {
    private int rId;

    public ArtistaAdapter(Context context, int resource, List<Artista> objects) {
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

        Artista artista = getItem(position);

        TextView textNome = mView.findViewById(R.id.textNome);
        TextView textGenero = mView.findViewById(R.id.textGenero);

        textNome.setText(artista.getNome());
        textGenero.setText(artista.getGenero());

        return mView;
    }
}
