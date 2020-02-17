package com.mars.ssmlearing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class SsmLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsmLearningApplication.class, args);
    }

    @Bean("cacheManager")
    public CacheManager simpleCacheManager() {
        return new ConcurrentMapCacheManager("detail");
    }

}
