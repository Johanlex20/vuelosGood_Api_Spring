package com.vuelos.good.dtos.usuario;
import jakarta.validation.constraints.NotBlank;

public class DireccionDto {

    @NotBlank(message = "dir.vali.direccion.dto")
    private String direccion;
    private String codigoPostal;
    @NotBlank(message = "dir.vali.pais.dto")
    private String pais;
    @NotBlank(message = "dir.vali.ciudad.dto")
    private String ciudad;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
