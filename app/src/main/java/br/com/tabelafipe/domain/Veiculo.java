package br.com.tabelafipe.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amandalacanna on 14/04/16.
 */
public class Veiculo {

    @SerializedName("key")
    private String key;

    @SerializedName("id")
    private Long idVeiculo;

    @SerializedName("fipe_name")
    private String fipeName;

    @SerializedName("name")
    private String name;

    public Veiculo() {
    }

    public Veiculo(String key, Long idVeiculo, String fipeName, String name) {
        this.key = key;
        this.idVeiculo = idVeiculo;
        this.fipeName = fipeName;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getFipeName() {
        return fipeName;
    }

    public void setFipeName(String fipeName) {
        this.fipeName = fipeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
