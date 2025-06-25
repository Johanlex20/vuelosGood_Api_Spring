package com.vuelos.good.component;
import com.vuelos.good.entity.sistema.Mensaje;
import com.vuelos.good.repository.sistema.iMensajeRepository;
import com.vuelos.good.services.iservice.sistema.iMensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
@Lazy
public class MensajeCacheLoader {
    private static String MENSAJES = "mensajes";

    @Autowired
    private iMensajeRepository mensajeRepository;

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
        Optional<Mensaje> msg = mensajeRepository.findByCodigoAndTipo("men.pre.cache.ram.mensajes", "BASICO");
        System.out.println(mensajes.size() + " " + msg.map(Mensaje::getMensaje).orElse("Mensaje no encontrado"));
    }
}
