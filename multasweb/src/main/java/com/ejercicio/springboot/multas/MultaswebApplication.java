package com.ejercicio.springboot.multas;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ejercicio.springboot.multas.entities.Cliente;
import com.ejercicio.springboot.multas.entities.Multa;
import com.sboot.curso.cliente.ApplicationMultas;



//@SpringBootApplication
public class MultaswebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationMultas.class, args);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Cliente[]> httpEntity = new HttpEntity<Cliente[]>(headers);
		RestTemplate template = new RestTemplate();
		ResponseEntity<Cliente[]> response = 
				template.exchange(
						"http://localhost:8080/clientes", 
						HttpMethod.GET,
						httpEntity,
						Cliente[].class);
		HttpStatus statusCode = response.getStatusCode();
		
		if(statusCode == HttpStatus.OK) {
			Cliente[] clientes = response.getBody();
			if(clientes != null) {
				for(Cliente cliente : clientes) {
					System.out.println(cliente.getNombre());
				}
			}
		}
				
		
	}

}