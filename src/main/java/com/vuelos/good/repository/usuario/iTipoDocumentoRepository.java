package com.vuelos.good.repository.usuario;
import com.vuelos.good.entity.usuario.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iTipoDocumentoRepository extends JpaRepository<TipoDocumento,Integer> {
}
