package com.vuelos.good.services.iService;
import com.vuelos.good.dtos.UsuRequestDto;
import com.vuelos.good.entity.Usuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface iUsuService {

    List<Usuarios> findAll();
    Page<Usuarios> paginate(Pageable pageable);

    Usuarios findById(Integer id);

    Usuarios save(UsuRequestDto usuRequestDto);

    Usuarios update(Integer id, UsuRequestDto usuRequestDto);

    Boolean delete(Integer id);

    Usuarios usuChangeEstado(Integer id);

    List<Usuarios> findUsuariosActivos();

    List<Usuarios> findUsuariosInActivos();

    Page<Usuarios> paginateUsuActivos(Pageable pageable);
    Page<Usuarios> paginateUsuInActivos(Pageable pageable);
}
