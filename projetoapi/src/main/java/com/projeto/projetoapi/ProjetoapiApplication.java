package com.projeto.projetoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableFeignClients
@EnableScheduling
@EnableSwagger2
@SpringBootApplication
public class ProjetoapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoapiApplication.class, args);
	}

}
