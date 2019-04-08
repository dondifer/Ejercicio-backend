package com.sboot.curso.cliente.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sboot.curso.cliente.model.entity.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{

}