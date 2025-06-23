package com.vuelos.good.services.iservice.sistema;
import com.vuelos.good.dtos.sistema.MensajeRequestDto;
import com.vuelos.good.entity.sistema.Mensaje;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface iMensajeService {

    List<Mensaje> findAll();
    Page<Mensaje> paginate(Pageable pageable);

    Mensaje findById(Integer id);

    Mensaje save(MensajeRequestDto mensajeDto);

    Mensaje update(Integer id, MensajeRequestDto mensajeDto);

    Boolean delete(Integer id);

    String getMensaje(String codigo);

    String getMensaje(String codigo, String tipo);

    void resetCache();

    void resetMensajesCache();
}
