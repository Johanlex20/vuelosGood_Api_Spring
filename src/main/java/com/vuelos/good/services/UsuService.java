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
    public Usuarios update(Integer id, Usuarios usuarios) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }


    public Direccion saveDireccion(Direccion direccion) {
        Direccion newDireccion = new Direccion();
        newDireccion.setDireccion(direccion.getDireccion());
        newDireccion.setCiudad(direccion.getCiudad());
        newDireccion.setPais(direccion.getPais());
        newDireccion.setCodigoPostal(direccion.getCodigoPostal());
        return direccionRepository.save(newDireccion);
    }

    public Rol getRolById(Integer idRol) {
        return rolRepository.findById(idRol)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con id: " + idRol));
    }

    public UsuarioData saveUsuData(UsuarioData usuarioData, Direccion dir){
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
}
