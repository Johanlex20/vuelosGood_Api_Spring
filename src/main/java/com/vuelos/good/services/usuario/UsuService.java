package com.vuelos.good.services.usuario;
import com.vuelos.good.dtos.usuario.DireccionRequestDto;
import com.vuelos.good.dtos.usuario.RolRequestDto;
import com.vuelos.good.dtos.usuario.UsuDataRequestDto;
import com.vuelos.good.dtos.usuario.UsuRequestDto;
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
    public Usuarios save(UsuRequestDto usuRequestDto) {

            Direccion dir = saveDireccion(usuRequestDto.getUsuarioDataDto().getDireccionRequestDto());
            Rol rol = asignarRol(usuRequestDto.getRolDto(),3);

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
        Rol rol = asignarRol(usuRequestDto.getRolDto(),3);

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
        newDireccion.setCiudad(direccionRequestDto.getCiudad().toUpperCase());
        newDireccion.setPais(direccionRequestDto.getPais().toUpperCase());
        newDireccion.setCodigoPostal(direccionRequestDto.getCodigoPostal());
        return direccionRepository.save(newDireccion);
    }

    private Rol getRolById(Integer idRol) {
        return rolRepository.findById(idRol)
                .orElseThrow(() -> new ResourcetNotFoundRequestException(mensajeService.getMensaje("men.error.id.rol.notFound","BASICO") + idRol));
    }

    private Rol asignarRol(RolRequestDto rolDto, Integer idRolDefault){
        Integer idRol = (rolDto != null && rolDto.getIdRol() != null)
                ? rolDto.getIdRol()
                : idRolDefault;
        return getRolById(idRol);
    }

    private TipoDocumento getTipoDocById(Integer idTipoDoc){
        return tipoDocumentoRepository.findById(idTipoDoc).orElseThrow(()->new ResourcetNotFoundRequestException(mensajeService.getMensaje("Tipo documento no encontrado!","BASICO") +idTipoDoc));
    }

    private UsuarioData saveUsuData(UsuDataRequestDto usuDataRequestDto, Direccion dir){
            UsuarioData  newUsu = new UsuarioData();
            TipoDocumento tipoDoc = getTipoDocById(usuDataRequestDto.getTipoDocDto().getIdTipoDoc());

            newUsu.setUsuName(usuDataRequestDto.getUsuName());
            newUsu.setUsuLastname(usuDataRequestDto.getUsuLastname());
            newUsu.setTipoDocumento(tipoDoc);
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
        TipoDocumento tipoDoc = getTipoDocById(usuDataRequestDto.getTipoDocDto().getIdTipoDoc());

        updateUsu.setUsuName(usuDataRequestDto.getUsuName());
        updateUsu.setUsuLastname(usuDataRequestDto.getUsuLastname());
        updateUsu.setDocumento(usuDataRequestDto.getDocumento());
        updateUsu.setTipoDocumento(tipoDoc);
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
