package com.spring.transtionsexample.config;

import com.spring.transtionsexample.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@Slf4j
public class TaskConfig {

    @Autowired
    private AsyncService asyncService;

    @Scheduled(initialDelay = 1000, fixedDelay = 5000)
    public void asyncProcessing() {
        log.info("TaskConfig::asyncProcessing entry point");
        asyncService.processing();
    }
}
