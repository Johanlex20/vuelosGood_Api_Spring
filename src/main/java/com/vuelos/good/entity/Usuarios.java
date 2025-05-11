package com.vuelos.good.entity;
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

    @OneToOne
    @JoinColumn(name = "id_usuario_data", referencedColumnName = "id_usu_data")
    private UsuarioData idUsuarioData;
}
