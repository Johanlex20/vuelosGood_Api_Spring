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

    //Construtor basio
    public Direccion() {
    }

    //Constructor lleno
    public Direccion(Integer idDireccion, String direccion, String codigoPostal, String pais, String ciudad) {
        this.idDireccion = idDireccion;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
        this.ciudad = ciudad;
    }

    //Getter and Setter

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion() {
        this.idDireccion = idDireccion;
    }

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
