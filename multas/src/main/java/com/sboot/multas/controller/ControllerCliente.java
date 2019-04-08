package com.sboot.multas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sboot.multas.model.entities.Cliente;
import com.sboot.multas.model.entities.ClienteRepository;

@RestController
public class ControllerCliente {

	private final ClienteRepository repository;
	
	public ControllerCliente(ClienteRepository repository) {
		this.repository = repository;
	}
	
	//Lista de todos los clientes
	@GetMapping("/clientes")
	public List <Cliente> clientes(){
		return repository.findAll();
	}
	
	//Encontrar un cliente en particular
	@GetMapping("/clientes/{id}")
	public Cliente cliente (@PathVariable Integer matricula) {
		return repository.findById(matricula).orElse(null);
	}
	
	//Dar de alta nuevo cliente
	
}
