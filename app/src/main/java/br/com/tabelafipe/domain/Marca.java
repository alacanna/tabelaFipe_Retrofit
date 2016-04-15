package br.com.tabelafipe.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amandalacanna on 14/04/16.
 */
public class Marca {

    @SerializedName("key")
    private String key;

    @SerializedName("id")
    private Long idMarca;

    @SerializedName("fipe_name")
    private String fipeName;

    @SerializedName("name")
    private String name;

    public Marca() {
    }

    public Marca(String key, Long idMarca, String fipeName, String name) {
        this.key = key;
        this.idMarca = idMarca;
        this.fipeName = fipeName;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
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
