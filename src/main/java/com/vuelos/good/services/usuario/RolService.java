package com.vuelos.good.services.usuario;
import com.vuelos.good.dtos.usuario.RolDto;
import com.vuelos.good.entity.usuario.Rol;
import com.vuelos.good.exceptions.ResourcetNotFoundRequestException;
import com.vuelos.good.repository.usuario.iRolRepository;
import com.vuelos.good.services.iservice.usuario.iRolService;
import com.vuelos.good.services.sistema.MensajeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService implements iRolService {

    @Autowired
    iRolRepository rolRepository;

    @Autowired
    MensajeServices mensajeService;

    @Override
    public Rol getRolById(Integer idRol) {
        return rolRepository.findById(idRol)
                .orElseThrow(() -> new ResourcetNotFoundRequestException(mensajeService.getMensaje("men.error.id.rol.notFound","BASICO") + idRol));
    }

    @Override
    public Rol asignarRol(RolDto rolDto, Integer idRolDefault){
        Integer idRol = (rolDto != null && rolDto.getIdRol() != null)
                ? rolDto.getIdRol()
                : idRolDefault;
        return getRolById(idRol);
    }

   /* public Rol asinarRol(RolDto rolDto, Integer idRolDefault){
        Object RolDto = null;
        Integer numero = rolDto.getIdRol();
        return getRolById(rolDto.getIdRol());
    }*/
}
