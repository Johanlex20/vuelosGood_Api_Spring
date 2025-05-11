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

}
