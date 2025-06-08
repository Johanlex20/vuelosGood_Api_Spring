package com.vuelos.good.controllers;
import com.vuelos.good.services.iService.iAlmacenamientoService;
import com.vuelos.good.services.iService.iMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/media")
public class MediaController implements iMediaService {

    @Autowired
    private iAlmacenamientoService almacenamientoService;

    @Override
    @PostMapping(value = "/upload")
    public Map<String, String> subir(@RequestParam(value = "file") MultipartFile multipartFile) {
       String path = almacenamientoService.almacenar(multipartFile);
        return Map.of("path", path);
    }

    @Override
    @GetMapping(value = "/{filename}")
    public ResponseEntity<Resource> getResource(@PathVariable(value = "filename") String nombreArchivo) throws IOException {
        Resource recurso = almacenamientoService.cargarRecurso(nombreArchivo);
        String contenType = Files.probeContentType(recurso.getFile().toPath());
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, contenType)
                .body(recurso);
    }
}
