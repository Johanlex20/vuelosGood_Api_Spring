package com.vuelos.good.controllers;

import com.vuelos.good.entity.Usuarios;
import com.vuelos.good.services.iService.iUsuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuController {

    @Autowired
    private iUsuService usuService;

    @GetMapping(value = "/{id}")
    private Usuarios findById(@PathVariable(value = "id") Integer id){
        return usuService.findById(id);
    }

    @GetMapping
    public Page<Usuarios> paginate(@PageableDefault(sort = "usuCreatedAt", direction = Sort.Direction.ASC, size = 2) Pageable pageable){
        return usuService.paginate(pageable);
    }

    @PostMapping
    public ResponseEntity<Usuarios> crearUsuario(@RequestBody Usuarios usuario) {
        Usuarios nuevoUsuario = usuService.save(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }
}
