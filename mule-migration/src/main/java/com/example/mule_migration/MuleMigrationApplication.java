package com.example.mule_migration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableScheduling
public class MuleMigrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuleMigrationApplication.class, args);
		log.info("Mule Migration service is started ...");
	}

}
