package com.mars.ssmlearing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.Executor;

@EnableTransactionManagement
@EnableCaching
@EnableAsync
@SpringBootApplication
public class SsmLearningApplication implements AsyncConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SsmLearningApplication.class, args);
    }

    @Bean("cacheManager")
    public CacheManager simpleCacheManager() {
        return new ConcurrentMapCacheManager("detail");
    }

    @Override
    public Executor getAsyncExecutor() {
        //如果不配置，默认使用的是SimpleAsyncTaskExecutor，会每个异步调用创建一个线程
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(50);
        taskExecutor.initialize();
        return taskExecutor;
    }
}
