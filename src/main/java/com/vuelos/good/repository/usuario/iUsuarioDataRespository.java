package com.vuelos.good.repository.usuario;
import com.vuelos.good.entity.usuario.UsuarioData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarioDataRespository extends JpaRepository<UsuarioData, Integer> {
}
