package com.ejercicio.springboot.multas.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.ejercicio.springboot.multas.model.entities.Multa;
import com.ejercicio.springboot.multas.model.entities.MultaRepository;

@Configuration
public class Configuracion {
	
	
	
	@Bean
	public CommandLineRunner iniciarBaseDeDatos(MultaRepository repo) {
		return args -> {
			repo.save(new Multa(1,"CategoriaPrueba1", 444.44));
			repo.save(new Multa(2,"CategoriaPrueba2", 555.55));
			repo.save(new Multa(3, "CategoriaPrueba3",666.66));
		};
	}
	
	

}
