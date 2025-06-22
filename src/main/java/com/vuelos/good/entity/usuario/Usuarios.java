package com.vuelos.good.entity.usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "usu_created_at")
    private LocalDate usuCreatedAt;

    @Column(name = "usu_update_at")
    private LocalDate usuUpdateAt;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_usuario_data", referencedColumnName = "id_usu_data")
    @JsonIgnoreProperties("usuario")
    private UsuarioData idUsuarioData;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario, LocalDate usuCreatedAt, LocalDate usuUpdateAt, Rol rol, UsuarioData idUsuarioData) {
        this.idUsuario = idUsuario;
        this.usuCreatedAt = usuCreatedAt;
        this.usuUpdateAt = usuUpdateAt;
        this.rol = rol;
        this.idUsuarioData = idUsuarioData;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getUsuCreatedAt() {
        return usuCreatedAt;
    }

    public void setUsuCreatedAt(LocalDate usuCreatedAt) {
        this.usuCreatedAt = usuCreatedAt;
    }

    public LocalDate getUsuUpdateAt() {
        return usuUpdateAt;
    }

    public void setUsuUpdateAt(LocalDate usuUpdateAt) {
        this.usuUpdateAt = usuUpdateAt;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public UsuarioData getIdUsuarioData() {
        return idUsuarioData;
    }

    public void setIdUsuarioData(UsuarioData idUsuarioData) {
        this.idUsuarioData = idUsuarioData;
    }
}
