package com.sboot.curso.cliente.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sboot.curso.cliente.model.ClienteRepository;
import com.sboot.curso.cliente.model.entity.Cliente;


@Configuration
public class Configuracion {

	@Bean
	public CommandLineRunner iniciarBaseDeDatos(ClienteRepository repo) {
		return args -> {
			repo.save(new Cliente("Ruben", "Garcia Garcia", "Gran Via 1"));
			repo.save(new Cliente("Enrique", "Ciudad", "Princesa 4"));
			repo.save(new Cliente("Inés", "Pedraza Pino", "Andres Mellado 3"));
			};
		}
		
	}
