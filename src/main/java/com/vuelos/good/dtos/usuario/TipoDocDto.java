package com.vuelos.good.dtos.usuario;
import jakarta.validation.constraints.NotNull;

public class TipoDocDto {

    @NotNull(message = "El tipo de documento es obligatorio")
    private Integer idTipoDoc;

    public Integer getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(Integer idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

}
