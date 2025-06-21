package com.vuelos.good.services.sistema;
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
        return mensajeRepository.findById(id).orElseThrow(()-> new ResourcetNotFoundRequestException("Mensaje Id no encotrado!"));
    }

    @Override
    public Mensaje save(Mensaje mensaje) {
        Mensaje men = null;
        try{
            men = new Mensaje();
            men.setCodigo(mensaje.getCodigo());
            men.setEstadoMensaje(mensaje.getEstadoMensaje());
            men.setMensaje(mensaje.getMensaje());
            men.setMenDescripcion(mensaje.getMenDescripcion());
            men.setTipo(mensaje.getTipo());
            men.setMenCreatedAt(LocalDate.now());
        }catch (DataAccessException e){
            throw new BadRequestException("Error: Al crear Mensaje Del Sistema!", e);
        }
        return mensajeRepository.save(men);
    }

    @Override
    public Mensaje update(Integer id, Mensaje mensaje) {
        Mensaje men = findById(id);
        try{
            if(men != null){
                men.setCodigo(mensaje.getCodigo());
                men.setEstadoMensaje(mensaje.getEstadoMensaje());
                men.setMensaje(mensaje.getMensaje());
                men.setMenDescripcion(mensaje.getMenDescripcion());
                men.setTipo(mensaje.getTipo());
                men.setMenUpdatedAt(LocalDate.now());
            }else {
                throw new BadRequestException("ERROR: Actualizar Mensaje Del Sistema!");
            }
        }catch (DataAccessException e){
            throw new BadRequestException("ERROR: Actualizar Mensaje Del Sistema!",e);
        }
        return mensajeRepository.save(men);
    }

    @Override
    public Boolean delete(Integer id) {
        Mensaje menDelete = findById(id);
        mensajeRepository.deleteById(menDelete.getIdMensaje());
        System.out.println("Mensaje Del Sistema "+ menDelete.getIdMensaje()+" eliminado con exito!");
        return true;
    }
}
