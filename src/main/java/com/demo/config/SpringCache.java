package com.demo.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;


@Configuration
@EnableCaching
public class SpringCache {
    @Bean
    public CacheManager getCacheManager(RedisTemplate<String,Object> template) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(template);
        ArrayList<String> objects = new ArrayList<>();
        objects.add("Statute");
        redisCacheManager.setCacheNames(objects);
        redisCacheManager.setDefaultExpiration(1800);
        return redisCacheManager;
    }
}
