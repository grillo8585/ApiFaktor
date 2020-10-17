package com.asofi.servrest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CascadeType;
@Entity
@Table(name="proyectos")
@XmlRootElement(name="proyectos")
public class Proyectos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4572874057637177821L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 100)
	private String descripcion;
	
	@Column(length = 50)
	private String nombre;

	@OneToOne(optional = true,cascade = { javax.persistence.CascadeType.MERGE,javax.persistence.CascadeType.PERSIST,javax.persistence.CascadeType.REFRESH}, 
			  fetch = FetchType.EAGER,targetEntity = Empresas.class,orphanRemoval = false )
	//@JoinColumn(name = "empresas_id")
	private Empresas empresa_p;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Empresas getEmpresa() {
		return empresa_p;
	}

	public void setEmpresa(Empresas empresa) {
		this.empresa_p = empresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
