package com.vuelos.good.entity.usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario_data")
public class UsuarioData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usu_data")
    private Long idUsuData;

    @Column(name = "usu_name")
    private String usuName;

    @Column(name = "usu_lastname")
    private String usuLastname;

    @Column(name = "usu_documento")
    private String documento;

    private String email;

    private String password;

    private String celular;

    @Column(name = "img_usu")
    private String imgUsu;

    @Column(name = "estado_usu")
    private String estadoUsu;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_direccion")
    private Direccion idDireccion;

    @OneToOne(mappedBy = "idUsuarioData" )
    @JsonIgnoreProperties("idUsuarioData")
    private Usuarios usuario;

    public UsuarioData() {
    }

    public UsuarioData(Long idUsuData, String usuName, String usuLastname, String documento, String email, String password, String celular, String imgUsu, String estadoUsu, Direccion idDireccion, Usuarios usuario) {
        this.idUsuData = idUsuData;
        this.usuName = usuName;
        this.usuLastname = usuLastname;
        this.documento = documento;
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

    public String getUsuName() {
        return usuName;
    }

    public void setUsuName(String usuName) {
        this.usuName = usuName;
    }

    public String getUsuLastname() {
        return usuLastname;
    }

    public void setUsuLastname(String usuLastname) {
        this.usuLastname = usuLastname;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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
