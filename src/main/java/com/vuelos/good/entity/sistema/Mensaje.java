package com.vuelos.good.entity.sistema;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "mensaje")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mensaje")
    private Integer idMensaje;

    @Column(unique = true)
    private String codigo;

    @Column(length = 5000)
    private String mensaje;

    private String tipo;

    @Column(name = "men_descripcion")
    private String menDescripcion;

    @Column(name = "men_created_at")
    private LocalDate menCreatedAt;

    @Column(name = "men_updated_at")
    private LocalDate menUpdatedAt;

    @Column(name = "estado_mensaje")
    private String estadoMensaje;


    public Mensaje() {
    }

    public Mensaje(Integer idMensaje, String codigo, String mensaje, String tipo, String menDescripcion, LocalDate menCreatedAt, LocalDate menUpdatedAt, String estadoMensaje) {
        this.idMensaje = idMensaje;
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.tipo = tipo;
        this.menDescripcion = menDescripcion;
        this.menCreatedAt = menCreatedAt;
        this.menUpdatedAt = menUpdatedAt;
        this.estadoMensaje = estadoMensaje;
    }

    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

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

    public LocalDate getMenCreatedAt() {
        return menCreatedAt;
    }

    public void setMenCreatedAt(LocalDate menCreatedAt) {
        this.menCreatedAt = menCreatedAt;
    }

    public LocalDate getMenUpdatedAt() {
        return menUpdatedAt;
    }

    public void setMenUpdatedAt(LocalDate menUpdatedAt) {
        this.menUpdatedAt = menUpdatedAt;
    }

    public String getEstadoMensaje() {
        return estadoMensaje;
    }

    public void setEstadoMensaje(String estadoMensaje) {
        this.estadoMensaje = estadoMensaje;
    }
}
