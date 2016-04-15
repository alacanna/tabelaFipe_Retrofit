package br.com.tabelafipe.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.tabelafipe.domain.Marca;

/**
 * Created by amandalacanna on 14/04/16.
 */
public class SpinnerMarcaAdapter extends ArrayAdapter<Marca> {

    private Context context;
    private List<Marca> marcas;

    public SpinnerMarcaAdapter(Context context, int textViewResourceId,
                               List<Marca> marcas) {
        super(context, textViewResourceId, marcas);
        this.context = context;
        this.marcas = marcas;
    }

    public int getCount(){
        return marcas.size();
    }

    public Marca getItem(int position){
        return marcas.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setTextColor(Color.BLACK);
        label.setText(marcas.get(position).getFipeName());
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = new TextView(context);
        label.setTextColor(Color.BLACK);
        label.setText(marcas.get(position).getFipeName());
        return label;
    }
}