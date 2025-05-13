package com.vuelos.good.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario_data")
public class UsuarioData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usu_data")
    private Long idUsuData;

    private String usu_name;

    private String usu_lastname;

    private String email;

    private String password;

    private String celular;

    @Column(name = "img_usu")
    private String imgUsu;

    @Column(name = "estado_usu")
    private String estadoUsu;

    @ManyToOne
    @JoinColumn(name = "id_direccion")
    private Direccion idDireccion;

    @OneToOne(mappedBy = "idUsuarioData")
    private Usuarios usuario;

    public UsuarioData() {
    }
    public UsuarioData(Long idUsuData, String usu_name, String usu_lastname, String email, String password, String celular, String imgUsu, String estadoUsu, Direccion idDireccion, Usuarios usuario) {
        this.idUsuData = idUsuData;
        this.usu_name = usu_name;
        this.usu_lastname = usu_lastname;
        this.email = email;
        this.password = password;
        this.celular = celular;
        this.imgUsu = imgUsu;
        this.estadoUsu = estadoUsu;
        this.idDireccion = idDireccion;
        this.usuario = usuario;
    }

    public Long getIdUsuData() {
        return idUsuData;
    }

    public void setIdUsuData(Long idUsuData) {
        this.idUsuData = idUsuData;
    }

    public String getUsu_name() {
        return usu_name;
    }

    public void setUsu_name(String usu_name) {
        this.usu_name = usu_name;
    }

    public String getUsu_lastname() {
        return usu_lastname;
    }

    public void setUsu_lastname(String usu_lastname) {
        this.usu_lastname = usu_lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getImgUsu() {
        return imgUsu;
    }

    public void setImgUsu(String imgUsu) {
        this.imgUsu = imgUsu;
    }

    public String getEstadoUsu() {
        return estadoUsu;
    }

    public void setEstadoUsu(String estadoUsu) {
        this.estadoUsu = estadoUsu;
    }

    public Direccion getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Direccion idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
