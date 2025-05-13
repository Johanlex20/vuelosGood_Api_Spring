package com.vuelos.good.repository.iUsuRepository;
import com.vuelos.good.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol,Integer> {
}
