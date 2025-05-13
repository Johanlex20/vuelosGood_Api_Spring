package com.vuelos.good.repository.iUsuRepository;
import com.vuelos.good.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuRepository extends JpaRepository<Usuarios, Integer> {
}
