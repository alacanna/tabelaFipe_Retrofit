package br.com.tabelafipe.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.tabelafipe.domain.Marca;
import br.com.tabelafipe.domain.Veiculo;

/**
 * Created by amandalacanna on 14/04/16.
 */
public class SpinnerVeiculoAdapter extends ArrayAdapter<Veiculo> {

    private Context context;
    private List<Veiculo> veiculos;

    public SpinnerVeiculoAdapter(Context context, int textViewResourceId,
                                 List<Veiculo> veiculos) {
        super(context, textViewResourceId, veiculos);
        this.context = context;
        this.veiculos = veiculos;
    }

    public int getCount(){
        return veiculos.size();
    }

    public Veiculo getItem(int position){
        return veiculos.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setTextColor(Color.BLACK);
        label.setText(veiculos.get(position).getFipeName());
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = new TextView(context);
        label.setTextColor(Color.BLACK);
        label.setText(veiculos.get(position).getFipeName());
        return label;
    }
}