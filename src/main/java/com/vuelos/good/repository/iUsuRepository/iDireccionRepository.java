package com.vuelos.good.repository.iUsuRepository;
import com.vuelos.good.entity.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iDireccionRepository extends JpaRepository<Direccion, Integer> {
}
