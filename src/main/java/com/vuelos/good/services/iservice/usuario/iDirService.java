package com.vuelos.good.services.iservice.usuario;
import com.vuelos.good.dtos.usuario.DireccionDto;
import com.vuelos.good.entity.usuario.Direccion;

public interface iDirService {
    Direccion saveDireccion(DireccionDto dirDto);
}
