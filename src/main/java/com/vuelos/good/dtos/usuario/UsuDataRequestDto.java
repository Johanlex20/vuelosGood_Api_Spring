package com.vuelos.good.dtos.usuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class UsuDataRequestDto {

    @NotBlank(message = "usu.vali.nombre.dto")
    @Size(min = 3, message = "usu.vali.min.nombre.dto")
    @Size(max = 100, message = "usu.vali.max.nombre.dto")
    private String usuName;

    @NotBlank(message = "usu.vali.apellido.dto")
    @Size(min = 3, message = "usu.vali.min.apellido.dto")
    @Size(max = 100, message = "usu.vali.max.apellido.dto")
    private String usuLastname;
    @NotBlank(message = "usu.vali.documento.dto")
    private String documento;
    @NotNull(message = "usu.vali.email.dto")
    @Email(message = "usu.vali.email.formato.dto")
    private String email;
    @NotEmpty(message = "usu.vali.password.dto")
    @Pattern(regexp = "[a-z0-9-]+")
    @Size(min = 5, message = "usu.vali.min.password.dto")
    private String password;
    @Pattern(regexp = "[0-9]+")
    @NotEmpty(message = "usu.vali.celular.dto")
    @Size(min = 10, max = 10, message = "usu.vali.min.celular.dto")
    private String celular;
    @NotEmpty(message = "usu.vali.img.dto")
    private String imgUsu;
    @NotEmpty(message = "usu.vali.estado.dto")
    private String estadoUsu;

    @Valid
    @NotNull(message = "usu.vali.direccion.dto")
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
