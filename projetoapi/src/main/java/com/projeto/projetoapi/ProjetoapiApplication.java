package com.projeto.projetoapi;

import com.projeto.projetoapi.DTO.AtributesPostDTO;
import com.projeto.projetoapi.DTO.PostDTO;
import com.projeto.projetoapi.entities.Value;
import com.projeto.projetoapi.repositories.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.List;

@EnableFeignClients
@EnableScheduling
@SpringBootApplication
public class ProjetoapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoapiApplication.class, args);
	}

}
