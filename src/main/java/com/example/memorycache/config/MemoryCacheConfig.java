package com.example.memorycache.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.*;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class MemoryCacheConfig {

    @Bean
    public CaffeineCacheManager caffeineCacheManager(){
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager("caffeineCache");
        caffeineCacheManager.setCaffeine(caffeineCacheBuilder());
        return caffeineCacheManager;
    }

    @Bean
    public Caffeine<Object, Object> caffeineCacheBuilder() {
        return Caffeine.newBuilder()
                .initialCapacity(130)
                .maximumSize(800)
                .expireAfterWrite(20, TimeUnit.MILLISECONDS)
                .weakKeys()
                .recordStats();
    }

}
