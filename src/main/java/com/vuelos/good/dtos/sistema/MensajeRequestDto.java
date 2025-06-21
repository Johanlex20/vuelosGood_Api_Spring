package com.vuelos.good.dtos.sistema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class MensajeRequestDto {

    @NotBlank(message = "Codigo Mensaje es necesario!")
    private String codigo;

    @NotBlank(message = "Mensaje es necesario!")
    private String mensaje;

    @NotNull(message = "Tipo Mensaje es necesario!")
    private String tipo;

    @NotNull(message = "Descripcion Mensaje es necesaria!")
    private String menDescripcion;

    @NotEmpty(message = "Estado Mensaje es necesario")
    private String estadoMensaje;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMenDescripcion() {
        return menDescripcion;
    }

    public void setMenDescripcion(String menDescripcion) {
        this.menDescripcion = menDescripcion;
    }

    public String getEstadoMensaje() {
        return estadoMensaje;
    }

    public void setEstadoMensaje(String estadoMensaje) {
        this.estadoMensaje = estadoMensaje;
    }
}
