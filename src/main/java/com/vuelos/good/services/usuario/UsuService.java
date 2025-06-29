package com.vuelos.good.services.usuario;
import com.vuelos.good.dtos.usuario.DireccionDto;
import com.vuelos.good.dtos.usuario.RolDto;
import com.vuelos.good.dtos.usuario.UsuDataDto;
import com.vuelos.good.dtos.usuario.UsuDto;
import com.vuelos.good.entity.usuario.*;
import com.vuelos.good.exceptions.ResourcetNotFoundRequestException;
import com.vuelos.good.repository.usuario.*;
import com.vuelos.good.services.iservice.usuario.iUsuService;
import com.vuelos.good.services.iservice.sistema.iMensajeService;
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

    @Autowired
    private iMensajeService mensajeService;

    @Autowired
    private iTipoDocumentoRepository tipoDocumentoRepository;

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
        return usuRepository.findById(id).orElseThrow(()-> new ResourcetNotFoundRequestException( mensajeService.getMensaje("usu.error.id.usu.notFound","BASICO")));
    }

    @Override
    public Usuarios save(UsuDto usuDto) {

            Direccion dir = saveDireccion(usuDto.getUsuarioDataDto().getDireccionRequestDto());
            Rol rol = asignarRol(usuDto.getRolDto(),3);

            UsuData newUsu = saveUsuData(usuDto.getUsuarioDataDto(), dir);
            usuarioDataRespository.save(newUsu);

            Usuarios usu = new Usuarios();
            usu.setRol(rol);
            usu.setIdUsuarioData(newUsu);
            usu.setUsuCreatedAt(LocalDate.now());

        return usuRepository.save(usu);
    }

    @Override
    public Usuarios update(Integer id, UsuDto usuDto) {

        Direccion dir = saveDireccion(usuDto.getUsuarioDataDto().getDireccionRequestDto());
        Rol rol = asignarRol(usuDto.getRolDto(),3);

        Usuarios usu = findById(id);
        UsuData updateUsu = updateUsuData(usu.getIdUsuarioData(), usuDto.getUsuarioDataDto(), dir);

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


    private Direccion saveDireccion(DireccionDto dirDto) {
        Direccion newDir = new Direccion();
        newDir.setDireccion(dirDto.getDireccion());
        newDir.setCiudad(dirDto.getCiudad().toUpperCase());
        newDir.setPais(dirDto.getPais().toUpperCase());
        newDir.setCodigoPostal(dirDto.getCodigoPostal());
        return direccionRepository.save(newDir);
    }

    private Rol getRolById(Integer idRol) {
        return rolRepository.findById(idRol)
                .orElseThrow(() -> new ResourcetNotFoundRequestException(mensajeService.getMensaje("men.error.id.rol.notFound","BASICO") + idRol));
    }

    private Rol asignarRol(RolDto rolDto, Integer idRolDefault){
        Integer idRol = (rolDto != null && rolDto.getIdRol() != null)
                ? rolDto.getIdRol()
                : idRolDefault;
        return getRolById(idRol);
    }

    private TipoDocumento getTipoDocById(Integer idTipoDoc){
        return tipoDocumentoRepository.findById(idTipoDoc).orElseThrow(()->new ResourcetNotFoundRequestException(mensajeService.getMensaje("Tipo documento no encontrado!","BASICO") +idTipoDoc));
    }

    private UsuData saveUsuData(UsuDataDto usuDataDto, Direccion dir){
            UsuData newUsu = new UsuData();
            TipoDocumento tipoDoc = getTipoDocById(usuDataDto.getTipoDocDto().getIdTipoDoc());

            newUsu.setUsuName(usuDataDto.getUsuName());
            newUsu.setUsuLastname(usuDataDto.getUsuLastname());
            newUsu.setTipoDocumento(tipoDoc);
            newUsu.setDocumento(usuDataDto.getDocumento());
            newUsu.setEmail(usuDataDto.getEmail());
            newUsu.setPassword(usuDataDto.getPassword());
            newUsu.setCelular(usuDataDto.getCelular());
            newUsu.setImgUsu(usuDataDto.getImgUsu());
            newUsu.setEstadoUsu(usuDataDto.getEstadoUsu());
            newUsu.setIdDireccion(dir);
            return usuarioDataRespository.save(newUsu);
    }

    private UsuData updateUsuData(UsuData updateUsu, UsuDataDto usuDataDto, Direccion dir){
        TipoDocumento tipoDoc = getTipoDocById(usuDataDto.getTipoDocDto().getIdTipoDoc());

        updateUsu.setUsuName(usuDataDto.getUsuName());
        updateUsu.setUsuLastname(usuDataDto.getUsuLastname());
        updateUsu.setDocumento(usuDataDto.getDocumento());
        updateUsu.setTipoDocumento(tipoDoc);
        updateUsu.setEmail(usuDataDto.getEmail());
        updateUsu.setPassword(usuDataDto.getPassword());
        updateUsu.setCelular(usuDataDto.getCelular());
        updateUsu.setImgUsu(usuDataDto.getImgUsu());
        updateUsu.setEstadoUsu(usuDataDto.getEstadoUsu());
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
