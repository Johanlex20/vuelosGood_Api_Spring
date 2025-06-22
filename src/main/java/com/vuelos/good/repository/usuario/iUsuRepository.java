package com.vuelos.good.repository.usuario;
import com.vuelos.good.entity.usuario.Usuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iUsuRepository extends JpaRepository<Usuarios, Integer> {
    List<Usuarios> findByIdUsuarioData_EstadoUsu(String estadoUsu);

    @Query("SELECT u FROM Usuarios u WHERE u.idUsuarioData.estadoUsu = 'I'")
    List<Usuarios> findByIdUsuarioDataEstadoInactivo();

    Page<Usuarios> findByIdUsuarioData_EstadoUsu(String estadoUsu, Pageable pageable);

    @Query("SELECT u FROM Usuarios u WHERE u.idUsuarioData.estadoUsu = 'I'")
    Page<Usuarios> findByIdUsuarioDataEstadoInactivo(Pageable pageable);

}
