package com.ejercicio.springboot.multas.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Multa {
	
	@Id
	private Integer id;
	private Integer matricula;
	private String categoria;
	private Double cantidad;
	
	
	
	
	
	
	
	
	public Multa() {
		super();
	}

	public Multa(Integer matricula, String categoria, Double cantidad) {
		super();
		this.matricula = matricula;
		this.categoria = categoria;
		this.cantidad = cantidad;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMatricula() {
		return matricula;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
