package com.example.mule_migration.util;

import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShutdownLogger {
    
    @PreDestroy
    public void beforeTerminateService()
    {
        log.info("Mule Migration service is stopped ...");
    }
}
