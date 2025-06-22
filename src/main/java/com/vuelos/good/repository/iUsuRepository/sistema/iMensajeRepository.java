package com.vuelos.good.repository.iUsuRepository.sistema;
import com.vuelos.good.entity.sistema.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface iMensajeRepository extends JpaRepository<Mensaje, Integer> {
    Optional<Mensaje> findByCodigo(String codigo);
    Optional<Mensaje> findByCodigoAndTipo(String codigo, String tipo);
}
