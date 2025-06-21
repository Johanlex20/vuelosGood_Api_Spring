package com.vuelos.good.dtos;
import jakarta.validation.constraints.NotBlank;

public class DireccionRequestDto {

    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;
    private String codigoPostal;
    @NotBlank(message = "El país es obligatorio")
    private String pais;
    @NotBlank(message = "La ciudad es obligatoria")
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
