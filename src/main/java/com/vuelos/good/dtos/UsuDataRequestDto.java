package com.vuelos.good.dtos;
public class UsuDataRequestDto {

    private String usuName;
    private String usuLastname;
    private String documento;
    private String email;
    private String password;
    private String celular;
    private String imgUsu;
    private String estadoUsu;
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
