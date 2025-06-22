package com.vuelos.good.dtos.usuario;
import jakarta.validation.Valid;
import java.time.LocalDate;

public class UsuRequestDto {

    private Integer idUsuario;
    private LocalDate usuCreatedAt;
    private LocalDate usuUpdateAt;
    @Valid
    private RolRequestDto rolDto;
    @Valid
    private UsuDataRequestDto usuarioDataDto;

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

    public RolRequestDto getRolDto() {
        return rolDto;
    }

    public void setRolDto(RolRequestDto rolDto) {
        this.rolDto = rolDto;
    }

    public UsuDataRequestDto getUsuarioDataDto() {
        return usuarioDataDto;
    }

    public void setUsuarioDataDto(UsuDataRequestDto usuarioDataDto) {
        this.usuarioDataDto = usuarioDataDto;
    }
}
