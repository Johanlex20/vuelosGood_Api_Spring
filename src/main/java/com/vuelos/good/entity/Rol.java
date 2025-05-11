package com.vuelos.good.entity;
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

}
