package br.com.tabelafipe.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import br.com.tabelafipe.R;
import br.com.tabelafipe.domain.Marca;
import br.com.tabelafipe.domain.Veiculo;
import br.com.tabelafipe.repository.Repository;
import br.com.tabelafipe.repository.ServiceGenerator;
import br.com.tabelafipe.ui.adapter.SpinnerMarcaAdapter;
import br.com.tabelafipe.ui.adapter.SpinnerVeiculoAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.spnMarca)Spinner spnMarca;
    @Bind(R.id.spnVeiculo)Spinner spnVeiculo;

    @Bind(R.id.progress)ProgressBar progressBar;

    private Marca marcaSelecionada;
    private Veiculo veiculoSelecionado;

    private Call<List<Marca>> call;
    private Call<List<Veiculo>> callVeiculo;

    private Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        repository = ServiceGenerator.createService(Repository.class);

        progressBar.setVisibility(View.VISIBLE);
        call = repository.getMarca();
        call.enqueue(new Callback<List<Marca>>() {
            @Override
            public void onResponse(Call<List<Marca>> call, Response<List<Marca>> response) {
                progressBar.setVisibility(View.GONE);
                if(response.isSuccessful()){
                    if (!call.isCanceled()) {
                        SpinnerMarcaAdapter marcaAdapter = new SpinnerMarcaAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, response.body());
                        marcaAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                        spnMarca.setAdapter(marcaAdapter);
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Ocorreu um erro", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Marca>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Ocorreu um erro de conexão", Toast.LENGTH_LONG).show();
            }
        });
    }


    @OnItemSelected(R.id.spnMarca) void selecionaMarca(int position){
        marcaSelecionada = ((Marca) spnMarca.getItemAtPosition(position));
        Toast.makeText(MainActivity.this, "Marca selecionada: "+ marcaSelecionada.getFipeName(), Toast.LENGTH_LONG).show();

        progressBar.setVisibility(View.VISIBLE);
        callVeiculo = repository.getVeiculos(String.format("%s.json", marcaSelecionada.getIdMarca()));
        callVeiculo.enqueue(new Callback<List<Veiculo>>() {
            @Override
            public void onResponse(Call<List<Veiculo>> call, Response<List<Veiculo>> response) {
                progressBar.setVisibility(View.GONE);

                if(response.isSuccessful()){
                    if (!callVeiculo.isCanceled()) {
                        SpinnerVeiculoAdapter veiculoAdapter = new SpinnerVeiculoAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, response.body());
                        veiculoAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                        spnVeiculo.setAdapter(veiculoAdapter);
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Ocorreu um erro", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Veiculo>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Ocorreu um erro de conexão", Toast.LENGTH_LONG).show();
            }
        });

    }

    @OnItemSelected(R.id.spnVeiculo) void selecionaVeiculo(int position) {
        veiculoSelecionado = ((Veiculo) spnVeiculo.getItemAtPosition(position));
        Toast.makeText(MainActivity.this, "Veiculo selecionado: " + veiculoSelecionado.getFipeName(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(call != null)
            call.cancel();

        if(callVeiculo != null)
            callVeiculo.cancel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
