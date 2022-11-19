package com.mb30.chartio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.mb30.chartio.domain.model"})  // scan JPA entities
public class ChartioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChartioApplication.class, args);
	}

}
