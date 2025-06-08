package com.vuelos.good.controllers;
import com.vuelos.good.entity.Usuarios;
import com.vuelos.good.services.iService.iUsuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @GetMapping(value = "/list")
    public List<Usuarios> findAll() {
        return usuService.findAll();
    }

    @PostMapping
    public Usuarios crearUsuario(@RequestBody Usuarios usuario) {
        return usuService.save(usuario);
    }

    @PutMapping(value = "/{id}")
    public Usuarios update(@PathVariable(value = "id") Integer id, @RequestBody Usuarios usuario) {
        return usuService.update(id, usuario);
    }

    @DeleteMapping(value = "/{id}")
    private Boolean delete(@PathVariable(value = "id") Integer id) {
        return usuService.delete(id);
    }

    @PutMapping(value = "/estado/{id}")
    public Usuarios usuarioEstado(@PathVariable(value = "id") Integer id){
        return usuService.usuChangeEstado(id);
    }

    @GetMapping(value = "/list/active")
    public List<Usuarios> listarUsuActivos(){
        return usuService.findUsuariosActivos();
    }

    @GetMapping(value = "/list/inActive")
    public List<Usuarios> listUsuariosInActivos(){
        return usuService.findUsuariosInActivos();
    }

    @GetMapping(value = "/active")
    public Page<Usuarios> pageUsuActivos(@PageableDefault(sort = "usuCreatedAt", direction = Sort.Direction.ASC, size = 2) Pageable pageable){
        return usuService.paginateUsuActivos(pageable);
    }

    @GetMapping(value = "/inActive")
    public Page<Usuarios> pageUsuInActivos(@PageableDefault(sort = "usuCreatedAt", direction = Sort.Direction.ASC, size = 2) Pageable pageable){
        return usuService.paginateUsuInActivos(pageable);
    }
}
