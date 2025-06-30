package com.vuelos.good.services.usuario;
import com.vuelos.good.dtos.usuario.DireccionDto;
import com.vuelos.good.entity.usuario.Direccion;
import com.vuelos.good.repository.usuario.iDireccionRepository;
import com.vuelos.good.services.iservice.usuario.iDirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirService implements iDirService {

    @Autowired
    private iDireccionRepository direccionRepository;

    public Direccion saveDireccion(DireccionDto dirDto) {
        Direccion newDir = new Direccion();
        newDir.setDireccion(dirDto.getDireccion());
        newDir.setCiudad(dirDto.getCiudad().toUpperCase());
        newDir.setPais(dirDto.getPais().toUpperCase());
        newDir.setCodigoPostal(dirDto.getCodigoPostal());
        return direccionRepository.save(newDir);
    }

}
