package com.asofi.servrest.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="proyectos")
public class Proyectos {
	private Long id;
	private String nombre;
	private Empresas empresa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Empresas getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresas empresa) {
		this.empresa = empresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
