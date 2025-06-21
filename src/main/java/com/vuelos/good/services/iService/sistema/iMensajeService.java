package com.vuelos.good.services.iService.sistema;
import com.vuelos.good.entity.sistema.Mensaje;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface iMensajeService {

    List<Mensaje> findAll();
    Page<Mensaje> paginate(Pageable pageable);

    Mensaje findById(Integer id);

    Mensaje save(Mensaje mensaje);

    Mensaje update(Integer id, Mensaje mensaje);

    Boolean delete(Integer id);

}
