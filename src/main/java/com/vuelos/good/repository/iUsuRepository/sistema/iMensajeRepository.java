package com.vuelos.good.repository.iUsuRepository.sistema;
import com.vuelos.good.entity.sistema.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iMensajeRepository extends JpaRepository<Mensaje, Integer> {
}
