package com.vuelos.good.repository.iUsuRepository;
import com.vuelos.good.entity.UsuarioData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarioDataRespository extends JpaRepository<UsuarioData, Integer> {
}
