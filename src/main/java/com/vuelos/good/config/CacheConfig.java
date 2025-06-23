package com.vuelos.good.config;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {
    private static String MENSAJES = "mensajes";
    @Bean
    public CacheManager cacheManager(){
        CaffeineCacheManager cacheManager = new CaffeineCacheManager(MENSAJES);
                cacheManager.setCaffeine(
                        Caffeine.newBuilder()
                                .maximumSize(1000)
                                .expireAfterWrite(1, TimeUnit.DAYS)
                );
    return cacheManager;
    }
}
