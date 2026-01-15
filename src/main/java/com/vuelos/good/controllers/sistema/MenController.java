package com.vuelos.good.controllers.sistema;
import com.vuelos.good.dtos.sistema.MensajeRequestDto;
import com.vuelos.good.entity.sistema.Mensaje;
import com.vuelos.good.services.iservice.sistema.iMensajeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/mensajes")
public class MenController {

    @Autowired
    private iMensajeService mensajeService;

    @GetMapping(value = "/list")
    List<Mensaje> findAll(){
        return mensajeService.findAll();
    }
    @GetMapping
    Page<Mensaje> paginate(@PageableDefault(sort = "menCreatedAt",direction = Sort.Direction.DESC, size = 5) Pageable pageable){
        return mensajeService.paginate(pageable);
    }
    @GetMapping(value = "/{id}")
    Mensaje findById(@PathVariable(value = "id") Integer id){
        return mensajeService.findById(id);
    }

    @PostMapping
    Mensaje save(@RequestBody @Valid MensajeRequestDto mensajeDto){
        return mensajeService.save(mensajeDto);
    }

    @PutMapping(value = "/{id}")
    Mensaje update(@PathVariable(value = "id") Integer id, @RequestBody @Valid MensajeRequestDto mensajeDto){
        return mensajeService.update(id,mensajeDto);
    }

    @DeleteMapping(value = "/{id}")
    Boolean delete(@PathVariable(value = "id") Integer id){
        return mensajeService.delete(id);
    }

  /*  @GetMapping("/rest-cache")
    public ResponseEntity<String> restCache() {
       mensajeService.resetMensajesCache();
       return ResponseEntity.ok(mensajeService.getMensaje("men.cache.reiniciada.mensajes","BASICO"));
    }*/

 /*   @GetMapping("/list-mensaje")
    public String listarUsuario(){
        return mensajeService.getMensaje("lista de mensajes Usuario");
    }*/

}
