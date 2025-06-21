package com.vuelos.good.controllers.sistema;
import com.vuelos.good.dtos.sistema.MensajeRequestDto;
import com.vuelos.good.entity.sistema.Mensaje;
import com.vuelos.good.services.iService.sistema.iMensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    Mensaje save(@RequestBody MensajeRequestDto mensajeDto){
        return mensajeService.save(mensajeDto);
    }

    @PutMapping(value = "/{id}")
    Mensaje update(@PathVariable(value = "id") Integer id, @RequestBody MensajeRequestDto mensajeDto){
        return mensajeService.update(id,mensajeDto);
    }

    @DeleteMapping(value = "/{id}")
    Boolean delete(@PathVariable(value = "id") Integer id){
        return mensajeService.delete(id);
    }

}
