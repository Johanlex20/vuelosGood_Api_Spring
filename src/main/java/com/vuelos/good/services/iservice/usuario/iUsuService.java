package com.vuelos.good.services.iservice.usuario;
import com.vuelos.good.dtos.usuario.UsuDto;
import com.vuelos.good.entity.usuario.Usuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface iUsuService {

    List<Usuarios> findAll();
    Page<Usuarios> paginate(Pageable pageable);

    Usuarios findById(Integer id);

    Usuarios save(UsuDto usuDto);

    Usuarios update(Integer id, UsuDto usuDto);

    Boolean delete(Integer id);

    Usuarios usuChangeEstado(Integer id);

    List<Usuarios> findUsuariosActivos();

    List<Usuarios> findUsuariosInActivos();

    Page<Usuarios> paginateUsuActivos(Pageable pageable);
    Page<Usuarios> paginateUsuInActivos(Pageable pageable);
}
