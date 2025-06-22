package com.vuelos.good.entity.usuario;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;

    private String rol;

    private String descripcion;

    @Column(name = "estado_rol")
    private String estadoRol;

    @Column(name = "rol_created_at")
    private LocalDate rolCreatedAt;

    @Column(name = "rol_update_at")
    private LocalDate rolUpdateAt;

    @Column(name = "id_permiso")
    private String idPermiso;

    public Rol() {
    }

    public Rol(Integer idRol, String rol, String descripcion, String estadoRol, LocalDate rolCreatedAt, LocalDate rolUpdateAt, String idPermiso) {
        this.idRol = idRol;
        this.rol = rol;
        this.descripcion = descripcion;
        this.estadoRol = estadoRol;
        this.rolCreatedAt = rolCreatedAt;
        this.rolUpdateAt = rolUpdateAt;
        this.idPermiso = idPermiso;
    }

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

    public LocalDate getRolCreatedAt() {
        return rolCreatedAt;
    }

    public void setRolCreatedAt(LocalDate rolCreatedAt) {
        this.rolCreatedAt = rolCreatedAt;
    }

    public LocalDate getRolUpdateAt() {
        return rolUpdateAt;
    }

    public void setRolUpdateAt(LocalDate rolUpdateAt) {
        this.rolUpdateAt = rolUpdateAt;
    }

    public String getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(String idPermiso) {
        this.idPermiso = idPermiso;
    }
}
