package com.vuelos.good.services.sistema;
import com.vuelos.good.component.MensajeCacheLoader;
import com.vuelos.good.dtos.sistema.MensajeRequestDto;
import com.vuelos.good.entity.sistema.Mensaje;
import com.vuelos.good.exceptions.BadRequestException;
import com.vuelos.good.exceptions.ResourcetNotFoundRequestException;
import com.vuelos.good.repository.sistema.iMensajeRepository;
import com.vuelos.good.services.iservice.sistema.iMensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class MensajeServices implements iMensajeService {

    private static String MENSAJES = "mensajes";

    @Autowired
    private iMensajeRepository mensajeRepository;

    @Autowired
    private CacheManager cacheManager;



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
        Mensaje mensaje = mensajeRepository.save(men);
      /*  resetCache();*/
        return mensaje;

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
        Mensaje mensaje = mensajeRepository.save(men);
        /*resetCache();*/
        return mensaje;
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
        return getMensaje(codigo,"BASICO");
    }

    @Override
    public String getMensaje(String codigo, String tipo){
        String key = codigo + "-" + tipo;
        Cache cache = cacheManager.getCache(MENSAJES);

        if (cache != null) {
            String mensaje = cache.get(key, String.class);
            if (mensaje != null) {
                return mensaje;
            }
        }

        return mensajeRepository.findByCodigoAndTipo(codigo, tipo)
                .map(Mensaje::getMensaje)
                .orElse("Mensaje no encontrado → " + codigo);
    }

    /*@CacheEvict(value = "mensajes", allEntries = true)
    public void resetCache() {
        resetMensajesCache();
    }*/

    /*public void resetMensajesCache() {
        Cache cache = cacheManager.getCache(MENSAJES);
        if (cache != null) {
            cache.clear();
        }

        List<Mensaje> mensajes = mensajeRepository.findAll();
        for (Mensaje m : mensajes) {
            String key = m.getCodigo() + "-" + m.getTipo();
            cache.put(key, m.getMensaje());
        }
        System.out.println(getMensaje("men.cache.restset.manual","BASICO"));
    }*/

}
