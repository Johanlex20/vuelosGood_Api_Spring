package com.vuelos.good.services.iservice.usuario;
import com.vuelos.good.dtos.usuario.RolDto;
import com.vuelos.good.entity.usuario.Rol;

public interface iRolService {
    Rol getRolById(Integer idRol);

    Rol asignarRol(RolDto rolDto, Integer idRolDefault);
}
