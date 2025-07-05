package com.vuelos.good.services.usuario;
import com.vuelos.good.dtos.usuario.UsuDataDto;
import com.vuelos.good.dtos.usuario.UsuDto;
import com.vuelos.good.entity.usuario.*;
import com.vuelos.good.exceptions.BadRequestException;
import com.vuelos.good.exceptions.ResourcetNotFoundRequestException;
import com.vuelos.good.repository.usuario.*;
import com.vuelos.good.services.iservice.usuario.iRolService;
import com.vuelos.good.services.iservice.usuario.iUsuService;
import com.vuelos.good.services.iservice.sistema.iMensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
    private DirService dirService;
    @Autowired
    private iMensajeService mensajeService;
    @Autowired
    private iTipoDocumentoRepository tipoDocumentoRepository;
    @Autowired
    private iRolService rolService;


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

            boolean usuExists = usuarioDataRespository.existsByEmail(usuDto.getUsuarioDataDto().getEmail());
            boolean docExists = usuarioDataRespository.existsByDocumento(usuDto.getUsuarioDataDto().getDocumento());
            boolean celExists = usuarioDataRespository.existsByCelular(usuDto.getUsuarioDataDto().getCelular());

            if (usuExists){
                throw new BadRequestException(mensajeService.getMensaje("usu.error.email.duplicado","BASICO"));
            } else if (docExists) {
                throw new BadRequestException(mensajeService.getMensaje("usu.error.doc.duplicado","BASICO"));
            } else if (celExists) {
                throw new BadRequestException(mensajeService.getMensaje("usu.error.cel.duplicado","BASICO"));
            }

        try{
                Direccion dir = dirService.saveDireccion(usuDto.getUsuarioDataDto().getDireccionRequestDto());
                Rol rol = rolService.asignarRol(usuDto.getRolDto(),3);
                UsuData newUsu = saveUsuData(usuDto.getUsuarioDataDto(), dir);
                usuarioDataRespository.save(newUsu);

                Usuarios usu = new Usuarios();
                usu.setRol(rol);
                usu.setIdUsuarioData(newUsu);
                usu.setUsuCreatedAt(LocalDate.now());

                return usuRepository.save(usu);

            }catch (DataAccessException e){
                throw new BadRequestException(mensajeService.getMensaje("usu.error.created","BASICO"), e);
            }
    }

    @Override
    public Usuarios update(Integer id, UsuDto usuDto) {

        Usuarios usu = findById(id);
        boolean usuExists = usuarioDataRespository.existsByEmailAndIdUsuDataNot(usuDto.getUsuarioDataDto().getEmail(), id);
        boolean docExists = usuarioDataRespository.existsByDocumentoAndIdUsuDataNot(usuDto.getUsuarioDataDto().getDocumento(), id);
        boolean celExists = usuarioDataRespository.existsByCelularAndIdUsuDataNot(usuDto.getUsuarioDataDto().getCelular(), id);


        if (usuExists){
            throw new BadRequestException(mensajeService.getMensaje("usu.error.email.duplicado","BASICO"));
        } else if (docExists) {
            throw new BadRequestException(mensajeService.getMensaje("usu.error.doc.duplicado","BASICO"));
        } else if (celExists) {
            throw new BadRequestException(mensajeService.getMensaje("usu.error.cel.duplicado","BASICO"));
        }

        try {
            Direccion dir = dirService.saveDireccion(usuDto.getUsuarioDataDto().getDireccionRequestDto());
            Rol rol = rolService.asignarRol(usuDto.getRolDto(),3);
            UsuData updateUsu = updateUsuData(usu.getIdUsuarioData(), usuDto.getUsuarioDataDto(), dir);

            usu.setRol(rol);
            usu.setIdUsuarioData(updateUsu);
            usu.setUsuUpdateAt(LocalDate.now());
        }catch (DataAccessException e){
            throw new BadRequestException(mensajeService.getMensaje("usu.error.updated","BASICO"), e);
        }
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

    private TipoDocumento getTipoDocById(Integer idTipoDoc){
        return tipoDocumentoRepository.findById(idTipoDoc).orElseThrow(()->new ResourcetNotFoundRequestException(mensajeService.getMensaje("usu.tipoDoc.notFound","BASICO") +" "+idTipoDoc));
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
