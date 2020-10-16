package com.asofi.servrest.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


public class Reporte implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5219228382595666492L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	private String nombre;
	
	private List<String> calculo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getCalculo() {
		return calculo;
	}

	public void setCalculo(List<String> calculo) {
		this.calculo = calculo;
	}

}
