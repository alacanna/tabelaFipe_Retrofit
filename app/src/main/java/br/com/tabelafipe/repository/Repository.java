package br.com.tabelafipe.repository;

import java.util.List;

import br.com.tabelafipe.domain.Marca;
import br.com.tabelafipe.domain.Veiculo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by amandalacanna on 14/04/16.
 */
public interface Repository {
    @GET("carros/marcas.json")
    Call<List<Marca>> getMarca();

    @GET("carros/veiculos/{idVeiculo}")
    Call<List<Veiculo>> getVeiculos(@Path("idVeiculo") String strIdVeiculo);
}
