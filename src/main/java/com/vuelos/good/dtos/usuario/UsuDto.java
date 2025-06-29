package com.vuelos.good.dtos.usuario;
import jakarta.validation.Valid;
import java.time.LocalDate;

public class UsuDto {

    private Integer idUsuario;
    private LocalDate usuCreatedAt;
    private LocalDate usuUpdateAt;
    @Valid
    private RolDto rolDto;
    @Valid
    private UsuDataDto usuarioDataDto;

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

    public RolDto getRolDto() {
        return rolDto;
    }

    public void setRolDto(RolDto rolDto) {
        this.rolDto = rolDto;
    }

    public UsuDataDto getUsuarioDataDto() {
        return usuarioDataDto;
    }

    public void setUsuarioDataDto(UsuDataDto usuarioDataDto) {
        this.usuarioDataDto = usuarioDataDto;
    }
}
