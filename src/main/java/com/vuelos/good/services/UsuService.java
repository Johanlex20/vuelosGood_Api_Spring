package com.vuelos.good.services;
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
    public Usuarios save(Usuarios usuario) {

            Direccion dir = saveDireccion(usuario.getIdUsuarioData().getIdDireccion());
            Rol rol = getRolById(usuario.getRol().getIdRol());

            UsuarioData newUsu = saveUsuData(usuario.getIdUsuarioData(), dir);
            usuarioDataRespository.save(newUsu);

            usuario.setRol(rol);
            usuario.setIdUsuarioData(newUsu);
            usuario.setUsuCreatedAt(LocalDate.now());

        return usuRepository.save(usuario);
    }

    @Override
    public Usuarios update(Integer id, Usuarios usuario) {

        Direccion dir = saveDireccion(usuario.getIdUsuarioData().getIdDireccion());
        Rol rol = getRolById(usuario.getRol().getIdRol());

        Usuarios usu = findById(id);
        UsuarioData updateUsu = updateUsuData(usu.getIdUsuarioData(), usuario.getIdUsuarioData(), dir);

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


    private Direccion saveDireccion(Direccion direccion) {
        Direccion newDireccion = new Direccion();
        newDireccion.setDireccion(direccion.getDireccion());
        newDireccion.setCiudad(direccion.getCiudad());
        newDireccion.setPais(direccion.getPais());
        newDireccion.setCodigoPostal(direccion.getCodigoPostal());
        return direccionRepository.save(newDireccion);
    }

    private Rol getRolById(Integer idRol) {
        return rolRepository.findById(idRol)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con id: " + idRol));
    }

    private UsuarioData saveUsuData(UsuarioData usuarioData, Direccion dir){
            UsuarioData  newUsu = new UsuarioData();
            newUsu.setUsuName(usuarioData.getUsuName());
            newUsu.setUsuLastname(usuarioData.getUsuLastname());
            newUsu.setDocumento(usuarioData.getDocumento());
            newUsu.setEmail(usuarioData.getEmail());
            newUsu.setPassword(usuarioData.getPassword());
            newUsu.setCelular(usuarioData.getCelular());
            newUsu.setImgUsu(usuarioData.getImgUsu());
            newUsu.setEstadoUsu(usuarioData.getEstadoUsu());
            newUsu.setIdDireccion(dir);
            return usuarioDataRespository.save(newUsu);
    }

    private UsuarioData updateUsuData(UsuarioData updateUsu, UsuarioData usuarioData, Direccion dir){
        updateUsu.setUsuName(usuarioData.getUsuName());
        updateUsu.setUsuLastname(usuarioData.getUsuLastname());
        updateUsu.setDocumento(usuarioData.getDocumento());
        updateUsu.setEmail(usuarioData.getEmail());
        updateUsu.setPassword(usuarioData.getPassword());
        updateUsu.setCelular(usuarioData.getCelular());
        updateUsu.setImgUsu(usuarioData.getImgUsu());
        updateUsu.setEstadoUsu(usuarioData.getEstadoUsu());
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
