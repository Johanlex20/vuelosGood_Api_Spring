package com.vuelos.good.services.sistema;
import com.vuelos.good.dtos.sistema.MensajeRequestDto;
import com.vuelos.good.entity.sistema.Mensaje;
import com.vuelos.good.exceptions.BadRequestException;
import com.vuelos.good.exceptions.ResourcetNotFoundRequestException;
import com.vuelos.good.repository.iUsuRepository.sistema.iMensajeRepository;
import com.vuelos.good.services.iService.sistema.iMensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class MensajeServices implements iMensajeService {

    @Autowired
    private iMensajeRepository mensajeRepository;

    @Override
    public List<Mensaje> findAll() {
        return mensajeRepository.findAll();
    }

    @Override
    public Page<Mensaje> paginate(Pageable pageable) {
        return mensajeRepository.findAll(pageable);
    }

    @Override
    public Mensaje findById(Integer id) {
        return mensajeRepository.findById(id).orElseThrow(()-> new ResourcetNotFoundRequestException(getMensaje("men.error.id.mensaje.notFound","BASICO") + id));
    }

    @Override
    public Mensaje save(MensajeRequestDto mensajeDto) {
        Mensaje men = null;
        try{
            men = new Mensaje();
            men.setCodigo(mensajeDto.getCodigo());
            men.setEstadoMensaje(mensajeDto.getEstadoMensaje());
            men.setMensaje(mensajeDto.getMensaje());
            men.setMenDescripcion(mensajeDto.getMenDescripcion());
            men.setTipo(mensajeDto.getTipo());
            men.setMenCreatedAt(LocalDate.now());
        }catch (DataAccessException e){
            throw new BadRequestException(getMensaje("men.error.created","BASICO"), e);
        }
        return mensajeRepository.save(men);
    }

    @Override
    public Mensaje update(Integer id, MensajeRequestDto mensajeDto) {
        Mensaje men = findById(id);
        try{
            if(men != null){
                men.setCodigo(mensajeDto.getCodigo());
                men.setEstadoMensaje(mensajeDto.getEstadoMensaje());
                men.setMensaje(mensajeDto.getMensaje());
                men.setMenDescripcion(mensajeDto.getMenDescripcion());
                men.setTipo(mensajeDto.getTipo());
                men.setMenUpdatedAt(LocalDate.now());
            }else {
                throw new BadRequestException(getMensaje("men.error.mensaje.updated","BASICO"));
            }
        }catch (DataAccessException e){
            throw new BadRequestException(getMensaje("men.error.mensaje.updated","BASICO"),e);
        }
        return mensajeRepository.save(men);
    }

    @Override
    public Boolean delete(Integer id) {
        Mensaje menDelete = findById(id);
        mensajeRepository.deleteById(menDelete.getIdMensaje());
        System.out.println(getMensaje("men.exito.mensaje.delete","BASICO")+" "+menDelete.getIdMensaje());
        return true;
    }

    @Override
    public String getMensaje(String codigo) {
        return mensajeRepository.findByCodigo(codigo)
                .map(Mensaje::getMensaje)
                .orElse(getMensaje("men.notFound.mensaje","BASICO")+" "+ codigo);
    }
    @Override
    public String getMensaje(String codigo, String tipo){
        if (tipo != null && !tipo.isEmpty()) {
            return mensajeRepository.findByCodigoAndTipo(codigo, tipo)
                    .map(Mensaje::getMensaje)
                    .orElseGet(() -> getMensaje(codigo));
        }
        return getMensaje(codigo);
    }

}
