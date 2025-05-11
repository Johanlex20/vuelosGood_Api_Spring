package com.vuelos.good.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Integer idDireccion;

    private String direccion;

    @Column(name = "codigo_postal")
    private String codigoPostal;

    private String pais;

    private String ciudad;

}
