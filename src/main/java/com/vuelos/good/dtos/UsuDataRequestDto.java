package com.vuelos.good.dtos;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class UsuDataRequestDto {

    @NotNull
    @Size(min = 3, message = "Nombre debe tener almenos 3 caracteres!")
    @Size(max = 100, message = "Nombre debe tener maximo 100 caracteres!")
    private String usuName;
    @NotNull
    @Size(min = 3, message = "Apellido debe tener almenos 3 caracteres!")
    @Size(max = 100, message = "Apellido debe tener maximo 100 caracteres!")
    private String usuLastname;
    @NotNull
    private String documento;
    @NotNull
    @Email
    private String email;
    @NotEmpty
    @Pattern(regexp = "[a-z0-9-]+")
    @Size(min = 5, message = "La contraseña debe tener al menos 5 caracteres!")
    private String password;
    @Pattern(regexp = "[0-9]+")
    @Size(min = 10, max = 10, message = "Celular debe tener 10 numeros!")
    private String celular;
    @NotEmpty
    private String imgUsu;
    @NotEmpty
    private String estadoUsu;

    @Valid
    @NotNull(message = "La dirección no puede ser nula")
    private DireccionRequestDto direccionRequestDto;

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

    public DireccionRequestDto getDireccionRequestDto() {
        return direccionRequestDto;
    }

    public void setDireccionRequestDto(DireccionRequestDto direccionRequestDto) {
        this.direccionRequestDto = direccionRequestDto;
    }
}
