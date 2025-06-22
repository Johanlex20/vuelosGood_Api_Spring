package com.vuelos.good.services.iservice.sistema;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;

public interface iAlmacenamientoService {

    void iniciar();
    String almacenar(MultipartFile archivo);

    Path cargar(String nombreArchivo);

    Resource cargarRecurso(String nombreArchivo);

    void eliminarRecurso(String nombreArchivo);

}
