package com.api.chamados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ChamadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChamadosApplication.class, args);
	}

}
