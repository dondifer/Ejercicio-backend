package com.sboot.curso.cliente.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sboot.curso.cliente.model.ClienteRepository;
import com.sboot.curso.cliente.model.entity.Cliente;

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
	public Cliente cliente(@PathVariable Integer matricula) {
		return repository.findById(matricula).orElse(null);
	}
	
	//Dar de alta nuevo cliente
	@PostMapping("/clientes")
	public Cliente altaCliente(@RequestBody Cliente cliente) {
		return repository.save(cliente);
	}
	
	//Eliminar cliente
	@DeleteMapping("/clientes/{id}")
	public void eliminarCliente(@PathVariable Integer matricula) {
		repository.deleteById(matricula);
	}
	
	//Actualizar cliente
	@PutMapping("/clientes/{id}")
	public Cliente actualizarCliente(@RequestBody Cliente cliente, @PathVariable Integer matricula) {
		return repository.findById(matricula)
				.map(persona -> {
					persona.setNombre(cliente.getNombre());
					persona.setApellidos(cliente.getApellidos());
					persona.setDireccion(cliente.getDireccion());
					return repository.save(cliente);
				})
				.orElseGet(() -> {
					cliente.setMatricula(matricula);
					return repository.save(cliente);
				});
				
	}
	
}
