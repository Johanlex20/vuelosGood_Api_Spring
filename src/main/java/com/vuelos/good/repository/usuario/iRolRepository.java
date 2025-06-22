package com.vuelos.good.repository.usuario;
import com.vuelos.good.entity.usuario.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol,Integer> {
}
