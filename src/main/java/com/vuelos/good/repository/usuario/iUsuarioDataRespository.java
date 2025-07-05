package com.vuelos.good.repository.usuario;
import com.vuelos.good.entity.usuario.UsuData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarioDataRespository extends JpaRepository<UsuData, Integer> {
    boolean existsByEmail(String email);

    boolean existsByEmailAndIdUsuDataNot(String email, Integer idUsuario);

    boolean existsByDocumento(String documento);

    boolean existsByDocumentoAndIdUsuDataNot(String documento, Integer id);

    boolean existsByCelular(String celular);

    boolean existsByCelularAndIdUsuDataNot(String celular, Integer id);
}
