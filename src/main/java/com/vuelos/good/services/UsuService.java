package com.vuelos.good.services;
import com.vuelos.good.dtos.DireccionRequestDto;
import com.vuelos.good.dtos.UsuDataRequestDto;
import com.vuelos.good.dtos.UsuRequestDto;
import com.vuelos.good.entity.Direccion;
import com.vuelos.good.entity.Rol;
import com.vuelos.good.entity.UsuarioData;
import com.vuelos.good.entity.Usuarios;
import com.vuelos.good.repository.iUsuRepository.iDireccionRepository;
import com.vuelos.good.repository.iUsuRepository.iRolRepository;
import com.vuelos.good.repository.iUsuRepository.iUsuRepository;
import com.vuelos.good.repository.iUsuRepository.iUsuarioDataRespository;
import com.vuelos.good.services.iService.iUsuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class UsuService implements iUsuService {

    @Autowired
    private iUsuRepository usuRepository;
    @Autowired
    private iUsuarioDataRespository usuarioDataRespository;
    @Autowired
    private iRolRepository rolRepository;
    @Autowired
    private iDireccionRepository direccionRepository;

    @Override
    public List<Usuarios> findAll() {
        return usuRepository.findAll();
    }

    @Override
    public Page<Usuarios> paginate(Pageable pageable) {
        return usuRepository.findAll(pageable);
    }

    @Override
    public Usuarios findById(Integer id) {
        return usuRepository.findById(id).orElseThrow(()-> new RuntimeException("ERROR ID: Id no encontrado en la base de datos! "));
    }

    @Override
    public Usuarios save(UsuRequestDto usuRequestDto) {

            Direccion dir = saveDireccion(usuRequestDto.getUsuarioDataDto().getDireccionRequestDto());
            Rol rol = getRolById(usuRequestDto.getRolDto().getIdRol());

            UsuarioData newUsu = saveUsuData(usuRequestDto.getUsuarioDataDto(), dir);
            usuarioDataRespository.save(newUsu);

            Usuarios usu = new Usuarios();
            usu.setRol(rol);
            usu.setIdUsuarioData(newUsu);
            usu.setUsuCreatedAt(LocalDate.now());

        return usuRepository.save(usu);
    }

    @Override
    public Usuarios update(Integer id, UsuRequestDto usuRequestDto) {

        Direccion dir = saveDireccion(usuRequestDto.getUsuarioDataDto().getDireccionRequestDto());
        Rol rol = getRolById(usuRequestDto.getRolDto().getIdRol());

        Usuarios usu = findById(id);
        UsuarioData updateUsu = updateUsuData(usu.getIdUsuarioData(), usuRequestDto.getUsuarioDataDto(), dir);

        usu.setRol(rol);
        usu.setIdUsuarioData(updateUsu);
        usu.setUsuUpdateAt(LocalDate.now());

        return usuRepository.save(usu);
    }

    @Override
    public Boolean delete(Integer id) {
        Usuarios usu = findById(id);
        usuRepository.deleteById(id);
        System.out.println("Usuario "+ usu.getIdUsuarioData().getUsuName()+" eliminado con exito!");
        return true;
    }

    public Usuarios usuChangeEstado(Integer id){
        Usuarios usu = findById(id);
        usu.getIdUsuarioData().setEstadoUsu("I");
        usu.setUsuUpdateAt(LocalDate.now());
        return usuRepository.save(usu);
    }


    private Direccion saveDireccion(DireccionRequestDto direccionRequestDto) {
        Direccion newDireccion = new Direccion();
        newDireccion.setDireccion(direccionRequestDto.getDireccion());
        newDireccion.setCiudad(direccionRequestDto.getCiudad());
        newDireccion.setPais(direccionRequestDto.getPais());
        newDireccion.setCodigoPostal(direccionRequestDto.getCodigoPostal());
        return direccionRepository.save(newDireccion);
    }

    private Rol getRolById(Integer idRol) {
        return rolRepository.findById(idRol)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con id: " + idRol));
    }

    private UsuarioData saveUsuData(UsuDataRequestDto usuDataRequestDto, Direccion dir){
            UsuarioData  newUsu = new UsuarioData();
            newUsu.setUsuName(usuDataRequestDto.getUsuName());
            newUsu.setUsuLastname(usuDataRequestDto.getUsuLastname());
            newUsu.setDocumento(usuDataRequestDto.getDocumento());
            newUsu.setEmail(usuDataRequestDto.getEmail());
            newUsu.setPassword(usuDataRequestDto.getPassword());
            newUsu.setCelular(usuDataRequestDto.getCelular());
            newUsu.setImgUsu(usuDataRequestDto.getImgUsu());
            newUsu.setEstadoUsu(usuDataRequestDto.getEstadoUsu());
            newUsu.setIdDireccion(dir);
            return usuarioDataRespository.save(newUsu);
    }

    private UsuarioData updateUsuData(UsuarioData updateUsu, UsuDataRequestDto usuDataRequestDto, Direccion dir){
        updateUsu.setUsuName(usuDataRequestDto.getUsuName());
        updateUsu.setUsuLastname(usuDataRequestDto.getUsuLastname());
        updateUsu.setDocumento(usuDataRequestDto.getDocumento());
        updateUsu.setEmail(usuDataRequestDto.getEmail());
        updateUsu.setPassword(usuDataRequestDto.getPassword());
        updateUsu.setCelular(usuDataRequestDto.getCelular());
        updateUsu.setImgUsu(usuDataRequestDto.getImgUsu());
        updateUsu.setEstadoUsu(usuDataRequestDto.getEstadoUsu());
        updateUsu.setIdDireccion(dir);

        return usuarioDataRespository.save(updateUsu);
    }

    public List<Usuarios> findUsuariosActivos() {
        return usuRepository.findByIdUsuarioData_EstadoUsu("A");
    }

    public List<Usuarios> findUsuariosInActivos(){
        return usuRepository.findByIdUsuarioDataEstadoInactivo();
    }

    @Override
    public Page<Usuarios> paginateUsuActivos(Pageable pageable) {
        return usuRepository.findByIdUsuarioData_EstadoUsu("A",pageable);
    }

    @Override
    public Page<Usuarios> paginateUsuInActivos(Pageable pageable) {
        return  usuRepository.findByIdUsuarioDataEstadoInactivo(pageable);
    }
}
