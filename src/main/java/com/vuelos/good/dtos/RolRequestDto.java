package com.vuelos.good.dtos;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class RolRequestDto {

    private Integer idRol;

    @NotEmpty(message = "Rol es necesario!")
    @Size(max = 3, message = "Rol puede tener maximo 3 caracteres!")
    private String rol;

    @NotEmpty(message = "Descripcion es necesaria!")
    private String descripcion;
    @NotEmpty(message = "Estado del Rol es necesario!")
    private String estadoRol;

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstadoRol() {
        return estadoRol;
    }

    public void setEstadoRol(String estadoRol) {
        this.estadoRol = estadoRol;
    }

    public String getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(String idPermiso) {
        this.idPermiso = idPermiso;
    }

    private String idPermiso;
}
