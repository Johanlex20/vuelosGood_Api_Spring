package com.vuelos.good.repository.usuario;
import com.vuelos.good.entity.usuario.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iDireccionRepository extends JpaRepository<Direccion, Integer> {
}
