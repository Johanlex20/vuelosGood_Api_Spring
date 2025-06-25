package com.vuelos.good.dtos.usuario;
import jakarta.validation.constraints.NotNull;

public class RolRequestDto {
    //@NotNull(message = "rol.vali.dto")
    private Integer idRol;

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
}
