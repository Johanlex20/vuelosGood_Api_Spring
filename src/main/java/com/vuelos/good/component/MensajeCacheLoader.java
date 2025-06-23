package com.vuelos.good.component;
import com.vuelos.good.entity.sistema.Mensaje;
import com.vuelos.good.repository.sistema.iMensajeRepository;
import com.vuelos.good.services.iservice.sistema.iMensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class MensajeCacheLoader {
    private static String MENSAJES = "mensajes";

    @Autowired
    private iMensajeRepository mensajeRepository;

    @Autowired
    private iMensajeService mensajeServices;

    @Autowired
    private CacheManager cacheManager;

    @EventListener(ApplicationReadyEvent.class)
    public void cargarMensajesEnCache(){
        List<Mensaje> mensajes = mensajeRepository.findAll();
        Cache cache = cacheManager.getCache(MENSAJES);

        if (cache != null){
            for (Mensaje m : mensajes){
                String key = m.getCodigo() + "-" + m.getTipo();
                cache.put(key,m.getMensaje());
            }
        }
        System.out.println(mensajes.size() +" "+ mensajeServices.getMensaje("men.pre.cache.ram.mensajes", "BASICO"));
    }
}
