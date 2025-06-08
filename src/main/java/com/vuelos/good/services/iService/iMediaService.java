package com.vuelos.good.services.iService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface iMediaService {

    Map<String, String> subir(MultipartFile multipartFile);

    ResponseEntity<Resource> getResource(String nombreArchivo) throws IOException;

}
