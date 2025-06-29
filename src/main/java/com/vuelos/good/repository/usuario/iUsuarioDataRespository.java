package com.vuelos.good.repository.usuario;
import com.vuelos.good.entity.usuario.UsuData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarioDataRespository extends JpaRepository<UsuData, Integer> {
}
