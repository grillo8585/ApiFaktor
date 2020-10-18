package com.asofi.servrest.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="empresas")
@XmlRootElement(name="empresas")
public class Empresas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6010765727027311334L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	private String nombre;
	@Column(length = 50)
	private String nit;
	@Column(length = 50)
	private String descripcion;
	@Column(length = 50)
	private String direccion;
	@Column(length = 50)
	private String telefono;
	
	
	@JoinTable(
		        name = "empresas_l_riesgos",
		        joinColumns = @JoinColumn(name = "empresas_id", nullable = false),
		        inverseJoinColumns = @JoinColumn(name="l_riesgos_id", nullable = false)
		    )
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH })
	private List<Riesgos> l_riesgos;
//
//	
	public List<Riesgos> getL_riesgos() {
		return l_riesgos;
	}

	public void setL_riesgos(List<Riesgos> l_riesgos) {
		this.l_riesgos = l_riesgos;
	}

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
	
	//Getters and setter del nit
	public String getNit() {
		return nit;
	}
	
	public void setNit(String nit) {
		this.nit = nit;
	}
	
	//Getters and setter de la descripcion
	public String getDescripcion() {
		return descripcion;
	}
		
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	//Getters and setter de la direccion
	public String getDireccion() {
		return direccion;
	}
			
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	//Getters and setter del telefono
	public String getTelefono() {
		return telefono;
	}
				
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

}
