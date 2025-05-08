package com.example.mule_migration.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SchedulerService {

    private final XmlConsumerService xmlConsumerService;
    public SchedulerService(){
        this.xmlConsumerService = new XmlConsumerService();
    }
    @Scheduled(fixedRate = 10000)
    public void logMigration()
    {
        log.info("Migration Check Executed");
        xmlConsumerService.parseProduct();
        // log.info(this.xmlConsumerService.parseProduct().toString());
    }


}